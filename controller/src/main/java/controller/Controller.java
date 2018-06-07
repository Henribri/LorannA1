package controller;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import contract.controller.ControllerOrder;
import contract.controller.IController;
import contract.model.IElement;
import contract.model.IMobile;
import contract.model.IModel;
import contract.view.IView;

public class Controller implements IController{ // IController interface

	
	private IView view;
	private IModel model;
	private char c;
	
	/**
	 * Put in place view and model
	 * @param view
	 * 		to interact with the game
	 * @param model
	 * 		which stock different data
	 */		

public Controller(final IView view, final IModel model) { // Controller				
	this.setView(view);
	this.setModel(model);
}

//setter model
/**
 * Set a model
 * @param model
 * 		which stock different data
 */
private void setModel(final IModel model) {
	this.model = model;
}
//setter view

/**
 * Set a view
 * @param view
 * 	to interact with the game
 */
private void setView(final IView view) {
	this.view = view;
}

/**
 * Control the different direction and movement
 * @param controllerOrder
 * 		The direction in fonction of the key pressed
 */

public void orderPerform(final ControllerOrder controllerOrder) throws IOException, SQLException { //Get back the enter from the View before send the char to the Model
	switch (controllerOrder) {

		case Right:
			this.c = 'R';
			this.model.getArmobile().get(0).move(c);
			break;

		case Left:
			this.c = 'L';
			this.model.getArmobile().get(0).move(c);
			break;	

		case Up:
			this.c = 'U';
			this.model.getArmobile().get(0).move(c);
			break;

		case Down:
			this.c = 'D';
			this.model.getArmobile().get(0).move(c);
			break;

		case Spell:
			this.model.getArmobile().get(0).launchSpell(c);
			break;

		default:

			break;
	}		
}



public void getMap() throws SQLException {
}

public List<IMobile> getArmobile(){

return null;
}
public void printMessage(String message) {
// TODO Auto-generated method stub

}

/**
 * To know wich the key was pressed
 * @param e
 * keypressed
 */
public void keyPressed(KeyEvent e) {
// TODO Auto-generated method stub

}

public List<IElement> getArimages(){
// TODO Auto-generated method stub
return null;
}

}
