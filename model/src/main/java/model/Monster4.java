package model;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

import contract.model.IElement;
import contract.model.IMobile;
import contract.model.IModel;
import contract.model.Permeability;

public class Monster4 extends Mobile{

	private int x;
	private int y;
	private IModel model;
	private Lorann lorann;

	Permeability perm = Permeability.MONSTER;

	private List<IMobile> Armobile = new ArrayList<IMobile>();
	private List<IElement> Arimages = new ArrayList<IElement>();
	/**
	 * Put the monster in a model and give his position
	 * @param x
	 * position on x axe
	 * @param y
	 * position on y axe
	 * @param model
	 * model wanted
	 * @throws SQLException
	 * use data base
	 */

	public Monster4(int x, int y, IModel model) throws SQLException {
		this.model = model;
		this.Arimages = this.model.getArimages();
		this.Armobile = this.model.getArmobile();
		this.lorann = (Lorann) this.Armobile.get(0);
		this.x = x;
		this.y = y;
	}
	
	private int timerTimeInMilliSeconds = 1500;
	Timer timer = new Timer(timerTimeInMilliSeconds, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			move();
			model.refresh();
		}
		
	});
	
	public void monsterDie() {
		try {
			this.model.getArmobile().remove(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BufferedImage Image() throws IOException {
		BufferedImage monster_1 = ImageIO.read(new File(path +"monster_4.png"));
		return monster_1;
	}

	public Permeability getPerm() {
		return this.perm;
	}

public void move() {
		
		if (this.model.checkBump(this.getX(), this.getY()) == Permeability.SPELL) {
			try {
				this.model.getArmobile().remove(this);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*
		 * Upper-left
		 */

		if ((this.Armobile.get(0).getX() < this.x) && (this.Armobile.get(0).getY() < this.y))

			for (IElement obj : this.Arimages) {
				
				if(this.model.checkBump(this.getX()-1, this.getY()-1) == Permeability.PENETRABLE){
						this.setX(getX() - 1);
						this.setY(getY() - 1);
						break;			
				}
			}
			
			for (IMobile obj : this.Armobile) {
				if (this.model.checkBump(this.getX()-1,this.getY()-1) == Permeability.CHARACTER) {
					this.setX(getX() - 1);
					this.setY(getY() - 1);
					this.model.reloadMap();
						break;
					}
				else if (this.model.checkBump(this.getX()-1,this.getY()-1) == Permeability.SPELL) {
					this.lorann.destroySpell();
					this.monsterDie();
				}
			}

		/*
		 * Upper-right
		 */

		if ((this.Armobile.get(0).getX() > this.x) && (this.Armobile.get(0).getY() < this.y)) {
			for (IElement obj : this.Arimages) {
				if (this.model.checkBump(this.getX()+1, this.getY()-1) == Permeability.PENETRABLE) {
						this.setX(getX() + 1);
						this.setY(getY() - 1);
						break;
				}
			}
			
			for (IMobile obj : this.Armobile) {
				if (this.model.checkBump(this.getX()+1,this.getY()-1) == Permeability.CHARACTER) {
					this.setX(getX() + 1);
					this.setY(getY() - 1);
					this.model.reloadMap();
						break;
					}
				else if (this.model.checkBump(this.getX()+1,this.getY()-1) == Permeability.SPELL) {
					this.lorann.destroySpell();
					this.monsterDie();
				}
			}
		}

		/*
		 * Lower-left
		 */

		else if ((this.Armobile.get(0).getX() < this.x) && (this.Armobile.get(0).getY() > this.y)) {

			for (IElement obj : this.Arimages) {
				if (this.model.checkBump(this.getX()-1, this.getY()+1) == Permeability.PENETRABLE) {
						this.setX(getX() - 1);
						this.setY(getY() + 1);
						break;
					
				}
			}
			
			for (IMobile obj : this.Armobile) {
				if (this.model.checkBump(this.getX()-1,this.getY()+1) == Permeability.CHARACTER) {
					this.setX(getX() - 1);
					this.setY(getY() + 1);
					this.model.reloadMap();
						break;
					}
				else if (this.model.checkBump(this.getX()-1,this.getY()+1) == Permeability.SPELL) {
					this.lorann.destroySpell();
					this.monsterDie();
				}
			}
		}

		/*
		 * Lower-right
		 */

		else if ((this.Armobile.get(0).getX() > this.x) && (this.Armobile.get(0).getY() > this.y)) {

			for (IElement obj : this.Arimages) {
				if (this.model.checkBump(this.getX()+1, this.getY()+1) == Permeability.PENETRABLE) {
						this.setX(getX() + 1);
						this.setY(getY() + 1);
						break;
					
				}
			}
			
			for (IMobile obj : this.Armobile) {
				if (this.model.checkBump(this.getX()+1,this.getY()+1) == Permeability.CHARACTER) {
					this.setX(getX() + 1);
					this.setY(getY() + 1);
					this.model.reloadMap();
						break;
					}
				else if (this.model.checkBump(this.getX()+1,this.getY()+1) == Permeability.SPELL) {
					this.lorann.destroySpell();
					this.monsterDie();
				}
			}
		}

		/*
		 * Left
		 */

		else if ((this.Armobile.get(0).getX() < this.x) && (this.Armobile.get(0).getY() == this.y)) {

			for (IElement obj : this.Arimages) {
				if (this.model.checkBump(this.getX()-1, this.getY()) == Permeability.PENETRABLE) {
						this.setX(getX() - 1);
						break;
					}
			}
			
			for (IMobile obj : this.Armobile) {
				if (this.model.checkBump(this.getX()-1,this.getY()) == Permeability.CHARACTER) {
						this.setX(getX() - 1);
						this.model.reloadMap();
						break;
					}
				else if (this.model.checkBump(this.getX()-1,this.getY()) == Permeability.SPELL) {
					this.lorann.destroySpell();
					this.monsterDie();
				}
			}
		}

		/*
		 * Right
		 */

		else if ((this.Armobile.get(0).getX() > this.x) && (this.Armobile.get(0).getY() == this.y)) {

			for (IElement obj : this.Arimages) {
				if (this.model.checkBump(this.getX()+1,this.getY()) == Permeability.PENETRABLE) {
						this.setX(getX() + 1);
						break;
					}
			}
			
			for (IMobile obj : this.Armobile) {
				if (this.model.checkBump(this.getX()+1,this.getY()) == Permeability.CHARACTER) {
						this.setX(getX() + 1);
						this.model.reloadMap();
						break;
					}
				else if (this.model.checkBump(this.getX()+1,this.getY()) == Permeability.SPELL) {
					this.lorann.destroySpell();
					this.monsterDie();
				}
			}
		}

		/*
		 * Up
		 */

		else if ((this.Armobile.get(0).getX() == this.x) && (this.Armobile.get(0).getY() < this.y)) {

			for (IElement obj : this.Arimages) {
				if (this.model.checkBump(this.getX(), this.getY()-1) == Permeability.PENETRABLE) {
						this.setY(getY() - 1);
						break;
					}
			}
			
			for (IMobile obj : this.Armobile) {
				if (this.model.checkBump(this.getX(),this.getY()-1) == Permeability.CHARACTER) {
						this.setY(getY() - 1);
						this.model.reloadMap();
						break;
					}
				else if (this.model.checkBump(this.getX(),this.getY()-1) == Permeability.SPELL) {
					this.lorann.destroySpell();
					this.monsterDie();
				}
			}
			
		}

		/*
		 * Down
		 */
		
		else if ((this.Armobile.get(0).getX() == this.x) && (this.Armobile.get(0).getY() > this.y)) {
			for (IElement obj : this.Arimages) {
				if (this.model.checkBump(this.getX(), this.getY()+1) == Permeability.PENETRABLE) {
						this.setY(getY() + 1);
						break;
					}
				}
		}
		
		for (IMobile obj : this.Armobile) {
			if (this.model.checkBump(this.getX(),this.getY()+1) == Permeability.CHARACTER) {
					this.setY(getY() + 1);
					this.model.reloadMap();
					break;
				}
			else if (this.model.checkBump(this.getX(),this.getY()+1) == Permeability.SPELL) {
				this.lorann.destroySpell();
				this.monsterDie();
			}
		}
	}

public void launchSpell(char c) {
	// TODO Auto-generated method stub

}
	public void move(char c) throws IOException, SQLException {
		// TODO Auto-generated method stub

	}

	public String getName() {
		// TODO Auto-generated method stub
		return "monster4";
	}
}
