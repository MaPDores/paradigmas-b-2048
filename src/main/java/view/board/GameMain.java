package view.board;

import controller.BoardController;
import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* TEST CODE TO BE DELETED */
import view.block.ColoredBlock;
/* TEST CODE TO BE DELETED */

/**
 *
 * @author marcelo
 */
public class GameMain extends JFrame {
    
    private BoardController boardController = new BoardController();
    private GameBoard board;
    
    /* TEST CODE TO BE DELETED */
    boolean isThere = false;
    /* TEST CODE TO BE DELETED */
    
    public GameMain() {
        super("2048");
        board = new GameBoard();
        init();
    }
    /* TEST CODE TO BE DELETED */
    class GameKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {
            if (ke.getKeyChar() == ' ') {
                if (!isThere) {
                    System.out.println("sds");
                    boardController.shiftLeft(board.holders);
                    boardController.combineLeft(board.holders, board);
                    boardController.shiftLeft(board.holders);
                } else {
                    ColoredBlock aux = board.holders[1][3].removeBlock();
                    board.holders[1][0].setBlock(aux);
                    isThere = false; 
                }
                //board.remove(board.holders[1][0].removeBlock());
                //board.revalidate();
                //board.repaint();
            }
        }

        @Override
        public void keyPressed(KeyEvent ke) {}

        @Override
        public void keyReleased(KeyEvent ke) {}
    }
    /* TEST CODE TO BE DELETED */
    
    public final void init() {
        setTitle("2048");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 250, 298, 328);
        setResizable(false);
        setVisible(true);
        
        buildGUI();
        buildKeyListeners();
    }
    
    private void buildGUI() {
        add(board);
    }
    
    private void buildKeyListeners() {
        /*TEST CODE TO BE DELETED*/
        GameKeyListener space = new GameKeyListener();
        addKeyListener(space);
        /*TEST CODE TO BE DELETED*/
    }
}
