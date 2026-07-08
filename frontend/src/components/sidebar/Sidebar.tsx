import "./Sidebar.css";

import SubjectFilter from "../searchFilters/SubjectFilter";
import CourseNumberFilter from "../searchFilters/CourseNumberFilter";
import CourseNameFilter from "../searchFilters/CourseNameFilter";
import GpaRangeFilter from "../searchFilters/GpaRangeFilter";
import OfferedThisTermFilter from "../searchFilters/OfferedThisTermFilter";

export default function Sidebar() {
  return (
    <aside className="sidebar">
      <h2 className="sidebar__title">Search Filters</h2>

      <SubjectFilter />
      <CourseNumberFilter />
      <CourseNameFilter />
      <GpaRangeFilter />
      <OfferedThisTermFilter />

      <div className="sidebar__buttons">
        <button className="secondary">Reset</button>
        <button className="primary">Search</button>
      </div>
    </aside>
  );
}
