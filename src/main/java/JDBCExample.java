import java.sql.*;

public class JDBCExample {

    public static void main(String[] args) {
        String query = "";
        try(
                Connection con = DriverManager.getConnection("");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
        )
        {
            rs.next();
            String id = rs.getString("salary");

            return;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
        }
    }
}
