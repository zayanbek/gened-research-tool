import GpaSlider from "./GpaSlider";

type GpaRangeFilterProps = {
  values: number[];
  onChange: (values: number[]) => void;
};

export default function GpaRangeFilter({
  values,
  onChange,
}: GpaRangeFilterProps) {
  return (
    <div className="search-card__section">
      <label>GPA Range</label>

      <div className="search-card__gpa-values">
        <span>{values[0].toFixed(1)}</span>
        <span>{values[1].toFixed(1)}</span>
      </div>

      <GpaSlider values={values} setValues={onChange} />
    </div>
  );
}
