package view.block;

public class ColoredBlock extends ExtendableBlock{   
    private int number;

    public int getNumber() {
        return number;
    }
    
    public ColoredBlock (int number, int x, int y) {
        super("/assets/"+number+".png", x, y);
        setSize(65, 65);
        this.number = number;       
    }
}
