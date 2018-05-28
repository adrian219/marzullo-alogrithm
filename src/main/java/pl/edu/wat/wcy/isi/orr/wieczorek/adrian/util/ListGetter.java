package pl.edu.wat.wcy.isi.orr.wieczorek.adrian.util;

import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.element.Interval;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.element.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListGetter {

    public static List<Pair> getSortPairList(List<Interval> intervalList, AlgorithmType algorithmType) {
        List<Pair> pairList = getPairList(intervalList, algorithmType);

        Collections.sort(pairList);
        return pairList;
    }

    public static List<Pair> getReserveList(List<Pair> pairList){
        List<Pair> reservePairList = new ArrayList<>(pairList);
        Collections.reverse(reservePairList);

        return reservePairList;
    }


    private static List<Pair> getPairList(List<Interval> intervalList, AlgorithmType algorithmType) {
        List<Pair> pairList = new ArrayList<>();
        for(Interval interval : intervalList){
            pairList.add(new Pair(interval.getStart(), -1));
            if(algorithmType.equals(AlgorithmType.INTERSECTION)){
                pairList.add(new Pair(getAverage(interval.getStart(), interval.getEnd()), 0));
            }
            pairList.add(new Pair(interval.getEnd(), +1));
        }
        return pairList;
    }

    private static Double getAverage(Double a, Double b){
        return (a+b)/2.0;
    }
}
