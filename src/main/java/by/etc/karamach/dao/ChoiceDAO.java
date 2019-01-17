package by.etc.karamach.dao;

import by.etc.karamach.bean.Grade;

public interface ChoiceDAO {
    void saveNewChoice(int questionId, int answerId, int gradeId) throws DAOException;

    int getCountAllChoicesByGrade(Grade grade) throws DAOException;

    int getCountRightChoicesByGrade(Grade grade) throws DAOException;

    void deleteUnusedChoices() throws DAOException;
}
