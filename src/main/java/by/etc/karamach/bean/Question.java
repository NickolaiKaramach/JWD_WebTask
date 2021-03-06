package by.etc.karamach.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Question implements Serializable {
    private static final long serialVersionUID = -3269717093128035302L;

    private int id;
    private int testId;
    private String description;
    private int ownerId;

    transient private List<Answer> answerList;

    public Question() {
    }

    public Question(int id, int testId, String description, int ownerId, List<Answer> answerList) {
        this.id = id;
        this.testId = testId;
        this.description = description;
        this.ownerId = ownerId;
        this.answerList = answerList;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Question question = (Question) o;

        return getId() == question.getId() &&
                getTestId() == question.getTestId() &&
                getOwnerId() == question.getOwnerId() &&
                Objects.equals(getDescription(), question.getDescription()) &&
                Objects.equals(getAnswerList(), question.getAnswerList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTestId(), getDescription(), getOwnerId(), getAnswerList());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Question.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("testId=" + testId)
                .add("description='" + description + "'")
                .add("ownerId=" + ownerId)
                .add("answerList=" + answerList)
                .toString();
    }
}
