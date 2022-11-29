public class Point {
	
	public double x;
	public double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double distance(Point that) {
		double dx = Math.pow(that.x - this.x, 2);
		double dy = Math.pow(that.y - this.y, 2);
		return Math.sqrt(dx + dy);
	}
}