import "./SearchFilters.css";

type CourseNameFilterProps = {
  value: string;
  onChange: (value: string) => void;
};

export default function CourseNameFilter({
  value,
  onChange,
}: CourseNameFilterProps) {
  return (
    <div className="filter-section">
      <label htmlFor="courseName">Course Name</label>

      <input
        id="courseName"
        type="text"
        placeholder="Search by course title..."
        value={value}
        onChange={(e) => onChange(e.target.value)}
      />
    </div>
  );
}
