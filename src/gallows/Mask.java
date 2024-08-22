package gallows;

public class Mask {
	
	private String word;
	private char[] mask;
	
	public Mask(String word) {
		this.word = word;
		this.mask = word.replaceAll("\\D", "*").toCharArray();
	}
	
	public void showMask() {
		System.out.println(mask);
	}

	public int updateMask(String letter) {
		int openLettersNumber = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.toUpperCase().charAt(i) == letter.toUpperCase().charAt(0)) {
				mask[i] = letter.charAt(0);
				openLettersNumber++;
			}
		}
		return openLettersNumber;
	}
}
