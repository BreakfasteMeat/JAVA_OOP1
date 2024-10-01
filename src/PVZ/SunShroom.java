package PVZ;
public class SunShroom extends Mushroom implements sunProducer{
    Size size;
    public SunShroom(int sun_cost, int hp) {
        super(25, DEFAULT_HP);
        this.size = Size.SMALL;
    }

    @Override
    public int generate_sun(){
        if(size == Size.SMALL){
            return 15;
        } else {
            return 25;
        }
    }
    public void grow(){
        size = Size.LARGE;
    }
    enum Size{
        SMALL,LARGE;
    }

}
