export interface CourseSearchRequest {
  subject: string;
  number: number | undefined;
  level: number | undefined;
  minGpa: number;
  maxGpa: number;
  title: string;
  genEdCodes: string[];
}
