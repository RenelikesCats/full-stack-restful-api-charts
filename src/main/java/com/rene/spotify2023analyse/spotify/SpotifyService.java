package com.rene.spotify2023analyse.spotify;

import com.rene.spotify2023analyse.spotify.exceptions.PlatformNotFoundException;
import com.rene.spotify2023analyse.spotify.exceptions.TrackNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SpotifyService {
    private final SpotifyRepository spotifyRepository;


    public SpotifyService(SpotifyRepository spotifyRepository) {
        this.spotifyRepository = spotifyRepository;
    }

    List<Track> findAll() {
        return spotifyRepository.findAll();
    }

    List<Track> findOnlySoloArtists() {
        return spotifyRepository.findByArtistCountEquals(1);
    }

    List<Track> findByReleasedYear(int releaseYear) {
        return spotifyRepository.findByReleasedYear(releaseYear);
    }

    List<Track> findAllByPlatform_And_ChartsByRank(String platform, int rank) {
        String chart = platform.toLowerCase() + "Charts";
        switch (chart) {
            case "spotifyCharts" -> {
                return spotifyRepository.findAllSpotifyChartsByRank(rank);
            }
            case "appleCharts" -> {
                return spotifyRepository.findAllAppleChartsByRank(rank);
            }
            case "deezerCharts" -> {
                return spotifyRepository.findAllDeezerChartsByRank(rank);
            }
            case "shazamCharts" -> {
                return spotifyRepository.findAllShazamChartsByRank(rank);
            }
            default -> throw new PlatformNotFoundException();
        }
    }

    @Transactional
    void delete(long id) {
        Track track = spotifyRepository.findById(id).orElseThrow(() -> new TrackNotFoundException(id));
        spotifyRepository.deleteById(id);
    }

    @Transactional
    void updateChartRank(long id, String platform, int rank) {
        String chart = platform.toLowerCase() + "Charts";
        switch (chart) {
            case "spotifyCharts" -> {
                Track track = spotifyRepository.findById(id).orElseThrow(() -> new TrackNotFoundException(id));
                track.setSpotifyCharts(rank);

            }
            case "appleCharts" -> {
                Track track = spotifyRepository.findById(id).orElseThrow(() -> new TrackNotFoundException(id));
                track.setAppleCharts(rank);

            }
            case "deezerCharts" -> {
                Track track = spotifyRepository.findById(id).orElseThrow(() -> new TrackNotFoundException(id));
                track.setDeezerCharts(rank);

            }
            case "shazamCharts" -> {
                Track track = spotifyRepository.findById(id).orElseThrow(() -> new TrackNotFoundException(id));
                track.setShazamCharts(rank);


            }
            default -> throw new PlatformNotFoundException();
        }


    }
}



