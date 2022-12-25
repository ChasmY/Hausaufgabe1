package Repository.InMemory;

import Repository.CrudRepo;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.sql.Types.NULL;

public class UserRepositoryMemory implements CrudRepo<Integer, User> {
    private final ArrayList<User> allUsers = new ArrayList<>();

    public UserRepositoryMemory() {
        populate();
    }

    public ArrayList<User> getList(){return allUsers;}

    public void populate() {
        User user = new User(1,"Ion", "134", 78, "Client");
        User user1 = new User(2,"Marie", "124", 30, "Client");
        User user2 = new User(3,"Georgiana", "3215", 43, "Client");
        User user3 = new User(4,"Georgica", "2213",23, "Client");
        User user4 = new User(5,"Hagrid", "71002", 73, "Client");
        User user5 = new User(6,"Andreea","154", 37, "Dealer");
        User user6 = new User(7,"Fabian", "1231", 24, "Dealer");
        User user7 = new User(8,"Luciana", "17752", 59, "Dealer");
        User user8 = new User(9,"Adrian", "1121", 43, "Dealer");
        User user9 = new User(10,"Ovi", "5290", 89, "Dealer");
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
    public void update(Integer id, User newEntity) {
        for(User user: allUsers)
            if(Objects.equals(user.getIdUser(), id))
                user = newEntity;
    }

    @Override
    public User findById(Integer id) throws Exception {
        boolean found = false;
        User u = new User(NULL,"", "", NULL, "");
        for(User user: allUsers)
            if(Objects.equals(user.getIdUser(), id)) {
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
