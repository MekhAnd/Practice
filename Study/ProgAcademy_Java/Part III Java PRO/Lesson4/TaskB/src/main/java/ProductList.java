import java.sql.*;
import java.util.Scanner;

public class ProductList {


    private String url = "jdbc:mysql://localhost:3306/taskb?useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String pass = "1101";
    private static Connection conn;

    public ProductList () {
        try {
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(Statement st = conn.createStatement()){
            st.execute("CREATE TABLE IF NOT EXISTS Product (product_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, product_model_name VARCHAR(128) NOT NULL, product_brand VARCHAR(128) NOT NULL, product_type VARCHAR(128) NOT NULL, product_price FLOAT NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct (Product a) throws SQLException {
        PreparedStatement ps =conn.prepareStatement("INSERT INTO Product (PRODUCT_MODEL_NAME, PRODUCT_BRAND, PRODUCT_TYPE, PRODUCT_PRICE) VALUES (?, ?, ?, ?)");
        try {
            ps.setString(1,a.getModelName());
            ps.setString(2,a.getBrand());
            ps.setString(3,a.getType());
            ps.setDouble(4,a.getPrice());
            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }

    public void deleteProduct(Product a) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the product model name: ");
        String modelName = sc.nextLine();

        PreparedStatement ps = conn.prepareStatement("DELETE FROM Product WHERE name = ?");
        try {
            ps.setString(1,a.getModelName());
            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }

    public void getProductList(){
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Product")) {
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

    public static int getProductID (String a, Double b) throws SQLException {
        int id=-1;

        try (PreparedStatement ps = conn.prepareStatement("SELECT PRODUCT_ID FROM Product WHERE PRODUCT_MODEL_NAME = '" + a + "' AND PRODUCT_PRICE = '"+b+"'")) {

            ResultSet rs = ps.executeQuery();
            try {
                ResultSetMetaData md = rs.getMetaData();
                //System.out.println("_");
                for (int i = 1; i <= md.getColumnCount(); i++)
                    md.getColumnName(i);
                //System.out.println("__");

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        id = rs.getInt(i);
                    }
//                    System.out.println();
                }
//                System.out.println();
            } finally {
                rs.close();
            }
        }
        return id;
    }





}
