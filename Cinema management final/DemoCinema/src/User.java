import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class User {
    private static String username;
    private String fathername;
    private String phone;
    private String gender;
    private String password;
    private int age;
    java.util.List<String> reservation;
    static FileDeal fileDeal;

    public User(String username, String password, String fathername, String phone, String gender, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.fathername = fathername;
        this.gender = gender;
        this.phone = phone;
        reservation = new ArrayList<>();
        fileDeal = new FileDeal();
        fileDeal.createFile(Main.path, "Users.txt", " " + username + ";" + password + ";" + fathername + ";" + phone + ";" + gender + ";" + age + ";" + "\n");
    }

    public User() {
    }
    public static void addReservation(String str, String name, String fathername) {
        fileDeal.createNestedFolders(Main.path+"\\" + (name + fathername));
        fileDeal.createFile(Main.path +"\\" + (name + fathername), "UserTickets.txt", " "+str);
    }

    public String[] login(String username, String password) throws IOException {

        String[] ans = null;
        boolean userfound = false;
        String usr = "";
        String pass = "";
        try
        {
            FileDeal f = new FileDeal();
            ArrayList<String[]> z = f.readStr(Main.path + "\\Users.txt");
            for (var i : z) {
                usr = i[0];
                pass = i[1];
                if (username.equals(usr) && password.equals(pass)) {
                    ans = i;
                    userfound = true;
                    UserAccountScreen.setUserName(i[0]);
                    UserAccountScreen.setUserFatherName(i[2]);
                }
            }
        }
        finally {
            return ans;
        }
    }
    static public void ChangePass(String Upass,String OldPass) throws FileNotFoundException {
        FileDeal fileD = new FileDeal();
        ArrayList<String[]> names = fileD.readStr(Main.path + "\\Users.txt");
        for (String[] i : names) {
            if (i[1].equals(OldPass)) {
                i[1] = Upass;
                fileD.writeStr(Main.path + "\\Users.txt",names,';');
                break;
            }

        }

    }
}