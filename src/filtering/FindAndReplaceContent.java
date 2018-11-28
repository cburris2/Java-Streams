/**
 *
 */
package filtering;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author cburr
 *
 */
public class FindAndReplaceContent {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// find content within the given file and replace its content
		final Path path = Paths.get("/home/logfile");
		final String ext = ".json";
		final String old = "";
		final String newText = "";
		findAndReplace(path, ext, old, newText);

	}

	private static void findAndReplace(Path path, String ext, String old, String newText) throws IOException {

		try {
			Files.list(path)
			.filter(f -> f.endsWith(ext))
			.map(Path::getFileName)
			.forEach(file -> {
				try {
					file.resolve(path);
					String content = new String(Files.readAllBytes(file));
					content = content.replaceAll(old, newText);
					Files.write(file, content.getBytes());
				} catch (final IOException e) {
					throw new RuntimeException(e);
				}

			});
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}

	}

}
