import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ticketing {
    int timeConverter;
    User user;
    int seatNumber;
    int cinema;
    String Father,Uname,movie;
    Ticketing(int timeConverter, String seatNumber , String cinema,String Father,String Uname,String movie){
        this.timeConverter = timeConverter;
        this.seatNumber= Integer.parseInt(seatNumber);
        this.cinema = Integer.parseInt(cinema);
        this.Father=Father;
        this.Uname=Uname;
        this.movie=movie;
    }
    Ticketing(){}

     public  static boolean bookTicket(int timeConverter, String seatNumber , String cinema,String Father,String Uname,String movie)
    {
        int realTime = timeConverter;
        int cinemaId = Integer.parseInt(cinema);
            Main.bookedTickets[cinemaId][realTime][Integer.parseInt(seatNumber)]= true;
            Ticket bookedTicket = new Ticket(Integer.parseInt(seatNumber), realTime, cinemaId,movie);
            User.addReservation(cinemaId+";"+realTime+";"+seatNumber+";"+movie+"\n",Uname,Father);
            return true;
    }
    public synchronized boolean CancelTicket(String ID){
       synchronized (this){
            ArrayList<String[]> s = new ArrayList<>();
            FileDeal fileDeal = new FileDeal();
            try {
                s = fileDeal.readStr(Main.path + "\\bookTicket.txt");
            } catch (FileNotFoundException e) {
                System.out.println(e.toString());
            }
            int x = 0;
            String zz = "";
            for (String[] i : s) {
                zz = "";
                zz += i[0];
                zz += i[1];
                zz += i[2];
                if (zz.equals(ID)) {
                    s.remove(i);
                    x++;
                    Main.bookedTickets[Integer.parseInt(i[0])][Integer.parseInt(i[1])][Integer.parseInt(i[2])] = false;
                    File ff = new File(Main.path + "\\bookTicket.txt");
                    FileWriter fww;
                    try {
                        fww = new FileWriter(ff);
                        for (String[] d : s) {
                            String line = "";
                            for (int r = 0; r < d.length; r++)
                                line += d[r] + ";";
                            fww.write(" " + line + "\n");
                        }
                        fww.flush();
                        fww.close();
                        cancelTicketUser(ID, UserAccountScreen.getUserName(), UserAccountScreen.getFatherUserName());
                        return true;
                    } catch (IOException ex) {
                        System.out.println(ex.toString());
                    }
                }
            }
        }
        return false;
    }
    public  synchronized void cancelTicketUser(String ID,String name ,String fathername) throws IOException {
        ArrayList<String[]> s;
        FileDeal fileDeal = new FileDeal();
        s = fileDeal.readStr(Main.path +"\\" + (name + fathername) +"\\UserTickets.txt");
        String zz = "";
        for (String[] i : s) {
            zz = "";
            zz += i[0];
            zz += i[1];
            zz += i[2];
            if (zz.equals(ID)) {
                s.remove(i);
                File ff = new File(Main.path +"\\" + (name + fathername) +"\\UserTickets.txt");
                FileWriter fww;
                try {
                    fww = new FileWriter(ff);
                    for (String[] d : s) {
                        String line = "";
                        for (int r = 0; r < d.length; r++)
                            line += d[r] + ";";
                        fww.write(" " + line + "\n");
                    }
                    fww.flush();
                    fww.close();
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }
            break;
            }
        }
    }
        public static List<String> showAvailableSeats(int cinema, int time){
        int realTime = time;
        int cinemaId = cinema;
        List<String> availableSeats = new ArrayList<String>();
        for (int i = 1; i <= 50; i++) {
            if(!Main.bookedTickets[cinemaId][realTime][i]){
                availableSeats.add(String.valueOf(i));
            }
        }
        return availableSeats;
    }
        public static void curBookedTickets(){
            FileDeal fileDeal = new FileDeal();
            try {
                ArrayList<String[]> tickets = new ArrayList<>();
                 tickets=fileDeal.readStr(Main.path+"\\bookTicket.txt");
                String cinId, time, seat;
                for(var s:tickets){
                    cinId = s[0];
                    time = s[1];
                    seat = s[2];
                    System.out.println(cinId);
                    System.out.println(time);
                    System.out.println(seat);
                    Main.bookedTickets[Integer.parseInt(cinId)][Integer.parseInt(time)][Integer.parseInt(seat)] = true;
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.toString());
            }


        }
}
