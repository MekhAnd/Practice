import java.sql.*;
import java.util.Scanner;

public class UserList {

    private String url = "jdbc:mysql://localhost:3306/taskb?useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String pass = "1101";
    private static Connection conn;

    public UserList () {
        try {
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(Statement st = conn.createStatement()){
            st.execute("CREATE TABLE IF NOT EXISTS User(USER_ID INT NOT NULL AUTO_INCREMENT primary key, USER_NAME varchar(128) not null, USER_LAST_NAME varchar(128) not null, USER_EMAIL varchar(128), USER_PHONE varchar(128) not null)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser (User a) throws SQLException {
        PreparedStatement ps =conn.prepareStatement("INSERT INTO User (USER_NAME, USER_LAST_NAME, USER_EMAIL, USER_PHONE) VALUES (?, ?, ?, ?)");
        try {
            ps.setString(1,a.getName());
            ps.setString(2,a.getLastName());
            ps.setString(3,a.getEmail());
            ps.setString(4,a.getPhone());
            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }

    private static void deleteUser(User a) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter client email: ");
        String email = sc.nextLine();
        System.out.print("Enter client phone: ");
        String phone = sc.nextLine();

        PreparedStatement ps = conn.prepareStatement("DELETE FROM User WHERE name = '" + email + "' AND '" + phone + "'");
        try {
           ps.executeUpdate(); 
        } finally {
            ps.close();
        }
    }

    public static void getUserList(){
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM User")) {
            try(ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData md = rs.getMetaData();
                System.out.println();
                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }
                System.out.println();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getUserID (String email, String phone) throws SQLException {
        int id=-1;

        try (PreparedStatement ps = conn.prepareStatement("SELECT USER_ID FROM User WHERE USER_EMAIL = '" + email + "' AND USER_PHONE = '" + phone+ "'")) {

            ResultSet rs = ps.executeQuery();
            try {
                ResultSetMetaData md = rs.getMetaData();
                for (int i = 1; i <= md.getColumnCount(); i++)
                    md.getColumnName(i);
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        id = rs.getInt(i);
                    }
                }
            } finally {
                rs.close();
            }
        }
        return id;
    }

}
