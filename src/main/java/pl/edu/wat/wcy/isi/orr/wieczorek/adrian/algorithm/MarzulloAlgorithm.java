package pl.edu.wat.wcy.isi.orr.wieczorek.adrian.algorithm;

import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.element.Interval;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.element.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarzulloAlgorithm {

    public static Interval getBestInterval(List<Interval> intervalList){

        List<Pair> pairList = getSortPairList(intervalList);

        Integer best = 0;
        Integer current = 0;

        Pair currentPair;

        Long bestStart = 0L;
        Long bestEnd = 0L;

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

    private static List<Pair> getSortPairList(List<Interval> intervalList) {
        List<Pair> pairList = getPairList(intervalList);
        Collections.sort(pairList);
        return pairList;
    }

    private static List<Pair> getPairList(List<Interval> intervalList) {
        List<Pair> pairList = new ArrayList<>();
        for(Interval interval : intervalList){
            pairList.add(new Pair(interval.getStart(), -1));
            pairList.add(new Pair(interval.getEnd(), +1));
        }
        return pairList;
    }
}
