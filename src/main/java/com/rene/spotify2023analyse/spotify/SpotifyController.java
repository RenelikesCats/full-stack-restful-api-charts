package com.rene.spotify2023analyse.spotify;

import com.rene.spotify2023analyse.spotify.dto.ArtistTrackDayMonthYearStreams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("spotify2023chart")
public class SpotifyController {
    private final SpotifyService spotifyService;

    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping()
    public Stream<ArtistTrackDayMonthYearStreams> findAll() {
        return spotifyService.findAll().stream().map(ArtistTrackDayMonthYearStreams::new);
    }

}
