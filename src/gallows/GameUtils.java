package gallows;

import java.util.Scanner;

public class GameUtils {

    private static final GameUtils INSTANCE = new GameUtils();
    private final Scanner scanner = new Scanner(System.in);

    private GameUtils() {

    }

    public static GameUtils getInstance() {
        return INSTANCE;
    }

    private String readLetter() throws IndexOutOfBoundsException {
        return scanner.nextLine().substring(0, 1);
    }

    public String askLaunchGame() {
        System.out.println("Запустить игру? (Y/N)");
        return readLetter();
    }

    public String askLetter() {
        System.out.println("Введите букву: ");
        return readLetter();
    }

    public void showAlreadyUseMessage() {
        System.out.println("Вы уже вводили эту букву.");
    }

    public void showEmptyInputMessage() {
        System.out.println("Вы ничего не ввели.");
    }

    public void showIncorrectValueMessage() { System.out.println("Вы ввели некорректное значение."); }

    public void showGameWinMessage() { System.out.println("Вы выиграли."); }

    public void showGameLoseMessage(String word) { System.out.println("Вы проиграли. Загаданное слово - " + word); }

    public void showSeparatorLine() {
        System.out.println("======================================");
    }
}
