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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
//getContentPane() of JFrame
import java.awt.GraphicsEnvironment;

public class Display implements ActionListener{
    //JFRAME
    static JFrame GameScreen; 

    //JBUTTONS
    static JButton start; 
    static JButton next; 
    static JButton exit; 
    static JButton dialogueHistory; 
    static JButton Option1; 
    static JButton Option2; 
    static JButton Option3; 

    //JLABELS
    static JLabel astraeaLogo; 

    //ARRAYS
    static String[] option1 = {}; 
    static String[] option2 = {}; 
    static String[] option3 = {}; 

    //IMAGEICONS
    static ImageIcon gameLogo = new ImageIcon("VIS/DECOR/Astraea.png");
    static ImageIcon homescreenBG = new ImageIcon("VIS/DECOR/750Background.png");

    //BOUNCING ANIMATION VARIABLES
    static boolean animating = true;
    static Timer animationTimer; 


    public static void main(String[] args){
        //Creating JFrame
        GameScreen = new JFrame(); 
        GameScreen.setSize(750, 750);
        GameScreen.setResizable(false); 
        GameScreen.setMaximumSize(new Dimension(750, 750));
        GameScreen.setLayout(null); 
        GameScreen.setDefaultCloseOperation(GameScreen.EXIT_ON_CLOSE);
        //GameScreen.getContentPane().setBackground(Color.decode("#9fb5d1"));
        //save start and exit button words into this color: "#92bbdaff"
        GameScreen.setLocationRelativeTo(null); 

        JLabel HSBG = new JLabel();
        HSBG.setBounds(0, 0, 750, 750);
        HSBG.setIcon(homescreenBG);
        GameScreen.add(HSBG); 
        GameScreen.setContentPane(HSBG); 

        //Creating JLabel for logo in the very beginning of the game
        astraeaLogo = new JLabel();
        astraeaLogo.setBounds(0, 0, 500, 500);
        astraeaLogo.setIcon(gameLogo);

        //Creating JButton to start the game
        start = new JButton("<html><b> Start </b></html>"); 
        start.setBounds(0, 0, 275, 50); 
        start.setFocusPainted(false); 
        start.setOpaque(false);
        start.setVisible(true);

        //Creating JButton to exit the game
        exit = new JButton("<html><b> Exit </b></html>"); 
        exit.setBounds(0, 0, 275, 50); 
        exit.setFocusPainted(false);
        exit.setOpaque(false); 
        exit.setVisible(true); 
        
        //Set up
        Font Gerady_Bale = null;
        try {
           Gerady_Bale = Font.createFont(Font.TRUETYPE_FONT, new File("VIS/DECOR/Gerady Bale.otf"));
           GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
           ge.registerFont(Gerady_Bale);
        } catch (IOException | FontFormatException e) {
           e.printStackTrace();
        }


        //JButtons (start and exit) decor
        if (Gerady_Bale != null) {
            start.setFont(Gerady_Bale.deriveFont(24f)); 
            exit.setFont(Gerady_Bale.deriveFont(24f));
        }

        //Dimensions of the content pane of the JFrame
        GameScreen.setVisible(true);

        int screenHeight = (int)GameScreen.getContentPane().getHeight();
        int screenWidth = (int)GameScreen.getContentPane().getWidth();

        //Dimensions of astraeaLogo (gameLogo is the ImageIcon that astraeaLogo displays)
        int logoHeight = (int)gameLogo.getIconHeight(); 
        int logoWidth = (int)gameLogo.getIconWidth(); 

        //Dimensions of the start button
        int startHeight = (int)start.getHeight(); 
        int startWidth = (int)start.getWidth(); 

        //Dimensions of the exit button
        int exitHeight = (int)exit.getHeight(); 
        int exitWidth = (int)exit.getWidth(); 


        //Positioning everything on the JFrame
        astraeaLogo.setBounds((screenWidth - logoWidth)/2, (screenHeight - logoHeight)/2, logoWidth, logoHeight);
        GameScreen.add(astraeaLogo);
        start.setBounds((screenWidth - startWidth)/2, (screenHeight - startHeight)/2 + logoHeight/2, startWidth, startHeight);
        GameScreen.add(start);
        exit.setBounds((screenWidth - exitWidth)/2, (screenHeight - exitHeight)/2 + logoHeight/2 + 50, exitWidth, exitHeight); 
        GameScreen.add(exit); 
        
        upDownAnimation(astraeaLogo, start, 25); 

        //Creating an instance of this class (Display) for easier ActionListeners (less confusion about what 'this' could be)
        Display display = new Display();
        start.addActionListener(display);
        exit.addActionListener(display);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //Start button starting the game and ending the animation of the bouncing Astraea logo
        if (e.getSource() == start){
            animating = false;
            animationTimer.stop();
            astraeaLogo.setVisible(false);
            start.setVisible(false);
            exit.setVisible(false); 
            GameScreen.getContentPane().setBackground(Color.WHITE); 
        }

        //Exit button on the home screen of the game
        if (e.getSource() == exit){
            System.exit(0); 
        }
    }

    public void changeScreen(){
        //Changes the screen of the JFrame (for background to panel changes and sprite repositioning in the story)
    }

    public static void upDownAnimation(JLabel label, JButton button, int range){
        //Creating an instance of this class (Display) in the method -> apparently it's so the program can access non-static variables too
        Display temp = new Display(); 
        
        //Setting up paramet(er/re)s -> JLabel and JButton
        label.setVisible(true);
        button.setVisible(true);
        button.setFocusPainted(false);
        button.addActionListener(temp);

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
                        yPosC[0]++;

                        if (yPosC[0] >= yPosStart + yPosRange){
                            movingDown[0] = true; 
                        }
                    } else {
                        yPosC[0]--;  

                        if (yPosC[0] <= yPosStart - yPosRange){
                            movingDown[0] = false; 
                        } 
                    }
                    label.setLocation(label.getX(), yPosC[0]); 
                }
            }
        });
        animationTimer.start();
    }
}