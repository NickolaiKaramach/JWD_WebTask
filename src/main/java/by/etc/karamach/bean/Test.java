package by.etc.karamach.bean;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Test implements Serializable {
    private static final long serialVersionUID = 5483058234636613217L;

    private int id;
    private String name;
    private int ownerId;
    private String status;

    public Test(int id, String name, int ownerId, String status) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Test test = (Test) o;

        return getId() == test.getId() &&
                getOwnerId() == test.getOwnerId() &&
                Objects.equals(getName(), test.getName()) &&
                Objects.equals(getStatus(), test.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getOwnerId(), getStatus());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Test.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("ownerId=" + ownerId)
                .add("status='" + status + "'")
                .toString();
    }
}
