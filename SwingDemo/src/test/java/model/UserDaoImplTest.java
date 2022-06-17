package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserDaoImplTest {

	private Connection conn;
	private List<User> users;
	private static final int NUM_TEST_USERS = 2;

	private List<User> loadUsers() throws IOException {

		// @formatter:off
		return Files
				.lines(Paths.get("C:/dev/workspace-formation/advanced-java/text.txt"))
				.map(line -> line.split("[^A-Za-z]"))
				.map(Arrays::asList)
				.flatMap(list -> list.stream())
				.filter(word -> (word.length()>3) && (word.length() < 6))
				.map(word -> new User(word, "pass" + word))
				.limit(NUM_TEST_USERS)
				.collect(Collectors.toList());

		// @formatter:on

	}

	@Before
	public void setUp() throws SQLException, IOException {

		users = loadUsers();

		var props = Profile.getProperties("db");

		var db = DataBase.instance();
		db.connect(props);

		conn = db.getConnection();
		conn.setAutoCommit(false);
	}

	@After
	public void tearDown() throws SQLException {
		DataBase.instance().close();
	}

	private int getMaxId() throws SQLException {
		var stmt = conn.createStatement();

		var rs = stmt.executeQuery("select max(id) as id from SWING_USER");
		rs.next();

		var id = rs.getInt("id");

		stmt.close();
		return id;
	}

	private List<User> getUsersInRange(int minId, int maxId) throws SQLException {

		List<User> retrieved = new ArrayList<User>();

		var stmt = conn.prepareStatement("select id, name, password from SWING_USER where id >= ? and id <= ?");
		stmt.setInt(1, minId);
		stmt.setInt(2, maxId);

		var rs = stmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String password = rs.getString("password");

			var user = new User(id, name, password);
			retrieved.add(user);

		}

		stmt.close();
		return retrieved;
	}

	@Test
	public void testFindAndUpdate() throws SQLException {
		var user = users.get(0);
		UserDao userDao = new UserDaoImpl();
		userDao.save(user);
		var maxId = getMaxId();
		user.setId(maxId);
		var retreivedUserOpt = userDao.findById(maxId);

		assertTrue("no user retreived", retreivedUserOpt.isPresent());

		var retreivedUser = retreivedUserOpt.get();

		assertEquals("retreived user don't match", user, retreivedUser);

		user.setName("abcde");
		user.setPassword("password");
		userDao.update(user);

		retreivedUserOpt = userDao.findById(maxId);

		assertTrue("no updated user retreived", retreivedUserOpt.isPresent());

		retreivedUser = retreivedUserOpt.get();

		assertEquals("retreived user don't match updated user", user, retreivedUser);

		System.out.println(retreivedUser);

	}

	@Test
	public void testSaveMultiple() throws SQLException {
		UserDao userDao = new UserDaoImpl();
		for (var u : users) {
			userDao.save(u);
		}

		var maxId = getMaxId();
		System.out.println(maxId);

		for (int i = 0; i < users.size(); i++) {
			int id = (maxId - users.size()) + i + 1;

			users.get(i).setId(id);

		}

		var retreivedUsers = getUsersInRange((maxId - users.size()) + 1, maxId);

		assertEquals("size of retreived users not equal to number of test users", retreivedUsers.size(),
				NUM_TEST_USERS);

		assertEquals("retrived users don't match saved users", users, retreivedUsers);

	}

	@Test
	public void testSave() throws SQLException {

		User user = new User("Jupiter", "Jupiter");
		UserDao userDao = new UserDaoImpl();
		userDao.save(user);

		var stmt = conn.createStatement();
		var rs = stmt.executeQuery("select id, name, password from SWING_USER order by id desc");
		var result = rs.next();

		assertTrue("cannot retreive inserted user", result);

		var name = rs.getString("name");
		assertEquals("user name doesn't match retreived", user.getName(), name);

		var password = rs.getString("password");
		assertEquals("user password doesn't match retreived", user.getPassword(), password);

		stmt.close();
	}

	@Test
	public void testgetAll() throws SQLException {
		UserDao userDao = new UserDaoImpl();
		for (var u : users) {
			userDao.save(u);
		}

		var maxId = getMaxId();

		for (int i = 0; i < users.size(); i++) {
			int id = (maxId - users.size()) + i + 1;

			users.get(i).setId(id);

		}

		var dbUsers = userDao.getAll();
		dbUsers = dbUsers.subList(dbUsers.size() - users.size(), dbUsers.size());

		assertEquals("size of retreived users not equal to number of test users", dbUsers.size(), NUM_TEST_USERS);

		assertEquals("retrived users don't match saved users", users, dbUsers);

	}

	@Test
	public void testDelete() throws SQLException {
		UserDao userDao = new UserDaoImpl();
		for (var u : users) {
			userDao.save(u);
		}

		var maxId = getMaxId();
		System.out.println(maxId);

		for (int i = 0; i < users.size(); i++) {
			int id = (maxId - users.size()) + i + 1;

			users.get(i).setId(id);

		}
		var deleteUserIndex = NUM_TEST_USERS / 2;
		var deleteUser = users.get(deleteUserIndex);

		users.remove(deleteUser);

		userDao.delete(deleteUser);
		var retreivedUsers = getUsersInRange((maxId - NUM_TEST_USERS) + 1, maxId);

		assertEquals("size of retreived users not equal to number of test users", retreivedUsers.size(), users.size());

		assertEquals("retrived users don't match saved users", users, retreivedUsers);

	}
}
