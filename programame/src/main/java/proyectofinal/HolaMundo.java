package proyectofinal;

public class HolaMundo {

	public static void main(String[] args) {
//		Harvester harvest = new Harvester();
//		CallBack call = new CallBack() {
//
//			public void doWork() {
//				System.out.println("clase anonima");
//				System.out.println(getClass().getName());
//			}
//
//		};
//		harvest.collect(call);

	
//		Abstracta abstracta = new Abstracta() {
//			@Override
//			public void doWork() {
//				new CallBack() {
//
//					public void doWork() {
//						System.out.println("haciendo el trabajo");
//						System.out.println(getClass().getName());
//					}
//				}.doWork();
//				System.out.println("Codigo plus");
//
//			}
//
//		};
//		harvest.collect(abstracta);
//
//		harvest.collect(new Hijo());
	Hijo hijo = new Hijo();
		hijo.doWork("hola", "chicos", "puedo", "pasar", "tantos", "parametros", "como", "me de", "la gana");
	
	
	
	}

	private static void funcion1(Object object) {
		// TODO Auto-generated method stub

	}

	private static void funcion2() {
		// TODO Auto-generated method stub

	}

}
