import "./SearchResults.css";

import Header from "../../components/header/Header";
import Sidebar from "../../components/sidebar/Sidebar";
import ResultsCard from "../../components/resultsCard/ResultsCard";

export default function SearchResults() {
  return (
    <div className="page">
      <Header />

      <main className="search-results">
        <Sidebar />

        <section className="search-results__content">
          <ResultsCard />
          <ResultsCard />
        </section>
      </main>
    </div>
  );
}
