package com.rene.spotify2023analyse.spotify;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotifyController {
    private final SpotifyService spotifyService;

    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

}
