package gallows;

import gallows.validator.LetterInputValidator;
import gallows.validator.Validator;
import java.util.ArrayList;

public class GameLauncher {

    public static final String LAUNCHER_RUN_COMMAND = "Y";
    public static final String LAUNCHER_QUIT_COMMAND = "N";

    private Reader reader;
    private Validator validator;
    private Game game;


    public GameLauncher(Reader reader, Validator validator) {
        this.reader = reader;
        this.validator = validator;
    }

    public void launch() {
        while (true) {
            System.out.println(String.format("Запустить игру? (%s/%s)", LAUNCHER_RUN_COMMAND, LAUNCHER_QUIT_COMMAND));
            String s = reader.readLine();
            if (validator.validate(s)) {
                if (s.equalsIgnoreCase(LAUNCHER_QUIT_COMMAND)) {
                    break;
                }
                Game game = new Game();
                initializeGame(game);
                game.play();
            } else {
                System.out.println("Некорректный ввод.");
            }
        }
    }

    public void initializeGame(Game game) {
        String word = Dictionary.getRandomWord();

        game.setWord(word);
        game.setMask(new Mask(word.length()));
        game.setGallowsImage(GallowsImage.getInstance());
        game.setEnteredLetters(new ArrayList<>());
        game.setGameInformer(GameInformer.getInstance());
        game.setValidator(new LetterInputValidator());
        game.setReader(reader);
    }
}