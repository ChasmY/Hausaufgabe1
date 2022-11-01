package Controller;

import Repository.InMemory.UserRepositoryMemory;
import model.User;

import java.util.List;

public class UserController extends UserRepositoryMemory {

    public UserController(List<User> allUsers) {
        super(allUsers);
    }

    @Override
    public void add(User entity) {
        super.add(entity);
    }

    @Override
    public void delete(User s) {
        super.delete(s);
    }

    @Override
    public User findById(String s) {
        return super.findById(s);
    }

    @Override
    public void update(String s, User newEntity) {
        super.update(s, newEntity);
    }
}
