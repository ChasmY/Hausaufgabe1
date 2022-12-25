package model;

public class User {
    private int idUser;
    private int age;
    private String name, password, socialStatus;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){this.age = age;}

    public String getSocialStatus() {return socialStatus;}

    public void setSocialStatus(String socialStatus) {
        this.socialStatus = socialStatus;
    }

    public User(int idUser, String name, String password, int age, String socialStatus) {
        this.idUser = idUser;
        this.name = name;
        this.age = age;
        this.password = password;
        this.socialStatus = socialStatus;
    }
}