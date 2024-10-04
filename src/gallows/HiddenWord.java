package gallows;

import java.util.stream.IntStream;

public class HiddenWord {

    private static final char PLACEHOLDER = '*';

    private final String word;
    private final char[] mask;

    public HiddenWord(String word) {
        this.word = word;
        this.mask = new char[word.length()];
        generateMask();
    }

    public boolean isLetterContains(char letter) {
        return isLetterContains(letter, word.toCharArray());
    }

    private boolean isLetterContains(char letter, char[] array) {
        for (char e : array) {
            if (Character.toLowerCase(e) == Character.toLowerCase(letter)) {
                return true;
            }
        }
        return false;
    }

    public boolean isWordGuessed() {
        return !isLetterContains(PLACEHOLDER, mask);
    }

    public int openLetter(char letter) {
        if (!isLetterContains(letter) || isLetterContains(letter, mask)) {
            return 0;
        }
        int counter = 0;
        int index = word.indexOf(letter);
        while (index != -1) {
          counter++;
          mask[index] = word.toCharArray()[index];
          index = word.indexOf(letter, index + 1);
        }
        return counter;
    }

    private void generateMask() {
        IntStream.range(0, mask.length)
                .forEach(i -> mask[i] = PLACEHOLDER);
    }

    public String getMask() {
        return String.valueOf(mask);
    }

    public String getWord() {
        return word;
    }
}