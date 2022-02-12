package main;

import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
      JFrame window=new JFrame();
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setResizable(false);
      GamePanel panel=new GamePanel();
      window.add(panel);
      window.pack();
      window.setLocationRelativeTo(null);
      window.setVisible(true);
      panel.setOs();
      panel.startGameThread();
    }
}
