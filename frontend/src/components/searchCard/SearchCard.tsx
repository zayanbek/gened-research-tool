import "./SearchCard.css";
import GpaSlider from "../gpaSlider/GpaSlider";

import { useState } from "react";

export default function SearchCard() {
  const [gpaRange, setGpaRange] = useState([2.5, 4.0]);

  return (
    <aside className="search-card">
      <h2 className="search-card__title">Search Filters</h2>

      <div className="search-card__section">
        <label htmlFor="subject">Subject</label>
        <select id="subject">
          <option value="">Any Subject</option>
          <option>CS</option>
          <option>MATH</option>
          <option>ECON</option>
          <option>STAT</option>
        </select>
      </div>

      <div className="search-card__section">
        <label htmlFor="courseNumber">Course Number</label>
        <input id="courseNumber" type="number" placeholder="e.g. 225" />
      </div>

      <div className="search-card__section">
        <label htmlFor="courseName">Course Name</label>
        <input
          id="courseName"
          type="text"
          placeholder="Search by course title..."
        />
      </div>

      <div className="search-card__section">
        <label>GPA Range</label>

        <div className="search-card__gpa-values">
          <span>{gpaRange[0].toFixed(1)}</span>
          <span>{gpaRange[1].toFixed(1)}</span>
        </div>

        <GpaSlider values={gpaRange} setValues={setGpaRange} />
      </div>

      <div className="search-card__section search-card__toggle">
        <label htmlFor="semester">Available Next Semester</label>

        <input id="semester" type="checkbox" />
      </div>

      <div className="search-card__buttons">
        <button className="secondary">Reset</button>

        <button className="primary">Search</button>
      </div>
    </aside>
  );
}
