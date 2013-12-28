package com.spider.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.text.Document;

import com.spider.app.Application;

public class MainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar mEnuBar;

	public MainUI() {
		this.setTitle(Application.APPNAME);
		this.mEnuBar = SJMenuBar.getInstance();
		this.setJMenuBar(this.mEnuBar);
		this.setSize(1000, 700);
		this.setContentPane(createContentPane());
		this.setResizable(false);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windows closings");
			}
		});
	}

	private JPanel createContentPane() {
		JPanel p = new JPanel(new BorderLayout());
		p.add(BorderLayout.NORTH, createNthPane());
		p.add(BorderLayout.CENTER, createCtnPane());
		// p.add(BorderLayout.SOUTH, createSthPane());
		return p;
	}

	private JPanel createNthPane() {
		JPanel p = new JPanel();
		p.add(new JLabel("NthPane", SwingConstants.CENTER));
		return p;
	}

	private JPanel createCtnPane() {
		JPanel p = new JPanel(new BorderLayout());
		try {
			Runtime rt = Runtime.getRuntime();
			Process pr = rt.exec("tools/apktool/apktool.bat");

			BufferedReader input = new BufferedReader(new InputStreamReader(
					pr.getInputStream()));

			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = input.readLine()) != null) {
				System.out.println(line);
				sb.append(line + "\r\n");
			}
			int exitVal = pr.waitFor();
			System.out.println("Exited with error code " + exitVal);
			JTextPane text = new JTextPane();
			text.setBackground(Color.BLACK);
			// text.setDocument(doc)
			text.setText(sb.toString());
			p.add(BorderLayout.NORTH, text);
			return p;
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return null;
	}

	private JPanel createTextFiled() {

		JPanel p = new JPanel();
		return p;
	}

	private JPanel createIdOrPwdPane() {
		JPanel p = new JPanel(new GridLayout(2, 1, 0, 10));
		p.add(createIdPane());
		p.add(createPwdPane());
		return p;
	}

	private JTextField userid;

	private JPanel createIdPane() {
		JPanel p = new JPanel();
		JTextField text = new JTextField(
				"xxxxxxxxxxxxxxxxxxxxxxxxxxxaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa \n aaaaaaaaaa");
		p.add(text);
		p.add(new JLabel("user_id"));
		userid = new JTextField(20);
		p.add(userid);
		return p;
	}

	public String getCardId() {
		return this.userid.getText();
	}

	private JPasswordField password;

	private JPanel createPwdPane() {
		JPanel p = new JPanel();
		p.add(new JLabel(" user_pd"));
		password = new JPasswordField(20);
		p.add(password);
		return p;
	}

	public String getPassword() {
		return new String(this.password.getPassword());
	}

	private JPanel createSthPane() {
		JPanel p = new JPanel();
		JButton logon = new JButton("登陆");
		logon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// try {
				// //clientContext.logon();
				// } catch (IdOrPwdException e1) {
				// JOptionPane.showMessageDialog(null, e1.getMessage());
				// }

			}
		});
		JButton exist = new JButton(" 退出");
		exist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		p.add(logon);
		p.add(exist);
		return p;
	}
}
