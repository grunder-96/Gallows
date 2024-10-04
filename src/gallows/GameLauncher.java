package gallows;

import gallows.validator.ExpectedValueValidator;
import gallows.validator.Validator;

public class GameLauncher {

    public static final String LAUNCHER_RUN_COMMAND = "Y";
    public static final String LAUNCHER_QUIT_COMMAND = "N";

    private Reader reader;
    private Validator validator;

    public GameLauncher() {
        this.reader = new Reader();
        this.validator = new ExpectedValueValidator(LAUNCHER_RUN_COMMAND, LAUNCHER_QUIT_COMMAND);
    }

    public GameLauncher(Reader reader, Validator validator) {
        this.reader = reader;
        this.validator = validator;
    }

    public void launch() {
        while (true) {
            System.out.printf("Запустить игру? (%s/%s)\n", LAUNCHER_RUN_COMMAND, LAUNCHER_QUIT_COMMAND);
            String s = reader.readLine();

            if (validator.validate(s)) {
                if (s.equalsIgnoreCase(LAUNCHER_QUIT_COMMAND)) {
                    break;
                }

                Game game = initializeGame();
                game.play();
                continue;
            }
            System.out.println("Некорректный ввод.");
        }
    }

    private Game initializeGame() {
        String word = Dictionary.getRandomWord();
        return new Game(new HiddenWord(word));
    }
}