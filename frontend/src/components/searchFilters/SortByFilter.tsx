import "./SearchFilters.css";

type SortBy = "subject" | "number" | "level" | "title" | "gpa";

type SortByFilterProps = {
  sortBy: SortBy;
  sortDirection: "asc" | "desc";
  onSortByChange: (value: SortBy) => void;
  onDirectionChange: (value: "asc" | "desc") => void;
};

export default function SortByFilter({
  sortBy,
  sortDirection,
  onSortByChange,
  onDirectionChange,
}: SortByFilterProps) {
  return (
    <div className="filter-section">
      <label>Sort By</label>

      <select
        value={sortBy}
        onChange={(e) => onSortByChange(e.target.value as SortBy)}
      >
        <option value="subject">Subject</option>
        <option value="number">Course Number</option>
        <option value="level">Level</option>
        <option value="title">Course Title</option>
        <option value="gpa">Average GPA</option>
      </select>

      <select
        value={sortDirection}
        onChange={(e) => onDirectionChange(e.target.value as "asc" | "desc")}
      >
        <option value="asc">Ascending</option>
        <option value="desc">Descending</option>
      </select>
    </div>
  );
}
