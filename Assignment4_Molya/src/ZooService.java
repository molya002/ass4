public class ZooService {
    private final ZooRepository repo = new ZooRepository();

    public void create(String name, String loc) {
        repo.save(new Zoo(name, loc, 0));
    }

    public void showByLocation(String loc) {
        repo.findByLocation(loc);
    }

    public void remove(int id) {
        repo.delete(id);
    }
}
