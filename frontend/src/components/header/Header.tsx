import "./Header.css";
import { useNavigate } from "react-router-dom";

export default function Header() {
  const navigate = useNavigate();

  return (
    <header className="header">
      <div className="header__left">
        <button className="header__logo" onClick={() => navigate("/")}>
          🎓
        </button>

        <div>
          <h1 className="header__title">Gen-Ed Research Tool</h1>
        </div>
      </div>
    </header>
  );
}
