package contract.model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author Henri
 *
 *
 *Name position image of an Element and his movement
 */


public interface IElement {
	
	int getX();
	int getY();
	void setX( int x);
	void setY(int y);
	String getName();
	Permeability getPerm();
	BufferedImage Image() throws IOException;
	void move(char c) throws IOException, SQLException;
	List<IElement> getArimages();
	
}
