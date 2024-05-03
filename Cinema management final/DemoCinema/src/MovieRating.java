import java.util.ArrayList;
import java.util.Arrays;

public class MovieRating {
    FileDeal fileDeal = new FileDeal();
    public void leaveComment(String title, String comment ,String username,int star) {
        fileDeal.createFile(Main.path,"Comment.txt", " "+username +";" + title + ";" + comment +";" + star +";"+"\n");
    }
    public static int [] generateBusyTimesReport(){
        int []arr=new int[8];
        int cnt;
        for (int i = 0; i <8; i++) {
            cnt=0;
            for(int j=1; j<=6; j++){
                for(int k=1; k<=50; k++){
                    if(Main.bookedTickets[j][i+1][k])
                        cnt++;
                }
            }
            arr[i]=cnt;
        }
        return arr;
    }
}
