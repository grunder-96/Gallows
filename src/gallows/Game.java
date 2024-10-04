package gallows;

import gallows.validator.LetterInputValidator;
import gallows.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private HiddenWord hiddenWord;
	private GallowsImage gallowsImage;
	private List<String> enteredLetters;
	private GameInformer gameInformer;
	private Reader reader;
	private Validator validator;

	private int errorsCounter;

	private static final int MAX_ERRORS = 6;

	public Game(HiddenWord hiddenWord) {
		this.hiddenWord = hiddenWord;
		this.gallowsImage = GallowsImage.getInstance();
		this.enteredLetters = new ArrayList<>();
		this.gameInformer = GameInformer.getInstance();
		this.reader = new Reader();
		this.validator = new LetterInputValidator();
	}

	public void play() {
		while (!getIsOverState()) {
			showCurrentGameState();
			processUserInput(getUserInput());
		}
		showGameResult();
	}

	 private void showCurrentGameState() {
		 gameInformer.showSeparatorLine();
		 gallowsImage.drawGallows(errorsCounter);
		 gameInformer.printMessage(hiddenWord.getMask());
		 gameInformer.showAlreadyEnteredLetters(enteredLetters);
	 }

	 private String getUserInput() {
		 gameInformer.askLetter();
		 return reader.readLine().toLowerCase();
	 }

	 private void processUserInput(String input) {
		 if (!validator.validate(input)) {
			 gameInformer.showIncorrectInputMessage();
			 return;
		 }

		 if (enteredLetters.contains(input)) {
			 gameInformer.showAlreadyUseMessage();
			 return;
		 }

		 enteredLetters.add(input);

		 if (hiddenWord.isLetterContains(input.charAt(0))) {
			 hiddenWord.openLetter(input.charAt(0));
		 } else {
			 gameInformer.showNotContainInWordMessage();
			 errorsCounter++;
		 }
	 }

	private void showGameResult() {
		showCurrentGameState();
		if (getIsWinState()) {
			gameInformer.showGameWinMessage();
		} else {
			gameInformer.showGameLoseMessage(hiddenWord.getWord());
		}
	}

	private boolean getIsOverState() {
		return hiddenWord.isWordGuessed() || errorsCounter >= MAX_ERRORS;
	}

	private boolean getIsWinState() {
		return hiddenWord.isWordGuessed();
	}
}