import java.sql.Connection;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {
        //1. Step: Registration to the driver
        //2. Step: Create connection with database
       Connection connection= JdbcUtils.connectToDatabase("localhost","postgres","postgres","rukiyetunc");

        //3. Step: Create statement
        Statement statement =JdbcUtils.createStatement();

        //4.step execute the query
        //JdbcUtils.createTable("Students","name varchar(20)","id int","address varchar(50)","tel bigint");

        JdbcUtils.insertDataInToTable("Students","name 'John'");
        JdbcUtils.insertDataInToTable("Students","name 'Mark'","id 123","tel 1234567890","address 'Ankara'");

        //JdbcUtils.dropTable("workers");
        //5. Step: Close the connection and statement
        JdbcUtils.closeConnectionAndStatement();

    }
}
