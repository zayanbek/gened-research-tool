package com.zayan.gened_researcher_tool.controller;

import com.zayan.gened_researcher_tool.dto.RateMyProfessorDto;
import com.zayan.gened_researcher_tool.service.RateMyProfessorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate-my-professor/professors")
public class RateMyProfessorController {

     private final RateMyProfessorService rateMyProfessorService;

     public RateMyProfessorController(RateMyProfessorService rateMyProfessorService) {
          this.rateMyProfessorService = rateMyProfessorService;
     }

     @GetMapping("/{instructorName}")
     public RateMyProfessorDto getTeacherInformation(@PathVariable String instructorName) {
          return rateMyProfessorService.getProfessor(instructorName);
     }

}
