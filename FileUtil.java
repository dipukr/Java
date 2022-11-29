import java.io.*;
import java.nio.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;
import java.util.function.*;

public class FileUtil {

	public static void listFiles(File dir, List<String> all) throws Exception {
		File[] files = dir.listFiles();
		for (File file: files) {
			if (file.getName().equals("$RECYCLE.BIN") ||
				file.getName().equals("System Volume Information")) continue;
			if (file.isDirectory())
				listFiles(file, all);
			else all.add(file.getName());
		}
	}

	public static void listDir() throws Exception {
		String root = "D:/Code";
		long fileCount = Files.walk(Path.of(root)).filter(Files::isRegularFile).count();
		long folderCount = Files.walk(Path.of(root)).count() - fileCount;
		System.out.printf("%d files\n", fileCount);
		System.out.printf("%d folders", folderCount);
	}

	public static void replaceAll(String file) throws Exception {
		List<String> lines = Files.lines(Path.of(file))
			.map(s -> s.replaceAll("    ", "\t"))
			.collect(Collectors.toList());
		StringBuilder data = new StringBuilder();
		lines.forEach(s -> data.append(s).append('\n'));
		Files.write(Paths.get(file), data.toString().getBytes());
	}

	public static List<Path> findAll(Path root) throws Exception {
		return Files.list(root)
				.map(Path::toAbsolutePath)
				.collect(Collectors.toList());
	}
}