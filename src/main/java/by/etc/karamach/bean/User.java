package by.etc.karamach.bean;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class User implements Serializable {
    private static final long serialVersionUID = -6844576554904773999L;

    //TODO: Question - shell we on our own set id?
    private int id;
    private String email;
    private String password;
    private String name;
    private int accessLevel;

    public User(int id, String email, String password, String name, int accessLevel) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.accessLevel = accessLevel;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;
        return id == user.getId() &&
                accessLevel == user.getAccessLevel() &&
                Objects.equals(email, user.getEmail()) &&
                Objects.equals(password, user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, accessLevel);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("accessLevel=" + accessLevel)
                .toString();
    }
}
