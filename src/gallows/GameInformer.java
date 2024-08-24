package gallows;

import java.util.List;

public class GameInformer {

    private static final GameInformer INSTANCE = new GameInformer();

    private GameInformer() {

    }

    public static GameInformer getInstance() {
        return INSTANCE;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void askLetter() {
        printMessage("Введите букву: ");
    }

    public void showAlreadyEnteredLetters(List<String> letters) {
        printMessage("Список использовавшихся букв: " + letters);
    }

    public void showIncorrectInputMessage() { printMessage("Некорректный ввод."); }

    public void showAlreadyUseMessage() {printMessage("Вы уже вводили эту букву."); }

    public void showNotContainInWordMessage() {printMessage("Такой буквы в слове нет.");}

    public void showGameWinMessage() { printMessage("Вы выиграли."); }

    public void showGameLoseMessage(String word) { printMessage("Вы проиграли. Загаданное слово - " + word); }

    public void showSeparatorLine() {
        printMessage("======================================");
    }
}
