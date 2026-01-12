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

    public static String[] read(int numOfLines){
        String[] text = new String[numOfLines];

        try{
            FileReader fr = new FileReader("User Options.txt"); 
            BufferedReader br = new BufferedReader(fr); 
            String temp = br.readLine(); 
            
            for (int i = 0; i <= numOfLines; i++){
                text[i] = temp; 
                br.readLine();
            }

            while (br != null){
                System.out.println(temp); 
                temp = br.readLine(); 
            }
            br.close(); 

        } catch (IOException e){
            System.out.println("Error: " + e); 
        }

        return text; 
    }
}