package com.rene.chart2023analyse.chart.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record NewTrack(@NotBlank String trackName, @NotBlank String artistName, @NotNull @Positive int artistCount,
                       @NotNull @Positive int releasedDay, @NotNull @Positive int releasedMonth,
                       @NotNull @Positive int releasedYear,
                       @PositiveOrZero int spotifyCharts, @PositiveOrZero int appleCharts,
                       @PositiveOrZero int deezerCharts, @PositiveOrZero int shazamCharts,
                       @Positive long streams,
                       @NotNull @PositiveOrZero int bpm, String key) {

}
