import "./Header.css";

export default function Header() {
  return (
    <header className="header">
      <div className="header__left">
        <div className="header__logo">🎓</div>

        <div>
          <h1 className="header__title">Gen-Ed Research Tool</h1>
        </div>
      </div>
    </header>
  );
}