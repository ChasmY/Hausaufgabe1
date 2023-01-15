package Controller;

import model.User;
import org.junit.jupiter.api.Test;

import static java.sql.Types.NULL;
import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    UserController users = new UserController();

    @Test
    void add() throws Exception {
        User user = new User("Mada", "2341", 23, "Dealer");
        User user1 = new User("Luca", "3422", 20, "Dealer");
        User user2 = new User("Ale", "2093", 20, "Client");
        users.add(user);
        assert(users.size() == 11);
        users.add(user1);
        assert(users.size() == 12);
        users.add(user2);
        assert(users.size() == 13);

        try{
            User user3 = new User("Mircea", "243", 15, "Client");
            users.add(user3);
        }
        catch (RuntimeException e){
            assert true;
        }

    }

    @Test
    void delete() throws Exception {
        users.delete(users.findById("Georgiana"));
        assert(users.size() == 9);
        users.delete(users.findById("Hagrid"));
        assert(users.size() == 8);
        users.delete(users.findById("Adrian"));
        assert(users.size() == 7);
        users.delete(users.findById("Ovi"));
        assert(users.size() == 6);
        users.delete(users.findById("Fabian"));
        assert(users.size() == 5);
        users.delete(users.findById("Luciana"));
        users.delete(users.findById("Georgica"));
        users.delete(users.findById("Marie"));
        users.delete(users.findById("Ion"));
        users.delete(users.findById("Andreea"));
        assert(users.size() == 0);
    }

    @Test
    void findById() throws Exception {
        assert(users.findById("Andreea") == users.getList().get(5));
        assert(users.findById("Ion") == users.getList().get(0));
        assert(users.findById("Luciana") == users.getList().get(7));

        try{
            User u = new User("", "", NULL, "");
            u = users.findById("Ares");
        }
        catch (RuntimeException e){
            assert true;
        }
    }

}