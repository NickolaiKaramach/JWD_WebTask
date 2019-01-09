package by.etc.karamach.bean;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Answer implements Serializable {
    private static final long serialVersionUID = -5998132299192393135L;

    private int id;
    private boolean isRight;
    private String description;
    private int questionId;

    public Answer() {
    }

    public Answer(int id, boolean isRight, String description, int questionId) {
        this.id = id;
        this.isRight = isRight;
        this.description = description;
        this.questionId = questionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Answer answer = (Answer) obj;

        return getId() == answer.getId() &&
                isRight() == answer.isRight() &&
                getQuestionId() == answer.getQuestionId() &&
                Objects.equals(getDescription(), answer.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isRight(), getDescription(), getQuestionId());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Answer.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("isRight=" + isRight)
                .add("description='" + description + "'")
                .add("questionId=" + questionId)
                .toString();
    }
}
