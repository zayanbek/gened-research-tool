export default function CourseNameFilter() {
  return (
    <div className="search-card__section">
      <label htmlFor="courseName">Course Name</label>
      <input
        id="courseName"
        type="text"
        placeholder="Search by course title..."
      />
    </div>
  );
}
