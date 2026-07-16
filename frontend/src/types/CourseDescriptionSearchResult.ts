import type { GpaHistoryDto } from "./GpaHistoryDto";

export interface CourseDescriptionSearchResult {
  description: string;
  creditHours: string;
  sectionInfo: string;
  sectionTitle: string;
  sectionCreditHours: string;
  gpaHistory: GpaHistoryDto[];
}
