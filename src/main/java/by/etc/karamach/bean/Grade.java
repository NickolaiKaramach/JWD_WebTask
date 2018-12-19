package by.etc.karamach.bean;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Grade implements Serializable {
    private static final long serialVersionUID = -2744249801865549578L;

    private int id;
    private int test_id;
    private int user_id;
    private int mark;

    public Grade() {
    }

    public Grade(int id, int test_id, int user_id, int mark) {
        this.id = id;
        this.test_id = test_id;
        this.user_id = user_id;
        this.mark = mark;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Grade grade = (Grade) obj;

        return getId() == grade.getId() &&
                getTest_id() == grade.getTest_id() &&
                getUser_id() == grade.getUser_id() &&
                getMark() == grade.getMark();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTest_id(), getUser_id(), getMark());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Grade.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("test_id=" + test_id)
                .add("user_id=" + user_id)
                .add("mark=" + mark)
                .toString();
    }
}
