package ua.com.transportations.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.transportations.dao.UserDao;
import ua.com.transportations.models.db.User;

import javax.sql.DataSource;

/**
 * Created by d.fedorov on 28.06.16.
 */
@Component
public class UserDaoJdbcImpl extends BaseDaoJdbcImpl<User> implements UserDao{

    @Autowired
    private DataSource dataSource;


    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected DataSource getDataSource() {
        return dataSource;
    }

    @Override
    protected String getTableName() {
        return "TS_USER";
    }
}
