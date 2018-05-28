package pl.edu.wat.wcy.isi.orr.wieczorek.adrian.element;

public class Interval {
    private Double start;
    private Double end;

    public Interval(Double start, Double end) {
        this.start = start;
        this.end = end;
    }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(Double end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
