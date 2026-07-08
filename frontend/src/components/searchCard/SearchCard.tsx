import "./SearchCard.css";

import SubjectFilter from "../searchFilters/SubjectFilter";
import CourseNumberFilter from "../searchFilters/CourseNumberFilter";
import CourseNameFilter from "../searchFilters/CourseNameFilter";
import GpaRangeFilter from "../searchFilters/GpaRangeFilter";
// import OfferedThisTermFilter from "../searchFilters/OfferedThisTermFilter";
import GenedCategoryFilter from "../searchFilters/GenedCategoryFilter";

import { useNavigate } from "react-router-dom";

export default function SearchCard() {
  const navigate = useNavigate();

  return (
    <aside className="search-card">
      <h2 className="search-card__title">Search Filters</h2>

      <SubjectFilter />

      <CourseNumberFilter />

      <CourseNameFilter />

      <GpaRangeFilter />

      {/* <OfferedThisTermFilter /> */}

      <GenedCategoryFilter />

      <div className="search-card__buttons">
        <button className="secondary">Reset</button>
        <button className="primary" onClick={() => navigate("/results")}>
          Search
        </button>
      </div>
    </aside>
  );
}
