import java.util.ArrayList;
import java.util.List;

public class Movie {
    private int movieId;
    private String title,genre,showtimes;
    private Cinema cinema;
    FileDeal fileDeal = new FileDeal();
    public Movie(int movieId, String title, String genre,Cinema cinema ,String showtimes1,String showtimes2) {
        fileDeal.createFile(Main.path,"Movies.txt",movieId+";"+title+";"+genre+";"+cinema.getID()+";"+showtimes1+";"+showtimes2+"\n");
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.cinema = cinema;
        this.showtimes = showtimes;
    }

}