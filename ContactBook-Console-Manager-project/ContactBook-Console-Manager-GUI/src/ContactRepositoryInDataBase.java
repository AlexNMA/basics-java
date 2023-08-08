import java.sql.*;
import java.util.ArrayList;

public class ContactRepositoryInDataBase {
	String url = "jdbc:sqlite:./data/Users.db";
	Connection con;
	Statement statement;
	ResultSet resultSet;

	public void getConnectionAndStatement() {

		try {
			con = DriverManager.getConnection(url);
			statement = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeAll() throws SQLException {
		con.close();
		statement.close();
		if (resultSet != null) {
			resultSet.close();
		}
	}

	public void removeFromDataBase(int id) throws Exception {
		String queryString = "DELETE FROM users where userId = " + id;
		getConnectionAndStatement();
		statement.executeUpdate(queryString);
		closeAll();
	}

	public void setInDataBase(Contact contact) throws Exception {
		String name = contact.getName();
		int age = contact.getAge();
		int id = contact.getId();
		String queryString = "UPDATE users " + "SET userName = \"" + name + "\" , userAge = " + age + " WHERE userId = "
				+ id;
		getConnectionAndStatement();
		statement.executeUpdate(queryString);
		closeAll();
	}

	public void addInDataBase(Contact contact) throws Exception {
		String queryString = "INSERT INTO users (userName, userAge)" + "VALUES (" + "\"" + contact.getName() + "\""
				+ ", " + contact.getAge() + ")";
		getConnectionAndStatement();

		statement.executeUpdate(queryString);
		closeAll();
	}

	public Contact getFromDataBase(int id) throws Exception {
		String name;
		int age;
		getConnectionAndStatement();
		resultSet = statement.executeQuery("SELECT * FROM users WHERE userId = " + id);
		age = resultSet.getInt("userAge");
		name = resultSet.getString("userName");
		closeAll();
		return new Contact(id, name, age);
	}

	public ArrayList<Contact> getAllContacts() throws ClassNotFoundException, SQLException {
		ArrayList<Contact> contacts = new ArrayList<>();
		getConnectionAndStatement();
		resultSet = statement.executeQuery("SELECT * FROM users");
		while (resultSet.next()) {
			contacts.add(new Contact(resultSet.getInt("userId"), resultSet.getString("userName"),
					resultSet.getInt("userAge")));
		}
		closeAll();
		return contacts;

	}

}
