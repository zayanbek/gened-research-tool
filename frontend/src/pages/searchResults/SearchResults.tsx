import "./SearchResults.css";

import Header from "../../components/header/Header";
import Sidebar from "../../components/sidebar/Sidebar";
import ResultsCard from "../../components/resultsCard/ResultsCard";

import { searchCourses } from "../../api/courses";

import type { CourseSearchRequest } from "../../types/CourseSearchRequest";

import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import type { CourseSearchResult } from "../../types/CourseSearchResult";

export default function SearchResults() {
  const location = useLocation();

  // Initial filters passed from the Home page
  const initialFilters = (location.state as
    | CourseSearchRequest
    | undefined) ?? {
    subject: "",
    number: undefined,
    level: undefined,
    minGpa: 0,
    maxGpa: 4,
    title: "",
    genEdCodes: [],
  };

  // Sidebar edits this state
  const [filters, setFilters] = useState<CourseSearchRequest>(initialFilters);

  const [results, setResults] = useState<CourseSearchResult[]>([]);
  const [loading, setLoading] = useState(false);

  async function loadResults() {
    setLoading(true);

    try {
      const response = await searchCourses(filters);
      setResults(response);
    } catch (err) {
      console.error(err);
    } finally {
      setLoading(false);
    }
  }

  function resetFilters() {
    setFilters({
      subject: "",
      number: undefined,
      level: undefined,
      minGpa: 0,
      maxGpa: 4,
      title: "",
      genEdCodes: [],
    });
  }

  // Perform the initial search when arriving from Home
  useEffect(() => {
    loadResults();
  }, []);

  return (
    <div className="page">
      <Header />

      <main className="search-results">
        <Sidebar
          filters={filters}
          setFilters={setFilters}
          onSearch={loadResults}
          onReset={resetFilters}
        />

        <section className="search-results__content">
          {loading ? (
            <p>Loading...</p>
          ) : results.length === 0 ? (
            <p>No courses found.</p>
          ) : (
            results.map((course) => (
              <ResultsCard key={course.id} course={course} />
            ))
          )}
        </section>
      </main>
    </div>
  );
}
