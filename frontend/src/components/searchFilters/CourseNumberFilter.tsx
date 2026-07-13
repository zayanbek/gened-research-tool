type CourseNumberFilterProps = {
  value: number | undefined;
  onChange: (value: number | undefined) => void;
};

export default function CourseNumberFilter({
  value,
  onChange,
}: CourseNumberFilterProps) {
  return (
    <div className="search-card__section">
      <label htmlFor="courseNumber">Course Number</label>

      <input
        id="courseNumber"
        type="number"
        value={value ?? ""}
        placeholder="e.g. 225"
        onChange={(e) =>
          onChange(e.target.value === "" ? undefined : Number(e.target.value))
        }
      />
    </div>
  );
}
