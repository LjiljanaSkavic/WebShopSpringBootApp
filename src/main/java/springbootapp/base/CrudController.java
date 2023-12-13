package springbootapp.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.entities.LogEntity;
import springbootapp.services.LogService;
import springbootapp.services.SharedService;

import java.io.Serializable;
import java.util.List;

public abstract class CrudController<ID extends Serializable, REQ, RESP> {
    private final Class<RESP> respClass;
    private final CrudService<ID> crudService;

    private SharedService sharedService;

    @Autowired
    LogService logService;

    public CrudController(Class<RESP> respClass, CrudService<ID> crudService) {
        this.respClass = respClass;
        this.crudService = crudService;
        this.sharedService = new SharedService();
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
        logService.log(new LogEntity(null, "Object " + respClass.getSimpleName() + " created.", sharedService.getDateTime()));
        return crudService.insert(object, respClass);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public RESP update(@PathVariable ID id, @RequestBody REQ object) throws NotFoundException {
        logService.log(new LogEntity(null, "Object " + respClass.getSimpleName() + " updated.", sharedService.getDateTime()));
        return crudService.update(id, object, respClass);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public void delete(@PathVariable ID id) {
        logService.log(new LogEntity(null, "Object " + respClass.getSimpleName() + " deleted.", sharedService.getDateTime()));
        crudService.delete(id);
    }
}
