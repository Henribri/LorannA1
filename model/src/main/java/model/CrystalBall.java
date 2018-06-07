package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import contract.model.IElement;
import contract.model.Permeability;

public class CrystalBall extends Items {

	private int x;
	private int y;
	private String name = "crystal";
	Permeability perm = Permeability.COLLECTABLE;
	
	public CrystalBall(int x, int y){
		
		this.x = x;
		this.y = y;
		
	}

	public int getX() {
		return x;
	}
	
	public String getName(){
		return this.name;
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

	public BufferedImage Image() throws IOException {
		BufferedImage crystal_ball = ImageIO.read(new File(path +"crystal_ball.png"));
		return crystal_ball;
	}

	public Permeability getPerm() {
		// TODO Auto-generated method stub
		return this.perm;
	}

	public void move(char c) {
		// TODO Auto-generated method stub
		
	}

	public List<IElement> getArimages() {
		// TODO Auto-generated method stub
		return null;
}
}
