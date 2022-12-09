package jdbc_oldrecords;

import java.sql.*;

public class CallableStmt01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","rukiyetunc");
        Statement st= con.createStatement();

        //example create a function which uses 2 parameters and return the sum of the parameters
        String sql1 = "create or replace function addF(a numeric ,b numeric) returns numeric language plpgsql as $$ begin return a+b; end $$";
        boolean result1= st.execute(sql1);
        System.out.println(result1);

        CallableStatement cst1 = con.prepareCall("{?=call addF(?,?)}");
        cst1.registerOutParameter(1,Types.NUMERIC);
        cst1.setInt(2,40);
        cst1.setInt(3,60);
        cst1.execute();
        System.out.println(cst1.getObject(1));


        String sql2 = "CREATE OR REPLACE FUNCTION volumeOfConeF(r NUMERIC, h NUMERIC) RETURNS NUMERIC LANGUAGE plpgsql AS $$ BEGIN RETURN 3.14*r*r*h/3; END $$";

        boolean result2 = st.execute(sql2);
        System.out.println(result2);

        CallableStatement cst2 = con.prepareCall("{? = call volumeOfConeF(?, ?) }");
        cst2.registerOutParameter(1,Types.NUMERIC);
        cst2.setInt(2,30);
        cst2.setInt(3,100);
        cst2.execute();
        System.out.printf("%.2f",cst2.getObject(1));


        con.close();
        st.close();
        cst1.close();
        cst2.close();

    }
}
