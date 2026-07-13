import { Range, getTrackBackground } from "react-range";

type GpaSliderProps = {
  values: number[];
  setValues: (values: number[]) => void;
};

export default function GpaSlider({ values, setValues }: GpaSliderProps) {
  return (
    <Range
      step={0.1}
      min={0}
      max={4}
      values={values}
      onChange={setValues}
      renderTrack={({ props, children }) => {
        const { key, ...trackProps } = props;

        return (
          <div
            key={key}
            {...trackProps}
            className="gpa-slider__track"
            style={{
              ...trackProps.style,
              background: getTrackBackground({
                values,
                colors: [
                  "var(--secondary)",
                  "var(--primary)",
                  "var(--secondary)",
                ],
                min: 0,
                max: 4,
              }),
            }}
          >
            {children}
          </div>
        );
      }}
      renderThumb={({ props }) => {
        const { key, ...thumbProps } = props;

        return <div key={key} {...thumbProps} className="gpa-slider__thumb" />;
      }}
    />
  );
}
