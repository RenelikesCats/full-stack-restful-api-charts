package com.rene.spotify2023analyse.spotify;

import jakarta.persistence.*;

@Entity
@Table(name = "spotify2023")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackName;


    private String artistName;


    private Integer artistCount;


    private Integer releasedYear;


    private Integer releasedMonth;


    private Integer releasedDay;

    private Integer spotifyCharts;

    private Integer streams;

    private Integer appleCharts;

    private Integer deezerCharts;

    private Integer shazamCharts;

    private Integer bpm;


    private String key;

    public Long getId() {
        return id;
    }


    public String getTrackName() {
        return trackName;
    }


    public String getArtistName() {
        return artistName;
    }


    public Integer getArtistCount() {
        return artistCount;
    }


    public Integer getReleasedYear() {
        return releasedYear;
    }


    public Integer getReleasedMonth() {
        return releasedMonth;
    }


    public Integer getReleasedDay() {
        return releasedDay;
    }


    public Integer getSpotifyCharts() {
        return spotifyCharts;
    }


    public Integer getStreams() {
        return streams;
    }


    public Integer getAppleCharts() {
        return appleCharts;
    }


    public Integer getDeezerCharts() {
        return deezerCharts;
    }


    public Integer getShazamCharts() {
        return shazamCharts;
    }


    public Integer getBpm() {
        return bpm;
    }


    public String getKey() {
        return key;
    }


}