import "./ResultsCard.css";

export default function ResultsCard() {
  return (
    <aside className="results-card">
      <label className="results-card__subject-code">MATH 421</label>
      <h2 className="results-card__subject-name">Calculus III</h2>

      <div className="results-card__geneds">
        <span className="results-card__tag">QR2</span>
        <span className="results-card__tag">HUM</span>
        <span className="results-card__tag">NAT</span>
      </div>
    </aside>
  );
}
