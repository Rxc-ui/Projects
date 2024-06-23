package model;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel{
    private MouseInputs mouseInputs;
    private float xDelta = 100f;
    private float yDelta = 100f;
    private int frames = 0;
    private long lastTime = System.currentTimeMillis();
    private float xDirection = 1f;
    private float yDirection = 1f;
    private Color color = Color.BLUE;
    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    public void changeXDelta(int value){
        this.xDelta += value;
    }
    public void changeYDelta(int value){
        this.yDelta += value;
    }
    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
//        g.drawRect(100, 100,200,50);
        g.setColor(color);
        g.fillRect((int) xDelta, (int) yDelta, 200, 50);
        moveRectangle();
        frames++;
        // repaint();
    }
    private void moveRectangle() {
        xDelta += xDirection;
        if(xDelta >= 400 || xDelta <= 0){
            xDirection = xDirection * -1;
            color = changeRandomColor();
        }
        yDelta += yDirection;
        if(yDelta >= 400 || yDelta <= 0){
            yDirection = yDirection * -1;
            color = changeRandomColor();
        }
    }
    private Color changeRandomColor(){
        return new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255));
    }
}
