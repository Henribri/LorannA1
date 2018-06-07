package contract.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 * 
 * Model of the game
 */
public interface IModel {
	
	void getMessage();
	void addArmobile(IMobile mobile);
	Observable getObservable();
	int getX();
	void setX(int x);
	int getLvl();
	void createMap(int lvl) throws SQLException;
	 public void refresh();

	void launchSpell();


	void move(char c) throws IOException, SQLException;

	List<IElement> getArimages() throws SQLException;

	List<IMobile> getArmobile() throws SQLException;
	void reloadMap();

Permeability checkBump(int x, int y);
	
    /**
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    //Example getExampleById(int id) throws SQLException;

    /**
     * Gets the example by name.
     *
     * @param name
     *            the name
     * @return the example by name
     * @throws SQLException
     *             the SQL exception
     */
    //Example getExampleByName(String name) throws SQLException;

    /**
     * Gets the all examples.
     *
     * @return the all examples
     * @throws SQLException
     *             the SQL exception
     */
    //List<Example> getAllExamples() throws SQLException;
    
	/*IElement getElement(int x, int y);
	void addObserver(Observer observer);
	void changed();
	void getGameOver(Graphics graphics);
	void getMenu(Graphics graphics);*/
	
	//void addParticule(int life, StateHero state, IEntitie hero);
}
