//Swing GUI
import javax.swing.*; 
//ActionListener and ActionEvent for JButtons and more
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//File readers
import java.io.File;
//Font setup imports
import java.io.IOException;
import java.awt.Color; 
import java.awt.Font;
import java.awt.FontFormatException;
//getContentPane() of JFrame
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

    //JLABELS
    static JLabel astraeaLogo; 

    //ARRAYS
    String[] option1 = {}; 
    String[] option2 = {}; 
    String[] option3 = {}; 

    //IMAGEICONS
    static ImageIcon gameLogo = new ImageIcon("VIS/DECOR/Astraea.png");

    //BOUNCING ANIMATION VARIABLES
    boolean animating = true;
    Timer animationTimer; 


    public static void main(String[] args){
        //Creating JFrame
        GameScreen = new JFrame(); 
        GameScreen.setBounds(0, 0, 750,750);
        GameScreen.setLayout(null); 
        GameScreen.setDefaultCloseOperation(GameScreen.EXIT_ON_CLOSE);
        GameScreen.getContentPane().setBackground(Color.BLACK);

        //Creating JLabel for logo in the very beginning of the game
        astraeaLogo = new JLabel();
        astraeaLogo.setBounds(0, 0, 500, 500);
        astraeaLogo.setIcon(gameLogo);
        
        //Set up
        Font Gerady_Bale = null;
        try {
           Gerady_Bale = Font.createFont(Font.TRUETYPE_FONT, new File("VIS/DECOR/Gerady Bale.otf"));
           GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
           ge.registerFont(Gerady_Bale);
        } catch (IOException | FontFormatException e) {
           e.printStackTrace();
        }

        //getContentPane() code
        GameScreen.setVisible(true);

        int screenHeight = (int)GameScreen.getContentPane().getHeight();
        int screenWidth = (int)GameScreen.getContentPane().getWidth();
        int logoHeight = (int)gameLogo.getIconHeight(); 
        int logoWidth = (int)gameLogo.getIconWidth(); 

        astraeaLogo.setBounds((screenWidth - logoWidth)/2, (screenHeight - logoHeight)/2, logoWidth, logoHeight);
        GameScreen.add(astraeaLogo); 
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == start){
            animating = false;
            animationTimer.stop();
        }
    }

    public void changeScreen(){
        //Changes the screen of the JFrame
    }

    public void upDownAnimation(JLabel label, JButton button, int range){
        //Setting up paramet(er/re)s -> JLabel and JButton
        label.setVisible(true);
        label.setBounds(label.getX(), label.getY(), label.getWidth(), label.getHeight()); 
        start = button; 
        button.setVisible(true);
        button.setBounds(button.getX(), button.getY(), button.getWidth(), button.getHeight()); 
        button.setFocusPainted(false);
        button.addActionListener(this);

        final int yPosStart = label.getY();
        final int yPosRange = range; 
        final int[] yPosC = {yPosStart};  
        final boolean[] movingDown = {false}; 

        animating = true; 

        animationTimer = new Timer(30, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (animating) {
                    if (!movingDown[0]){
                        yPosC[0]--;

                        if (yPosC[0] >= yPosStart + yPosRange){
                            movingDown[0] = false; 
                        }
                    } else {
                        yPosC[0]++; 

                        if (yPosC[0] <= yPosStart - yPosRange){
                            movingDown[0] = true; 
                        } 
                    }
                    label.setLocation(label.getX(), yPosC[0]); 
                }
            }
        });
        animationTimer.start();
    }

}