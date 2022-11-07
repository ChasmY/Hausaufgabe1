package Controller;

import Repository.InMemory.DealerRepositoryMemory;
import model.Dealer;

import java.util.List;

public class DealerController extends DealerRepositoryMemory {

    public DealerController(List<Dealer> allDealers) {
        super(allDealers);
    }

    @Override
    public void add(Dealer entity) {
        super.add(entity);
    }

    @Override
    public void delete(Dealer entity) {
        super.delete(entity);
    }

    @Override
    public void update(String s, Dealer newEntity) {
        super.update(s, newEntity);
    }

    @Override
    public Dealer findById(String s) {
        return super.findById(s);
    }

    @Override
    public int size(){
        return super.size();
    }
}
