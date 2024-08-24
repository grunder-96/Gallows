package gallows.validator;

import gallows.GameLauncher;

public class LauncherSelectionValidator implements Validator<String> {

    @Override
    public boolean validate(String input) {
        return input.toUpperCase().matches(String.format("(%s|%s)",
                GameLauncher.LAUNCHER_RUN_COMMAND, GameLauncher.LAUNCHER_QUIT_COMMAND));
    }
}
