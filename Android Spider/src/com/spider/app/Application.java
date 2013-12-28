package com.spider.app;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Application {
	public static String APPNAME = "Android Spider";
	public static String APPIconUrl = "icon/spider.jpg";

	public static void setIconImage(JFrame frame, String url) {
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage(url));
	}

	public static void AppInit(JFrame frame) {
		setIconImage(frame, APPIconUrl);
	}
}
