package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.util.List;


import org.junit.Test;

import contract.model.IMobile;
import contract.model.Permeability;

public class TestModel {
	
	    
	    @Test
	    public void testgetPerm(){
	    	
	    	Permeability expected = Permeability.BLOCKING;
	    	assertEquals(expected, Permeability.BLOCKING);
	    	  }
	    
	    @Test
	    public void testmove() {
	    	     	 
	    } 
	    
	    @Test 
	    public void testgetArimages(){
	    	List<IMobile> expected = null;
	    	assertNull(expected);
	    	
	    }
	    
	    @Test
	    public void testgetMessage() {
	    	    	
	    }
	    
	    @Test
	    public void testgetObservable() {
	    	    	
	    }
	    
	 
	    
	    @Test
	    public void testcontrol() {
	    	    	
	    }
	    
	    @Test
	    public void launchSpell() throws SQLException{
	    	
	    	
	    }
	    
	}

