package test;

public class chocolateBoiled {
private static chocolateBoiled c=null;
private boolean empty;
private boolean boiled;
chocolateBoiled() {
	empty=true;
	boiled=false;
}
public static chocolateBoiled getchocolate() {
	if(c==null) {
		c=new chocolateBoiled();
	}
	return c;
}
public void fill() {
	if(empty==true) {
		System.out.println("Filling");
		empty=false;
	}
	else {
		System.out.println("Filled");
	}
}
public void boil() {
	if(empty==false && boiled==false) {
		System.out.println("Boiling");
		boiled=true;
	}
	else if(empty==true) {
		System.out.println("Empty");
	}
	else if(empty==false && boiled==true)
		System.out.println("Already boiled");
}
public void drain() {
	if(empty==false && boiled==true) {
		System.out.println("Draining");
		empty=true;
		boiled=false;
	}
	else if(empty==true) {
		System.out.println("Empty");
	}
	else if(empty==false && boiled==false) {
		System.out.println("Boiling");
	}
}
public static void main(String args[]) {
	chocolateBoiled tst=getchocolate();
	tst.fill();
	tst.boil();
	tst.drain();
}
}
