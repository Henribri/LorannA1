package view;

import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.SwingUtilities;

import contract.controller.ControllerOrder;
import contract.controller.IController;
import contract.model.IElement;
import contract.model.IMobile;
import contract.model.IModel;
import contract.view.IView;

public class ViewFacade implements IView, Runnable {

	private final View view;
	
	public ViewFacade(IModel model) {
		this.view = new View(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Check which is the key pressed and interact in function of
	 * @param keyCode
	 * 		key pressed
	 * @return
	 * 		return the movement
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) { //KeyEvent which get back the enter
			
		switch (keyCode) {
		
		case KeyEvent.VK_RIGHT: 
			return ControllerOrder.Right;
			
		case KeyEvent.VK_LEFT:
			return ControllerOrder.Left;
			
		case KeyEvent.VK_UP:
			return ControllerOrder.Up;
			
		case KeyEvent.VK_DOWN:
			return ControllerOrder.Down;
			
		case KeyEvent.VK_SPACE:
			return ControllerOrder.Spell;
		}
		return null;
	}

/**
 * Show a message
 * @param message
 * Show a message
 */
	public void printMessage(final String message) {
		this.view.printMessage(message);
	}
	
	public void run() {
		this.view.setVisible(true);
	}

/**
 * set the controller used
 * @param controller
 * set the controller used
 */
	public void setController(final IController controller) {
		this.view.setController(controller);
	}


	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public List<IMobile> getArmobile() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IElement> getArimages() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addArmobile(IMobile mobile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IMobile> getMobile() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<IElement> getImages() {
		// TODO Auto-generated method stub
		return null;
	}

}
