import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Color; 
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

public class Display implements ActionListener{
    //JFRAME
    static JFrame GameScreen; 

    //JBUTTONS
    JButton start; 
    JButton next; 
    JButton dialogueHistory; 
    JButton Option1; 
    JButton Option2; 
    JButton Option3; 

    //JLabels
    static JLabel astraeaLogo; 

    //ARRAYS
    String[] option1 = {}; 
    String[] option2 = {}; 
    String[] option3 = {}; 

    //IMAGEICONS
    static ImageIcon gameLogo = new ImageIcon("VIS/DECOR/Astraea.png");


    public static void main(String[] args){
        GameScreen = new JFrame(); 
        GameScreen.setBounds(0, 0, 750,750);
        GameScreen.setLayout(null); 
        GameScreen.setDefaultCloseOperation(GameScreen.EXIT_ON_CLOSE);
        GameScreen.getContentPane().setBackground(Color.BLACK);

        astraeaLogo = new JLabel();
        astraeaLogo.setBounds(0, 0, 500, 500);
        astraeaLogo.setIcon(gameLogo);
        GameScreen.add(astraeaLogo); 


        Font Gerady_Bale = null;
        try {
           Gerady_Bale = Font.createFont(Font.TRUETYPE_FONT, new File("VIS/DECOR/Gerady Bale.otf"));
           GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
           ge.registerFont(Gerady_Bale);
        } catch (IOException | FontFormatException e) {
           e.printStackTrace();
        }

        GameScreen.setVisible(true);
    }

        public void actionPerformed(ActionEvent e) {
        // This method is required by ActionListener interface
    }

    public void changeScreen(){
            
    }

}