package springbootapp.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.entities.LogEntity;
import springbootapp.services.LogService;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public abstract class CrudController<ID extends Serializable, REQ, RESP> {
    private final Class<RESP> respClass;
    private final CrudService<ID> crudService;

    @Autowired
    LogService logService;

    public CrudController(Class<RESP> respClass, CrudService<ID> crudService) {
        this.respClass = respClass;
        this.crudService = crudService;
    }

    @GetMapping
    @CrossOrigin
    List<RESP> findAll() {
        return crudService.findAll(respClass);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public RESP findById(@PathVariable ID id) throws NotFoundException {
        return crudService.findById(id, respClass);
    }

    @PostMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public RESP insert(@RequestBody REQ object) throws NotFoundException {
        logService.log(new LogEntity(null, "Object " + respClass.getSimpleName() + " created.", getDateTime()));
        return crudService.insert(object, respClass);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public RESP update(@PathVariable ID id, @RequestBody REQ object) throws NotFoundException {
        logService.log(new LogEntity(null, "Object " + respClass.getSimpleName() + " updated.", getDateTime()));
        return crudService.update(id, object, respClass);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public void delete(@PathVariable ID id) {
        logService.log(new LogEntity(null, "Object " + respClass.getSimpleName() + " deleted.", getDateTime()));
        crudService.delete(id);
    }

    private Timestamp getDateTime() {
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        return Timestamp.valueOf(currentDateTime);
        long currentTimeMillis = System.currentTimeMillis();
        return new Timestamp(currentTimeMillis);
    }
}
