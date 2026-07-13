import "./SearchCard.css";

import SubjectFilter from "../searchFilters/SubjectFilter";
import CourseNumberFilter from "../searchFilters/CourseNumberFilter";
import CourseNameFilter from "../searchFilters/CourseNameFilter";
import GpaRangeFilter from "../searchFilters/GpaRangeFilter";
import OfferedThisTermFilter from "../searchFilters/OfferedThisTermFilter";
import GenedCategoryFilter from "../searchFilters/GenedCategoryFilter";

import { useState } from "react";
import { useNavigate } from "react-router-dom";
import type { CourseSearchRequest } from "../../types/CourseSearchRequest";

export default function SearchCard() {
  const navigate = useNavigate();

  const [filters, setFilters] = useState<CourseSearchRequest>({
    subject: "",
    number: undefined,
    level: undefined,
    minGpa: 0,
    maxGpa: 4,
    title: "",
    genEdCodes: [],
  });

  return (
    <aside className="search-card">
      <h2 className="search-card__title">Search Filters</h2>

      <SubjectFilter
        value={filters.subject}
        onChange={(subject) =>
          setFilters((prev) => ({
            ...prev,
            subject,
          }))
        }
      />

      <CourseNumberFilter
        value={filters.number}
        onChange={(courseNumber) =>
          setFilters((prev) => ({
            ...prev,
            courseNumber,
          }))
        }
      />

      <CourseNameFilter
        value={filters.title}
        onChange={(courseName) =>
          setFilters((prev) => ({
            ...prev,
            courseName,
          }))
        }
      />

      <GpaRangeFilter
        minGpa={filters.minGpa}
        maxGpa={filters.maxGpa}
        onChange={(minGpa, maxGpa) =>
          setFilters((prev) => ({
            ...prev,
            minGpa,
            maxGpa,
          }))
        }
      />

      <div className="search-card__buttons">
        <button className="secondary">Reset</button>
        <button
          className="primary"
          onClick={() => {
            navigate("/results", {
              state: filters,
            });
          }}
        >
          Search
        </button>
      </div>
    </aside>
  );
}
