package by.etc.karamach.bean;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Answer implements Serializable {
    private static final long serialVersionUID = 3049527556500318388L;

    private int id;
    private boolean isRight;
    private String description;
    private int question_id;

    public Answer() {
    }

    public Answer(int id, boolean isRight, String description, int question_id) {
        this.id = id;
        this.isRight = isRight;
        this.description = description;
        this.question_id = question_id;
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

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
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
                getQuestion_id() == answer.getQuestion_id() &&
                Objects.equals(getDescription(), answer.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isRight(), getDescription(), getQuestion_id());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Answer.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("isRight=" + isRight)
                .add("description='" + description + "'")
                .add("question_id=" + question_id)
                .toString();
    }
}
