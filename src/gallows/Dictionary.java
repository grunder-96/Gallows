package gallows;

import gallows.exception.DictionaryNotFoundException;
import gallows.exception.NoMoreWordsException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Dictionary {

	private static List<String> words;

	static {
		generateDictionary();
	}

	private Dictionary() {}

	private static void generateDictionary() {
		Path path = Path.of("resources", "dictionary.txt");
		if (!Files.exists(path)) {
			throw new DictionaryNotFoundException("Dictionary file not found. Program terminated.");
		}
		try (Stream<String> lines = Files.lines(path)) {
			words = lines
					.map(str -> str.replaceAll("[\\d]", ""))
					.map(String::trim)
					.filter(s -> s.length() > 5)
					.collect(toList());
		} catch (IOException e) {
            throw new RuntimeException(e);
        }
	}

	public static String getRandomWord() {
			if (words.isEmpty()) {
				throw new NoMoreWordsException("The dictionary is empty. Program terminated.");
			}
			int index = new Random().nextInt(words.size());
			String word = words.get(index);
			words.remove(index);
			return word;
	}
}
