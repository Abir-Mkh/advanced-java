package com.formation.bd;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		var props = Profile.getProperties("db");

		var db = DataBase.instance();

		try {
			db.connect(props);
		} catch (SQLException e) {
			System.out.println("Cannot connect to db");
		}

		System.out.println("Connected");

		UserDao userDao = new UserDaoImpl();
		//userDao.save(new User("Mars"));
		//userDao.save(new User("Pluto"));
		//userDao.save(new User("Soleil"));
		//userDao.save(new User("Saturne"));

		var users = userDao.getAll();

		users.forEach(System.out::println);

		var userOpt = userDao.findById(3);

		if(userOpt.isPresent()) {

			User user = userOpt.get();
			System.out.println("Retreived: " + user);
			user.setName("Snoopy");

			userDao.update(user);
		} else {
			System.out.println("No user retreived");
		}

		userDao.delete(new User(13, null));

		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Cannot close db connection");
		}
	}
}
