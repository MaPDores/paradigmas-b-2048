package view.utils;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 * @author marcelo
 * 
 * Classe que se responsabiliza da criação de imagens.
 * (Factory design pattern)
 */
public class ImageFactory {
    public ImageIcon createImageIcon(String source) {
        Image img = null;
        try {
            img = ImageIO.read(getClass().getResource(source));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon(img);
    }
    
    public Image createImage(String source) {
        Image img = null;
        try {
         img = ImageIO.read(getClass().getResource(source));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
