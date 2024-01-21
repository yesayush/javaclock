package com.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("testing...");
        MyWindow w = new MyWindow();
    }

    public static class MyWindow extends JFrame {
        private JLabel heading;
        private JLabel clockLabel;
        private Font font = new Font("", Font.BOLD, 35);

        public MyWindow() {
            super.setTitle("My Clock");
            super.setSize(400, 400);
            super.setLocation(300, 50);
            this.createGUI();
            this.startClock();
            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            super.setVisible(true);
        }

        public void createGUI() {
            // GUI
            heading = new JLabel("My Clock");
            clockLabel = new JLabel("Clock");

            heading.setFont(font);
            clockLabel.setFont(font);

            this.setLayout(new GridLayout(2, 1));

            this.add(heading);
            this.add(clockLabel);
        }

        public void startClock() {
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String dateTime = new Date().toString();
                    clockLabel.setText(dateTime);
                }
            });

            timer.start();
        }
    }
}
