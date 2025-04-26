package com.rene.spotify2023analyse.spotify;

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

    List<Track> findAll(){
        return spotifyRepository.findAll();
    }

}
