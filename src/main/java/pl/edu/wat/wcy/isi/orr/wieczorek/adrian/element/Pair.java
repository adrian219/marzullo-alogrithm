package pl.edu.wat.wcy.isi.orr.wieczorek.adrian.element;

public class Pair implements Comparable<Pair> {
    private Long offset;
    private Integer type;

    public Pair(Long offset, Integer type) {
        this.offset = offset;
        this.type = type;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
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
        return o.getOffset().intValue() - this.getOffset().intValue();
    }
}
