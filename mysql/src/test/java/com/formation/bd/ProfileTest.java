package com.formation.bd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ProfileTest {

	@Test
	public void testLoadDbConfig() {

		var props = Profile.getProperties("db");
		assertNotNull("Cannot load profile db properties", props);

		var dbName = props.getProperty("database");
		assertEquals("dbName incorrect", "MOS_BDD_ABIR", dbName);
	}
}
