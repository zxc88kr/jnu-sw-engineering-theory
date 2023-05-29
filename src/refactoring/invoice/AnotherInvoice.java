package refactoring.invoice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class AnotherInvoice {
	private String _name;
	private MyCollection _orders;

	private Printer _printer;
	private int count;

	public AnotherInvoice(String customer_name, MyCollection orders, Printer printer) {
		this._name = customer_name;
		this._orders = orders;

		this._printer = printer;
	}

	void printOwing() {
		Enumeration<Order> e = _orders.elements();
		double outstanding = 0.0;
		count = 0;

		// print banner
		printBanner();

		// calculate outstanding
		outstanding = calculateOutstanding(e, outstanding);

		// print details
		printDetails(outstanding);
	}

	private void printBanner() {
		_printer.print("*************************");
		_printer.print("***** Customer Owes *****");
		_printer.print("*************************");
	}
	
	private double calculateOutstanding(Enumeration<Order> e, double outstanding) {
		while (e.hasMoreElements()) {
			Order each = e.nextElement();
			outstanding += each.getAmount();
			count += 1;
		}
		return outstanding;
	}

	private void printDetails(double outstanding) {
		_printer.print("name: " + _name);
		_printer.print("amount: " + outstanding);
		_printer.print("count: " + count);
	}

	public static void main(String[] args) {
		ArrayList<Order> arrList = new ArrayList<Order>();
		arrList.add(new Order(4.5));
		arrList.add(new Order(1.3));
		arrList.add(new Order(9.7));

		AnotherInvoice invoice = new AnotherInvoice("Hong gil dong", new MyCollection(Collections.enumeration(arrList)),
				new Printer() {
					public void print(String msg) {
						System.out.println(msg);
					}
				});
		invoice.printOwing();
	}
}