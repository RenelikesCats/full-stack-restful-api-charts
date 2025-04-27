package com.rene.chart2023analyse.chart.dto;

import com.rene.chart2023analyse.chart.Track;

public record ResponseConciseDTO(long id, String artistName, String trackName, String date,
                                 long streams,int spotify,int apple,int deezer,int shazam) {
    public ResponseConciseDTO(Track track) {
        this(track.getId(),track.getArtistName(), track.getTrackName(), track.getReleasedDay() + "/" + track.getReleasedMonth() + "/" + track.getReleasedYear(),
                track.getStreams(),track.getSpotifyCharts(),track.getAppleCharts(),track.getDeezerCharts(),track.getShazamCharts());
    }
}
