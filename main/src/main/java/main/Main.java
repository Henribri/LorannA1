package main;

import java.io.IOException;
import java.sql.SQLException;

import controller.Controller;
import model.dao.Model;
import view.ViewFacade;


public abstract class Main {
	
	/**
	 * Try java doc for main
	 * @param args
	 * argument
	 * @throws SQLException
	 * use database
	 * @throws IOException
	 * test if it work
	 */
	public static void main(final String[] args) throws SQLException, IOException {
		final Model model = new Model();
		model.createMap(model.LevelSelection() + 1);
		final ViewFacade view = new ViewFacade(model);
		final Controller controller = new Controller(view, model);
		view.setController(controller);
    }
}
