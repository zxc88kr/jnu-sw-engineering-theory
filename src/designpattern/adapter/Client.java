package designpattern.adapter;

public class Client {
	public static void request(ClassA[] arr) {
		for (ClassA elem : arr) {
			elem.request();
		}
	}
}