import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  ResponsiveContainer,
} from "recharts";

import type { GpaHistoryDto } from "../../../types/GpaHistoryDto";

type Props = {
  history: GpaHistoryDto[];
};

export default function GpaHistoryChart({ history }: Props) {
  const data = history.map((entry) => ({
    semester: `${entry.term} ${entry.year}`,
    gpa: entry.gpa,
  }));

  return (
    <ResponsiveContainer width="100%" height={220}>
      <LineChart data={data}>
        <CartesianGrid stroke="var(--border)" />

        <XAxis dataKey="semester" tick={{ fill: "var(--foreground)" }} />

        <YAxis domain={[0, 4]} tick={{ fill: "var(--foreground)" }} />

        <Tooltip
          formatter={(value) => [
            typeof value === "number" ? value.toFixed(2) : value,
            "GPA",
          ]}
        />

        <Line
          type="monotone"
          dataKey="gpa"
          stroke="var(--primary)"
          strokeWidth={3}
          dot={{ r: 4 }}
        />
      </LineChart>
    </ResponsiveContainer>
  );
}
