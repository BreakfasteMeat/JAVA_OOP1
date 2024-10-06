package LA2_Interfaces_Shape_of_Us;
import java.util.Comparator;
public abstract class Shape implements Comparable<Shape>{
	String color;
	public Shape(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "A shape that is color " + color;
	}

	public abstract double area();
	public abstract double perimeter();

	@Override
	public  int compareTo(Shape o){
		int comp = this.color.compareTo(o.color);
		if(comp == 0){
			Double o1 = this.area();
			Double o2 = o.area();
			comp = Double.compare(o2,o1);
		}
		return comp;
	}
	public static class compareArea implements Comparator<Shape>{
		@Override
		public int compare(Shape s1, Shape s2){
			int comp = Double.compare(s2.area(),s1.area());

			return comp;
		}
	}
	public static class comparePerimeter implements Comparator<Shape>{
		@Override
		public int compare(Shape s1, Shape s2){
			int comp = Double.compare(s2.perimeter(),s1.perimeter());

			return comp;
		}
	}
}
