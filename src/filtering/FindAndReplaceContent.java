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
		final Path path = Paths.get("C:/Users/shock/git/Java-Streams/src/filtering/"); // specify the path to the directory where the json files are located
		final String ext = ".json";
		final String old = "path";
		final String newText = "absolute_path";
		findAndReplace(path, ext, old, newText);

	}

	private static void findAndReplace(Path path, String ext, String old, String newText) throws IOException {

		try {
			System.out.println("Searching for files with extension: " + ext + " in path: " + path);
			System.out.println(Files.list(path).count() + " files found.");
			Files.list(path)
			.filter(f -> f.toString().endsWith(ext))
			.map(Path::getFileName)
			.forEach(file -> {
				try {

					String content = new String(Files.readAllBytes(path.resolve(file)));
					content = content.replaceAll(old, newText);
					Files.write(path.resolve(file), content.getBytes());
					System.out.println("Replaced content in file: " + file);
					System.out.println("Old content: " + old);
					System.out.println("New content: " + newText);
				} catch (final IOException e) {
					throw new RuntimeException(e);
				}

			});
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}

	}

}
