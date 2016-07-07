package ua.com.transportations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.transportations.dao.UserDao;
import ua.com.transportations.exceptions.BadRequestException;
import ua.com.transportations.models.db.User;
import ua.com.transportations.models.extra.UserRole;
import ua.com.transportations.models.extra.UserStatus;

/**
 * Created by d.fedorov on 05.06.16.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setStatus(UserStatus.REGISTERED.ordinal())
                .setPassword(
                        passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
        userDao.addUserRole(user.getId(), UserRole.USER.ordinal());
        return user;
    }

    public User getUser(long userId) {
        try {

            return userDao.get(userId);
        } catch (EmptyResultDataAccessException e) {
            throw new BadRequestException();
        }
    }
}
