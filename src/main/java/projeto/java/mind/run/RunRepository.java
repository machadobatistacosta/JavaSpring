package projeto.java.mind.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
    
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    Optional<Run> findById(Integer id){
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }

    void create(Run run){
        runs.add(run);
    }

    void update(Run run, Integer id){
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id){
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init(){
        runs.add(new Run(1, "Java spring boot"));

        runs.add(new Run(2,"Java spring boot 2"));
    }
}