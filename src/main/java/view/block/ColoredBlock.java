package view.block;

public class ColoredBlock extends ExtendableBlock{   
    
    private int number;

    public int getNumber() {
        return number;
    }
    
    public ColoredBlock (int number, int x, int y) {
        super("/assets/"+number+".png", x, y);
        setSize(this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
        this.number = number;
    }
}
