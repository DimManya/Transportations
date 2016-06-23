package ua.com.transportations.dao.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d.fedorov on 05.06.16.
 */
public class BaseDao<T> {

    public T save(T entity) {
        return entity;
    }

    public T update(T entity) {
        return entity;
    }

    public T saveOrUpdate(T entity) {
//        if (entity.getId() == null) {
//            return save(entity);
//        } else {
//            return update(entity);
//        }
        return null;
    }

    public T findById(Long id) {
        return null;
    }

    protected List<T> findByCriteria() {
        List<T> result = new ArrayList<T>();
        return result;
    }


}
