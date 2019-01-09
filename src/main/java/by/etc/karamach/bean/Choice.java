package by.etc.karamach.bean;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Choice implements Serializable {
    private static final long serialVersionUID = 7404199510942119275L;

    private int id;

    private int questionId;
    private int answerId;
    private int gradeId;

    public Choice() {
    }

    public Choice(int id, int questionId, int answerId, int gradeId) {
        this.id = id;
        this.questionId = questionId;
        this.answerId = answerId;
        this.gradeId = gradeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Choice choice = (Choice) o;

        return getId() == choice.getId() &&
                getQuestionId() == choice.getQuestionId() &&
                getAnswerId() == choice.getAnswerId() &&
                getGradeId() == choice.getGradeId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getQuestionId(), getAnswerId(), getGradeId());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Choice.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("questionId=" + questionId)
                .add("answerId=" + answerId)
                .add("gradeId=" + gradeId)
                .toString();
    }
}
