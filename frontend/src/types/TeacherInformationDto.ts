import type { RateMyProfessorDto } from "./RateMyProfessorDto";

export interface TeacherInformationDto {
  name: string;
  excellent: number;
  outstanding: number;
  rateMyProfessor: RateMyProfessorDto;
}
