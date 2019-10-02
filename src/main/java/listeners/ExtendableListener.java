package listeners;

import controller.BoardController;
import java.awt.Container;
import view.block.BlockHolder;

/**
 *
 * @author marcelo
 */
public abstract class ExtendableListener {
    protected Container board;
    protected BlockHolder[][] holders;
    protected BoardController boardController = new BoardController();
    
    public ExtendableListener (BlockHolder[][] holders, Container board) {
        this.holders = holders;
        this.board = board;
    }
}
