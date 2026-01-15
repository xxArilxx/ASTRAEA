/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ IMPORTS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
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

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ DISPLAY CLASS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
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
    static JButton dialogueTextBox;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~ JLABELS ~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    //Intro
    static JLabel astraeaLogo; 
    static JLabel gameLogo;
    static JLabel homeScreenBG;
    static JLabel background; 
    static JLabel textTriangle; 

    //Objects
    static JLabel musicBox;
    static JLabel fauxHorns;

    //Backgrounds
    static JLabel home;
    static JLabel creaturePanel;
    static JLabel forestNoArch;
    static JLabel forestArch;
    static JLabel forestPortal;
    static JLabel portalInterior;
    //~~~~~~~~~~~~~~~~~~~~~~~~~ IMAGEICONS ~~~~~~~~~~~~~~~~~~~~~~~~~~//
    //Decor
    static ImageIcon gameLogoIMG = new ImageIcon("VIS/DECOR/Astraea.png");
    static ImageIcon homescreenBGIMG = new ImageIcon("VIS/DECOR/Astraea Background.png");
    static ImageIcon dialogueTextBoxIMG = new ImageIcon("VIS/DECOR/Dialogue-Text Box.png");
    static ImageIcon textTriangleIMG = new ImageIcon("VIS/DECOR/textTriangle.png"); 

    //Objects
    static ImageIcon musicBoxIMG = new ImageIcon("VIS/OBJECTS/Music Box.png");
    static ImageIcon fauxHornsIMG = new ImageIcon("VIS/OBJECTS/ATLHorns.png"); 

    //Backgrounds
    static ImageIcon homeIMG = new ImageIcon("BG/home.png");
    static ImageIcon creaturePanelIMG = new ImageIcon("BG/Creature Panel.png"); 
    static ImageIcon forestNoArchIMG = new ImageIcon("BG/Forest (no arch).png"); 
    static ImageIcon forestArchIMG = new ImageIcon("BG/Forest (arch).png"); 
    static ImageIcon forestPortalIMG = new ImageIcon("BG/Forest (portal).png"); 
    static ImageIcon portalInteriorIMG = new ImageIcon("BG/Portal Interior.png"); 
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~ ARRAYS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    //Options
    static String[] option1 = {}; 
    static String[] option2 = {}; 
    static String[] option3 = {}; 

    //Background Image
    static ImageIcon[] backgroundIMGs = {homeIMG, creaturePanelIMG, forestNoArchIMG, forestArchIMG, forestPortalIMG, portalInteriorIMG}; 

    //BOUNCING ANIMATION VARIABLES
    static boolean animating = true;
    static Timer bouncingTimer; 

    //INTEGERS
    static int counter = -1; 

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ SET UP ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String[] args){
        //JFrame
        GameScreen = new JFrame(); 
        GameScreen.setSize(1000, 600);
        GameScreen.setResizable(false); 
        GameScreen.setMaximumSize(new Dimension(1000, 600));
        GameScreen.setLayout(null); 
        GameScreen.setDefaultCloseOperation(GameScreen.EXIT_ON_CLOSE);
        GameScreen.setLocationRelativeTo(null); 

        //JButton
        dialogueTextBox = new JButton(); 
        dialogueTextBox.setBounds(15, 395, 970, 170);
        dialogueTextBox.setIcon(dialogueTextBoxIMG); 

        dialogueTextBox.setContentAreaFilled(false); 
        dialogueTextBox.setOpaque(false);
        dialogueTextBox.setBorderPainted(false); 
        dialogueTextBox.setFocusPainted(false); 

        //~~~~~~~~~~~~~~~~~JLABELS WITH THEIR IMAGEICONS~~~~~~~~~~~~~~~~~//
        home = new JLabel(); 
        home.setBounds(0, 0, 1000, 600);
        home.setIcon(homeIMG); 

        homeScreenBG = new JLabel(); 
        homeScreenBG.setBounds(0, 0, 1000, 600);
        homeScreenBG.setIcon(homescreenBGIMG);
        GameScreen.add(homeScreenBG); 

        textTriangle = new JLabel(); 
        textTriangle.setBounds(928, 500, 25, 24); 
        textTriangle.setIcon(textTriangleIMG); 

        astraeaLogo = new JLabel();
        astraeaLogo.setBounds(0, 0, 1000, 600);
        astraeaLogo.setIcon(gameLogoIMG);
        
        //Objects
        musicBox = new JLabel(); 
        musicBox.setBounds(0, 0, 1000, 600);
        musicBox.setIcon(musicBoxIMG);

        fauxHorns = new JLabel(); 
        fauxHorns.setBounds(0, 0, 1000, 600);
        fauxHorns.setIcon(fauxHornsIMG);
    
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

        //Setting Background image
        GameScreen.setContentPane(homeScreenBG); 

        //~~~~~~~~~~~~~~~~~~~~~~~~~JBUTTON SETUP~~~~~~~~~~~~~~~~~~~~~~~~~//
        //Start JButton
        start = new JButton("<html><b> Start </b></html>"); 
        start.setBounds(0, 0, 275, 50); 
        start.setFocusPainted(false); 
        start.setOpaque(false);
        start.setVisible(true);


        //Exit JButton
        exit = new JButton("<html><b> Exit </b></html>"); 
        exit.setBounds(0, 0, 275, 50); 
        exit.setFocusPainted(false);
        exit.setOpaque(false); 
        exit.setVisible(true); 
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//



        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~FONT~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        Font Gerady_Bale = null;
        try {
           Gerady_Bale = Font.createFont(Font.TRUETYPE_FONT, new File("VIS/DECOR/Gerady Bale.otf"));
           GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
           ge.registerFont(Gerady_Bale);
        } catch (IOException | FontFormatException e) {
           e.printStackTrace();
        }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//



        //~~~~~~~~~~~~~~~~~~~~~~~~~DECORATIONS~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        //Element Decorating
        //save start and exit button words into this color: "#92bbdaff"
        if (Gerady_Bale != null) {
            start.setFont(Gerady_Bale.deriveFont(24f)); 
            exit.setFont(Gerady_Bale.deriveFont(24f));
        }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//



        //~~~~~~~~~~~~~~~~~~DIMENSIONS AND POSITIONING~~~~~~~~~~~~~~~~~~~//
        //Content pane
        GameScreen.setVisible(true);

        int screenHeight = (int)GameScreen.getContentPane().getHeight();
        int screenWidth = (int)GameScreen.getContentPane().getWidth();

        //astraeaLogo -> gameLogo is the ImageIcon that astraeaLogo displays
        int logoHeight = (int)gameLogoIMG.getIconHeight(); 
        int logoWidth = (int)gameLogoIMG.getIconWidth(); 

        //start button
        int startHeight = (int)start.getHeight(); 
        int startWidth = (int)start.getWidth(); 

        //exit button
        int exitHeight = (int)exit.getHeight(); 
        int exitWidth = (int)exit.getWidth(); 

        //Positioning everything on the JFrame
        astraeaLogo.setBounds((screenWidth - logoWidth)/2, (screenHeight - logoHeight)/2, logoWidth, logoHeight);
        GameScreen.add(astraeaLogo);
        start.setBounds((screenWidth - startWidth)/2, (screenHeight - startHeight)/2 + logoHeight/2 - 50, startWidth, startHeight);
        GameScreen.add(start);
        exit.setBounds((screenWidth - exitWidth)/2, (screenHeight - exitHeight)/2 + logoHeight/2, exitWidth, exitHeight); 
        GameScreen.add(exit); 
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//



        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~OBJECTS~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        Display display = new Display(); //for easier ActionListeners (less confusion about what 'this' could be)
        TextReader textReader = new TextReader(); //for reading and writing to text files
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

        start.addActionListener(display);
        exit.addActionListener(display);
        dialogueTextBox.addActionListener(display); 

        upDownAnimation(astraeaLogo, start, 25); 
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ACTIONLISTENERS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public void actionPerformed(ActionEvent e){
        //Start button starting the game and ending the animation of the bouncing Astraea logo
        if (e.getSource() == start){
            //Ends animation
            animating = false;
            bouncingTimer.stop();

            //Happens after animation
            astraeaLogo.setVisible(false);
            start.setVisible(false);
            exit.setVisible(false); 
            homeScreenBG.setVisible(false); 

            GameScreen.setContentPane(home);

            home.setLayout(null); 
            home.add(textTriangle); 
            home.add(dialogueTextBox); 

            dialogueTextBox.setVisible(true);
            textTriangle.setVisible(true); 
            upDownAnimation(textTriangle, dialogueTextBox, 5);
        }

        //Exit button on the home screen of the game
        if (e.getSource() == exit){
            System.exit(0); 
        }

        if (e.getSource() == dialogueTextBox){
            animating = false;
            bouncingTimer.stop();

            nextStoryLine(); 
        }
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void changeScreen(){
        //Changes the screen of the JFrame (for background to panel changes and sprite repositioning in the story)
    }

    public static void nextStoryLine(){
        counter++;  
        background.setIcon(backgroundIMGs[counter]); 
        GameScreen.setContentPane(background);;
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ANIMATIONS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
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

        bouncingTimer = new Timer(30, new ActionListener(){
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
        bouncingTimer.start();
    }
}/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FIN ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/