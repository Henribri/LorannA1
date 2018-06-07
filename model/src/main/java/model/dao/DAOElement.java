package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAOElement<E> {

	private final Connection connection;

	public DAOElement(Connection connection) throws SQLException {
		this.connection = connection;
	}

	protected Connection getConnection() {
		return this.connection;
	}

	public abstract boolean create(E entity);


	public abstract boolean delete(E entity);


	public abstract boolean update(E entity);


	public abstract E find(int id);


public abstract E find(String key);
}
