package com.formation.bd;

import java.sql.SQLException;

public class DaoException extends  RuntimeException {
	private static final Long serailVersionUID = 1L;

	public DaoException(SQLException e) {
		super(e);
	}


}
