package com.rene.spotify2023analyse.spotify.dto;

import com.rene.spotify2023analyse.spotify.Track;

public record ArtistTrackDayMonthYearStreams(String artistName, String trackName, int day, int month, int year,
                                             long streams) {
    public ArtistTrackDayMonthYearStreams(Track track) {
        this(track.getArtistName(), track.getTrackName(), track.getReleasedDay(), track.getReleasedMonth(), track.getReleasedYear(), track.getStreams());
    }
}
