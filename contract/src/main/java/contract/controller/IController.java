package contract.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import contract.model.IElement;
import contract.model.IMobile;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Henri Briaux
 * 
 */
public interface IController {
	
	void orderPerform(ControllerOrder controllerOrder) throws IOException, SQLException;
	void getMap() throws SQLException;
	
	public List<IElement> getArimages() throws SQLException;
	public List<IMobile> getArmobile() throws SQLException;
}
