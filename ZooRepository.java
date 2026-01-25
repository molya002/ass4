import java.sql.*;

public class ZooRepository {

    public void save(Zoo zoo) {
        String sql = "INSERT INTO public.zoo(name_zoo, location, size) VALUES (?, ?, ?)";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, zoo.getName());
            ps.setString(2, zoo.getLocation());
            ps.setInt(3, zoo.getSize());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void findByLocation(String location) {
        String sql = "SELECT * FROM public.zoo WHERE location = ?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, location);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " "
                        + rs.getString("name_zoo"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM public.zoo WHERE id = ?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
