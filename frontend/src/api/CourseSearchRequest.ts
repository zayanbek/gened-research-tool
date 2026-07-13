export interface CourseSearchRequest {
  subject?: string;
  number?: number;
  level?: number;
  minGpa?: number;
  maxGpa?: number;
  title?: string;
  genEdCodes?: string[];
}
