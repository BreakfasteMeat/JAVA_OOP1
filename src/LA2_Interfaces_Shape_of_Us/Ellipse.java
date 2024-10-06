package LA2_Interfaces_Shape_of_Us;
public class Ellipse extends Shape {
	double a, b;
	String color;
	public Ellipse(double a, double b, String color){
		super(color);
		this.a=a;
		this.b=b;

	}
	@Override
	public double area(){
		return 3.14159 * a * b;
	}
	@Override
	public double perimeter(){
		return 3.14159*(3*(a+b) - Math.sqrt((a + 3*b) *(b+3*a)));
	}
	@Override
	public String toString(){
		return super.toString() + " which is also an Ellipse";
	}

	public static class Circle extends Ellipse {
		public Circle(double radius, String color){
			super(radius,radius,color);
		}

		public String toString(){
			return super.toString() + " which is also a Circle";
		}
	}
}