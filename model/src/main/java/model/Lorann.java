package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import contract.controller.ControllerOrder;
import contract.model.IElement;
import contract.model.IMobile;
import contract.model.IModel;
import contract.model.Permeability;

public class Lorann extends Mobile{
	private int x;
	private int y;
	private IModel model;
	private int exitX;
	private int exitY;
	private RainbowSpell spell;
	private boolean spelled = false;
	private boolean isAlive = true;
	int score = 0;
	char c;
	int lvl;
	Permeability perm = Permeability.CHARACTER;
	
	List<IElement> Arimages = new ArrayList<IElement>();
	List<IMobile> Armobile = new ArrayList<IMobile>();
	
	BufferedImage image;
	/**
	 * Put lorann in a model and give his position
	 * @param x
	 * position on x axe
	 * @param y
	 * position on x axe
	 * @param model
	 * model wanted
	 * @throws SQLException
	 * use database
	 */

	public Lorann(int x, int y, IModel model) throws SQLException {
		this.model = model;
		this.Arimages = this.model.getArimages();
		this.Armobile = this.model.getArmobile();
		this.x = x;
		this.y = y;

		try {
			this.image = ImageIO.read(new File(path +"lorann_b.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private int timerTimeInMilliSeconds = 10;
	
	Timer timer = new Timer(timerTimeInMilliSeconds, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("test");
		}
	});
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void move(char c) throws IOException, SQLException {
		if(isAlive == true) {
		switch (c) {

		// move Right
		case 'R':
			this.image = ImageR();
			this.c = c;
			
			
			for (IElement obj : this.Arimages) {
				if ((obj.getX() == this.getX() + 1) && (obj.getY() == this.getY())) {
					if (obj.getPerm() == Permeability.PENETRABLE) {
						this.setX(getX() + 1);
						break;
					} else if (obj.getPerm() == Permeability.COLLECTABLE) {
						if (obj.getName() == "crystal") {
							for (IElement obj2 : this.Arimages) {
								if (obj2.getName() == "doorC") {
									DoorO doorO = new DoorO(obj2.getX(), obj2.getY());
									this.exitX = obj2.getX();
									this.exitY = obj2.getY();
									Arimages.set(Arimages.indexOf(obj2), doorO);
								}
							}
						}
						this.setX(getX() + 1);
						score = score + 100;
						System.out.println("Le score est de " +score);
						IElement black = new Black(obj.getX(), obj.getY());
						Arimages.set(Arimages.indexOf(obj), black);
						break;
					} else if ((obj.getX() == this.getX() + 1) && (obj.getY() == this.getY())) {
						if(obj.getPerm() == Permeability.MONSTER) {
							System.out.println("test");
						}
					}
				}
			}
			break;
		// move Left
		case 'L':
			this.image = ImageL();
			this.c = c;

			for (IElement obj : this.Arimages) {
				if ((obj.getX() == this.getX() - 1) && (obj.getY() == this.getY())) {
					if (obj.getPerm() == Permeability.PENETRABLE) {
						this.setX(getX() - 1);
						break;
					} else if (obj.getPerm() == Permeability.COLLECTABLE) {
						if (obj.getName() == "crystal") {
							for (IElement obj2 : this.Arimages) {
								if (obj2.getName() == "doorC") {
									DoorO doorO = new DoorO(obj2.getX(), obj2.getY());
									this.exitX = obj2.getX();
									this.exitY = obj2.getY();
									Arimages.set(Arimages.indexOf(obj2),doorO);
								}
							}
						}
						this.setX(getX() - 1);
						score = score + 100;
						System.out.println("Le score est de " +score);
						IElement black = (IElement) new Black(obj.getX(), obj.getY());
						Arimages.set(Arimages.indexOf(obj), black);
						break;
					} if(obj.getPerm() == Permeability.MONSTER) {
						isAlive = false;
					}
				}else if ((obj.getX() == this.getX() - 1) && (obj.getY() == this.getY())) {
					if(obj.getPerm() == Permeability.MONSTER) {
						System.out.println("test");
					}
				}
			}
			break;

		// move Up
		case 'U':
			this.image = ImageU();
			this.c = c;

			for (IElement obj : this.Arimages) {
				if ((obj.getY() == this.getY() - 1) && (obj.getX() == this.getX())) {
					if (obj.getPerm() == Permeability.PENETRABLE) {
						this.setY(getY() - 1);
						break;
					} else if (obj.getPerm() == Permeability.COLLECTABLE) {
						if (obj.getName() == "crystal") {
							for (IElement obj2 : this.Arimages) {
								if (obj2.getName() == "doorC") {
									DoorO doorO = new DoorO(obj2.getX(), obj2.getY());
									this.exitX = obj2.getX();
									this.exitY = obj2.getY();
									Arimages.set(Arimages.indexOf(obj2), doorO);
								}
							}
						}
						score = score + 100;
						System.out.println("Le score est de " +score);
						this.setY(getY() - 1);
						IElement black = (IElement) new Black(obj.getX(), obj.getY());
						Arimages.set(Arimages.indexOf(obj), black);
						break;
					}else if (obj.getPerm() == Permeability.SPELL) {
						if(obj.getName() == "spell") {
							
						}if(obj.getPerm() == Permeability.MONSTER) {
							isAlive = false;
						}
					}
				}if ((obj.getX() == this.getX()) && (obj.getY() == this.getY() -1)) {
					if(obj.getPerm() == Permeability.MONSTER) {
						System.out.println("test");
					}
				}
			}
			break;

		// move Down
		case 'D':
			this.image = ImageD();
			this.c = c;

			for (IElement obj : this.Arimages) {
				if ((obj.getY() == this.getY() + 1) && (obj.getX() == this.getX())) {
					if (obj.getPerm() == Permeability.PENETRABLE) {
						this.setY(getY() + 1);
						break;
					} else if (obj.getPerm() == Permeability.COLLECTABLE) {
						if (obj.getName() == "crystal") {
							for (IElement obj2 : this.Arimages) {
								if (obj2.getName() == "doorC") {
									DoorO doorO = new DoorO(obj2.getX(), obj2.getY());
									this.exitX = obj2.getX();
									this.exitY = obj2.getY();
									Arimages.set(Arimages.indexOf(obj2),doorO);
								}
							}
						}
						score = score + 100;
						System.out.println("Le score est de " +score);
						this.setY(getY() + 1);
						IElement black = (IElement) new Black(obj.getX(), obj.getY());
						Arimages.set(Arimages.indexOf(obj), black);
						break;
					}
				}else if ((obj.getX() == this.getX()) && (obj.getY() == this.getY() +1)) {
					if(obj.getPerm() == Permeability.MONSTER) {
						System.out.println("test");
					}
				}	
			}
			break;
		}
		if ((this.x == this.exitX) && (this.y == this.exitY)) {
			this.lvl = this.model.getLvl();
			if(lvl<=5) {
			System.out.println("Lvl " +lvl+" END");
			lvl++;
			this.model.createMap(lvl);
			System.out.println("Road to lvl" + lvl);
			}
			
		}
		if(this.model.checkBump(this.getX(), this.getY()) == Permeability.MONSTER){
			this.model.reloadMap();
		}
		else if(this.model.checkBump(this.getX(), this.getY()) == Permeability.SPELL) {
			System.out.println("SPELL detect by Lorann");
			this.destroySpell();
		}
	}
}		

	public BufferedImage ImageD() throws IOException {
		image = ImageIO.read(new File(path +"lorann_b.png"));
		return image;
	}

	public BufferedImage ImageDl() throws IOException {
		image = ImageIO.read(new File(path +"lorann_bl.png"));
		return image;
	}

	public BufferedImage ImageDr() throws IOException {
		image = ImageIO.read(new File(path +"lorann_br.png"));
		return image;
	}

	public BufferedImage ImageL() throws IOException {
		image = ImageIO.read(new File(path +"lorann_l.png"));
		return image;
	}

	public BufferedImage ImageR() throws IOException {
		image = ImageIO.read(new File(path +"lorann_r.png"));
		return image;
	}

	public BufferedImage ImageU() throws IOException {
		image = ImageIO.read(new File(path +"lorann_u.png"));
		return image;
	}

	public BufferedImage ImageUl() throws IOException {
		image = ImageIO.read(new File(path +"lorann_ul.png"));
		return image;
	}

	public BufferedImage ImageUr() throws IOException {
		image = ImageIO.read(new File(path +"lorann_ur.png"));
		return image;
	}

	public BufferedImage Image() throws IOException {
		return image;

	}

	public Permeability getPerm() {
		return this.perm;
	}

	public void launchSpell(char c) throws SQLException {
		if(spelled  == false) {
			this.spell = new RainbowSpell(this.getX(), this.getY(), this.c, this.model, this);
		spelled = true;
		}
	}
	
	public void destroySpell() {
		this.spell.spelled = false;
		try {
			this.model.getArmobile().remove(this.spell);
			System.out.println("DESTROY !!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		spelled = false;
	}


	public void getMessage() {
		// TODO Auto-generated method stub

	}

	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}

	public void getMap1() throws SQLException {
		// TODO Auto-generated method stub
	}

	public void control() {
		// TODO Auto-generated method stub

	}

	public void orderPerform(ControllerOrder controllerOrder) throws IOException, SQLException {
		// TODO Auto-generated method stub

	}

	public void printMessage(String message) {
		// TODO Auto-generated method stub

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

	public void move() {
		// TODO Auto-generated method stub

	}

	public String getName() {
		// TODO Auto-generated method stub
		return "lorann";
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
		System.out.println("test");
	for(IMobile obj : this.Armobile) {	
		if ((obj.getX() == this.getX()) && (obj.getY() == this.getY())) {
			if(obj.getPerm() == Permeability.MONSTER) {
				
				}
			}
		}
	}		
}
