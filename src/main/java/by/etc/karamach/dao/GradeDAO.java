package by.etc.karamach.dao;

import by.etc.karamach.bean.Grade;

import java.sql.Timestamp;

public interface GradeDAO {
    void saveNewGrade(Grade grade) throws DAOException;

    void finishGrade(int finishingGrade, Timestamp currentTimestamp, int gradeId) throws DAOException;
}
