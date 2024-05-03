public class Cinema {
    private String cinemaName;
    //add movie that shown
    private int ID;
    public Cinema(String cinemaName,int ID) {
        this.cinemaName = cinemaName;
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }
    public String toString() {
        return "Cinema{cinemaName='" + this.cinemaName + "', movies=" + "}";
    }
}


