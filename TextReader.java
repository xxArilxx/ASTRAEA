import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter; 
import java.io.FileReader; 
import java.io.BufferedReader; 

class TextReader{
    public static void main(String[] args){
        
    }

    public static void write(String temp){
        try{
            FileWriter fw = new FileWriter("User Options.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println(temp);
            pw.close();
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }

    public static String readln(){
        String temp = "";
        try {
            FileReader fr = new FileReader("User Options.txt");
            BufferedReader br = new BufferedReader(fr);
            temp = br.readLine();
            br.close();
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        return temp;
    }

    public static void read(int numOfLines){
        String[] text = new String[numOfLines];
        try{
            FileReader fr = new FileReader("User Options.txt");
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
}