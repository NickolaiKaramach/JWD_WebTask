package by.etc.karamach.bean;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Test implements Serializable {
    private static final long serialVersionUID = 6868597506057900721L;

    private int id;
    private String name;
    private int ownerId;

    public Test(int id, String name, int ownerId) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
    }

    public Test() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Test test = (Test) obj;

        return getId() == test.getId() &&
                getOwnerId() == test.getOwnerId() &&
                Objects.equals(getName(), test.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getOwnerId());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Test.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("ownerId=" + ownerId)
                .toString();
    }
}
