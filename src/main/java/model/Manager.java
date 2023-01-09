package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Pentru a fi creat tabelul
@Table(name = "Managers") //Mentionam in ce tabel sunt stocate datele
public class Manager {

    @Id
    private int idManager;

    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String mainUsername;
    @Column
    private String mainPassword;
    @Column
    private String newUsername;
    @Column
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

    public Manager(){}
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
