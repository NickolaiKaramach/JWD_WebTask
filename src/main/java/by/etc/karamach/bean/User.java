package by.etc.karamach.bean;

import java.util.Objects;
import java.util.StringJoiner;

public class User {
    //TODO: Question - shell we on our own set id?
    private int id;
    private String login;
    private String password;
    private int accessLevel;

    public User() {
    }

    public User(int id, String login, String password, int accessLevel) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
                Objects.equals(login, user.getLogin()) &&
                Objects.equals(password, user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, accessLevel);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("login='" + login + "'")
                .add("password='" + password + "'")
                .add("accessLevel=" + accessLevel)
                .toString();
    }
}
