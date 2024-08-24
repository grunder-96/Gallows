package gallows;

import java.util.stream.IntStream;

public class Mask {

	private static final char PLACEHOLDER = '*';
	
	private final char[] view;

	public Mask(int length) {
		view = new char[length];
		IntStream.range(0, length).forEach(i -> view[i] = PLACEHOLDER);
	}

	public void updateMask(int index, char letter) {
		view[index] = letter;
	}

	public char[] getView() {
		return view;
	}
}

