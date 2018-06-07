package contract.view;

import java.awt.event.KeyEvent;
import java.util.List;

import contract.controller.IController;
import contract.model.IElement;
import contract.model.IMobile;

/**
 * <h1>The Interface IView.</h1>
 *To interact with the game
 */
public interface IView {

	List<IMobile> getMobile();
	List<IElement> getImages();
	
	void keyPressed(final KeyEvent e);
	
	
    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    //void displayMessage(String message);
}
