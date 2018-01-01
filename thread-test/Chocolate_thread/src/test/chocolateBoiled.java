package test;

public class chocolateBoiled implements Runnable{
private static chocolateBoiled c=null;
private boolean empty;
private boolean boiled;
private static Thread [] jobs = new Thread[3];
private int threadID;
chocolateBoiled() {
	empty=true;
	boiled=false;
}
public chocolateBoiled(chocolateBoiled c,int i){
	this.c=c;
	this.threadID=i;
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
public void run() {
	System.out.println("Thread " + this.threadID+"started.");
	try {
		c.fill();
		c.boil();
		c.drain();
	} catch (Exception ie) {
		ie.printStackTrace();
	}
	System.out.println("Thread " + this.threadID+"ended.");
}
public static void main(String args[]) {
	chocolateBoiled tst=null;
	try {
		for(int i=0; i<jobs.length; i++) {
		jobs[i] = new Thread(new chocolateBoiled(tst.getchocolate(),i+1));
		jobs[i].start();
		jobs[i].join();
		}
	} catch(InterruptedException e) { System.out.println(e); }
}
}
