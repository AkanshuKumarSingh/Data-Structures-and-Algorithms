package Graph;

abstract class vehicle{
	int price = 1000000;

	
	vehicle(){
		System.out.println("vehicle created");
	}
	
	abstract void run();
	void move() {
		System.out.println("Vehicle is moving");
	}
	
	static void honk() {
		System.out.println("...honk");
	}
	
	final void fillPetrol() {
		// this is a final method can't be overridden
		System.out.println("filling");
	}
}

public class bike extends vehicle {
	int price = 10000;
	String model = "Honda";
	
	@Override
	void run() {
	// need to implement abstract method else it will show error
		System.out.println("bike is running");
	}
	
	void move() {
		// we can either implement it or not no problem if not implemented vehicle move is gonna execute
		System.out.println("bike is moving");
	}
	
	static void honk() {
		// we can either implement it or not no problem if not implemented vehicle honk is gonna execute
		System.out.println("...Bike honk");
	}
	
	
	
	public static void main(String args[]) {
	
		vehicle v = new bike();
		v.move();
		v.run();
		System.out.println(v.price);
		// vehicle doesn't containes model so gives error but if reference is bike type then error goes
		// System.out.println(v.model);		
		honk();
		v.fillPetrol();
	}
	
}
