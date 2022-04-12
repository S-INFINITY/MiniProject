import java.awt.Canvas;

import javax.swing.JFrame;

import EventHandler.KeyInput;

// This class is used to create the window that the game will be displayed in.

public class Window extends Canvas {
    public Window(int width, int height, String title, Game game, KeyInput keyInput) {

        JFrame frame = new JFrame(title);

        frame.addKeyListener(keyInput);

        // Setting the size of the window
        frame.setPreferredSize(new java.awt.Dimension(width, height));
        frame.setMaximumSize(new java.awt.Dimension(width, height));
        frame.setMinimumSize(new java.awt.Dimension(width, height));

        // Setting window settings
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // set the window to be in the center of the screen
        frame.setLocationRelativeTo(null);

        frame.add(game);
        frame.setVisible(true);
        game.start();

    }
}