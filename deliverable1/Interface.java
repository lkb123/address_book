package deliverable1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class Interface extends JPanel {
	
	static AddressBook a;
	static JFrame mainFrame = new JFrame();
	static JPanel listPanel = new JPanel();
	static JPanel buttonPanel = new JPanel();
	static DefaultListModel<Entry> entries;
	static JList<Entry> list;
	static JMenuItem findNext, save;
	static String file = null;
	
	public static void main(String[] args) throws IOException {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new Interface();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Interface() throws IOException {
		if(file != null) {
			mainFrame.setTitle(file);
			a = new AddressBook(file);
		}
		else {
			mainFrame.setTitle("Untitled");
			a = new AddressBook();
		}
		entries = a.getEntries();
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setMinimumSize(new Dimension(700, 500));
		mainFrame.setResizable(false);
		
		listPanel.setPreferredSize(new Dimension(700, 400));
		buttonPanel.setPreferredSize(new Dimension(500, 100));
		
		createMenu();
		createList();
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
		item.addActionListener(new NewListener());
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		menu.add(item);
		//open
		item = new JMenuItem("Open", KeyEvent.VK_O);
		item.addActionListener(new OpenListener());
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		menu.add(item);
		//Save
		save = new JMenuItem("Save", KeyEvent.VK_S);
		save.addActionListener(new SaveListener());
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		if(mainFrame.getTitle().equals("Untitled"))	save.setEnabled(true);
		else	save.setEnabled(false);
		menu.add(save);
		//Save As
		item = new JMenuItem("Save As", KeyEvent.VK_A);
		item.addActionListener(new SaveAsListener());
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
		item.setActionCommand("Sort by Name");
		item.addActionListener(new SortListener());
		menu.add(item);
		
		item = new JMenuItem("Sort by Zip");
		item.setActionCommand("Sort by Zip");
		item.addActionListener(new SortListener());
		menu.add(item);
		
		mbar.add(menu);
		
		//search menu
		menu = new JMenu("Search");
		menu.setMnemonic(KeyEvent.VK_E);
		//find
		item = new JMenuItem("Find");
		item.addActionListener(new FindListener());
		menu.add(item);
		//find again
		findNext = new JMenuItem("Find Again");
		findNext.addActionListener(new FindIteratorListener());
		findNext.setEnabled(false);
		menu.add(findNext);
		
		mbar.add(menu);
		
		mainFrame.setJMenuBar(mbar);
	}
	
	/**
	 * creates the list
	 * @param entry the values for the list
	 */
	public static void createList() {
		list = new JList<Entry>(entries);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setPreferredSize(new Dimension(500, 390));
		list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		listPanel.add(list);
		
		JScrollPane scroll = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//JScrollPane scroll = new JScrollPane(list);
		scroll.setPreferredSize(new Dimension(520, 410));
		listPanel.add(scroll);
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
	 * Get the currently selected index of the JList
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
	 * Gets the instance list of the address book
	 * @return the list of the address book
	 */
	public static JList<Entry> getList() {
		return list;
	}
	
	/**
	 * Gets the instance of the findNext JMenuItem located in the Search Menu of the Interface
	 * @return the findNext menu item
	 */
	public static JMenuItem getFindNext() {
		return findNext;
	}
	
	/**
	 * Gets the instance of the save JMenuItem located in the File Menu of the Interface
	 * @return the save menu item
	 * @return
	 */
	public static JMenuItem getSave() {
		return save;
	}
	
	public static void setAddressBook(AddressBook tmp) {
		a = tmp;
	}
	
	
	public static void reset() {
		file = null;
		a.reset();
		mainFrame.setTitle("Untitled");
	}
	
	public static void reset(String newFile) throws IOException {
		file = newFile;
		a.reload(newFile);
		mainFrame.setTitle(newFile);
	}
	
	
} //end of class
