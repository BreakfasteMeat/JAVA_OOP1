package LA2_Interfaces_Shape_of_Us;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Shape shape = null;
		Scanner sc = new Scanner(System.in);
		String option;
		String color;
		List<Shape> shapes = new ArrayList<>();
		do {
			System.out.print("Enter shape: ");
			option = sc.nextLine();
			switch (option) {
				case "DONE":
					break;
				case "Rectangle":
					System.out.print("Enter length: ");
					double len = sc.nextDouble();
					System.out.print("Enter width: ");
					double wid = sc.nextDouble();
					// This nextLine is to rid the next line made by the previous scan
					// Do this in the future as well, before getting a String input
					sc.nextLine();
					System.out.print("Enter color: ");
					color = sc.nextLine();
					shape = new Rectangle(len, wid, color);
					shapes.add(shape);
					break;
				case "Square":
					System.out.print("Enter side: ");
					double side = sc.nextDouble();
					sc.nextLine();
					System.out.print("Enter color: ");
					color = sc.nextLine();
					shape = new Rectangle.Square(side,color);
					shapes.add(shape);
					break;
				case "Ellipse":
					System.out.print("Enter a: ");
					double a = sc.nextDouble();
					System.out.print("Enter b: ");
					double b = sc.nextDouble();

					System.out.print("Enter color: ");
					sc.nextLine();
					color = sc.nextLine();

					shape = new Ellipse(a,b,color);
					shapes.add(shape);
					break;
				case "Circle":
					System.out.print("Enter radius: ");
					double radius = sc.nextDouble();
					System.out.print("Enter color: ");
					sc.nextLine();
					color = sc.nextLine();
					shape = new Ellipse.Circle(radius,color);
					shapes.add(shape);
					break;
				case "Triangle":
					System.out.print("Enter base: ");
					double base = sc.nextDouble();

					System.out.print("Enter height: ");
					double height = sc.nextDouble();

					System.out.print("Enter a: ");
					double a2 = sc.nextDouble();

					System.out.print("Enter c: ");
					double c = sc.nextDouble();

					System.out.print("Enter color: ");
					sc.nextLine();
					color = sc.nextLine();

					shape = new Triangle(base,height,a2,c,color);
					shapes.add(shape);
					break;
				case "Equilateral Triangle":
					System.out.print("Enter side: ");
					double side2 = sc.nextDouble();

					System.out.print("Enter color: ");
					sc.nextLine();
					color = sc.nextLine();

					shape = new Triangle.EquilateralTriangle(side2,color);
					shapes.add(shape);
					break;


			}
		} while (!option.equals("DONE"));

		do {
			System.out.print("Sort by: ");
			option = sc.nextLine();
			switch (option) {
				case "DONE":
					break;
				case "Color":
					// TODO sort by color
					Collections.sort(shapes);
					for (Shape s : shapes) {
						System.out.print("Area of " + s + ": ");
						System.out.format("%.2f\n", s.area());
					}
					break;
				case "Area":
					// TODO sort by area
					shapes.sort(new Shape.compareArea());
					for (Shape s : shapes) {
						System.out.print("Area of " + s + ": ");
						System.out.format("%.2f\n", s.area());
					}
					break;
				case "Perimeter":
					// TODO sort by perimeter
					shapes.sort(new Shape.comparePerimeter());
					for (Shape s : shapes) {
						System.out.print("Perimeter of " + s + ": ");
						System.out.format("%.2f\n", s.perimeter());
					}
					break;
			}
		} while (!option.equals("DONE"));
	}
}
