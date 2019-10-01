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
    public void keyTyped(KeyEvent ke) {
        if (ke.getKeyChar() == ' ') {
            boardController.shiftLeft(holders);
            boardController.combineLeft(holders, board);
            boardController.shiftLeft(holders);
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {}
    
}
