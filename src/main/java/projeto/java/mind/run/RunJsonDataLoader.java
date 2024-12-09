package projeto.java.mind.run;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class RunJsonDataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(RunJsonDataLoader.class);

    private final JdbcClientRunRepository runRepository;
    private final ObjectMapper objectMapper;

    public RunJsonDataLoader(JdbcClientRunRepository runRepository, ObjectMapper objectMapper) {
        this.runRepository = runRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (runRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")){
                Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
                logger.info("Lendo {} runs de um data json e salvando na coleção de memoria", allRuns.runs().size());
                runRepository.saveAll(allRuns.runs());
            } catch (Exception e) {
                throw new RuntimeException("Falha em ler o Json", e);
            }
        }else{
            logger.info("Não carregou os runs do data json porque a coleção contains data.");
        }
    }

}
