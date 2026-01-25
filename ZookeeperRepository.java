import java.sql.*;

public class ZookeeperRepository {

    public void save(Zookeeper z) {
        String sql = "INSERT INTO public.zookeepers(name_zookeeper, zoo_id) VALUES (?, ?)";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, z.getName());
            ps.setInt(2, z.getZooId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void findByZooName(String zooName) {
        String sql = """
            SELECT z.name_zookeeper
            FROM public.zookeepers z
            JOIN public.zoo zo ON z.zoo_id = zo.id
            WHERE zo.name_zoo = ?
        """;

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, zooName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM public.zookeepers WHERE id = ?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
