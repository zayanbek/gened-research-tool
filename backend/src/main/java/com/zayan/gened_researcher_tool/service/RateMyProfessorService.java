package com.zayan.gened_researcher_tool.service;

import com.zayan.gened_researcher_tool.dto.RateMyProfessorDto;
import jakarta.annotation.PostConstruct;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.JsonNode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class RateMyProfessorService {

     private final String API_LINK = "https://www.ratemyprofessors.com/graphql";

     // private static final String SCHOOL_NAME = "University of Illinois Urbana-Champaign";

     private RestClient restClient = RestClient.create();

     private String schoolId, teacherQuery, schoolQuery;

     @PostConstruct
     private void init() throws IOException {

          teacherQuery = new String(
                  getClass()
                          .getResourceAsStream("/graphql/teacher-search.graphql")
                          .readAllBytes(),
                  StandardCharsets.UTF_8
          );

          schoolQuery = new String(
                  getClass()
                          .getResourceAsStream("/graphql/school-search.graphql")
                          .readAllBytes(),
                  StandardCharsets.UTF_8
          );

          // schoolId = searchSchoolId(SCHOOL_NAME);
          schoolId = "U2Nob29sLTExMTI="; // School ID for UIUC
     }

     @Cacheable("rmp")
     public RateMyProfessorDto getProfessor(String instructorName) {

          String[] nameParts = instructorName.split(",", 2);

          String expectedLast = nameParts[0].trim();

          String expectedFirst = "";
          if (nameParts.length > 1) {
               expectedFirst = nameParts[1].trim().split("\\s+")[0];
          }

          // System.out.println("expected:" + expectedFirst + "|" + expectedLast);

          Map<String, Object> query = new HashMap<>();
          query.put("text", expectedLast);
          query.put("schoolID", schoolId);
          query.put("fallback", true);
          query.put("departmentID", null);

          Map<String, Object> variables = new HashMap<>();
          variables.put("query", query);
          variables.put("schoolID", schoolId);
          variables.put("includeSchoolFilter", true);

          Map<String, Object> body = new HashMap<>();
          body.put("query", teacherQuery);
          body.put("variables", variables);

          JsonNode response = restClient.post()
                  .uri(API_LINK)
                  .headers(h -> h.addAll(headers()))
                  .body(body)
                  .retrieve()
                  .body(JsonNode.class);

          // System.out.println("response: " + response.toPrettyString());

          JsonNode edges = response.path("data")
                  .path("search")
                  .path("teachers")
                  .path("edges");

          if (!edges.isArray() || edges.isEmpty()) {
               return RateMyProfessorDto.empty(instructorName);
          }

          // JsonNode professor = edges.get(0).path("node");

          // System.out.println(instructorName + "|" + expectedFirst + "|" + expectedLast);

          JsonNode professor = null;

          // System.out.println("** instructorName:     " + instructorName);

          for (JsonNode edge : edges) {

               JsonNode node = edge.path("node");

               String firstName = node.path("firstName").asText();
               String lastName = node.path("lastName").asText();

               // System.out.println(firstName + "|" + lastName);

               boolean firstMatches = firstName.equalsIgnoreCase(expectedFirst);
               boolean lastMatches = lastName.equalsIgnoreCase(expectedLast);

               if (firstMatches && lastMatches) {
                    professor = node;
                    break;
               }
          }

          if (professor == null) {
               return RateMyProfessorDto.empty(instructorName);
          }


          return new RateMyProfessorDto(
                  professor.path("firstName").asText() + " "
                          + professor.path("lastName").asText(),
                  professor.path("avgRating").asDouble(),
                  professor.path("avgDifficulty").asDouble(),
                  professor.path("wouldTakeAgainPercent").asInt(),
                  professor.path("numRatings").asInt(),
                  professor.path("department").asText(),
                  "https://www.ratemyprofessors.com/professor/"
                          + professor.path("legacyId").asText()
          );
     }

     private String searchSchoolId(String schoolName) {

          Map<String, Object> body = Map.of(
                  "query", schoolQuery,
                  "variables", Map.of(
                          "query", Map.of(
                                  "text", schoolName
                          )
                  )
          );

          JsonNode response = restClient.post()
                  .uri(API_LINK)
                  .headers(h -> h.addAll(headers()))
                  .body(body)
                  .retrieve()
                  .body(JsonNode.class);


          JsonNode edges = response.path("data")
                  .path("newSearch")
                  .path("schools")
                  .path("edges");

          // for(JsonNode edge : edges) System.out.println(edge);

          if (!edges.isArray() || edges.isEmpty()) {
               return null;
          }

          return edges.get(0)
                  .path("node")
                  .path("id")
                  .asText();
     }

     private HttpHeaders headers() {

          HttpHeaders headers = new HttpHeaders();

          headers.set("User-Agent",
                  "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:129.0) Gecko/20100101 Firefox/129.0");

          headers.setContentType(MediaType.APPLICATION_JSON);

          headers.set("Authorization", "Basic dGVzdDp0ZXN0");
          headers.set("Accept", "*/*");
          headers.set("Accept-Language", "en-US,en;q=0.5");

          return headers;
     }

}
