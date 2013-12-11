package deliverable1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JMenuItem;

/**
 * @author Louie Kert Basay
 * @date
 * 
 */
public class NewListener implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JMenuItem save = Interface.getSave();
		if(save.isEnabled()) {
			//TODO
		}
		
		/*
		Constructor<?>[] ctors = Interface.class.getDeclaredConstructors();
		Constructor<?> ctor = ctors[0];
		try {
			String[] args = new String[] {};
			Interface i = (Interface) ctor.newInstance();
			Method m = i.getClass().getDeclaredMethod("main", String[].class);
			m.setAccessible(true);
			m.invoke(null, (Object) args);
			
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

}
