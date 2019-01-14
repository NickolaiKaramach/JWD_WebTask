package by.etc.karamach.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.StringJoiner;

public class Grade implements Serializable {
    private static final long serialVersionUID = 2551435947564380776L;

    private int id;
    private int testId;
    private int userId;
    private int mark;
    private Timestamp finishTime;
    private boolean isFinished;


    private transient Test test;

    public Grade() {
    }

    public Grade(int id, int testId, int userId, int mark, Timestamp finishTime, boolean isFinished, Test test) {
        this.id = id;
        this.testId = testId;
        this.userId = userId;
        this.mark = mark;
        this.finishTime = finishTime;
        this.isFinished = isFinished;
        this.test = test;
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

    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Grade grade = (Grade) o;

        return getId() == grade.getId() &&
                getTestId() == grade.getTestId() &&
                getUserId() == grade.getUserId() &&
                getMark() == grade.getMark() &&
                isFinished() == grade.isFinished() &&
                Objects.equals(getFinishTime(), grade.getFinishTime()) &&
                Objects.equals(getTest(), grade.getTest());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTestId(), getUserId(), getMark(), getFinishTime(), isFinished(), getTest());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Grade.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("testId=" + testId)
                .add("userId=" + userId)
                .add("mark=" + mark)
                .add("finishTime=" + finishTime)
                .add("isFinished=" + isFinished)
                .add("test=" + test)
                .toString();
    }
}
