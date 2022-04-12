package EventHandler;

import java.awt.event.KeyEvent;


import java.awt.event.KeyAdapter;


public class KeyInput extends KeyAdapter {
    Handler handler;

    Boolean[] keys = new Boolean[256];

    public KeyInput(Handler handler) {
        this.handler = handler;
        for (int i = 0; i < keys.length; i++) {
            keys[i] = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        keys[key] = true;

        for (int i = 0; i < handler.getSize(); i++) {
            handler.getObject(i).handleKeys(keys);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        keys[key] = false;

        for (int i = 0; i < handler.getSize(); i++) {
            handler.getObject(i).handleKeys(keys);
            // This shows Polymorphism.
            // The handleKeys method is called on every game object.
            // However handleKeys is defined differently based on the subclass of game object.
        }

    }


}
