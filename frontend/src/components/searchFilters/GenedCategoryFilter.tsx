import "./SearchFilters.css";

type GenedCategoryFilterProps = {
  value: string[];
  onChange: (codes: string[]) => void;
};

const GEN_ED_CATEGORIES = [
  {
    code: "ACP",
    name: "Advanced Composition",
  },
  {
    code: "HUM",
    name: "Humanities and the Arts",
    children: [
      { code: "HP", name: "Historical & Philosophical Perspectives" },
      { code: "LA", name: "Literature & the Arts" },
    ],
  },
  {
    code: "SBS",
    name: "Social & Behavioral Sciences",
    children: [
      { code: "BSC", name: "Behavioral Sciences" },
      { code: "SS", name: "Social Sciences" },
    ],
  },
  {
    code: "NAT",
    name: "Natural Sciences & Technology",
    children: [
      { code: "LS", name: "Life Sciences" },
      { code: "PS", name: "Physical Sciences" },
    ],
  },
  {
    code: "CS",
    name: "Cultural Studies",
    children: [
      { code: "NW", name: "Non-Western Cultures" },
      { code: "US", name: "US Minority Cultures" },
      { code: "WCC", name: "Western/Comparative Cultures" },
    ],
  },
  {
    code: "QR",
    name: "Quantitative Reasoning",
    children: [
      { code: "QR1", name: "Quantitative Reasoning I" },
      { code: "QR2", name: "Quantitative Reasoning II" },
    ],
  },
];

export default function GenEdCategoryFilter({
  value,
  onChange,
}: GenedCategoryFilterProps) {
  function toggle(code: string) {
    // Is this a parent category?
    const parent = GEN_ED_CATEGORIES.find((c) => c.code === code);

    if (parent) {
      const children = parent.children?.map((c) => c.code) ?? [];

      if (value.includes(code)) {
        // Uncheck the parent and all children
        onChange(
          value.filter(
            (selected) => selected !== code && !children.includes(selected),
          ),
        );
      } else {
        // Check the parent and all children
        onChange([...new Set([...value, code, ...children])]);
      }

      return;
    }

    // Otherwise, it's a child category
    const parentOfChild = GEN_ED_CATEGORIES.find((c) =>
      c.children?.some((child) => child.code === code),
    );

    if (value.includes(code)) {
      const next = value.filter((selected) => selected !== code);

      if (parentOfChild) {
        const siblingCodes =
          parentOfChild.children?.map((child) => child.code) ?? [];

        const anyChildrenSelected = siblingCodes.some(
          (childCode) => childCode !== code && next.includes(childCode),
        );

        if (!anyChildrenSelected) {
          // Remove the parent too if no children remain selected
          onChange(next.filter((selected) => selected !== parentOfChild.code));
          return;
        }
      }

      onChange(next);
    } else {
      const next = [...value, code];

      if (parentOfChild && !next.includes(parentOfChild.code)) {
        next.push(parentOfChild.code);
      }

      onChange(next);
    }
  }

  return (
    <div className="filter-section">
      <label>Gen-Ed Categories</label>

      <div className="filter-checkboxes">
        {GEN_ED_CATEGORIES.map((category) => {
          const parentSelected = value.includes(category.code);

          return (
            <div key={category.code} className="filter-gened-category">
              <label className="filter-checkbox">
                <input
                  type="checkbox"
                  checked={parentSelected}
                  onChange={() => toggle(category.code)}
                />

                <span>
                  <strong>{category.code}</strong> – {category.name}
                </span>
              </label>

              {parentSelected && category.children && (
                <div className="filter-gened-subcategories">
                  {category.children.map((child) => (
                    <label key={child.code} className="filter-checkbox">
                      <input
                        type="checkbox"
                        checked={value.includes(child.code)}
                        onChange={() => toggle(child.code)}
                      />

                      <span>
                        <strong>{child.code}</strong> – {child.name}
                      </span>
                    </label>
                  ))}
                </div>
              )}
            </div>
          );
        })}
      </div>
    </div>
  );
}
