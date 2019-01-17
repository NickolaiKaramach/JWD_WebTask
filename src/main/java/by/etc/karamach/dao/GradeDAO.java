package by.etc.karamach.dao;

import by.etc.karamach.bean.Grade;

import java.sql.Timestamp;
import java.util.List;

public interface GradeDAO {
    void saveNewGrade(Grade grade) throws DAOException;

    void finishGrade(int finishingGrade, Timestamp currentTimestamp, int gradeId) throws DAOException;

    List<Grade> takeUserGrades(Integer userId) throws DAOException;

    void deleteUnusedGrades() throws DAOException;
}
