package com.rene.chart2023analyse.chart.exceptions;

public class ChartNegativeRankException extends RuntimeException {
    public ChartNegativeRankException() {
        super("Chart cannot be under 0");
    }
}
