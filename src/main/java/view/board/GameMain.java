package view.board;

import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author marcelo
 */
public class GameMain extends JFrame {
    
    private GameBoard board;
    
    public GameMain() {
        super("2048");
        board = new GameBoard();
        init();
    }
    /*TEST CODE TO BE DELETED*/
    class GameKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {
            if (ke.getKeyChar() == ' ') {
                board.remove(board.holders[3][2].removeBlock());
                board.revalidate();
                board.repaint();
            }
        }

        @Override
        public void keyPressed(KeyEvent ke) {}

        @Override
        public void keyReleased(KeyEvent ke) {}
    }
    /*TEST CODE TO BE DELETED*/
    
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
