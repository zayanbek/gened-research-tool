import "./ResultsCard.css";

import type { CourseSearchResult } from "../../types/CourseSearchResult";

type ResultsCardProps = {
  course: CourseSearchResult;
};

export default function ResultsCard({ course }: ResultsCardProps) {
  return (
    <aside className="results-card">
      <label className="results-card__subject-code">
        {course.subject} {course.number}
      </label>

      <h2 className="results-card__subject-name">{course.title}</h2>

      <div className="results-card__geneds">
        {course.genEdCodes.map((code) => (
          <span key={code} className="results-card__tag">
            {code}
          </span>
        ))}
      </div>
    </aside>
  );
}
