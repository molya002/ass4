package Service;

import Model.Animal;
import Repository.AnimalRepository;

public class AnimalService {
    private final AnimalRepository repo = new AnimalRepository();

    public void create(String name, String type, int zooId) {
        repo.save(new Animal(name, type, zooId));
    }

    public void showByZoo(String zooName) {
        repo.findByZooName(zooName);
    }

    public void remove(int id) {
        repo.delete(id);
    }
}
