package Repository.InMemory;

import Repository.CrudRepo;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositoryMemory implements CrudRepo<String, User> {
    private List<User> allUsers;

    public UserRepositoryMemory(List<User> allUsers) {
        this.allUsers = allUsers;
//        populateUsers();
    }

    public void populateUsers() {
        User user1 = new User("Ion", "134", 78);
        User user2 = new User("Marie", "124", 30);
        this.allUsers.add(user1);
        this.allUsers.add(user2);
    }

    public void printing() {
        for (User d : allUsers) {
            System.out.println(d.getName() + d.getPassword());
        }
    }

    @Override
    public void add(User entity) {
        this.allUsers.add(entity);
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
    public User findById(String s) {
        for(User user: allUsers)
            if(Objects.equals(user.getName(), s))
                return user;
        return null;
    }
}
