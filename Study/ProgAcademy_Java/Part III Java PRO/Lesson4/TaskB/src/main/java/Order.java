import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Order {

    private String url = "jdbc:mysql://localhost:3306/taskb?useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String pass = "1101";
    private static Connection conn;
    private Date now = new Date();
    private User a;
//    private ArrayList <Integer> productList = new ArrayList<Integer>();

    public Order() {
        this.a = a;
        try {
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(Statement st = conn.createStatement()){
            st.execute("CREATE TABLE IF NOT EXISTS Orders(USER_ID INT NOT NULL, PRODUCT_ID INT NOT NULL, DATE_ORDER DATETIME, FOREIGN KEY (USER_ID)  REFERENCES USER (USER_ID),  FOREIGN KEY (PRODUCT_ID)  REFERENCES PRODUCT (PRODUCT_ID))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createOrder (String email, String phone, String name, Double price) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO Orders(USER_ID, PRODUCT_ID, DATE_ORDER) VALUES (?,?, NOW())")){
            ps.setInt(1, UserList.getUserID(email, phone));
            ps.setInt(2, ProductList.getProductID(name, price));
            ps.executeUpdate();
        }
    }

    public void viewAllOrder(){
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Orders ")){//WHERE USER_ID like '%" + UserList.getUserID(this.a) + "%'
            try (ResultSet rs = ps.executeQuery();) {
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
                } catch (SQLException e){
                    e.printStackTrace();
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
