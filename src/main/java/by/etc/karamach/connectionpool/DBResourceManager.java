package by.etc.karamach.connectionpool;

import java.util.ResourceBundle;

public class DBResourceManager {
    private final static DBResourceManager instance = new DBResourceManager();

    private ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return resourceBundle.getString(key);
    }
}
