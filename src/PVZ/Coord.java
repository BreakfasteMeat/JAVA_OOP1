package PVZ;
public class Coord {
    int row;
    float col;

    public Coord(int row, float col) {
        this.row = row;
        this.col = col;
    }
    public void move(int row, float col){
        this.row += row;
        this.col += col;
    }
    @Override
    public String toString(){
        return "(" + row +","+col+")";
    }
}
