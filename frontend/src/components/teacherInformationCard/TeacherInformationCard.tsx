import { useState } from "react";

import type { TeacherInformationDto } from "../../types/TeacherInformationDto";
import "./TeacherInformationCard.css";

type TeacherInformationCardProps = {
  teacher: TeacherInformationDto;
};

function formatValue(value: number | null | undefined): string {
  return value == null || value === -1 ? "N/A" : value.toString();
}

export default function TeacherInformationCard({
  teacher,
}: TeacherInformationCardProps) {
  const [expanded, setExpanded] = useState(false);
  const rmp = teacher.rateMyProfessor;

  return (
    <aside
      className={`teacher-information-card ${
        expanded ? "teacher-information-card--expanded" : ""
      }`}
    >
      <button
        className="teacher-information-card__header"
        onClick={() => setExpanded((prev) => !prev)}
      >
        <div className="teacher-information-card__title">
          <span className="teacher-information-card__chevron">
            {expanded ? "▼" : "▶"}
          </span>

          <span>{teacher.name}</span>
        </div>

        {rmp.avgRating != null && (
          <span className="teacher-information-card__rating">
            ⭐ {rmp.avgRating === -1 ? "N/A" : rmp.avgRating.toFixed(1)}
          </span>
        )}
      </button>

      {expanded && (
        <div className="teacher-information-card__details">
          {rmp.numRatings != null && (
            <p>
              <strong>{formatValue(rmp.numRatings)}</strong> Ratings
            </p>
          )}

          {rmp.wouldTakeAgainPercent != null && (
            <p>
              <strong>
                {rmp.wouldTakeAgainPercent !== -1
                  ? `${rmp.wouldTakeAgainPercent.toFixed(1)}%`
                  : "N/A"}
              </strong>{" "}
              Would Take Again
            </p>
          )}

          {rmp.avgDifficulty != null && (
            <p>
              Difficulty:{" "}
              <strong>
                {rmp.avgDifficulty === -1
                  ? "N/A"
                  : `${rmp.avgDifficulty.toFixed(1)}/5`}
              </strong>
            </p>
          )}

          <div className="teacher-information-card__recognition">
            <div>
              🏆 Outstanding <strong>{teacher.outstanding}</strong>
            </div>

            <div>
              ⭐ Excellent <strong>{teacher.excellent}</strong>
            </div>
          </div>

          {rmp.link && (
            <a
              href={rmp.link}
              target="_blank"
              rel="noopener noreferrer"
              className="teacher-information-card__link"
            >
              View on Rate My Professor ↗
            </a>
          )}
        </div>
      )}
    </aside>
  );
}
