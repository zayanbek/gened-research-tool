import { useState } from "react";
import GpaSlider from "./GpaSlider";

export default function GpaRangeFilter() {
  const [gpaRange, setGpaRange] = useState([1.25, 3.5]);

  return (
    <div className="search-card__section">
      <label>GPA Range</label>

      <div className="search-card__gpa-values">
        <span>{gpaRange[0].toFixed(1)}</span>
        <span>{gpaRange[1].toFixed(1)}</span>
      </div>

      <GpaSlider values={gpaRange} setValues={setGpaRange} />
    </div>
  );
}
