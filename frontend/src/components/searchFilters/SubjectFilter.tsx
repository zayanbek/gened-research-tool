import { useSubjects } from "../../api/SubjectContext";

type SubjectFilterProps = {
  value: string;
  onChange: (value: string) => void;
};

export default function SubjectFilter({ value, onChange }: SubjectFilterProps) {
  const { subjects, loading } = useSubjects();

  return (
    <div className="search-card__section">
      <label htmlFor="subject">Subject</label>

      <select
        id="subject"
        value={value}
        onChange={(e) => onChange(e.target.value)}
        disabled={loading}
      >
        <option value="">
          {loading ? "Loading subjects..." : "Any Subject"}
        </option>

        {subjects.map((subject) => (
          <option key={subject.code} value={subject.code}>
            {subject.code} - {subject.name}
          </option>
        ))}
      </select>
    </div>
  );
}
