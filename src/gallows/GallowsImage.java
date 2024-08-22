package gallows;

public class GallowsImage {

	private static final GallowsImage INSTANCE = new GallowsImage();

	private GallowsImage() {}

	public static GallowsImage getInstance() {
		return INSTANCE;
	}

	public void drawGallows(int errors) {
		switch (errors) {
			case 0 -> {}
			case 1 -> {
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
			}
			case 2 -> {
				System.out.println("_____");
				System.out.println("|/   |");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
			}
			case 3 -> {
				System.out.println("_____");
				System.out.println("|/   |");
				System.out.println("|    0");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
			}
			case 4 -> {
				System.out.println("_____");
				System.out.println("|/   |");
				System.out.println("|    0");
				System.out.println("|   \\|/");
				System.out.println("|");
				System.out.println("|");
				System.out.println("|");
			}
			case 5 -> {
				System.out.println("_____");
				System.out.println("|/   |");
				System.out.println("|    0");
				System.out.println("|   \\|/");
				System.out.println("|    |");
				System.out.println("|");
				System.out.println("|");
			}
			case 6 -> {
				System.out.println("_____");
				System.out.println("|/   |");
				System.out.println("|    0");
				System.out.println("|   \\|/");
				System.out.println("|    |");
				System.out.println("|   //");
				System.out.println("|");
			}
		}
	}
}