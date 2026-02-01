package Model;

public class Zoo {
    private String name;
    private String location;
    private int size;

    public Zoo(String name, String location, int size) {
        this.name = name;
        this.location = location;
        this.size = size;
    }

    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getSize() { return size; }
}
