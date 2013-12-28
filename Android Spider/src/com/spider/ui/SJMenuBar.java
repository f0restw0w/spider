package com.spider.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class SJMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private static String FILE = "file";
	private static String OPTION = "option";
	private static String HELP = "help";
	private static JMenu mFile = new JMenu(FILE);
	private static JMenu mOtion = new JMenu(OPTION);
	private static JMenu mHelp = new JMenu(HELP);

	private static SJMenuBar mEnuBar = new SJMenuBar();

	public static SJMenuBar getInstance() {
		mEnuBar.add(mFile);
		mEnuBar.add(mOtion);
		mEnuBar.add(mHelp);
		return mEnuBar;
	}

	private SJMenuBar() {
	};
}
