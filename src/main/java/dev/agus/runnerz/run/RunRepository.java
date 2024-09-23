package dev.agus.runnerz.run;

import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(50, ChronoUnit.MINUTES), 5, Location.OUTDOORS));
        runs.add(new Run(1, "Evening Run", LocalDateTime.now(), LocalDateTime.now().plus(50, ChronoUnit.MINUTES), 5, Location.OUTDOORS));
    }
}
