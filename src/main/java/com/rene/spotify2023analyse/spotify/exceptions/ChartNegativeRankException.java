package com.rene.spotify2023analyse.spotify.exceptions;

public class ChartNegativeRankException extends RuntimeException {
    public ChartNegativeRankException() {
        super("Chart cannot be under 0");
    }
}
