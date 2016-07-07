package ua.com.transportations.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import ua.com.transportations.dao.UserDao;
import ua.com.transportations.models.db.User;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by d.fedorov on 28.06.16.
 */
@Component
public class UserDaoJdbcImpl extends BaseDaoJdbcImpl<User> implements UserDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public void addUserRole(long userId, int userRole) {
        SimpleJdbcInsert template = new SimpleJdbcInsert(dataSource).withTableName("user_roles");
        Map<String, Object> userRoleEntity = new HashMap(2);
        userRoleEntity.put("userId", userId);
        userRoleEntity.put("userRole", userRole);

        template.execute(userRoleEntity);
    }

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
        return "users";
    }
}
