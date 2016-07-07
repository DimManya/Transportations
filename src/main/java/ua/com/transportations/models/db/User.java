package ua.com.transportations.models.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ua.com.transportations.models.extra.UserRole;
import ua.com.transportations.models.extra.UserStatus;

/**
 * Created by d.fedorov on 05.06.16.
 */
public class User extends IdEntity {

    private long id;
    private String fName;
    private String lName;
    private String password;
    private String email;
    private String phone;
    private Integer age;
    private Integer gender;
    private int status;

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getfName() {
        return fName;
    }

    public User setfName(String fName) {
        this.fName = fName;
        return this;
    }

    public String getlName() {
        return lName;
    }

    public User setlName(String lName) {
        this.lName = lName;
        return this;
    }

    public String getFullName() {
        return String.format("%s %s", fName, lName);
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }


    public Integer getGender() {
        return gender;
    }

    public User setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public User setStatus(int status) {
        if (status >= UserStatus.values().length) {
            throw new IllegalArgumentException("User status is out of range for id = " + id);
        }
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!password.equals(user.password)) return false;
        if (!email.equals(user.email)) return false;
        return phone.equals(user.phone);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }

}
