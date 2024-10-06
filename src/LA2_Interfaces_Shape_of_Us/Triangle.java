package LA2_Interfaces_Shape_of_Us;

public class Triangle extends Shape {
	double base, height,a,c;
	public Triangle(double base, double height, double a, double c, String color){
		super(color);
		this.base = base;
		this.height = height;
		this.a = a;
		this.c = c;

	}
	public double area(){
		return 0.5 * base * height;
	}
	public double perimeter(){
		return a + base + c;
	}
	@Override
	public String toString(){
		return super.toString() + " which is also a Triangle";
	}

	public static class EquilateralTriangle extends Triangle {
		public EquilateralTriangle(double side, String color){
			super(side,(Math.sqrt(3)/2)*side,side,side,color);

		}
		@Override
		public String toString(){
			return super.toString() + " which is also an Equilateral Triangle";
		}
	}
}