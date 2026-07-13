import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import App from "./App.tsx";

import "./theme.css";
import { SubjectProvider } from "./api/SubjectContext.tsx";

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <SubjectProvider>
      <App />
    </SubjectProvider>
  </StrictMode>,
);
