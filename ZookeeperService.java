public class ZookeeperService {
    private final ZookeeperRepository repo = new ZookeeperRepository();

    public void create(String name, int zooId) {
        repo.save(new Zookeeper(name, zooId));
    }

    public void showByZoo(String zooName) {
        repo.findByZooName(zooName);
    }

    public void remove(int id) {
        repo.delete(id);
    }
}
