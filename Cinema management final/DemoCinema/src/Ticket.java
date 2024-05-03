public class Ticket {
    public String ID="";
    FileDeal fileDeal = new FileDeal();

    public Ticket(int seatNumber,int realTime , int cinemaId,String moviename) {
        String seatNum = Integer.toString(seatNumber);
        String time = Integer.toString(realTime);
        String cinId = Integer.toString(cinemaId);
        ID += cinId + ";";
        ID += time + ";";
        ID += seatNum;
        fileDeal.createFile(Main.path, "\\bookTicket.txt", " " + ID + ";" + moviename + "\n");
    }

}
