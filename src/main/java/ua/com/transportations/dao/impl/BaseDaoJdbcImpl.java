package ua.com.transportations.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ua.com.transportations.dao.BaseDao;
import ua.com.transportations.models.db.IdEntity;

import javax.sql.DataSource;

/**
 * Created by d.fedorov on 05.06.16.
 */
public abstract class BaseDaoJdbcImpl<T extends IdEntity> implements BaseDao<T>{


    protected abstract Class<T> getEntityClass();
    protected abstract DataSource getDataSource();
    protected abstract String getTableName();

    @Override
    public T get(long id) {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(getDataSource());
        return template.queryForObject(
                String.format("SELECT * FROM %s WHERE id = :id", getTableName()),
                new MapSqlParameterSource("id", id),
                new BeanPropertyRowMapper<T>(getEntityClass()));
    }

    @Override
    public T save(T entity) {
        SimpleJdbcInsert template = new SimpleJdbcInsert(getDataSource())
                .withTableName(getTableName())
                .usingGeneratedKeyColumns("id");
        Number id = template.executeAndReturnKey(new BeanPropertySqlParameterSource(entity));
        entity.setId(id.longValue());
        return entity;
    }


}
