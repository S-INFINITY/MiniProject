package Objects;

import java.awt.Graphics;

import Objects.Abstract.GameObject;

public class Block extends GameObject {
    
        public Block(float x, float y, ID id, String spriteSheetPath, int canvasWidth, int canvasHeight) {
            super(x, y, id, spriteSheetPath, canvasWidth, canvasHeight);
        }
    
        @Override
        public void tick() {
        }
    
        @Override
        public void render(Graphics g) {
            g.drawImage(sprite, (int) x, (int) y, width, height, null);
        }

        @Override
        public void handleKeys(Boolean[] keys) {
            // TODO Auto-generated method stub
            
        }
    
    
}
