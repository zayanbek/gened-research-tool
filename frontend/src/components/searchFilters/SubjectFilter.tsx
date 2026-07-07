export default function SubjectFilter() {
  return (
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
  );
}
