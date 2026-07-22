import "./SearchCard.css";

import SubjectFilter from "../searchFilters/SubjectFilter";
import CourseNumberFilter from "../searchFilters/CourseNumberFilter";
import CourseNameFilter from "../searchFilters/CourseNameFilter";
import GpaRangeFilter from "../searchFilters/GpaRangeFilter";

import { useState } from "react";
import { useNavigate } from "react-router-dom";

import type { CourseSearchRequest } from "../../types/CourseSearchRequest";

import LevelFilter from "../searchFilters/LevelFilter";
import GenedCategoryFilter from "../searchFilters/GenedCategoryFilter";
import OfferedLastTermFilter from "../searchFilters/OfferedLastTermFilter";
import SortByFilter from "../searchFilters/SortByFilter";

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
    offered: true,
    sortBy: "title",
    sortDirection: "asc",
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
        onChange={(number) =>
          setFilters((prev) => ({
            ...prev,
            number,
          }))
        }
      />

      <CourseNameFilter
        value={filters.title ?? ""}
        onChange={(title) =>
          setFilters((prev) => ({
            ...prev,
            title,
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

      <GenedCategoryFilter
        value={filters.genEdCodes}
        onChange={(genEdCodes) =>
          setFilters((prev) => ({
            ...prev,
            genEdCodes,
          }))
        }
      />

      <LevelFilter
        value={filters.level}
        onChange={(level) =>
          setFilters((prev) => ({
            ...prev,
            level,
          }))
        }
      />

      <OfferedLastTermFilter
        value={filters.offered}
        onChange={(offered) =>
          setFilters((prev) => ({
            ...prev,
            offered,
          }))
        }
      />

      <SortByFilter
        sortBy={filters.sortBy}
        sortDirection={filters.sortDirection}
        onSortByChange={(sortBy) =>
          setFilters((prev) => ({
            ...prev,
            sortBy,
          }))
        }
        onDirectionChange={(sortDirection) =>
          setFilters((prev) => ({
            ...prev,
            sortDirection,
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
