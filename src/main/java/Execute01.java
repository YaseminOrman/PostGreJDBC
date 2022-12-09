//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.*;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.step Registration to the driver
        Class.forName("org.postgresql.Driver");
        //2.step Create connection with database
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","rukiyetunc");
        //3.step Create statements
        Statement st = con.createStatement();

        //4.step Execute the query

        /*
        execute() method can be used in DDL(Table creation, drop table, alter table) and DQL(Select)
        1)If you use execute() method in DDL you will get false everytime.
        2)If you use execute() method in DQL you will get false or true
            When you use execute() method in DQL, if you get ResultSet Object as return you will get true
            otherwise you will get false.
         */

        String sql1 = "CREATE TABLE workers(worker_id VARCHAR(50), worker_name VARCHAR(20), worker_salary INT )";
        boolean sqlRes=st.execute(sql1);
        System.out.println(sqlRes);

        String sql2 ="alter table workers add worker_address varchar(80)";
        st.execute(sql2);

        String sql3 = "drop table workers";
        st.execute(sql3);


        //5. Step: Close the connection and statement
        con.close();
        st.close();


    }
}
