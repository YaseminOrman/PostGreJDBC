package jdbc_oldrecords;

import java.sql.*;

public class ExeQuery01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","rukiyetunc");
        Statement st= con.createStatement();

        String sql1 = "select company,number_of_employees from companies order by number_of_employees desc offset 1 row fetch next 1 row only";
        ResultSet result1= st.executeQuery(sql1);

        while(result1.next()){
            System.out.println(result1.getString("company")+"--->"+result1.getString("number_of_employees"));
        }

        //2.way
        String sql2 ="select company,number_of_employees from companies where number_of_employees= (select max(number_of_employees) from companies where number_of_employees < (select max(number_of_employees) from companies))";
        ResultSet result2 = st.executeQuery(sql2);
        while(result2.next()){
            System.out.println(result2.getString("company")+"---->"+result2.getInt("number_of_employees"));
        }

        String sql3 ="select company,number_of_employees from companies where number_of_employees <(select avg(number_of_employees) from companies)";
        ResultSet result3 = st.executeQuery(sql3);
        while(result3.next()){
            System.out.println(result3.getString("company")+"--->"+result3.getInt("number_of_employees"));
        }
        con.close();
        st.close();
        result1.close();
        result2.close();
        result3.close();
    }
}
