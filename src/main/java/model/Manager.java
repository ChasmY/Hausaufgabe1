package model;

import java.util.concurrent.atomic.AtomicLong;

public class Manager {
    //private static final AtomicLong idCounter = new AtomicLong();
    private int idManager;
    private String name;
    private int age;
    private String mainUsername;
    private String mainPassword;
    private String newUsername;
    private String newPassword;

    public Manager(int idManager, String name, int age, String newUsername, String newPassword) {
        this.idManager = idManager;
        this.name = name;
        this.age = age;
        this.mainUsername = "map-casino";
        this.mainPassword = "casino123";
        this.newUsername = newUsername;
        this.newPassword = newPassword;
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int id) {
        this.idManager = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMainUsername() {
        return mainUsername;
    }

    public void setMainUsername(String mainUsername) {
        this.mainUsername = mainUsername;
    }

    public String getMainPassword() {
        return mainPassword;
    }

    public void setMainPassword(String mainPassword) {
        this.mainPassword = mainPassword;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
