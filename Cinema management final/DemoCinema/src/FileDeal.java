import java.io.*;
import java.util.ArrayList;

public class FileDeal {
    private FileWriter fw;

    public FileDeal() {
    }

    public static void createFile(String Path, String fileName, String content) {
        try {
            File file = new File( Path, fileName);
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            bufferedWriter.write(content);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void createNestedFolders(String fullPath) {
        File currentFolder = new File( fullPath);
        if (!currentFolder.exists()) {
            boolean created = currentFolder.mkdirs();
            if (created) {
                System.out.println("تم إنشاء المجلد: " + currentFolder.getAbsolutePath());
            } else {
                System.out.println("فشل في إنشاء المجلد: " + currentFolder.getAbsolutePath());
            }
        } else {
            System.out.println("المجلد موجود بالفعل: " + currentFolder.getAbsolutePath());
        }

    }
    public  ArrayList readStr(String path) throws FileNotFoundException {
        ArrayList<String[]> all = new ArrayList<>();
        String[] line;
        BufferedReader in = null;
        File f = new File(path);
        FileReader fileReader = new FileReader(f);
        try {
            in = new BufferedReader(fileReader);
            String string = "";
            int i = 0;
            while (in.read() != -1) {
                string = in.readLine();
                line = string.split(";");
                all.add(line);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return all;
    }
    public void writeStr(String path , ArrayList<String[]> content , char regex){
        File ff = new File(path);
        FileWriter fww;
        try {
            fww = new FileWriter(ff);
            for (String[] i : content) {
                String line = "";
                for (int r = 0; r < i.length; r++)
                    line += i[r] + regex;
                fww.write(" " + line + "\n");
            }
            fww.flush();
            fww.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
