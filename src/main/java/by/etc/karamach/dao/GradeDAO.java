package by.etc.karamach.dao;

import by.etc.karamach.bean.Grade;

public interface GradeDAO {
    void saveNewGrade(Grade grade) throws DAOException;
}
