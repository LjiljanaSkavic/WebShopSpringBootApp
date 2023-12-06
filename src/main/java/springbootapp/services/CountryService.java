package springbootapp.services;

import springbootapp.base.CrudService;

public interface CountryService extends CrudService<Integer> {

    boolean findByName(String name);
}
