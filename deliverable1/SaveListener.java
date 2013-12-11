package deliverable1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * @author Louie Kert Basay
 * @date
 * 
 */
public class SaveListener implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame f = Interface.getMainFrame();
		String file = null;
		if(f.getTitle().equals("Untitled")) {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(f);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File selected = fc.getSelectedFile();
				file = selected.getAbsolutePath();
				try {
					new Writer(file);
				} catch (FileNotFoundException e1) {
					;
				}
			}
			return;
		}
		else {
			file = f.getTitle();
			try {
				new Writer(file);
			} catch (FileNotFoundException e1) {
				;
			}
		}
		
	}

}
