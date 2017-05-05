package ThreadDemo;

public class TicketDemo extends Thread {
static int k=100;//
public static void main(String[] args){
	
	System.out.println("The origanl tickets are 100");
	TicketDemo t=new TicketDemo();
	Thread t1=new  Thread(t);
	Thread t2=new  Thread(t);
	Thread t3=new  Thread(t);
	Thread t4=new  Thread(t);
	Thread t5=new  Thread(t);

    t1.setName("station-1");

    t2.setName("station-2");

    t3.setName("station-3");

    t4.setName("station-4");

    t5.setName("station-5");
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	t5.start();
	while(t1.isAlive()||t2.isAlive()||t3.isAlive()||t4.isAlive()||t5.isAlive());
	 System.out.println("The test is end.");}


public void run() {
	for(k=100;k>0;k--){
			show();}
	}

private synchronized void show(){
	if(k>0){
	    String name =Thread.currentThread().getName();
		System.out.println("The station  "+name+"--have sold the number  "+k+"  ticket");
		try { 
			Thread.sleep(((int)(Math.random()*10)));
            } catch (InterruptedException e) { 
            	e.printStackTrace(); } }
	
}
}