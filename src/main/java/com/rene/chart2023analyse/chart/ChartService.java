package com.rene.chart2023analyse.chart;

import com.rene.chart2023analyse.chart.dto.NewTrack;
import com.rene.chart2023analyse.chart.exceptions.PlatformNotFoundException;
import com.rene.chart2023analyse.chart.exceptions.TrackNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ChartService {
    private final ChartRepository chartRepository;


    public ChartService(ChartRepository chartRepository) {
        this.chartRepository = chartRepository;
    }

    List<Track> findAll() {
        return chartRepository.findAll();
    }

    List<Track> findOnlySoloArtists() {
        return chartRepository.findByArtistCountEquals(1);
    }

    List<Track> findByReleasedYear(int releaseYear) {
        return chartRepository.findByReleasedYear(releaseYear);
    }

    List<Track> findAllByPlatform_And_ChartsByRank(String platform, int rank) {
        String chart = platform.toLowerCase() + "Charts";
        switch (chart) {
            case "spotifyCharts" -> {
                return chartRepository.findAllSpotifyChartsByRank(rank);
            }
            case "appleCharts" -> {
                return chartRepository.findAllAppleChartsByRank(rank);
            }
            case "deezerCharts" -> {
                return chartRepository.findAllDeezerChartsByRank(rank);
            }
            case "shazamCharts" -> {
                return chartRepository.findAllShazamChartsByRank(rank);
            }
            default -> throw new PlatformNotFoundException();
        }
    }

    @Transactional
    void delete(long id) {
        Track track = chartRepository.findById(id).orElseThrow(() -> new TrackNotFoundException(id));
        chartRepository.deleteById(id);
    }

    @Transactional
    void updateChartRank(long id, String platform, int rank) {
        String chart = platform.toLowerCase() + "Charts";
        Track track = chartRepository.findById(id).orElseThrow(() -> new TrackNotFoundException(id));
        switch (chart) {
            case "spotifyCharts" -> {
                track.setSpotifyCharts(rank);

            }
            case "appleCharts" -> {
                track.setAppleCharts(rank);

            }
            case "deezerCharts" -> {
                track.setDeezerCharts(rank);

            }
            case "shazamCharts" -> {
                track.setShazamCharts(rank);
            }
            default -> throw new PlatformNotFoundException();
        }
    }

    @Transactional
    long create(NewTrack newTrack) {
        Track track = new Track(newTrack.trackName(), newTrack.artistName(), newTrack.artistCount(),
                newTrack.releasedYear(), newTrack.releasedMonth(), newTrack.releasedDay(),
                newTrack.spotifyCharts(), newTrack.streams(), newTrack.appleCharts(), newTrack.deezerCharts(), newTrack.shazamCharts(),
                newTrack.bpm(), newTrack.key());

        return chartRepository.save(track).getId();
    }
}



