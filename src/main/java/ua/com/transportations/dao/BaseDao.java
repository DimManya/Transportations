package ua.com.transportations.dao;

import ua.com.transportations.models.db.IdEntity;

/**
 * Created by d.fedorov on 28.06.16.
 */
public interface BaseDao<T extends IdEntity> {

    T get(long id);

    T save(T entity);
}
