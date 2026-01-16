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
import java.awt.BorderLayout;
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
    static JButton context; 
    static JButton howToPlay; 
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
    static JLabel entranceToAstraea; 

    //STORY TEXT
    static JLabel textDisplay; 
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
    static ImageIcon entranceToAstraeaIMG = new ImageIcon("BG/Entrance to Astraea.png"); 
    static ImageIcon hideoutHiddenIMG = new ImageIcon("BG/Hideout (hidden).png"); 
    static ImageIcon hideoutOutsideIMG = new ImageIcon("BG/Hideout (outside).png"); 
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~ ARRAYS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    //Options
    static String[] option1 = {}; 
    static String[] option2 = {}; 
    static String[] option3 = {}; 

    //Background Image
    static ImageIcon[] backgroundIMGs = {homeIMG, creaturePanelIMG, forestNoArchIMG, forestArchIMG, forestPortalIMG, portalInteriorIMG, entranceToAstraeaIMG, hideoutHiddenIMG, hideoutOutsideIMG}; 

    //Last line of each scene
    static String[] lastLine = {"Hello? Aaaaaanybody here?", }; 

    //BOUNCING ANIMATION VARIABLES
    static boolean animating = true;
    static Timer bouncingTimer; 

    //VISUALS AND STORY SCENES
    static int backgroundNum = 0; 
    static boolean sceneOver = false; 

    //~~~~~~~~~~~~~~~~~~~~~~~~~ JTEXTAREAS ~~~~~~~~~~~~~~~~~~~~~~~~~~//
    static JTextArea contextLabel; 
    static JTextArea instructions; 

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

        //JLabel - Text Display
        textDisplay = new JLabel("this is a tester"); 
        textDisplay.setBounds(15, 395, 970, 170); 

        //~~~~~~~~~~~~~~~~~JLABELS WITH THEIR IMAGEICONS~~~~~~~~~~~~~~~~~//
        background = new JLabel();
        background.setBounds(0, 0, 1000, 600);
        background.setIcon(homeIMG); 

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

        //Context JButton
        context = new JButton("<html><b>Story Context</b></html>"); 
        context.setBounds(0, 0, 275, 50); 
        context.setFocusPainted(false); 
        context.setOpaque(false);
        context.setVisible(true); 

        //How to Play JButton
        howToPlay = new JButton("<html><b>How to Play</b></html>"); 
        howToPlay.setBounds(0, 0, 275, 50); 
        howToPlay.setFocusPainted(false); 
        howToPlay.setOpaque(false);
        howToPlay.setVisible(true); 

        //Dialogue Box
        dialogueTextBox = new JButton(); 
        dialogueTextBox.setBounds(15, 395, 970, 170);
        dialogueTextBox.setIcon(dialogueTextBoxIMG); 

        dialogueTextBox.setContentAreaFilled(false); 
        dialogueTextBox.setOpaque(false);
        dialogueTextBox.setBorderPainted(false); 
        dialogueTextBox.setFocusPainted(false); 
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
            context.setFont(Gerady_Bale.deriveFont(24f)); 
            howToPlay.setFont(Gerady_Bale.deriveFont(24f)); 
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

        //context button
        int contextHeight = (int)context.getHeight(); 
        int contextWidth = (int)howToPlay.getWidth(); 

        //how to play button
        int howToPlayHeight = (int)howToPlay.getHeight();
        int howToPlayWidth = (int)howToPlay.getWidth(); 

        //Positioning everything on the JFrame
        astraeaLogo.setBounds((screenWidth - logoWidth)/2, (screenHeight - logoHeight)/2, logoWidth, logoHeight);
        start.setBounds((screenWidth - startWidth)/2, (screenHeight - startHeight)/2 + logoHeight/2 - 50, startWidth, startHeight);
        exit.setBounds((screenWidth - exitWidth)/2, (screenHeight - exitHeight)/2 + logoHeight/2, exitWidth, exitHeight); 
        context.setBounds((1000 - contextWidth), 5 , contextWidth, contextHeight); 
        howToPlay.setBounds((1000 - howToPlayWidth), 55, howToPlayWidth, howToPlayHeight); 

        //Adding all the elements to the JFrame
        GameScreen.add(astraeaLogo);
        GameScreen.add(start);
        GameScreen.add(exit); 
        GameScreen.add(context); 
        GameScreen.add(howToPlay); 
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//



        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~OBJECTS~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        Display display = new Display(); //for easier ActionListeners (less confusion about what 'this' could be)
        TextReader textReader = new TextReader(); //for reading and writing to text files
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

        start.addActionListener(display);
        exit.addActionListener(display);
        context.addActionListener(display); 
        howToPlay.addActionListener(display); 
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
            context.setVisible(false); 
            howToPlay.setVisible(false);
            homeScreenBG.setVisible(false); 

            GameScreen.setContentPane(background);

            background.setLayout(null); 
            background.add(textTriangle); 
            background.add(dialogueTextBox); 

            dialogueTextBox.setVisible(true);
            textTriangle.setVisible(true); 
            upDownAnimation(textTriangle, dialogueTextBox, 5);
        }

        //Exit button on the home screen of the game
        if (e.getSource() == exit){
            System.exit(0); 
        }

        //Context
        if (e.getSource() == context){
            displayPopup("Story Context", "Context.txt");  
        }

        //How to Play
        if (e.getSource() == howToPlay){
            displayPopup("Story Context", "Instructions.txt");  
        }

        if (e.getSource() == dialogueTextBox){
            animating = false;
            bouncingTimer.stop();
            nextBackdrop(); 
        }
    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void changeScreen(){
        //Changes the screen of the JFrame (for background to panel changes and sprite repositioning in the story)
    }

    public static void nextBackdrop(){
        backgroundNum++;
    
        if (backgroundNum >= backgroundIMGs.length) {
            backgroundNum = backgroundIMGs.length - 1;
            return;
        }
    
        background.setIcon(backgroundIMGs[backgroundNum]); 
        background.add(textTriangle); 
        background.add(dialogueTextBox);

        dialogueTextBox.setVisible(true);
        textTriangle.setVisible(true);

        GameScreen.revalidate();
        GameScreen.repaint();

        upDownAnimation(textTriangle, dialogueTextBox, 5);
        sceneOver = false; 
    }
    
    public static void displayPopup(String title, String filePath) {
        JDialog dialog = new JDialog(GameScreen, title, true);
        dialog.setSize(700, 500);
        dialog.setLocationRelativeTo(GameScreen);
        dialog.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
    
        textArea.setText(TextReader.readAll(filePath));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("Serif", Font.PLAIN, 16));
        textArea.setMargin(new java.awt.Insets(15, 15, 15, 15));
    
        JScrollPane scrollPane = new JScrollPane(textArea);
        dialog.add(scrollPane, BorderLayout.CENTER);
    
        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Serif", Font.BOLD, 16));
        closeButton.addActionListener(e -> dialog.dispose());
        
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.add(closeButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ANIMATIONS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void upDownAnimation(JLabel label, JButton button, int range){
        //Creating an instance of this class (Display) in the method -> apparently it's so the program can access non-static variables too
        Display temp = new Display(); 
        
        //Setting up paramet(er/re)s -> JLabel and JButton
        label.setVisible(true);
        button.setVisible(true);
        button.setFocusPainted(false);

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