import "./DescriptionPanel.css";

import { useEffect, useState } from "react";

import { getCourseDescription } from "../../api/courses";

import type { CourseDescriptionSearchResult } from "../../types/CourseDescriptionSearchResult";
import GpaHistoryChart from "./gpaHistoryChart/GpaHistoryChart";

type CourseDescriptionPanelProps = {
  courseId: number | null;
  // onClose: () => void;
};

export default function DescriptionPanel({
  courseId,
  // onClose,
}: CourseDescriptionPanelProps) {
  const [course, setCourse] = useState<CourseDescriptionSearchResult | null>(
    null,
  );
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    if (courseId === null) {
      setCourse(null);
      return;
    }

    async function loadCourse() {
      setLoading(true);

      try {
        const response = await getCourseDescription(courseId);
        setCourse(response);
      } catch (err) {
        console.error(err);
      } finally {
        setLoading(false);
      }
    }

    loadCourse();
  }, [courseId]);

  if (courseId === null) {
    return null;
  }

  return (
    <aside className="course-description-panel">
      {/* <button className="course-description-panel__close" onClick={onClose}>
        ×
      </button> */}

      <h2 className="course-description-panel-title">Description</h2>

      {loading ? (
        <p>Loading...</p>
      ) : course ? (
        <aside className="description-section">
          {/* <h2>{course.sectionTitle}</h2> */}

          {course.description && (
            <>
              <label>Details</label>
              <p>{course.description}</p>
            </>
          )}

          {course.creditHours && (
            <>
              <label>Credit Hours</label>
              <p>{course.creditHours}</p>
            </>
          )}

          {course.sectionInfo && (
            <>
              <label>Section Information</label>
              <p>{course.sectionInfo}</p>
            </>
          )}

          {course.sectionCreditHours && (
            <>
              <label>Section Credit Hours</label>
              <p>{course.sectionCreditHours}</p>
            </>
          )}

          {course.gpaHistory.length > 0 && (
            <>
              <label>GPA History</label>
              <GpaHistoryChart history={course.gpaHistory} />
            </>
          )}

          {course.teacherInformation.length > 0 && (
            
          )}
        </aside>
      ) : (
        <p>Unable to load course.</p>
      )}
    </aside>
  );
}
