package pl.edu.wat.wcy.isi.orr.wieczorek.adrian.element;

public class Pair implements Comparable<Pair> {
    private Double offset;
    private Integer type;

    public Pair(Double offset, Integer type) {
        this.offset = offset;
        this.type = type;
    }

    public Double getOffset() {
        return offset;
    }

    public void setOffset(Double offset) {
        this.offset = offset;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public int compareTo(Pair o) {
        if(o.getOffset().equals(this.getOffset())) return o.getType() - this.getType();
        return (this.getOffset() - o.getOffset()) > 0 ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "offset=" + offset +
                ", type=" + type +
                '}';
    }
}
