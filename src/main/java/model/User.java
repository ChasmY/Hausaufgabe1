package model;

import javax.persistence.*;

@Entity //Pentru a fi creat tabelul
@Table(name = "Users") //In ce tabel vor fi stocate datele
@Inheritance(strategy = InheritanceType.JOINED) //Pentru crearea relatiilor de mostenire intre User-Client si User-Dealer
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
//Diferentierea useri-lor cine este Dealer, respectiv Client
public abstract class User {

    @Id //Stabilirea cheii Primare
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idUser;
    private String name;
    private String password;
    private int age;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public User(String name, String password, int age) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public User(){}
}