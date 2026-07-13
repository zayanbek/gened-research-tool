import "./Sidebar.css";

import SubjectFilter from "../searchFilters/SubjectFilter";
import CourseNumberFilter from "../searchFilters/CourseNumberFilter";
import CourseNameFilter from "../searchFilters/CourseNameFilter";
import GpaRangeFilter from "../searchFilters/GpaRangeFilter";
import OfferedThisTermFilter from "../searchFilters/OfferedThisTermFilter";

import type { CourseSearchRequest } from "../../types/CourseSearchRequest";

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
