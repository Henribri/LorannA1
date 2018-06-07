package model.dao;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JOptionPane;

import contract.model.IElement;
import contract.model.IMobile;
import contract.model.IModel;
import contract.model.Permeability;
import model.Black;
import model.Corners;
import model.CrystalBall;
import model.DoorC;
import model.DoorO;
import model.HBone;
import model.Lorann;
import model.Monster1;
import model.Monster2;
import model.Monster3;
import model.Monster4;
import model.Purse;
import model.VBone;

public class Model extends Observable implements IModel, IMobile, IElement {

		int x;
		int y; 
		int delay = 0;
		int period = 0;
		int lvl;
		private Permeability permBump = Permeability.BLOCKING;
		private String message;
		List<IElement> Arimages;
		List<IMobile> Armobile;
		
		public int LevelSelection() { //The home frame, where we ask the user at which level he want to start
			int level = 6;
			String[] TabLvl = { "1", "2", "3", "4", "5" };
			JOptionPane jop = new JOptionPane();
			while (level == 6) {

				level = JOptionPane.showOptionDialog(null, "Welcome! Which level do you want? ", "Level selection",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, TabLvl, TabLvl[0]);
			}
			this.lvl = level;
			return level;

		}

		public void createMap(int lvl) throws SQLException {

			DAOConnection co = new DAOConnection(DBConnection.getInstance().getConnection());
			this.Arimages = new ArrayList<IElement>();
			this.Armobile = new ArrayList<IMobile>();
			this.lvl = lvl;
			Lorann lorann ;
			switch (lvl) { //initializing Lorann and possible monsters on the map
			case 1:
				lorann = new Lorann(13, 7, this);
				Armobile.add(0, lorann);

				break;
			case 2:
				// add Loran :
				lorann = new Lorann(13, 7, this);
				Armobile.add(0, lorann);

				// add the monster (4,19,"M"),
				Monster1 monster1 = new Monster1(16, 3, this);
				Armobile.add(monster1);

				break;

			case 3:
				// add Loran :
				lorann = new Lorann(15, 9, this);
				Armobile.add(0, lorann);

				// add the monsters:
				Monster4 monster2 = new Monster4(19, 4, this);
				Armobile.add(monster2);

				Monster2 monster3 = new Monster2(5, 10, this);
				Armobile.add(monster3);

				Monster1 monster4 = new Monster1(8, 6, this);
				Armobile.add(monster4);

				break;

			case 4:
				// add Loran :
				lorann = new Lorann(11, 1, this);
				Armobile.add(0, lorann);

				// add the monsters:
				Monster4 monster5 = new Monster4(7, 9, this);
				Armobile.add(monster5);

				Monster2 monster6 = new Monster2(12, 9, this);
				Armobile.add(monster6);

				break;

			case 5:
				// add Loran :
				lorann = new Lorann(18, 6, this);
				Armobile.add(0, lorann);

				// add the monsters:
				Monster3 monster7 = new Monster3(8, 6, this);
				Armobile.add(monster7);

				break;

			default:
				break;
			}

			for (x = 0; x < 22; x++) { //The loop which will display the non-mobiles elements on the map
				for (y = 0; y < 14; y++) {
					char symbol = co.checkMap(x, y, lvl);
					switch (symbol) {
					case '+':
						VBone vbone = new VBone(x, y);
						Arimages.add(vbone); // add() is a method that adds an
												// element on the ArrayList called
												// here "Arimage"
						break;

					case '-':
						HBone hbone = new HBone(x, y);
						Arimages.add(hbone); // add() is a method that adds an
												// element on the ArrayList called
												// here "Arimage"
						break;

					case '#':
						Corners corner = new Corners(x, y);
						Arimages.add(corner); // add() is a method that adds an
												// element on the ArrayList called
												// here "Arimage"
						break;

					case 'x':
						Purse purse = new Purse(x, y);
						Arimages.add(purse); // add() is a method that adds an
												// element on the ArrayList called
												// here "Arimage"
						break;

					case 'o':
						CrystalBall crystal = new CrystalBall(x, y);
						Arimages.add(crystal); // add() is a method that adds an
												// element on the ArrayList called
												// here "Arimage"
						break;

					case '@':
						DoorO doorO = new DoorO(x, y);
						Arimages.add(doorO); // add() is a method that adds an
												// element on the ArrayList called
												// here "Arimage"
						break;

					case '$':
						DoorC doorC = new DoorC(x, y);
						Arimages.add(doorC); // add() is a method that adds an
												// element on the ArrayList called
												// here "Arimage"
						break;

					default:
						Black black = new Black(x, y);
						Arimages.add(black);// add() is a method that adds an
											// element on the ArrayList called
						break;					// here "Arimage"	
					}
				}
			}
		}

		public List<IElement> getArimages() {

			return this.Arimages;

		}
		
		public void reloadMap() {
			try {
				this.createMap(this.getLvl());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//Check bump between element
		public Permeability checkBump(int x, int y) {
			
			Permeability permBump = null;
			for (IElement obj : Arimages) {

				if ((obj.getX() == x) && (obj.getY() == y)) {
					if ((obj.getPerm() == Permeability.COLLECTABLE)) {
						this.permBump = Permeability.COLLECTABLE;						
					} else if (obj.getPerm() == Permeability.PENETRABLE) {
						this.permBump = Permeability.PENETRABLE;
					} else if (obj.getPerm() == Permeability.BLOCKING) {
						this.permBump = Permeability.BLOCKING;
					}
				}
			}
			for (IMobile obj2 : Armobile) {
				if ((obj2.getX() == x) && (obj2.getY() == y)) {
					if (obj2.getPerm() == Permeability.MONSTER) {
						this.permBump = Permeability.MONSTER;
					} else if (obj2.getPerm() == Permeability.CHARACTER) {
						this.permBump = Permeability.CHARACTER;
					} else if (obj2.getPerm() == Permeability.SPELL) {
						this.permBump = Permeability.SPELL;
					}
				}
			}
			return this.permBump;
		}

		public List<IMobile> getArmobile() {
			return this.Armobile;
		}

		/* Instantiate a new model*/
		public Model() {
			this.message = "Initialisation du jeu.";
		}

		public void getMessage() {

		}

		
		/* set a messagee */
		private void setMessage(final String message) {
			this.message = message;
			this.setChanged();
			this.notifyObservers();
		}

		public Observable getObservable() {
			return this;
		}

		public void moveL() {
			// TODO Auto-generated method stub

		}

		public void moveU() {
			// TODO Auto-generated method stub

		}

		public void moveD() {
			// TODO Auto-generated method stub

		}

		public void moveR() {
			// TODO Auto-generated method stub

		}

		public void launchSpell(char c) {
			// TODO Auto-generated method stub

		}

		public void move(char c) {
			// TODO Auto-generated method stub

		}

		public int getX() {
			// TODO Auto-generated method stub
			return 0;
		}

		public void setX(int x) {
			// TODO Auto-generated method stub

		}

		public int getY() {
			// TODO Auto-generated method stub
			return 0;
		}

		public void setY(int y) {
			// TODO Auto-generated method stub

		}

		public Permeability getPerm() {
			// TODO Auto-generated method stub
			return null;
		}

		public BufferedImage Image() throws IOException {
			// TODO Auto-generated method stub
			return null;
		}

		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		public int getLvl() {
			return this.lvl;
		}

		public void move() {
			// TODO Auto-generated method stub

		}

		public void refresh() {
			// TODO Auto-generated method stub

		}

		public void launchSpell() {
			// TODO Auto-generated method stub

		}

		public int LevelChoice(String message) {
			// TODO Auto-generated method stub
			return 0;
		}

		public Permeability checkPermBump() {
			// TODO Auto-generated method stub
			return null;
		}

		public void addArmobile(IMobile mobile) {
			this.Armobile.add(mobile);
		}

		public void delArmobile(IMobile mobile) {
			this.Armobile.remove(mobile);
		}

		@Override
		public void doNothing() {
			// TODO Auto-generated method stub
			
		}

		
	}
