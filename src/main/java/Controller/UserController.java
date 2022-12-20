package Controller;

import Repository.InMemory.UserRepositoryMemory;
import model.User;

import java.util.List;

public class UserController extends UserRepositoryMemory {

    //UserRepositoryMemory repo = new UserRepositoryMemory();

    @Override
    public void add(User entity) throws Exception {
        super.add(entity);
    }

    @Override
    public void delete(User s) {
        super.delete(s);
    }

    @Override
    public User findById(String s) throws Exception {
        return super.findById(s);
    }

    @Override
    public void update(String s, User newEntity) {
        super.update(s, newEntity);
    }

    @Override
    public void printAllUsers()
    {
        super.printAllUsers();
    }

    @Override
    public int size(){
        return super.size();
    }

}
