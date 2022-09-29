
import java.sql.*;
import java.util.Scanner;

public class Db {

    private String url = "jdbc:mysql://localhost:3306/taska?useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String pass = "1101";
    private static Connection conn;

    public Db (){
//        String url = "jdbc:mysql://localhost:3306/taska?useSSL=false&serverTimezone=UTC";
//        String user = "root";
//        String pass = "1101";

        try {
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Statement st = conn.createStatement()){
            st.execute("CREATE TABLE IF NOT EXISTS Apartments( ID INT NOT NULL AUTO_INCREMENT primary key, AREA varchar(128) not null, ADRES varchar(255) not null, SPASE float not null, ROOM int not null, PRICE int not null);");
            //I called SPASE  because SPACE reserved
            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void go (){
        try (Scanner sc = new Scanner(System.in)) {
            conn = DriverManager.getConnection (this.url, this.user, this.pass);

            while (true) {
                System.out.println("1: add new apartment");
                System.out.println("2: delete apartment");
                System.out.println("3: select apartment by the street");
                System.out.println("4: select apartment by the area (sq.m)");
                System.out.println("5: select apartment by rooms quantity");
                System.out.println("6: select apartment by the price");
                System.out.print("-> ");

                String s = sc.nextLine();
                    switch (s) {
                    case "1":
                        addAppartment(sc);
                        break;
                    case "2":
                        deleteApartment(sc);
                        break;
                    case "3":
                        viewApartmentsSTR(sc);
                        break;
                    case "4":
                         viewApartmentsArea(sc);
                        break;
                    case "5":
                        viewApartmentsRoom(sc);
                        break;
                    case "6":
                        viewApartmentsPrice(sc);
                        break;
                    default:
                        return;
                }
            }
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public void addAppartment(Scanner sc) throws SQLException {
        System.out.print("Enter the area where the apartment situated: ");
        String area = sc.nextLine();
        System.out.print("Enter full address where the apartment situated (STR. BUILDING, APARTMENT NUMBER)): ");
        String adres = sc.nextLine();
        System.out.print("Enter the area of this apartment (*.*): ");
        Double space = Double.parseDouble(sc.nextLine());
        System.out.print("Enter rooms quantity: ");
        Integer room = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the price of this apartment (*.*): ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("***Success***");
        System.out.println("*************");

        PreparedStatement ps = conn.prepareStatement("INSERT INTO Apartments (AREA, ADRES, SPASE, ROOM, PRICE) VALUES(?, ?, ?, ?, ?)");
        try {
            ps.setString(1, area);
            ps.setString(2, adres);
            ps.setDouble(3, space);
            ps.setInt(4, room);
            ps.setInt(5, price);
            ps.executeUpdate();
        } finally {
            ps.close();
        }

    }

    public void deleteApartment(Scanner sc){
        System.out.print("Enter full address where the apartment situated (STR. BUILDING, APARTMENT NUMBER)):");
        String adres = sc.nextLine();

        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM Apartments WHERE adres = ?")){
            ps.setString(1, adres);
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void viewApartmentsSTR(Scanner sc) throws SQLException {
        System.out.print("Enter the street name: ");
        String atr = sc.nextLine();

        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Apartments WHERE ADRES like '%" + atr + "%'")){
           ResultSet rs = ps.executeQuery();

           try {
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
            } finally {
                rs.close();
            }
        }
    }

    private static void viewApartmentsArea(Scanner sc) throws SQLException {
        System.out.print("Enter the area parametrs - minimal area: ");
        double min = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the area parametrs - maximum area: ");
        double max = Double.parseDouble(sc.nextLine());

           try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Apartments WHERE SPASE BETWEEN '" + min + "' AND '" + max + "'")){
               ResultSet rs = ps.executeQuery();
                try {

                    ResultSetMetaData md = rs.getMetaData();
                    System.out.println();
                    for (int i = 1; i <= md.getColumnCount(); i++)  // Александр, почему когда тут пытаешься установить тело цикла, то ResultSetMetaData md и счетчик в следующей строке становятся недоступны
                        System.out.print(md.getColumnName(i) + "\t\t");
                        System.out.println();

                        while (rs.next()) {
                            for (int i = 1; i <= md.getColumnCount(); i++) {
                            System.out.print(rs.getString(i) + "\t\t");
                            }
                        System.out.println();
                        }
                    System.out.println();
            } finally {
                rs.close();
            }
        }
    }

    private static void viewApartmentsRoom(Scanner sc) throws SQLException {
        System.out.print("Enter rooms quantity: ");
        int atr = Integer.parseInt(sc.nextLine());

        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Apartments WHERE ROOM like '" + atr + "'")){

            ResultSet rs = ps.executeQuery();
            try {

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
            } finally {
                rs.close();
            }
        }
    }

    private static void viewApartmentsPrice(Scanner sc) throws SQLException {
        System.out.print("Enter the price parametrs - minimal price: ");
        double min = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the price parametrs - maximum price: ");
        double max = Double.parseDouble(sc.nextLine());

        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Apartments WHERE PRICE BETWEEN '" + min + "' AND '" + max + "'")) {

            ResultSet rs = ps.executeQuery();
            try {
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
            } finally {
                rs.close();
            }
        }
    }
}
