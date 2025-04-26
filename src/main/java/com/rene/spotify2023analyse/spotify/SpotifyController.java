package com.rene.spotify2023analyse.spotify;

import com.rene.spotify2023analyse.spotify.dto.ArtistTrackDayMonthYearStreams;
import com.rene.spotify2023analyse.spotify.exceptions.TrackNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("spotify2023chart")
public class SpotifyController {
    private final SpotifyService spotifyService;

    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @Operation(summary = "Finds all (includes name, song title, date, streams)")
    @GetMapping("/tracks")
    public Stream<ArtistTrackDayMonthYearStreams> findAll() {
        return spotifyService.findAll().stream().map(ArtistTrackDayMonthYearStreams::new);
    }

    @Operation(summary = "Returns tracks with no featured artist(s)")
    @GetMapping("tracks/solo")
    public Stream<ArtistTrackDayMonthYearStreams> findOnlySoloArtists() {
        return spotifyService.findOnlySoloArtists().stream().map(ArtistTrackDayMonthYearStreams::new);
    }

    @Operation(summary = "Returns all tracks with given specific year")
    @GetMapping("/tracks/filterByYear")
    public Stream<ArtistTrackDayMonthYearStreams> findByReleasedYear(@RequestParam int releaseYear) {
        return spotifyService.findByReleasedYear(releaseYear).stream().map(ArtistTrackDayMonthYearStreams::new);
    }

    @Operation(summary = "Find all tracks by given platform and given rank")
    @GetMapping("/tracks/{platform}/rank")
    public Stream<ArtistTrackDayMonthYearStreams> findAllByPlatform_And_ChartsByRank(@PathVariable String platform, @RequestParam int rank) {
        return spotifyService.findAllByPlatform_And_ChartsByRank(platform, rank).stream().map(ArtistTrackDayMonthYearStreams::new);
    }

    @Operation(summary = "Delete a track by given track id")
    @DeleteMapping("/tracks/{id}")
    public void deleteById(@PathVariable long id) {
        spotifyService.delete(id);
    }

    @Operation(summary = "Updates the chart rank for an existing track in DB")
    @PutMapping("/tracks/{id}/{platform}/setrank")
    public void updateChartRank(@PathVariable long id, @PathVariable String platform, @RequestParam int rank) {
        spotifyService.updateChartRank(id,platform, rank);
    }

}
