package view.board;

import javax.swing.JFrame;
import listeners.GameArrowListener;

import listeners.GameKeyListener;
import listeners.GameMouseListener;

/**
 *
 * @author marcelo
 */
public class GameMain extends JFrame {
    
    private GameBoard board;
    private GameKeyListener keyListener;
    private GameMouseListener mouseListener;
    private GameArrowListener arrowListener;
    
    public GameMain() {
        super("2048");
        init();
    }
    
    public final void init() {
        setTitle("2048");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 250, 298, 328);
        setResizable(false);
        setVisible(true);
        
        buildGUI();
        buildKeyListeners();
        buildMouseListeners();
        buildArrowListeners();
    }
    
    private void buildGUI() {
        board = new GameBoard();
        add(board);
    }
    
    private void buildArrowListeners() {
        arrowListener = new GameArrowListener(board.holders);
        addKeyListener(arrowListener);
    }
    
    private void buildKeyListeners() {
        keyListener = new GameKeyListener(board.holders);
        addKeyListener(keyListener);
    }
    
    private void buildMouseListeners() {
        mouseListener = new GameMouseListener(board.holders);
        addMouseListener(mouseListener);
    }
}
