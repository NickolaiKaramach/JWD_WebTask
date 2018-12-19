package by.etc.karamach.bean;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Question implements Serializable {
    private static final long serialVersionUID = -8965441960212156538L;

    private int id;
    private int test_id;
    private String description;

    public Question() {
    }

    public Question(int id, int test_id, String description) {
        this.id = id;
        this.test_id = test_id;
        this.description = description;
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
                getTest_id() == question.getTest_id() &&
                Objects.equals(getDescription(), question.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTest_id(), getDescription());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Question.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("test_id=" + test_id)
                .add("description='" + description + "'")
                .toString();
    }
}
