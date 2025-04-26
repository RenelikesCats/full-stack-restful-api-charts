package com.rene.spotify2023analyse.spotify;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotifyRepository extends JpaRepository<Track, Long> {
}
