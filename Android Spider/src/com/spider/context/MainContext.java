package com.spider.context;

/*
 * @author f0rest
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.spider.app.Application;
import com.spider.ui.MainUI;

public class MainContext {
	public static void main(String[] args) {
		MainUI main = new MainUI();
		Application.AppInit(main);
		main.setVisible(true);

	}
}
