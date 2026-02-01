package Model;

public class Animal {
    private String name;
    private String type;
    private int zooId;

    public Animal(String name, String type, int zooId) {
        this.name = name;
        this.type = type;
        this.zooId = zooId;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public int getZooId() { return zooId; }
}
