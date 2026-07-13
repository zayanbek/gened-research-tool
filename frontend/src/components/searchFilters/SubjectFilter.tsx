type SubjectFilterProps = {
  value: string;
  onChange: (value: string) => void;
};

export default function SubjectFilter({ value, onChange }: SubjectFilterProps) {
  return (
    <div className="search-card__section">
      <label htmlFor="subject">Subject</label>

      <select
        id="subject"
        value={value}
        onChange={(e) => onChange(e.target.value)}
      >
        <option value="">Any Subject</option>
        <option value="CS">CS</option>
        <option value="MATH">MATH</option>
        <option value="ECON">ECON</option>
        <option value="STAT">STAT</option>
      </select>
    </div>
  );
}
