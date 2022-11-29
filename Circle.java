public class Circle {

	public Point center;
	public double radius;

	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(double x, double y, double radius) {
		this.center = new Point(x, y);
		this.radius = radius;
	}

	public boolean contains(Point p) {
		return center.distance(p) < radius;
	}
}