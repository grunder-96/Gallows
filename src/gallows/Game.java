package gallows;

import gallows.validator.Validator;
import java.util.Arrays;
import java.util.List;

public class Game {

	private String word;
	private Mask mask;
	private GallowsImage gallowsImage;
	private List<String> enteredLetters;
	private GameInformer gameInformer;
	private Reader reader;
	private Validator validator;

	private int openLettersCounter;
	private int errorsCounter;
	private boolean isOver;
	private boolean isWin;

	private static final int MAX_ERRORS = 6;

	public void play() {
		while (!isOver) {
			gameInformer.showSeparatorLine();
			gallowsImage.drawGallows(errorsCounter);
			gameInformer.printMessage(Arrays.toString(mask.getView()));
			gameInformer.showAlreadyEnteredLetters(enteredLetters);
			gameInformer.askLetter();
			String input = reader.readLine().toLowerCase();

			if (!validator.validate(input)) {
				gameInformer.showIncorrectInputMessage();
				continue;
			}

			if (enteredLetters.contains(input)) {
				gameInformer.showAlreadyUseMessage();
				continue;
			}

			enteredLetters.add(input);

			if (word.contains(input)) {
				int index = word.indexOf(input);
				while (index != -1) {
					openLettersCounter++;
					mask.updateMask(index, word.charAt(index));
					index = word.indexOf(input, index + 1);
				}
			} else {
				gameInformer.showNotContainInWordMessage();
				errorsCounter++;
			}

			updateIsOverState();
		}

		updateIsWinState();

		if (isWin) {
			gameInformer.showGameWinMessage();
		} else {
			gallowsImage.drawGallows(errorsCounter);
			gameInformer.showGameLoseMessage(word);
		}
	}

	private void updateIsOverState() {
		if (openLettersCounter >= word.length() || errorsCounter >= MAX_ERRORS) {
			isOver = true;
		}
	}

	private void updateIsWinState() {
		isWin = openLettersCounter == word.length();
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void setMask(Mask mask) {
		this.mask = mask;
	}

	public void setGallowsImage(GallowsImage gallowsImage) {
		this.gallowsImage = gallowsImage;
	}

	public void setEnteredLetters(List<String> enteredLetters) {
		this.enteredLetters = enteredLetters;
	}

	public void setGameInformer(GameInformer gameInformer) {
		this.gameInformer = gameInformer;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
}