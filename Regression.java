public class LinearRegression {

	private double m;
	private double c;

	public LinearRegression() {
		m = Math.random();
		c = Math.random();
	}

	public double predict(double x) {
		return m * x + c;
	}

	public void train(Data[] dataset, int epochs, double eta) {
		for (int i = 0; i < epochs; i++) {
			double dc_dm, dc_dc, dc_dz;
			double dz_dm, dz_dc;
			dc_dz = 2 * (z - y);
			dc_dm = dc_dz * dz_dm;
			dc_dc = dc_dz * dz_dc;
			m = m - eta * dc_dm;
			c = c - eta * dc_dc;
		}
	}
}
