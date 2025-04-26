package com.rene.chart2023analyse.chart;

import com.rene.chart2023analyse.chart.exceptions.ChartNegativeRankException;
import jakarta.persistence.*;

@Entity
@Table(name = "charts2023")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "track_name")
    private String trackName;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "artist_count")
    private int artistCount;

    @Column(name = "released_year")
    private int releasedYear;

    @Column(name = "released_month")
    private int releasedMonth;

    @Column(name = "released_day")
    private int releasedDay;

    @Column(name = "spotify_charts")
    private int spotifyCharts;

    @Column(name = "streams")
    private long streams;

    @Column(name = "apple_charts")
    private int appleCharts;

    @Column(name = "deezer_charts")
    private int deezerCharts;

    @Column(name = "shazam_charts")
    private int shazamCharts;

    @Column(name = "bpm")
    private int bpm;

    @Column(name = "`key`")
    private String key;

    public Track(String trackName, String artistName, int artistCount, int releasedYear, int releasedMonth, int releasedDay, int spotifyCharts, long streams, int appleCharts, int deezerCharts, int shazamCharts, int bpm, String key) {
        this.trackName = trackName;
        this.artistName = artistName;
        this.artistCount = artistCount;
        this.releasedYear = releasedYear;
        this.releasedMonth = releasedMonth;
        this.releasedDay = releasedDay;
        this.spotifyCharts = spotifyCharts;
        this.streams = streams;
        this.appleCharts = appleCharts;
        this.deezerCharts = deezerCharts;
        this.shazamCharts = shazamCharts;
        this.bpm = bpm;
        this.key = key;
    }

    protected Track() {
    }

    public Long getId() {
        return id;
    }

    public void setSpotifyCharts(int spotifyCharts) {
        if (spotifyCharts < 0) {
            throw new ChartNegativeRankException();
        }
        this.spotifyCharts = spotifyCharts;
    }

    public void setAppleCharts(int appleCharts) {
        if (appleCharts < 0) {
            throw new ChartNegativeRankException();
        }
        this.appleCharts = appleCharts;
    }

    public void setDeezerCharts(int deezerCharts) {
        if (deezerCharts < 0) {
            throw new ChartNegativeRankException();
        }
        this.deezerCharts = deezerCharts;
    }

    public void setShazamCharts(int shazamCharts) {
        if (shazamCharts < 0) {
            throw new ChartNegativeRankException();
        }
        this.shazamCharts = shazamCharts;
    }

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
}