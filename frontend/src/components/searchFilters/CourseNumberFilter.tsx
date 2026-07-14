import "./SearchFilters.css";

type CourseNumberFilterProps = {
  value?: number;
  onChange: (value?: number) => void;
};

export default function CourseNumberFilter({
  value,
  onChange,
}: CourseNumberFilterProps) {
  return (
    <div className="filter-section">
      <label htmlFor="courseNumber">Course Number</label>

      <input
        id="courseNumber"
        type="number"
        min={0}
        max={999}
        step={1}
        placeholder="e.g. 225"
        value={value ?? ""}
        onChange={(e) => {
          const text = e.target.value;

          if (text === "") {
            onChange(undefined);
            return;
          }

          const number = Number(text);

          if (number >= 0 && number <= 999) {
            onChange(number);
          }
        }}
      />
    </div>
  );
}
