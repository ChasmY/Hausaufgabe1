package model;

public class User {
    private int age;
    private String name, password;

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

    public void setAge(int age){
        this.age = age;
    }

    public User(String name, String password, int age) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}