package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.block.BlockHolder;

/**
 *
 * @author marcelo
 */
public class GameArrowListener extends ExtendableListener implements KeyListener{
        
    public GameArrowListener (BlockHolder[][] holders) {
        super(holders);
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        //boolean hasMoved = false;

        //switch(ke.getKeyChar()) {
        //    case 'w':
        //        hasMoved = boardController.moveUp(holders);
        //        break;
        //   case 'a':
        //        hasMoved = boardController.moveLeft(holders);
        //        break;
        //    case 's':
        //        hasMoved = boardController.moveDown(holders);
        //        break;
        //    case 'd':
        //        hasMoved = boardController.moveRight(holders);
        //        break;
        //}
        //if (hasMoved)
        //    boardController.createRandom(holders);
    }

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {}
}
