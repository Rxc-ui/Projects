package model;

import javax.swing.*;

public class GameWindow extends JFrame {
    private JFrame jframe;
    public GameWindow(GamePanel gamepanel){
        jframe = new JFrame();
        jframe.setSize(400, 400);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamepanel);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
