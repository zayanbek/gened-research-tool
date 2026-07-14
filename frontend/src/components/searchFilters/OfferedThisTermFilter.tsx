import "./SearchFilters.css";

export default function OfferedThisTermFilter() {
  return (
    <div className="search-card__section search-card__toggle">
      <label htmlFor="semester">Available Next Semester</label>

      <input id="semester" type="checkbox" />
    </div>
  );
}
