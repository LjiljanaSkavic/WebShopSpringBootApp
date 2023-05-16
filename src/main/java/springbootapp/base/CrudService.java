package springbootapp.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import springbootapp.exceptions.NotFoundException;

import java.io.Serializable;
import java.util.List;

public interface CrudService<ID extends Serializable> {
    <T> List<T> findAll(Class<T> resultDtoClass);

    <T> Page<T> findAll(Pageable page, Class<T> resultDtoClass);

    <T> T findById(ID id, Class<T> resultDtoClass);

    <T, U> T insert(U object, Class<T> resultDtoClass);

    <T, U> T update(ID id, U object, Class<T> resultDtoClass);

    void delete(ID id) throws NotFoundException;
}
