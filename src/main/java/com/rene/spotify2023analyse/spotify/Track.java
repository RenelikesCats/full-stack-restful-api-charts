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


    private int artistCount;


    private int releasedYear;


    private int releasedMonth;


    private int releasedDay;

    private int spotifyCharts;

    private long streams;

    private int appleCharts;

    private int deezerCharts;

    private int shazamCharts;

    private int bpm;


    private String key;

    public String getTrackName() {
        return trackName;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getArtistCount() {
        return artistCount;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public int getReleasedMonth() {
        return releasedMonth;
    }

    public int getReleasedDay() {
        return releasedDay;
    }

    public int getSpotifyCharts() {
        return spotifyCharts;
    }

    public long getStreams() {
        return streams;
    }

    public int getAppleCharts() {
        return appleCharts;
    }

    public int getDeezerCharts() {
        return deezerCharts;
    }

    public int getShazamCharts() {
        return shazamCharts;
    }

    public int getBpm() {
        return bpm;
    }

    public String getKey() {
        return key;
    }

    public Long getId() {
        return id;
    }
}