package com.demopackage;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		Demo4 d4 = new Demo4();
		d4.insertData();
		d4.updateData();
		d4.deleteData();
		d4.fetchData();
	}

	}


