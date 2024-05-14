package registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.RegisterBean;

public class RegisterDAO {
	
	 public int registerUser(RegisterBean registerBean) throws SQLException, ClassNotFoundException{
	        String INSERT_USERS_SQL = "INSERT INTO register" +
	            "  (firstName, lastName, userName, password, contact) VALUES " +
	            " (?, ?, ?, ?, ?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	       try	(Connection connection = DriverManager
	             .getConnection("jdbc:mysql://localhost:3306/training?useSSL=false", "root", "root");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
	            preparedStatement.setString(1, registerBean.getFirstName());
	            preparedStatement.setString(2, registerBean.getLastName());
	            preparedStatement.setString(3, registerBean.getUsername());
	            preparedStatement.setString(4, registerBean.getPassword());
	            preparedStatement.setString(5, registerBean.getContact());

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } 
	        
	        return result;
	    }

	
}
