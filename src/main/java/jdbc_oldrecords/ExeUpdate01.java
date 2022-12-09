package jdbc_oldrecords;
import java.sql.*;
public class ExeUpdate01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
       Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","rukiyetunc");
       Statement st =  con.createStatement();

       //Example 1 Update the number_of_employees to 16000 if the number_of_employees is less than the average number_of_employee

     String sql1 = " update  companies  set number_of_employees = 16000 where number_of_employees < (select avg(number_of_employees) from companies)";
     int numOfRecUpdated1 =st.executeUpdate(sql1);
        System.out.println("numOfRecUpdated1 = " + numOfRecUpdated1);

        String sql2 = "select * from companies";
        ResultSet result1 = st.executeQuery(sql2);
        while(result1.next()){
            System.out.println(result1.getInt(1)+"---"+result1.getString(2)+"---"+result1.getInt(3));
        }

        con.close();
        st.close();
        result1.close();
    }
}
