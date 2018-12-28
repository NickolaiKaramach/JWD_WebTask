package by.etc.karamach.bean;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Grade implements Serializable {
    private static final long serialVersionUID = -2744249801865549578L;

    private int id;
    private int testId;
    private int userId;
    private int mark;

    public Grade() {
    }

    public Grade(int id, int testId, int userId, int mark) {
        this.id = id;
        this.testId = testId;
        this.userId = userId;
        this.mark = mark;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
                getTestId() == grade.getTestId() &&
                getUserId() == grade.getUserId() &&
                getMark() == grade.getMark();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTestId(), getUserId(), getMark());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Grade.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("testId=" + testId)
                .add("userId=" + userId)
                .add("mark=" + mark)
                .toString();
    }
}
