package designPatterns;

public class MainClass {

	public static void main(String[] args) {
		Singleton.getInstance().Calculate(2, 3);
		StaticSingleton.getInstance().Calculate(2, 6);
	}

}
