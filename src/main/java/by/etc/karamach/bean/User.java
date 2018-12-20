package by.etc.karamach.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class User implements Serializable {
    private static final long serialVersionUID = 8057498312405991389L;

    private int id;
    private String email;
    private String password;
    private String name;
    private int accessLevel;

    transient private List<Test> createdTests;
    transient private List<Grade> grades;

    public User(int id, String email, String password, String name, int accessLevel) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.accessLevel = accessLevel;
    }

    public User() {
    }

    public List<Test> getCreatedTests() {
        return createdTests;
    }

    public void setCreatedTests(List<Test> createdTests) {
        this.createdTests = createdTests;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
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

        return getId() == user.getId() &&
                getAccessLevel() == user.getAccessLevel() &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getCreatedTests(), user.getCreatedTests()) &&
                Objects.equals(getGrades(), user.getGrades());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getPassword(), getName(), getAccessLevel(), getCreatedTests(), getGrades());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("name='" + name + "'")
                .add("accessLevel=" + accessLevel)
                .toString();
    }
}
