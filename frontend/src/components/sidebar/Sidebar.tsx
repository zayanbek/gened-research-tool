import "./Sidebar.css";

import SubjectFilter from "../searchFilters/SubjectFilter";
import CourseNumberFilter from "../searchFilters/CourseNumberFilter";
import CourseNameFilter from "../searchFilters/CourseNameFilter";
import GpaRangeFilter from "../searchFilters/GpaRangeFilter";
import LevelFilter from "../searchFilters/LevelFilter";

import type { CourseSearchRequest } from "../../types/CourseSearchRequest";
import GenedCategoryFilter from "../searchFilters/GenedCategoryFilter";
import OfferedLastTermFilter from "../searchFilters/OfferedLastTermFilter";
import SortByFilter from "../searchFilters/SortByFilter";

type SidebarProps = {
  filters: CourseSearchRequest;
  setFilters: React.Dispatch<React.SetStateAction<CourseSearchRequest>>;
  onSearch: () => void;
  onReset: () => void;
};

export default function Sidebar({
  filters,
  setFilters,
  onSearch,
  onReset,
}: SidebarProps) {
  return (
    <aside className="sidebar">
      <h2 className="sidebar__title">Search Filters</h2>

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
        value={filters.title}
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

      <div className="sidebar__buttons">
        <button className="secondary" onClick={onReset}>
          Reset
        </button>

        <button className="primary" onClick={onSearch}>
          Search
        </button>
      </div>
    </aside>
  );
}
