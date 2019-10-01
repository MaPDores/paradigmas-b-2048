package listeners;

import controller.BoardController;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.block.BlockHolder;

/**
 *
 * @author marcelo
 */
public class GameKeyListener implements KeyListener {
    
    private Container board;
    private BlockHolder[][] holders;
    private BoardController boardController = new BoardController();
    
    public GameKeyListener (BlockHolder[][] holders, Container board) {
        this.holders = holders;
        this.board = board;
    }
    
    @Override
        /* NOT WORKING PROPERLY */
    public void keyTyped(KeyEvent ke) {
        System.out.println(ke.getKeyCode());
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
