package gallows;

import gallows.validator.LauncherSelectionValidator;
import gallows.validator.Validator;

public class Main {

    public static void main(String[] args) {
        Reader reader = new Reader();
        Validator validator = new LauncherSelectionValidator();
        GameLauncher launcher = new GameLauncher(reader, validator);
        launcher.launch();
    }
}
