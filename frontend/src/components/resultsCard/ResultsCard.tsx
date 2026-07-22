import "./ResultsCard.css";

import type { CourseSearchResult } from "../../types/CourseSearchResult";

type ResultsCardProps = {
  course: CourseSearchResult;
  onClick: () => void;
};

const genEdClass: Record<string, string> = {
  ACP: "tag--acp",

  HUM: "tag--hum",
  HP: "tag--hum",
  LA: "tag--hum",

  SBS: "tag--sbs",
  BSC: "tag--sbs",
  SS: "tag--sbs",

  NAT: "tag--nat",
  LS: "tag--nat",
  PS: "tag--nat",

  CS: "tag--cs",
  NW: "tag--cs",
  US: "tag--cs",
  WCC: "tag--cs",

  QR: "tag--qr",
  QR1: "tag--qr",
  QR2: "tag--qr",
};

export default function ResultsCard({ course, onClick }: ResultsCardProps) {
  return (
    <aside className="results-card" onClick={onClick}>
      <label className="results-card__subject-code">
        {course.subject} {course.number}
      </label>

      <h2 className="results-card__subject-name">{course.title}</h2>

      <div className="results-card__geneds">
        {course.genEdCodes.map((code) => (
          <span
            key={code}
            className={`results-card__tag ${genEdClass[code] ?? ""}`}
          >
            {code}
          </span>
        ))}
      </div>
    </aside>
  );
}
