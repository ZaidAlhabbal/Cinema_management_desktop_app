
public class Cancel implements Runnable{
    String ID;
    Ticketing p;
    static boolean ans=false;
    Cancel(Ticketing p,String ID){
        this.p=p;
        this.ID = ID;
    }
    @Override
    public void run(){

        synchronized (p){
          ans= p.CancelTicket(ID);
        }
    }
}