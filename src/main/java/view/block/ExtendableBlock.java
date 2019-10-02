package view.block;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import view.utils.ImageFactory;
/**
 *
 * @author marcelo
 * 
 * Classe com campos básicos de um Block (Colored Block e Block Holder).
 */
public abstract class ExtendableBlock extends JLabel{

    private final ImageFactory imgFactory = new ImageFactory();
    
    public ExtendableBlock (int x, int y) {
        super();
        this.setLocation(x, y);
    }
    
    public ExtendableBlock (String imageSource, int x, int y) {
        super();
        this.setIcon(imgFactory.createImageIcon(imageSource));
        this.setLocation(x, y);
        this.setHorizontalAlignment(JLabel.CENTER);
       //System.out.print(this.getHorizontalAlignment()+"\n");
       //System.out.print(this.getVerticalAlignment()+"\n");
       //System.out.print(this.getAlignmentX()+"\n");
       //System.out.print(this.getAlignmentY()+"\n\n");
    }
}
