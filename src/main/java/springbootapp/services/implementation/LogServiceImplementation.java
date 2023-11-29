package springbootapp.services.implementation;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import springbootapp.models.entities.LogEntity;
import springbootapp.repositories.LogRepository;
import springbootapp.services.LogService;

@Service
@Transactional
public class LogServiceImplementation implements LogService {

    private final LogRepository repository;

    public LogServiceImplementation(LogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void log(LogEntity log) {
        System.out.println("save and flush");
        repository.saveAndFlush(log);
    }
}
