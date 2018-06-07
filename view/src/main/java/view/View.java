package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.controller.IController;
import contract.model.IModel;

class View extends JFrame implements KeyListener {
	
	private IModel	model;
	private IController	controller;
	private static final long	serialVersionUID	= -697358409737458175L;
	
	/*polymorphism of constructors*/
	
	public View(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}
	
	public View(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	public View(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}


	public View(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}
	
	/*getters and setter of controller*/
	public IController getController() {
		return this.controller;
	}

	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/*getter and setter of model*/
	protected IModel getModel() {
		return this.model;
	}


	private void setModel(final IModel model) {
		this.model = model;
	}

	//built the frame
	private void buildViewFrame(final IModel model) { 
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(new Panel(this));
		this.setTitle("LorannProject");
		this.setSize(704, 448);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void keyTyped(final KeyEvent e) {

	}

	/*KeyListener method for move*/
	public void keyPressed(final KeyEvent e) {
		try {
			this.getController().orderPerform(ViewFacade.keyCodeToControllerOrder(e.getKeyCode()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void keyReleased(final KeyEvent e) {

}
}

