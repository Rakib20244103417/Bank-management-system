package Bank.management.system;


import java.sql.*;

public class C{
    Statement statement;
    Connection ca;

    public C() {
        try {
            // Establishing MySQL Connection
            ca = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem", "root", "#Rakib%");
            statement = ca.createStatement();
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
}













