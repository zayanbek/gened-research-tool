import "./SearchFilters.css";

type LevelFilterProps = {
  value: number | undefined;
  onChange: (level: number | undefined) => void;
};

export default function LevelFilter({ value, onChange }: LevelFilterProps) {
  return (
    <div className="filter-section">
      <label htmlFor="level">Course Level</label>

      <select
        id="level"
        value={value ?? ""}
        onChange={(e) =>
          onChange(e.target.value === "" ? undefined : Number(e.target.value))
        }
      >
        <option value="">Any Level</option>
        <option value={100}>100</option>
        <option value={200}>200</option>
        <option value={300}>300</option>
        <option value={400}>400</option>
        <option value={500}>500</option>
      </select>
    </div>
  );
}
