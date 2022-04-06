package com.aizxue.confchecker.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MainUI {
	public static void main(String[] args) throws Exception {
		MainUI ui = new MainUI();
		ui.create();
	}

	public void create() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("conf checker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(640, 480);
		frame.setBounds(0, 0, 640, 480);
		frame.setLayout(null);

		JPanel panel = new JPanel();
//		panel.setLayout(null);
		panel.setBounds(0, 0, 200, 200);
		panel.setBorder(new LineBorder(Color.GREEN, 1));
		frame.add(panel);

		JButton initBtn = new JButton("初始化");
		initBtn.setActionCommand("init");
		initBtn.setBounds(0, 0, 200, 200);
		initBtn.setBorder(new LineBorder(Color.BLUE, 2));
		panel.add(initBtn);
		initBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				System.out.println(cmd);
			}
		});
		frame.setVisible(true);
	}
}
