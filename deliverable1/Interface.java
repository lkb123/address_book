package deliverable1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;

public class Interface extends JPanel {
	
	static AddressBook a ;
	static JFrame mainFrame = new JFrame("Untitled");
	static JPanel listPanel = new JPanel();
	static JPanel buttonPanel = new JPanel();
	static DefaultListModel<Entry> entries;
	static JList<Entry> list;
	
	public static void main(String[] args) throws IOException {
		String file = "json_files/sample_json.json";
		a = new AddressBook(file);
		//a = new AddressBook();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Interface();
			}
		});
	}
	
	public Interface() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setMinimumSize(new Dimension(700, 500));
		mainFrame.setResizable(false);
		
		listPanel.setPreferredSize(new Dimension(700, 400));
		buttonPanel.setPreferredSize(new Dimension(500, 100));
		
		createMenu();
		createList(setEntries());
		addButtons();
		
		add(listPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);
		
		
		mainFrame.getContentPane().add(this);
		mainFrame.setVisible(true);
	}
	
	/**
	 * sets the menu button of the interface
	 */
	public static void createMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu menu;
		JMenuItem item;
		
		//file menu
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		
		//new
		item = new JMenuItem("New", KeyEvent.VK_N);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		menu.add(item);
		//open
		item = new JMenuItem("Open", KeyEvent.VK_O);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		menu.add(item);
		//Save
		item = new JMenuItem("Save", KeyEvent.VK_S);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menu.add(item);
		//Save As
		item = new JMenuItem("Save As", KeyEvent.VK_A);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		menu.add(item);
		//-----------------------------
		menu.addSeparator();
		item = new JMenuItem("Print", KeyEvent.VK_P);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		menu.add(item);
		//-----------------------------		
		menu.addSeparator();
		item = new JMenuItem("Quit", KeyEvent.VK_Q);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		item.addActionListener(new QuitListener());
		menu.add(item);
		
		mbar.add(menu);
		
		//sort menu
		menu = new JMenu("Sort");
		menu.setMnemonic(KeyEvent.VK_O);
		
		//Sort by name
		item = new JMenuItem("Sort by Name");
		menu.add(item);
		
		item = new JMenuItem("Sort by Zip");
		menu.add(item);
		
		mbar.add(menu);
		
		//search menu
		menu = new JMenu("Search");
		menu.setMnemonic(KeyEvent.VK_E);
		mbar.add(menu);
		
		mainFrame.setJMenuBar(mbar);
	}
	
	/**
	 * creates the list
	 * @param entry the values for the list
	 */
	public static void createList(ArrayList<Entry> entry) {
		entries = new DefaultListModel<Entry> ();
		for(Entry s : entry) {
			entries.addElement(s);
		}
		
		list = new JList<Entry>(entries);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setPreferredSize(new Dimension(500, 390));
		list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		listPanel.add(list);
	}
	
	/**
	 * Add buttons to the interface
	 */
	public static void addButtons() {
		JButton add = new JButton("Add");
		add.addActionListener(new AddListener());
		JButton edit = new JButton("Edit");
		edit.addActionListener(new EditListener());
		JButton delete = new JButton("Delete");
		delete.addActionListener(new DeleteListener());
		
		buttonPanel.add(add);
		buttonPanel.add(edit);
		buttonPanel.add(delete);
	}
	
	/**
	 * set the entries for the list
	 * @return the the entries in the address book
	 */
	public static ArrayList<Entry> setEntries() {
		return a.getEntries();
	}
	
	/**
	 * Adds a new person to the list
	 * @param value the String value of the person to be added
	 */
	public static void addToList(Entry value) {
		entries.addElement(value);
	}
	
	/**
	 * 
	 * @return the selected index of the list
	 */
	public static int getSelectedIndex() {
		return list.getSelectedIndex();
	}
	
	/**
	 * Get the main frame of the address book
	 * @return the main frame of the interface
	 */
	public static JFrame getMainFrame() {
		return mainFrame;
	}
	
	/**
	 * Get the address book
	 * @return the address book
	 */
	public static AddressBook getAddressBook() {
		return a;
	}

	/**
	 * Edits the list model to be reflected to the list
	 * @param selectedIndex the index of the person to be edited
	 * @param entryAt the new entry
	 */
	public static void editToList(int selectedIndex, Entry entryAt) {
		entries.set(selectedIndex, entryAt);
	}

	/**
	 * @param selected the index of the entry to be deleted
	 */
	public static void deleteToList(int selected) {
		entries.remove(selected);
	}
} //end of class
