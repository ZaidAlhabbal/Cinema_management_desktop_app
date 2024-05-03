
public class Book extends Ticketing implements Runnable{
    Book(int timeConverter, String seatNumber , String cinema,String Father,String Uname,String movie){
        super( timeConverter, seatNumber , cinema,Father,Uname,movie);
    }
    @Override
    public void run(){
        bookTicket(Main.timeConverter.get(ReservationScreen.TimeZ), String.valueOf(ReservationScreen.seats.getSelectedItem()),ReservationScreen.z[3],UserAccountScreen.getFatherUserName(),UserAccountScreen.getUserName(),movie);
    }

}
