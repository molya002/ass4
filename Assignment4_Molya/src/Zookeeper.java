public class Zookeeper {
    private String name;
    private int zooId;

    public Zookeeper(String name, int zooId) {
        this.name = name;
        this.zooId = zooId;
    }

    public String getName() { return name; }
    public int getZooId() { return zooId; }
}
