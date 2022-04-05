import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import EventHandler.Handler;
import EventHandler.KeyInput;
import Objects.ID;
import Objects.Player;

import java.awt.Color;

/*
 * This is the main class which will be used to create the window and the game.
 * The run method contain the game loop.
 * The tick and render methods are used to tick and render the game.
 */

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "Game v0";

    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private KeyInput keyInput;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        handler = new Handler();
        keyInput = new KeyInput(handler);
        this.addKeyListener(keyInput);
        new Window(WIDTH, HEIGHT, TITLE, this);
        handler.addObject(new Player(10, 10, ID.Player));
    }

    public synchronized void start() {
        // start the thread
        Thread thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        // run the game
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }

    private void tick() {
        // update the game
        handler.tick();
    }

    public void render() {
        // render the game
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);

        handler.render(g);

        g.dispose();
        bs.show();


        
    }

}