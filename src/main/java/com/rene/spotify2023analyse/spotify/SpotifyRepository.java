package com.rene.spotify2023analyse.spotify;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpotifyRepository extends JpaRepository<Track, Long> {
    List<Track> findByReleasedYear(int releaseYear);

    List<Track> findByArtistCountEquals(int artistCount);

    @Query("select t from Track t where t.spotifyCharts = :rank order by t.id")
    List<Track> findAllSpotifyChartsByRank(int rank);

    @Query("select t from Track t where t.appleCharts = :rank order by t.id")
    List<Track> findAllAppleChartsByRank(int rank);

    @Query("select t from Track t where t.deezerCharts = :rank order by t.id")
    List<Track> findAllDeezerChartsByRank(int rank);

    @Query("select t from Track t where t.shazamCharts = :rank order by t.id")
    List<Track> findAllShazamChartsByRank(int rank);

}
