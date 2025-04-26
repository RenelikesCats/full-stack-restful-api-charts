package com.rene.chart2023analyse.chart;

import com.rene.chart2023analyse.chart.dto.ArtistTrackDayMonthYearStreams;
import com.rene.chart2023analyse.chart.dto.NewTrack;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("chart2023/tracks")
public class ChartController {
    private final ChartService chartService;

    public ChartController(ChartService chartService) {
        this.chartService = chartService;
    }

    @Operation(summary = "Finds all (includes name, song title, date, streams)")
    @GetMapping()
    public Stream<ArtistTrackDayMonthYearStreams> findAll() {
        return chartService.findAll().stream().map(ArtistTrackDayMonthYearStreams::new);
    }

    @Operation(summary = "Returns tracks with no featured artist(s)")
    @GetMapping("solo")
    public Stream<ArtistTrackDayMonthYearStreams> findOnlySoloArtists() {
        return chartService.findOnlySoloArtists().stream().map(ArtistTrackDayMonthYearStreams::new);
    }

    @Operation(summary = "Returns all tracks with given specific year")
    @GetMapping("filterByYear")
    public Stream<ArtistTrackDayMonthYearStreams> findByReleasedYear(@RequestParam int releaseYear) {
        return chartService.findByReleasedYear(releaseYear).stream().map(ArtistTrackDayMonthYearStreams::new);
    }

    @Operation(summary = "Find all tracks by given platform and given rank")
    @GetMapping("{platform}/rank")
    public Stream<ArtistTrackDayMonthYearStreams> findAllByPlatform_And_ChartsByRank(@PathVariable String platform, @RequestParam int rank) {
        return chartService.findAllByPlatform_And_ChartsByRank(platform, rank).stream().map(ArtistTrackDayMonthYearStreams::new);
    }

    @Operation(summary = "Delete a track by given track id")
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        chartService.delete(id);
    }

    @Operation(summary = "Updates the chart rank for an existing track in DB")
    @PutMapping("{id}/{platform}/setrank")
    public void updateChartRank(@PathVariable long id, @PathVariable String platform, @RequestParam int rank) {
        chartService.updateChartRank(id, platform, rank);
    }

    @Operation(summary = "Create new track")
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@RequestBody @Valid NewTrack newTrack) {
        return chartService.create(newTrack);
    }

}
