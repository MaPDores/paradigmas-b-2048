package listeners;

import java.awt.Container;
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
    
    public GameKeyListener (BlockHolder[][] holders, Container board) {
        super(holders, board);
    }
    
    @Override
        /* NOT WORKING PROPERLY */
    public void keyTyped(KeyEvent ke) {
        System.out.println(ke.getKeyChar());
        switch(ke.getKeyCode()) {
            case KeyEvent.VK_UP:
                boardController.shiftLeft(holders);
                boardController.combineLeft(holders, board);
                boardController.shiftLeft(holders);
                break;
            case KeyEvent.VK_LEFT:
                boardController.shiftLeft(holders);
                boardController.combineLeft(holders, board);
                boardController.shiftLeft(holders);
                break;
            case KeyEvent.VK_RIGHT:
                boardController.shiftLeft(holders);
                boardController.combineLeft(holders, board);
                boardController.shiftLeft(holders);
                break;
            case KeyEvent.VK_DOWN:
                boardController.shiftLeft(holders);
                boardController.combineLeft(holders, board);
                boardController.shiftLeft(holders);
                break;
        }
        switch(ke.getKeyChar()) {
            case 'w':
                boardController.shiftLeft(holders);
                boardController.combineLeft(holders, board);
                boardController.shiftLeft(holders);
                break;
            case 'a':
                boardController.shiftLeft(holders);
                boardController.combineLeft(holders, board);
                boardController.shiftLeft(holders);
                break;
            case 's':
                boardController.shiftLeft(holders);
                boardController.combineLeft(holders, board);
                boardController.shiftLeft(holders);
                break;
            case 'd':
                boardController.shiftLeft(holders);
                boardController.combineLeft(holders, board);
                boardController.shiftLeft(holders);
                break;
        }

    }

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {}
    
}
