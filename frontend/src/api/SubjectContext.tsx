// SubjectContext.tsx

import { createContext, useContext, useEffect, useState } from "react";

import type { Subject } from "../types/Subject";

type SubjectContextType = {
  subjects: Subject[];
  loading: boolean;
};

const SubjectContext = createContext<SubjectContextType>({
  subjects: [],
  loading: true,
});

export function SubjectProvider({ children }: { children: React.ReactNode }) {
  const [subjects, setSubjects] = useState<Subject[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch("http://localhost:8080/subjects")
      .then((r) => r.json())
      .then((data) => {
        setSubjects(data);
        setLoading(false);
      });
  }, []);

  return (
    <SubjectContext.Provider value={{ subjects, loading }}>
      {children}
    </SubjectContext.Provider>
  );
}

export function useSubjects() {
  return useContext(SubjectContext);
}
