package ua.com.transportations.dao;

import ua.com.transportations.models.db.User;

/**
 * Created by d.fedorov on 05.06.16.
 */
public interface UserDao extends BaseDao<User> {

    public void addUserRole(long userId, int userRole);
}
