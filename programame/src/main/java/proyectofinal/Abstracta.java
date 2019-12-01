package proyectofinal;

public abstract class Abstracta implements CallBack {

	public void doWork(String... strings) {
		for (String string : strings) {
			System.out.println(string);
		}

		System.out.println("clase abstracta");
		System.out.println(getClass().getName());

	}

}
