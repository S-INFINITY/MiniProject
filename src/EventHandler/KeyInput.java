package EventHandler;

import java.awt.event.KeyEvent;


import Objects.ControllableGameObject;
import Objects.GameObject;

import java.awt.event.KeyAdapter;

public class KeyInput extends KeyAdapter {
    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.getSize(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getClass() == ControllableGameObject.class) {
                ControllableGameObject tempControllableObject = (ControllableGameObject) tempObject;
                tempControllableObject.handleKeyPress(key);
            }
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.getSize(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getClass() == ControllableGameObject.class) {
                ControllableGameObject tempControllableObject = (ControllableGameObject) tempObject;
                tempControllableObject.handleKeyRelease(key);
            }
        }

    }

}
