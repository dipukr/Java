import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Loader {
	public static void main(final String[] args) throws Exception {
		var url = new URL("https://www.sfml-dev.org/index.php");
		var file = url.getFile().substring(1);
		var in = new BufferedInputStream(url.openStream());
		var out = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		while (true) {
			int count = in.read(buffer, 0, 1024);
			if (count == -1) break;
			out.write(buffer, 0, count);
		}
		System.out.println("done");
	}
}