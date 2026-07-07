import Header from "../../components/header/Header";
import Sidebar from "../../components/sidebar/Sidebar";

import "./SearchResults.css";

export default function Home() {
  return (
    <div className="page">
      <Header />

      <main className="home">
        <Sidebar />
      </main>
    </div>
  );
}
