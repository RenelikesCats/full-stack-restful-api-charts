package com.rene.chart2023analyse.chart.dto;

import com.rene.chart2023analyse.chart.Track;

public record ArtistTrackDayMonthYearStreams(String artistName, String trackName, String date,
                                             long streams) {
    public ArtistTrackDayMonthYearStreams(Track track) {
        this(track.getArtistName(), track.getTrackName(), track.getReleasedDay() + "/" + track.getReleasedMonth() + "/" + track.getReleasedYear(), track.getStreams());
    }
}
