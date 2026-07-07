import "./SearchCard.css";

import SubjectFilter from "../searchFilters/SubjectFilter";
import CourseNumberFilter from "../searchFilters/CourseNumberFilter";
import CourseNameFilter from "../searchFilters/CourseNameFilter";
import GpaRangeFilter from "../searchFilters/GpaRangeFilter";
import OfferedThisTermFilter from "../searchFilters/OfferedThisTermFilter";

export default function SearchCard() {
  return (
    <aside className="search-card">
      <h2 className="search-card__title">Search Filters</h2>

      <SubjectFilter />

      <CourseNumberFilter />

      <CourseNameFilter />

      <GpaRangeFilter />

      <OfferedThisTermFilter />

      <div className="search-card__buttons">
        <button className="secondary">Reset</button>
        <button className="primary">Search</button>
      </div>
    </aside>
  );
}
