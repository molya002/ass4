import java.sql.*;

public class AnimalRepository {

    public void save(Animal a) {
        String sql = "INSERT INTO public.animal(name_animal, type_animal, zoo_id) VALUES (?, ?, ?)";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, a.getName());
            ps.setString(2, a.getType());
            ps.setInt(3, a.getZooId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void findByZooName(String zooName) {
        String sql = """
            SELECT a.name_animal, a.type_animal
            FROM public.animal a
            JOIN public.zoo z ON a.zoo_id = z.id
            WHERE z.name_zoo = ?
        """;

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, zooName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1) + " - " + rs.getString(2));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM public.animal WHERE id = ?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
