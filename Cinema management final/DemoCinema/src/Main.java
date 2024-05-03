import java.io.File;
import java.util.HashMap;
import java.util.Map;
public class Main {

    static FileDeal f = new FileDeal();
    static File ff = new File("D:\\Cinema Management\\info");
    static  Map<String, Integer> timeConverter = new HashMap<>();
    static  Map<Integer, String> timeConverter2 = new HashMap<>();
    static boolean[][][] bookedTickets = new boolean[7][9][51];
    static String path= "D:\\Cinema Management\\info";
    public static void main(String[] args)
    {
        if(!ff.exists())
        {
            f.createNestedFolders(path);
        }
        Ticketing.curBookedTickets();
        timeConverter.put("08:00", 1);
        timeConverter.put("10:00", 2);
        timeConverter.put("12:00", 3);
        timeConverter.put("14:00", 4);
        timeConverter.put("16:00", 5);
        timeConverter.put("18:00", 6);
        timeConverter.put("20:00", 7);
        timeConverter.put("22:00", 8);
        timeConverter2.put(1, "08:00");
        timeConverter2.put(2, "10:00");
        timeConverter2.put(3, "12:00");
        timeConverter2.put(4, "14:00");
        timeConverter2.put(5, "16:00");
        timeConverter2.put(6, "18:00");
        timeConverter2.put(7, "20:00");
        timeConverter2.put(8, "22:00");
        File f=new File(path+"\\Movies.txt");
        if(!f.exists())
        {
            Cinema cinema = new Cinema("A1", 1);
            Cinema cinema2 = new Cinema("A2", 2);
            Cinema cinema3 = new Cinema("A3", 3);
            Cinema cinema4 = new Cinema("A4", 4);
            Cinema cinema5 = new Cinema("A5", 5);
            Cinema cinema6 = new Cinema("A6", 6);
            Movie movie = new Movie(1, "Avengers Age Of Ultron", "Action", cinema, "08:00", "10:00");
            Movie movie1 = new Movie(2, "Avengers Endgame", "Action", cinema, "12:00", "14:00");
            Movie movie2 = new Movie(3, "Avengers Infinity War", "Action", cinema, "16:00", "18:00");
            Movie movie3 = new Movie(4, "Fast And The Furious", "Action", cinema, "20:00", "22:00");
            Movie movie4 = new Movie(5, "I, Robot", "Action", cinema2, "08:00", "10:00");
            Movie movie5 = new Movie(6, "IP Man 2", "Action", cinema2, "12:00", "14:00");
            Movie movie6 = new Movie(7, "Iron Man 2", "Action", cinema2, "16:00", "18:00");
            Movie movie7 = new Movie(8, "Lucy", "Action", cinema2, "20:00", "22:00");
            Movie movie8 = new Movie(9, "Passenger", "Action", cinema3, "08:00", "10:00");
            Movie movie9 = new Movie(10, "Source Code", "Thriller", cinema3, "12:00", "14:00");
            Movie movie10 = new Movie(11, "Taken 2", "Action", cinema3, "16:00", "18:00");
            Movie movie11 = new Movie(12, "Taken 3", "Action", cinema3, "20:00", "22:00");
            Movie movie12 = new Movie(13, "The Amazing SpiderMan", "Action", cinema4, "08:00", "10:00");
            Movie movie13 = new Movie(14, "The Fifth Estate", "Action", cinema4, "12:00", "14:00");
            Movie movie14 = new Movie(15, "The Incredible hulk", "Science fiction", cinema4, "16:00", "18:00");
            Movie movie15 = new Movie(16, "The Martian", "Action", cinema4, "20:00", "22:00");
            Movie movie16 = new Movie(17, "The Matrix", "Action", cinema5, "08:00", "10:00");
            Movie movie17 = new Movie(18, "The Social Network", "Action", cinema5, "12:00", "14:00");
            Movie movie18 = new Movie(19, "Thor Love And Thunder", "Action", cinema5, "16:00", "18:00");
            Movie movie19 = new Movie(20, "Thor Ragnarok", "Action", cinema5, "20:00", "22:00");
            Movie movie20 = new Movie(21, "TPB AFK", "Drama", cinema6, "08:00", "10:00");
            Movie movie21 = new Movie(22, "Tron", "Action", cinema6, "12:00", "14:00");
            Movie movie22 = new Movie(23, "We Are Legion", "Drama", cinema6, "16:00", "18:00");
            Movie movie23 = new Movie(24, "ZombieLand", "Action", cinema6, "20:00", "22:00");
        }
        HomeScreen Home =new HomeScreen();
    }
}