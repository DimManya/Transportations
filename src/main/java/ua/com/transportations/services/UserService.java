package ua.com.transportations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.com.transportations.dao.UserDao;
import ua.com.transportations.models.db.User;
import ua.com.transportations.models.extra.UserStatus;

/**
 * Created by d.fedorov on 05.06.16.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User registerUser(User user) {
        user.setStatus(UserStatus.REGISTERED.ordinal());
        return userDao.save(user);
    }

    public User getUser(long userId) {
        return userDao.get(userId);
    }
}
