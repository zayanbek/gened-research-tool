import type { GpaHistoryDto } from "./GpaHistoryDto";
import type { TeacherInformationDto } from "./TeacherInformationDto";

export interface CourseDescriptionSearchResult {
  description: string;
  creditHours: string;
  sectionInfo: string;
  sectionTitle: string;
  sectionCreditHours: string;
  gpaHistory: GpaHistoryDto[];
  teacherInformation: TeacherInformationDto[];
}
