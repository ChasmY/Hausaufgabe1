package Controller;

import model.Manager;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.sql.Types.NULL;
import static org.junit.jupiter.api.Assertions.*;

class ManagerControllerTest {

    ManagerController managers = new ManagerController();

    @Test
    void add() throws Exception {
        Manager manager = new Manager(3, "Andreea", 45, "andreea123", "casino2");
        Manager manager1 = new Manager(4, "Gheorghe", 51, "gheorghe123", "casino3");
        managers.add(manager);
        assert(managers.size() == 3);
        managers.add(manager1);
        assert(managers.size() == 4);
        try{
            Manager manager2 = new Manager(5, "Alina", 32, "alina123", "casino4");
            managers.add(manager2);
        }
        catch (RuntimeException e){
            assert true;
        }
    }

    @Test
    void delete() throws Exception {
        assert(managers.size() == 2);
        managers.delete(managers.findById(1));
        assert(managers.size() == 1);
        managers.delete(managers.findById(2));
        assert(managers.size() == 0);
    }

    @Test
    void findById() throws Exception {
        assert(managers.findById(1) == managers.getAllManagers().get(0));
        assert(managers.findById(2) == managers.getAllManagers().get(1));
        try{
            Manager m = new Manager(NULL, "", NULL, "", "");
            m = managers.findById(5);
        }
        catch (RuntimeException e){
            assert true;
        }
    }

    @Test
    void sortByNameAsc() throws Exception {
        Manager manager = new Manager(3, "Radu", 45, "andreea123", "casino2");
        Manager manager1 = new Manager(4, "Gheorghe", 51, "gheorghe123", "casino3");
        managers.add(manager);
        assert(managers.size() == 3);
        managers.add(manager1);
        assert(managers.size() == 4);
        List<Manager> sortedManagers = managers.sortByNameAsc();
        Manager firstManager = sortedManagers.get(0);
        for( Manager manager2: sortedManagers){
            assert(manager2.getName().compareTo(firstManager.getName()) >= 0);
            firstManager = manager2;
        }
    }

    @Test
    void sortByNameDsc() throws Exception {
        Manager manager = new Manager(3, "Uwe", 45, "andreea123", "casino2");
        Manager manager1 = new Manager(4, "George", 51, "gheorghe123", "casino3");
        managers.add(manager);
        assert(managers.size() == 3);
        managers.add(manager1);
        assert(managers.size() == 4);
        List<Manager> sortedManagers = managers.sortByNameDsc();
        Manager firstManager = sortedManagers.get(0);
        for( Manager manager2: sortedManagers){
            assert(manager2.getName().compareTo(firstManager.getName()) <= 0);
            firstManager = manager2;
        }
    }

    @Test
    void filterAge() throws Exception {
        Manager manager = new Manager(3, "Uwe", 45, "andreea123", "casino2");
        Manager manager1 = new Manager(4, "Savin", 51, "savin123", "casino3");
        managers.add(manager);
        assert(managers.size() == 3);
        managers.add(manager1);
        assert(managers.size() == 4);
        List<Manager> filteredManagers = managers.filterAge(30);
        for(Manager manager2: filteredManagers){
            assert(manager2.getAge() > 30);
        }
    }
}