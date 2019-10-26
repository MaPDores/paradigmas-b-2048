package view.board;

import javax.swing.JFrame;

import listeners.GameKeyListener;
import listeners.GameMouseListener;
import listeners.GameWebListener;

/**
 *
 * @author marcelo
 */
public class GameMain extends JFrame {
    
    private GameBoard board;
    private GameKeyListener keyListener;
    private GameMouseListener mouseListener;
    private GameWebListener webListener;
    
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
        buildWebListener();
    }
    
    private void buildGUI() {
        board = new GameBoard();
        add(board);
    }
    
    private void buildKeyListeners() {
        keyListener = new GameKeyListener(board.holders);
        addKeyListener(keyListener);
    }
    
    private void buildMouseListeners() {
        mouseListener = new GameMouseListener(board.holders);
        addMouseListener(mouseListener);
    }
    
    private void buildWebListener() {
        webListener = new GameWebListener(board.holders);
        webListener.initServer();
    }
}
