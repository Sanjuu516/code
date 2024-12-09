import java.sql.*;

public class JDBCInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO students (id, name, age) VALUES (?, ?, ?)")) {

            stmt.setInt(1, 1);
            stmt.setString(2, "John Doe");
            stmt.setInt(3, 20);
            int rowsInserted = stmt.executeUpdate();

            System.out.println(rowsInserted > 0 ? "Insert successful!" : "Insert failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


import java.sql.*;

public class JDBCDelete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM students WHERE id = ?")) {

            stmt.setInt(1, 1);
            int rowsDeleted = stmt.executeUpdate();

            System.out.println(rowsDeleted > 0 ? "Delete successful!" : "Delete failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


import java.sql.*;

public class JDBCUpdate {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("UPDATE students SET age = ? WHERE id = ?")) {

            stmt.setInt(1, 21);
            stmt.setInt(2, 1);
            int rowsUpdated = stmt.executeUpdate();

            System.out.println(rowsUpdated > 0 ? "Update successful!" : "Update failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



import java.sql.*;

public class JDBCRetrieve {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        String query = "SELECT * FROM students";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

