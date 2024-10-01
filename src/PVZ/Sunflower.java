package PVZ;
public class Sunflower extends Plant implements sunProducer{
    public Sunflower() {
        super(50, DEFAULT_HP);
    }
    @Override
    public int generate_sun(){
        return 25;
    }
}
