import "./SearchFilters.css";

import GpaSlider from "./GpaSlider";

type GpaRangeFilterProps = {
  minGpa: number;
  maxGpa: number;
  onChange: (minGpa: number, maxGpa: number) => void;
};

export default function GpaRangeFilter({
  minGpa,
  maxGpa,
  onChange,
}: GpaRangeFilterProps) {
  return (
    <div className="filter-section">
      <label>GPA Range</label>

      <div className="filter-gpa-values">
        <span>{minGpa.toFixed(1)}</span>
        <span>{maxGpa.toFixed(1)}</span>
      </div>

      <GpaSlider
        values={[minGpa, maxGpa]}
        setValues={([min, max]) => onChange(min, max)}
      />
    </div>
  );
}
