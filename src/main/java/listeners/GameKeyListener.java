package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.block.BlockHolder;

/**
 *
 * @author marcelo
 * 
 * Classe que ouve as Teclas do Teclado e executa os comandos.
 */
public class GameKeyListener extends ExtendableListener implements KeyListener {
    
    public GameKeyListener (BlockHolder[][] holders) {
        super(holders);
    }
    
    @Override
        /* NOT WORKING PROPERLY */
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        boolean hasMoved = false;
        if(ke.getKeyCode() == KeyEvent.VK_W || ke.getKeyCode() == KeyEvent.VK_UP){
            hasMoved = boardController.moveUp(holders);
        }
        if(ke.getKeyCode() == KeyEvent.VK_A || ke.getKeyCode() == KeyEvent.VK_LEFT){
            hasMoved = boardController.moveLeft(holders);
        }
        if(ke.getKeyCode() == KeyEvent.VK_S || ke.getKeyCode() == KeyEvent.VK_DOWN){
            hasMoved = boardController.moveDown(holders);
        }
        if(ke.getKeyCode() == KeyEvent.VK_D || ke.getKeyCode() == KeyEvent.VK_RIGHT){
            hasMoved = boardController.moveRight(holders);
        }
        if(ke.getKeyCode() == KeyEvent.VK_SPACE){
            boardController.easterEgg(holders);
        }
        if (hasMoved)
            boardController.createRandom(holders);       
    }

    @Override
    public void keyReleased(KeyEvent ke) {}
    
}
