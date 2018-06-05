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

        Integer midcount = 0;
        Integer endcount = 0;

        Double low = 0.0;
        Double high = 0.0;

        Double midLow = 0.0;
        Double midHigh = 0.0;

        Integer m = intervalList.size();

        Boolean isPossible;

        for (Integer f = 0; f < Math.round(m / 2.0); f++) {
            midcount = 0;
            endcount = 0;

            for (Pair pair : pairList) {
                endcount -= pair.getType();

                if (endcount >= m - f) {
                    low = pair.getOffset();
                    endcount = 0;

                    for (Pair pair2 : reservePairList) {
                        endcount += pair2.getType();

                        if (endcount >= m - f) {
                            high = pair2.getOffset();

                            if (low <= high && midcount <= f) {
                                for(Pair pair3 : reservePairList){
                                    if(pair3.getType().equals(0)) midHigh = pair3.getOffset();
                                    if(pair3.getOffset() < high) break;
                                }
                                return new Interval(midLow, midHigh);
                            }
                        }else{
                            if (pair2.getType().equals(0)) {
                                midHigh = pair2.getOffset();
                                midcount++;
                            }
                        }
                    }

                }else{
                    if (pair.getType().equals(0)) {
                        midLow = pair.getOffset();
                        midcount++;
                    }
                }
            }
        }

        throw new InvalidIntervalException();
    }
}
