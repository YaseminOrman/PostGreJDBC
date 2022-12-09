package jdbc_oldrecords;

import java.sql.*;

public class PrepStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","rukiyetunc");
        Statement st= con.createStatement();

        //example update the number of employees to 9999 if the company name is IBM by using prepared statement
     String sql1 ="update companies set number_of_employees=? where company=?";
     PreparedStatement pst1= con.prepareStatement(sql1);
     pst1.setInt(1,9999);
     pst1.setString(2,"IBM");

    int numOfUpdateRec= pst1.executeUpdate();
        System.out.println("numOfUpdateRec = " + numOfUpdateRec);
    String sql2 = "select * from companies" ;
    ResultSet result1= st.executeQuery(sql2);
    while (result1.next()){
        System.out.println(result1.getInt(1)+"---"+result1.getString(2)+"---"+result1.getInt(3));
    }
    //update google to 1111
        pst1.setInt(1,1111);
        pst1.setString(2,"GOOGLE");
        int numOfUpdateRec2= pst1.executeUpdate();
        String sql3 = "select * from companies";
        ResultSet result2= st.executeQuery(sql3);
        while(result2.next()){
            System.out.println(result2.getInt(1)+"---"+result2.getString(2)+"---"+result2.getInt(3));
        }
        //update apple to 7777
        pst1.setInt(1,7777);
        pst1.setString(2,"APPLE");

        int numOfRec3= pst1.executeUpdate();
        System.out.println("numOfRec3 = " + numOfRec3);
        String sql4="select * from companies";
        ResultSet result3= st.executeQuery(sql4);
        while(result3.next()){
            System.out.println(result3.getInt(1)+"---"+result3.getString(2)+"---"+result3.getInt(3));
        }

        con.close();
        st.close();
        pst1.close();


    }
}
