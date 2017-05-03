package assign5;
/*
public class Printer extends Thread {
private Storage a;
public void run() {
	
	super.run();
	System.out.println(a.getNum());
	
}
}
*/
class Printer implements Runnable{
    Storage st;
    public Printer(Storage st){
          this.st = st;
    }
    @Override
    public void run() {
          synchronized(st) {
                for(int i = 0; i < 10; i++) {
                      while(st.isPrinted()) {              //loop to take care of spontaneous wake-ups
                            try {
                                  st.wait();
                            } catch(Exception e) {  }
                      }
                      System.out.println(Thread.currentThread().getName() + " " + st.getValue());
                      st.setPrinted(true);
                      st.notify();
                }
          }
    }
     
}