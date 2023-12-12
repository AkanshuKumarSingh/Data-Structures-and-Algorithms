package Graph;

interface phone {
	int price = 100000;

	void takePhoto();

	default void shootVideo() {
		System.out.println("Shooting");
	}

	static void playSongs() {
		System.out.println("Songs");
	}
}

interface phone1 {
	int price = 99999;

	void takePhoto();

	default void shootVideo() {
		System.out.println("Shooting1");
	}

	static void playSongs() {
		System.out.println("Songs1");
	}
	
}



public class iphone implements phone, phone1 {
	int price = 100;

	@Override
	public void takePhoto() {
		// this need to be implemented as it was just a abstract method
		System.out.println("Take photo");
	}
	
//	public void shootVideo() {
//		// we can override default method else default method will get executed.
//		System.out.println("Shooting Video");
//	}

	@Override
	public void shootVideo() {
		// TODO Auto-generated method stub
//		System.out.println("shoot---");
		phone1.super.shootVideo();
	}

	static void playSongs() {
		// we can override static method else default method will get executed.
		System.out.println("Playing Songs");
	}
	
	public static void main(String[] args) {
		phone p = new iphone();
		p.takePhoto();
		p.shootVideo();
		p.takePhoto();
		// static methods don't get inherited
		playSongs();
		// if iphone has phone reference type then there must be price in phone price in iphone will
		// will not get detected ya if you make p to iphone type then there must be price in
		// iphone
		System.out.println(p.price);
	}

}
