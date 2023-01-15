package Repository.InMemory;

import Repository.CrudRepo;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.sql.Types.NULL;

public class UserRepositoryMemory implements CrudRepo<String, User> {
    private final ArrayList<User> allUsers = new ArrayList<>();

    public UserRepositoryMemory() {
        populate();
    }

    public ArrayList<User> getList(){return allUsers;}

    public void populate() {
        User user = new User("Ion", "134", 78, "Client");
        User user1 = new User("Marie", "124", 30, "Client");
        User user2 = new User("Georgiana", "3215", 43, "Client");
        User user3 = new User("Georgica", "2213",23, "Client");
        User user4 = new User("Hagrid", "71002", 73, "Client");
        User user5 = new User("Andreea","154", 37, "Dealer");
        User user6 = new User("Fabian", "1231", 24, "Dealer");
        User user7 = new User("Luciana", "17752", 59, "Dealer");
        User user8 = new User("Adrian", "1121", 43, "Dealer");
        User user9 = new User("Ovi", "5290", 89, "Dealer");
        this.allUsers.add(user);
        this.allUsers.add(user1);
        this.allUsers.add(user2);
        this.allUsers.add(user3);
        this.allUsers.add(user4);
        this.allUsers.add(user5);
        this.allUsers.add(user6);
        this.allUsers.add(user7);
        this.allUsers.add(user8);
        this.allUsers.add(user9);
    }

    public void printing() {
        for (User d : allUsers) {
            System.out.println(d.getName() + d.getPassword());
        }
    }

    @Override
    public void add(User entity) throws Exception {
        try {
            if (entity.getAge() > 18)
                this.allUsers.add(entity);
        }
        catch (RuntimeException e){
            throw new Exception("You are too young!");
        };
    }

    @Override
    public void delete(User s) {
        this.allUsers.remove(s);
    }

    @Override
    public void update(String s, User newEntity) {
        for(User user: allUsers)
            if(Objects.equals(user.getName(), s))
                user = newEntity;
    }

    @Override
    public User findById(String s) throws Exception {
        boolean found = false;
        User u = new User("", "", NULL, "");
        for(User user: allUsers)
            if(Objects.equals(user.getName(), s)) {
                found = true;
                u = user;
                break;
            }
        try{
            if(found)
                return u;
        }
        catch(RuntimeException e){
            throw new Exception("No ID found");
        }
        return null;
    }

    public void printAllUsers(){
        for (User user : allUsers)
            System.out.println(user.getName() + " " + user.getPassword() + " " + user.getAge() + " " + user.getSocialStatus());
    }

    public int size(){
        int k=0;
        for(User user: allUsers)
            k+=1;
        return k;
    }
}
