import "./SearchFilters.css";

type OfferedLastTermFilterProps = {
  value: boolean;
  onChange: (offered: boolean) => void;
};

export default function OfferedLastTermFilter({
  value,
  onChange,
}: OfferedLastTermFilterProps) {
  return (
    <div className="filter-section filter-toggle">
      <label htmlFor="semester">Offered in Spring 2026?</label>

      <input
        id="semester"
        type="checkbox"
        checked={value}
        onChange={(e) => onChange(e.target.checked)}
      />
    </div>
  );
}
