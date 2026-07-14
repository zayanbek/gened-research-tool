import type { CourseSearchRequest } from "../types/CourseSearchRequest";

export async function searchCourses(filters: CourseSearchRequest) {
  const params = new URLSearchParams();

  if (filters.subject) params.append("subject", filters.subject);

  if (filters.number !== undefined)
    params.append("number", filters.number.toString());

  if (filters.level !== undefined)
    params.append("level", filters.level.toString());

  if (filters.minGpa !== undefined)
    params.append("minGpa", filters.minGpa.toString());

  if (filters.maxGpa !== undefined)
    params.append("maxGpa", filters.maxGpa.toString());

  if (filters.title) params.append("title", filters.title);

  if (filters.offered !== undefined)
    params.append("offered", filters.offered.toString());

  filters.genEdCodes?.forEach((code) => params.append("genEdCodes", code));

  const response = await fetch(
    `http://localhost:8080/courses?${params.toString()}`,
  );

  if (!response.ok) {
    throw new Error("Search failed");
  }

  return response.json();
}
