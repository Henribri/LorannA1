package contract.model;

import java.awt.image.BufferedImage;

/**
 * 
 * Movement of a Mobile element
 * 
 * @param c 
 * 		the movement of a mobile element
 * 
 * @param x
 *		the position on x axe
 *
 *@param y
 *		the position on y axe
 */
import java.io.IOException;
import java.sql.SQLException;

public interface IMobile {
	
	void move(char c) throws IOException, SQLException; 
	void move();
	
	void launchSpell(char c) throws SQLException;
	
	int getX();
	int getY();
	
	void setX(int x);
	void setY(int y);
	
	Permeability getPerm();
	
	BufferedImage Image() throws IOException;
	String getName();
	void doNothing();
}
