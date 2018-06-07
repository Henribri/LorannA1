package view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.awt.event.KeyEvent;
import java.util.List;

import org.junit.Test;

import contract.controller.ControllerOrder;
import contract.model.IElement;
import contract.model.IMobile;

public class TestView {

	@Test
    public void  keyCodeToControllerOrder() {
  
    	ControllerOrder expected = ControllerOrder.Right;
        assertEquals(expected, ViewFacade.keyCodeToControllerOrder(KeyEvent.VK_RIGHT)); 

        expected = ControllerOrder.Left;
        assertEquals(expected, ViewFacade.keyCodeToControllerOrder(KeyEvent.VK_LEFT)); 

        expected = ControllerOrder.Up;
        assertEquals(expected, ViewFacade.keyCodeToControllerOrder(KeyEvent.VK_UP)); 

        expected = ControllerOrder.Down;
        assertEquals(expected, ViewFacade.keyCodeToControllerOrder(KeyEvent.VK_DOWN)); 
	
    	expected = null; 
    	assertEquals(expected, ViewFacade.keyCodeToControllerOrder(0));

    }
    
    @Test
	public void keyPressed() {
		
		
	}

    @Test
   	public void keyTyped() {
   		
   		
   	}
    
    @Test
	public void getArmobile() {
    	List<IMobile> expected = null;
    	assertNull(expected);
	}
	
	@Test
	public void getArimages() {
    	List<IElement> expected = null;
    	assertNull(expected);
	}
    
}