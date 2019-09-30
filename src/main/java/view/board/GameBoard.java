package view.board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import view.block.BlockHolder;

import view.utils.ImageFactory;

/**
 *
 * @author marcelo
 * 
 * Classe tabuleiro do jogo, onde os blocos são 'colados'.
 */
public class GameBoard extends JPanel {
    
    Image img;
    ImageFactory imgFactory = new ImageFactory();
    BlockHolder[][] holders = new BlockHolder[4][4];
    
    public GameBoard () {
        super();
        initUI();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    public void initUI() {
        // Instancia a imagem de fundo
        img = imgFactory.createImage("/assets/FundoPronto_.png");

        // Seta tamanhos e layout
        setPreferredSize(new Dimension(img.getWidth(this), img.getHeight(this)));
        setSize(getPreferredSize());
        setLayout(null);
        
        // Seta os Holders em suas respectivas coordenadas
        for(int k = 9, i = 0; i < 4; k+=72, i++) {
            for(int l = 9, j = 0; j < 4; l+=72, j++) {
                holders[i][j] = new BlockHolder(l, k);
                add(holders[i][j]);
                //add(holders[i][j].createBlock(512));
            }
        }
        //remove(holders[3][2].removeBlock());
    }
}
