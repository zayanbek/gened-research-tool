import Header from "../../components/header/Header";
import SearchCard from "../../components/searchCard/SearchCard";

import "./Home.css";

export default function Home() {
  return (
    <div className="page">
      <Header />

      <main className="home">
        <SearchCard />
      </main>
    </div>
  );
}