import "./SearchCard.css";

import SubjectFilter from "../searchFilters/SubjectFilter";
import CourseNumberFilter from "../searchFilters/CourseNumberFilter";
import CourseNameFilter from "../searchFilters/CourseNameFilter";
import GpaRangeFilter from "../searchFilters/GpaRangeFilter";
// import OfferedThisTermFilter from "../searchFilters/OfferedThisTermFilter";
import GenedCategoryFilter from "../searchFilters/GenedCategoryFilter";

import { searchCourses } from "../../api/courses";

import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function SearchCard() {
  const navigate = useNavigate();

  const [filters, setFilters] = useState({
    subject: "",
    courseNumber: "",
    courseName: "",
    gpaRange: [0, 4],
    genEdCategories: [] as string[],
  });

  async function handleSearch() {
    const response = await searchCourses(filters);

    navigate("/results", {
      state: {
        results: response,
        filters,
      },
    });
  }

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
        value={filters.courseNumber}
        onChange={(courseNumber) =>
          setFilters((prev) => ({
            ...prev,
            courseNumber,
          }))
        }
      />

      <CourseNameFilter
        value={filters.courseName}
        onChange={(courseName) =>
          setFilters((prev) => ({
            ...prev,
            courseName,
          }))
        }
      />

      {/* <GpaRangeFilter
        values={filters.gpaRange}
        onChange={(gpaRange) =>
          setFilters((prev) => ({
            ...prev,
            gpaRange,
          }))
        }
      /> */}

      {/* <GenedCategoryFilter /> */}

      <div className="search-card__buttons">
        <button className="secondary">Reset</button>
        <button
          className="primary"
          onClick={() => {
            handleSearch;
          }}
        >
          Search
        </button>
      </div>
    </aside>
  );
}
