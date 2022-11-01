package Repository;

import model.User;

public interface UserRepository extends CrudRepo<String, User>{
    User findByUsernameAndPassword(String username, String password, int age);
}
