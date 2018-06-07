package view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.Timer;

import contract.model.IElement;
import contract.model.IMobile;
import contract.view.IView;

class Panel extends JPanel implements Observer, ActionListener, IView {
	/** The view frame. */
	private View view;
	/* New timer for the repaint */
	Timer timer = new Timer(10, this);
	/*ArrayList for sprites*/
	public List<IElement> Arimages ;//= new ArrayList<IElement>();
	public List<IMobile> Armobile ;//= new ArrayList<IMobile>();
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -998294702363713521L;
/**
 * Set the main view
 * @param view
 *  view wanted
 */
	public Panel(final View view) {
		timer.start();
		this.setViewFrame(view);
		view.getModel().getObservable().addObserver(this);
	}

	/* Get the view Frame */
	private View getViewFrame() {
		return this.view;
	}
	//set the View Frame
	private void setViewFrame(final View view) {
		this.view = view;
	}

	/* Get method for the Armobile and Arimages */
	public List<IMobile> getArmobile(){
		return this.Armobile;
	}
	
	public List<IElement> getArimages(){
		return this.Arimages;
	}

	/* Update method for the repaint*/
	

	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}
		 	   	    
	//Painting of the elements within the ArrayList
	@Override
	protected void paintComponent(final Graphics graphics) { 
		
		int pixelNumbers = 32;
		
		try {
			Arimages = this.view.getModel().getArimages();
			Armobile = this.view.getModel().getArmobile();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			for (IElement obj : Arimages) { 
				int x = obj.getX();
				int y = obj.getY();
				graphics.drawImage(obj.Image(), x * pixelNumbers, y * pixelNumbers, this);
			}
			for (IMobile obj : Armobile) {	
				int x = obj.getX();
				int y = obj.getY();
				graphics.drawImage(obj.Image(), x * pixelNumbers, y * pixelNumbers, this);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	/* Method to repaint the elements of the ArrayList */
	
	@SuppressWarnings("unused")
	public void actionPerformed(ActionEvent e) {
		int m = Armobile.size();
		for (int p = 0 ; p < m ; p++){
			IMobile obj = Armobile.get(p);
			obj.move();
			if (obj == null) {
				p--;
				m--;
			}
		}
		repaint();
	}

	public void addArmobile(IMobile mobile){
		this.Armobile.add(mobile);
	}

	public void keyPressed(KeyEvent e) {
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
