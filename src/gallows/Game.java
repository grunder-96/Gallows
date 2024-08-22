package gallows;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private GameUtils gameUtils = GameUtils.getInstance();

	private Dictionary dictionary;
	private String word;
	private Mask mask;
	private GallowsImage gallows;
	private List<String> enteredLetters;

	private int openLettersCounter;
	private int errorsCounter;
	private boolean isOver;
	private boolean isWin;

	private final int MAX_ERRORS = 6;

	public void launch() {
		try {
			String answer = gameUtils.askLaunchGame();
			if (answer.equalsIgnoreCase("y")) {
				initialize();
			} else if (answer.equalsIgnoreCase("n")) {
				System.out.println("Завершение программы.");
			} else {
				gameUtils.showIncorrectValueMessage();
				launch();
			}
		} catch (IndexOutOfBoundsException e) {
			gameUtils.showEmptyInputMessage();
			launch();
		}
	}

	private void initialize() {
		dictionary = Dictionary.getInstance();
		word = dictionary.getRandomWord();
		mask = new Mask(word);
		gallows = GallowsImage.getInstance();
		enteredLetters = new ArrayList<>();

		// Сброс полей состояния игры
		isOver = false;
		openLettersCounter = 0;
		errorsCounter = 0;

		mask.showMask();
		play();
	}

	private void play() {
		try {
			String letter = gameUtils.askLetter();

			// Вывод сообщения о букве, которая была введена ранее
			while(enteredLetters.contains(letter)) {
				gameUtils.showAlreadyUseMessage();
				letter = gameUtils.askLetter();
			}

			if (word.contains(letter)) {
				openLettersCounter += mask.updateMask(letter);
			}

			if (!word.contains(letter)) {
				errorsCounter++;
			}

			enteredLetters.add(letter);

			mask.showMask();
			showErrorsCounter();
			showEnteredLetters();
			gallows.drawGallows(errorsCounter);
			gameUtils.showSeparatorLine();

			isOver = checkIsOver();

			if (isOver) {
				if (isWin) {
					gameUtils.showGameWinMessage();
				} else {
					gameUtils.showGameLoseMessage(word);
				}
				launch();
			} else {
				play();
			}
		} catch (IndexOutOfBoundsException e) {
			gameUtils.showEmptyInputMessage();
			play();
		}
	}

	private void showErrorsCounter() {
		System.out.println("Ошибок: " + errorsCounter);
	}

	private void showEnteredLetters() {
		System.out.println("Введенные буквы: " + enteredLetters);
	}

	private boolean checkIsOver() {
		if (errorsCounter == MAX_ERRORS) {
			isWin = false;
			return true;
		}

		if (openLettersCounter == word.length()) {
			isWin = true;
			return true;
		}

		return false;
	}
}
