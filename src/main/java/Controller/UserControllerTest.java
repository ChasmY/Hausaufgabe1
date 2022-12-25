package Controller;

import model.User;
import org.junit.jupiter.api.Test;

import static java.sql.Types.NULL;
import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    UserController users = new UserController();

    @Test
    void add() throws Exception {
        User user = new User(11,"Mada", "2341", 23, "Dealer");
        User user1 = new User(12,"Luca", "3422", 20, "Dealer");
        User user2 = new User(13,"Ale", "2093", 20, "Client");
        users.add(user);
        assert(users.size() == 11);
        users.add(user1);
        assert(users.size() == 12);
        users.add(user2);
        assert(users.size() == 13);

        try{
            User user3 = new User(14, "Mircea", "243", 15, "Client");
            users.add(user3);
        }
        catch (RuntimeException e){
            assert true;
        }

    }

    @Test
    void delete() throws Exception {
        users.delete(users.findById(1));
        users.delete(users.findById(6));
        assert(users.size() == 8);
        users.delete(users.findById(2));
        assert(users.size() == 7);
        users.delete(users.findById(3));
        assert(users.size() == 6);
        users.delete(users.findById(4));
        assert(users.size() == 5);
        users.delete(users.findById(5));
        assert(users.size() == 4);
        users.delete(users.findById(7));
        users.delete(users.findById(8));
        users.delete(users.findById(9));
        users.delete(users.findById(10));
        assert(users.size() == 0);
    }

    @Test
    void findById() throws Exception {
        assert(users.findById(4) == users.getList().get(3));
        assert(users.findById(1) == users.getList().get(0));
        assert(users.findById(8) == users.getList().get(7));

        try{
            User u = new User(NULL,"", "", NULL, "");
            u = users.findById(18);
        }
        catch (RuntimeException e){
            assert true;
        }
    }

}