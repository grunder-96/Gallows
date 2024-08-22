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

	private static final Dictionary INSTANCE = new Dictionary();
	private static List<String> words;

	static {
		generateDictionary();
	}

	private Dictionary() {}

	public static Dictionary getInstance() {
		return INSTANCE;
	}

	private static void generateDictionary() {
		Path path = Path.of("resources", "dictionary.txt");
		if (!Files.exists(path)) {
			throw new DictionaryNotFoundException("Файл словаря не найден. Завершение программы.");

		}
		try (Stream<String> lines = Files.lines(path)) {
			words = lines
					.map(str -> str.replaceAll("[\\d\\s]", ""))
					.filter(s -> s.length() > 5)
					.collect(toList());
		} catch (IOException e) {
            throw new RuntimeException(e);
        }
	}

	public String getRandomWord() {
			if (words.isEmpty()) {
				throw new NoMoreWordsException("Словарь пуст. Завершение программы.");
			}
			int index = new Random().nextInt(words.size());
			String word = words.get(index);
			words.remove(index);
			return word;
	}
}
