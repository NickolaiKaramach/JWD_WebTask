package by.etc.karamach.dao.pool;

import java.util.ResourceBundle;

public class DBResourceManager {
    private final static DBResourceManager instance = new DBResourceManager();
    private static final String DATABASE_PROPERTIES_FILE = "database";

    private ResourceBundle resourceBundle = ResourceBundle.getBundle(DATABASE_PROPERTIES_FILE);


    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return resourceBundle.getString(key);
    }
}
