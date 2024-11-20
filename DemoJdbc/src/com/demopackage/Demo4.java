package com.demopackage;

	//use in MainMethod

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class Demo4 {
		private Connection getConnection() throws SQLException {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");
		
		}

		// Insert data method
		public void insertData() throws SQLException {
			Connection c = getConnection();
			Statement s = c.createStatement();
			s.executeUpdate("INSERT INTO student (id, name) VALUES (1, 'Sahil')");
			System.out.println("Data inserted successfully.");
			s.close();
			c.close();
		}

		// Update data method
		public void updateData() throws SQLException {
			Connection c = getConnection();
			Statement s = c.createStatement();
			s.executeUpdate("UPDATE student SET name='Maulik' WHERE id=1");
			System.out.println("Data updated successfully.");
			s.close();
			c.close();
		}

		// Delete data method
		public void deleteData() throws SQLException {
			Connection c = getConnection();
			Statement s = c.createStatement();
			s.executeUpdate("DELETE FROM student WHERE id=1");
			System.out.println("Data deleted successfully.");
			s.close();
			c.close();
		}

		// Fetch data method
		public void fetchData() throws SQLException {
			Connection c = getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM student");
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
			}
			rs.close();
			s.close();
			c.close();
		}
	}

