export default function CourseNumberFilter() {
  return (
    <div className="search-card__section">
      <label htmlFor="courseNumber">Course Number</label>
      <input id="courseNumber" type="number" placeholder="e.g. 225" />
    </div>
  );
}
