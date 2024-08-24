package gallows;

import java.util.List;

public class GallowsImage {

	private static final List<String> FRAMES;
	private static final GallowsImage INSTANCE = new GallowsImage();

	private GallowsImage() {}

	public static GallowsImage getInstance() {
		return INSTANCE;
	}

	static {
		FRAMES = List.of(
				"""
				____
				|/  |
				|
				|
				|
				|
				|
				""",
				"""
				____
				|/  |
				|   0
				|
				|
				|
				|
				""",
				"""
				____
				|/  |
				|   0
				|   |
				|
				|
				|
				""",
				"""
				____
				|/  |
				|   0
				|   |/
				|
				|
				|
				""",
				"""
				____
				|/  |
				|   0
				|  \\|/
				|
				|
				|
				""",
				"""
				____
				|/  |
				|   0
				|  \\|/
				|   |
				|
				|
				""",
				"""
				____
				|/  |
				|   0
				|  \\|/
				|   |
				|  //
				|
				"""
		);
	}

	public void drawGallows(int errors) {
		System.out.println(FRAMES.get(errors));
	}
}
