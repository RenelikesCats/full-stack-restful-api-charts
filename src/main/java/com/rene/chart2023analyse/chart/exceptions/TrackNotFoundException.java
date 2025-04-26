package com.rene.chart2023analyse.chart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TrackNotFoundException extends RuntimeException {
    public TrackNotFoundException(long id) {

        super("Couldn't find a track with id: " + id);
    }
}
