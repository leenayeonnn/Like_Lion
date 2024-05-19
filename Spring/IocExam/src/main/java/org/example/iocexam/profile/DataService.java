package org.example.iocexam.profile;

public class DataService {
    private String env;

    public DataService(String env) {
        this.env = env;
    }

    public String getEnv() {
        return env;
    }
}
