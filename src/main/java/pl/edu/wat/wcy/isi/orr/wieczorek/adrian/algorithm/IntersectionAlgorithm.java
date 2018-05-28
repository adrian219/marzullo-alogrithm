package pl.edu.wat.wcy.isi.orr.wieczorek.adrian.algorithm;

import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.element.Interval;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.element.Pair;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.exception.InvalidIntervalException;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.util.AlgorithmType;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.util.ListGetter;

import java.util.List;

public class IntersectionAlgorithm extends Algorithm {

    public IntersectionAlgorithm() {
        super(AlgorithmType.INTERSECTION);
    }

    public Interval getBestInterval(List<Interval> intervalList) throws InvalidIntervalException {
        List<Pair> pairList = ListGetter.getSortPairList(intervalList, algorithmType);
        List<Pair> reservePairList = ListGetter.getReserveList(pairList);

        System.out.println(pairList.toString());

        Integer midcount = 0;
        Integer endcount = 0;

        Double low = 0.0;
        Double high = 0.0;

        Integer m = intervalList.size();

        for (Integer f = 0; f < Math.round(m / 2.0); f++) {
            midcount = 0;
            endcount = 0;

            for (Pair pair : pairList) {
                endcount -= pair.getType();

                if (endcount >= m - f) {
                    low = pair.getOffset();
                    break;
                }

                if (pair.getType().equals(0)) {
                    midcount++;
                    endcount = 0;
                }

                for (Pair pair2 : reservePairList) {
                    endcount += pair2.getType();

                    if (endcount >= m - f) {
                        high = pair2.getOffset();
                        break;
                    }

                    if (pair2.getType().equals(0)) {
                        midcount++;
                    }
                }
            }

            if (midcount <= f) {
                break;
            }
        }

        if (low > high) {
            throw new InvalidIntervalException();
        }

        return new Interval(low, high);
    }
}
