package pl.edu.wat.wcy.isi.orr.wieczorek.adrian.algorithm;

import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.element.Interval;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.element.Pair;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.exception.InvalidIntervalException;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.util.AlgorithmType;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.util.ListGetter;

import java.util.List;

public class MarzulloAlgorithm extends Algorithm {

    public MarzulloAlgorithm() {
        super(AlgorithmType.MARZULLO);
    }

    public Interval getBestInterval(List<Interval> intervalList) throws InvalidIntervalException {

        List<Pair> pairList = ListGetter.getSortPairList(intervalList, algorithmType);

        Integer best = 0;
        Integer current = 0;

        Pair currentPair;

        Double bestStart = 0.0;
        Double bestEnd = 0.0;

        for(Integer i = 0; i<pairList.size(); i++){
            currentPair = pairList.get(i);

            current -= currentPair.getType();

            if(current > best){
                best = current;
                bestStart = currentPair.getOffset();
                bestEnd = pairList.get(i+1).getOffset();
            }
        }


        return new Interval(bestStart, bestEnd);
    }
}
