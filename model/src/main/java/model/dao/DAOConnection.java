package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.lang.model.util.Elements;

public class DAOConnection extends DAOElement{

	public DAOConnection(Connection connection) throws SQLException {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public char checkMap(int x, int y, int lvl) {
		char c = '?';
		final String sql;

		try {
			DAOConnection co = new DAOConnection(DBConnection.getInstance().getConnection());
			if (lvl == 1) {
				sql = "{call Selectlvl1(?,?)}";
			} else if (lvl == 2) {
				sql = "{call Selectlvl2(?,?)}";

			} else if (lvl == 3) {
				sql = "{call Selectlvl3(?,?)}";

			} else if (lvl == 4) {
				sql = "{call Selectlvl4(?,?)}";

			} else if (lvl == 5) {
				sql = "{call Selectlvl5(?,?)}";

			}
			else{
				return 'a';
			}
			final CallableStatement call = co.getConnection().prepareCall(sql);
			call.setInt(1, x);
			call.setInt(2, y);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.next()) {
				c = resultSet.getString("symbol").charAt(0);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();

		}
		return c;

	}

	public boolean create(Elements entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Elements entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Elements entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Elements find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Elements find(String key) {
		// TODO Auto-generated method stub
		return null;
}

	@Override
	public boolean create(Object entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object entity) {
		// TODO Auto-generated method stub
		return false;
	}
}
