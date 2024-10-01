package dev.agus.runnerz.run;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class runJSONDataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(runJSONDataLoader.class);
    private RunRepository runRepository;
    private ObjectMapper objectMapper;

    public runJSONDataLoader(RunRepository runRepository, ObjectMapper objectMapper) {
        this.runRepository = runRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (runRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")) {
                Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
                logger.info("Runs loaded from JSON file" + allRuns.runs().size());
                runRepository.saveAll(allRuns.runs());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
