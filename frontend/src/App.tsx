import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "./pages/home/Home";
import SearchResults from "./pages/searchResults/SearchResults";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/results" element={<SearchResults />} />
      </Routes>
    </BrowserRouter>
  );
}
