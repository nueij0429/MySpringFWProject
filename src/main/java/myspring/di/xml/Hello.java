package myspring.di.xml;

import java.util.List;

public class Hello {
	String name;
	Printer printer;
	List<String> names;

	public Hello() {
		System.out.println("");
	}

	public Hello(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		System.out.println("setNames() 메서드 호출됨");
		this.names = list;
	}

	public void setName(String name) {
		System.out.println("setName() 메서드 호출됨" + name);
		this.name = name;
	}

	public void setPrinter(Printer printer) {
		System.out.println("setPrinter() 메서드 호출됨" + printer.getClass().getName());
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
