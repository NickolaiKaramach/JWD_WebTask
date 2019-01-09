package by.etc.karamach.dao;

public interface ChoiceDAO {
    void saveNewChoice(int questionId, int answerId, int gradeId) throws DAOException;
}
