package pl.edu.wat.wcy.isi.orr.wieczorek.adrian.algorithm;

import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.element.Interval;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.exception.InvalidIntervalException;
import pl.edu.wat.wcy.isi.orr.wieczorek.adrian.util.AlgorithmType;

import java.util.List;

public abstract class Algorithm {
    protected AlgorithmType algorithmType;

    public Algorithm(AlgorithmType algorithmType) {
        this.algorithmType = algorithmType;
    }

    public abstract Interval getBestInterval(List<Interval> intervalList) throws InvalidIntervalException;
}
