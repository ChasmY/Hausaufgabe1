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
    public User findById(Integer id) throws Exception {
        return super.findById(id);
    }

    @Override
    public void update(Integer id, User newEntity) {
        super.update(id, newEntity);
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
