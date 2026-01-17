import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter; 
import java.io.FileReader; 
import java.io.BufferedReader; 

class TextReader{
    public static void write(String temp, String fileName){
        try{
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(temp);
            pw.close();
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }

    public static void write(String temp, String fileName, boolean save){
        try{
            FileWriter fw = new FileWriter(fileName, save);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(temp);
            pw.close();
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }

    public static String readln(String fileName){
        String temp = "";
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            temp = br.readLine();
            br.close();
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        return temp;
    }

    public static void read(int numOfLines, String fileName){
        String[] text = new String[numOfLines];
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            for (int i = 0; i < numOfLines; i++){
                text[i] = br.readLine();
                if (text[i] == null) break; 
            }

            br.close();
        } catch (IOException e){
            System.out.println("Error: " + e);
        }

        for (String temp : text){
            if (temp != null) {
                System.out.println(temp);
            }
        }
    }

    public static int lineCounter(String fileName) {
        int counter = 0;
        try {
            FileReader fr = new FileReader(fileName);    
            BufferedReader br = new BufferedReader(fr);
            while (br.readLine() != null) {
                counter++;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e); 
        }
        return counter; 
    }

    public static String readAll(String fileName) {
        StringBuilder fullText = new StringBuilder();

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (!firstLine) {
                    fullText.append(System.lineSeparator()); 
                }
                fullText.append(line);
                firstLine = false;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return fullText.toString();
    }
}