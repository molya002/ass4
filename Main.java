import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ZooService zoo = new ZooService();
        ZookeeperService keeper = new ZookeeperService();
        AnimalService animal = new AnimalService();

        while (true) {
            System.out.println("""
                1. Show all animals by zoo name
                2. Show all zoos by location
                3. Show all zookeepers by zoo name
                4. Create new zoo
                5. Create new zookeeper
                6. Create new animal
                7. Remove zoo
                8. Remove zookeeper
                9. Remove animal
                0. Exit
            """);

            int c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1 -> {
                    System.out.print("Zoo name: ");
                    animal.showByZoo(sc.nextLine());
                }
                case 2 -> {
                    System.out.print("Location: ");
                    zoo.showByLocation(sc.nextLine());
                }
                case 3 -> {
                    System.out.print("Zoo name: ");
                    keeper.showByZoo(sc.nextLine());
                }
                case 4 -> {
                    System.out.print("Zoo name: ");
                    String n = sc.nextLine();
                    System.out.print("Location: ");
                    zoo.create(n, sc.nextLine());
                }
                case 5 -> {
                    System.out.print("Name: ");
                    String n = sc.nextLine();
                    System.out.print("Zoo ID: ");
                    keeper.create(n, sc.nextInt());
                }
                case 6 -> {
                    System.out.print("Animal name: ");
                    String n = sc.nextLine();
                    System.out.print("Type: ");
                    String t = sc.nextLine();
                    System.out.print("Zoo ID: ");
                    animal.create(n, t, sc.nextInt());
                }
                case 7 -> {
                    System.out.print("Zoo ID: ");
                    zoo.remove(sc.nextInt());
                }
                case 8 -> {
                    System.out.print("Zookeeper ID: ");
                    keeper.remove(sc.nextInt());
                }
                case 9 -> {
                    System.out.print("Animal ID: ");
                    animal.remove(sc.nextInt());
                }
                case 0 -> System.exit(0);
            }
        }
    }
}
