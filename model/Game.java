package model;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread = new Thread(this);
    private final int fps = 144;
    public Game(){
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        gamePanel.requestFocusInWindow();
        gameThread.start();
    }

    @Override
    public void run() {
        // Draw the frames at a rate of 60 FPS
        double timePerFrameNanoSeconds = 1000000000.0/fps;
        long lastFrameTime = System.nanoTime();
        long currentTime = System.nanoTime();
        int frames = 0;
        long lastTime = System.currentTimeMillis();
        while(true){
            currentTime = System.nanoTime();
            if(currentTime - lastFrameTime >= timePerFrameNanoSeconds){
                gamePanel.repaint();
                frames++;
                lastFrameTime = currentTime;
            }
            if(System.currentTimeMillis() - lastTime >= 1000){
                System.out.println("FPS: " + frames);
                frames = 0;
                lastTime = System.currentTimeMillis();
            }
        }
    }
}
