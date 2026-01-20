/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ IMPORTS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
//Swing GUI
import javax.swing.*; 

//ActionListener and ActionEvent for JButtons
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Font setup imports
import java.io.File;
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
    static JButton homeButton; 

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

    //Characters
    static JLabel characterDisplay; 

    //STORY TEXT
    static JLabel textDisplay; 
    //~~~~~~~~~~~~~~~~~~~~~~~~~ IMAGEICONS ~~~~~~~~~~~~~~~~~~~~~~~~~~//
    //Decor
    static ImageIcon gameLogoIMG = new ImageIcon("VIS/DECOR/Astraea.png"); 
    static ImageIcon homescreenBGIMG = new ImageIcon("VIS/DECOR/Astraea Background.png"); 
    static ImageIcon dialogueTextBoxIMG = new ImageIcon("VIS/DECOR/Dialogue-Text Box.png"); 
    static ImageIcon textTriangleIMG = new ImageIcon("VIS/DECOR/textTriangle.png"); 
    static ImageIcon optionBoxIMG = new ImageIcon("VIS/DECOR/Option Box.png"); 
    static ImageIcon homeButtonIMG = new ImageIcon("VIS/DECOR/Home Button.png"); 

    //Objects
    static ImageIcon musicBoxIMG = new ImageIcon("VIS/OBJECTS/Music Box.png"); 
    static ImageIcon fauxHornsIMG = new ImageIcon("VIS/OBJECTS/ATLHorns.png"); 

    //Backgrounds
    static ImageIcon startingIMG = new ImageIcon("BG/Start.png"); 
    static ImageIcon homeIMG = new ImageIcon("BG/home.png");
    static ImageIcon creaturePanelIMG = new ImageIcon("BG/Creature Panel.png"); 
    static ImageIcon forestNoArchIMG = new ImageIcon("BG/Forest (no arch).png"); 
    static ImageIcon forestArchIMG = new ImageIcon("BG/Forest (arch).png"); 
    static ImageIcon forestPortalIMG = new ImageIcon("BG/Forest (portal).png"); 
    static ImageIcon portalInteriorIMG = new ImageIcon("BG/Portal Interior.png"); 
    static ImageIcon entranceToAstraeaIMG = new ImageIcon("BG/Entrance to Astraea.png"); 
    static ImageIcon hideoutHiddenIMG = new ImageIcon("BG/Hideout (hidden).png"); 
    static ImageIcon hideoutOutsideIMG = new ImageIcon("BG/Hideout (outside).png"); 

    //Characters
    
    static ImageIcon ATLANeutral = new ImageIcon("CHAR/Atlas/ATLANeutral.png"); 
    static ImageIcon ATLAAngry = new ImageIcon("CHAR/Atlas/ATLAAngry.png"); 
    static ImageIcon ATLASad = new ImageIcon("CHAR/Atlas/ATLASad.png"); 
    static ImageIcon ATLASmile = new ImageIcon("CHAR/Atlas/ATLASmile.png"); 
    static ImageIcon ATLAThinking = new ImageIcon("CHAR/Atlas/ATLAThinking.png"); 
    static ImageIcon ATLONeutral = new ImageIcon("CHAR/Atlas/ATLONeutral.png"); 
    static ImageIcon ATLOAngry = new ImageIcon("CHAR/Atlas/ATLOAngry.png"); 
    static ImageIcon ATLOSad = new ImageIcon("CHAR/Atlas/ATLOSad.png"); 
    static ImageIcon ATLOSmile = new ImageIcon("CHAR/Atlas/ATLOSmile.png"); 
    static ImageIcon ATLOThinking = new ImageIcon("CHAR/Atlas/ATLOThinking.png"); 

    static ImageIcon SOLNeutral = new ImageIcon("CHAR/Sol/SOLNeutral.png"); 
    static ImageIcon SOLAngry = new ImageIcon("CHAR/Sol/SOLAngry.png"); 
    static ImageIcon SOLAwaken = new ImageIcon("CHAR/Sol/SOLAwaken.png");
    static ImageIcon SOLExcited = new ImageIcon("CHAR/Sol/SOLExcited.png"); 
    static ImageIcon SOLSad = new ImageIcon("CHAR/Sol/SOLSad.png"); 
    static ImageIcon SOLThinking = new ImageIcon("CHAR/Sol/SOLThinking.png"); 

    static ImageIcon SUPNeutral = new ImageIcon("CHAR/The Supreme/SUPNeutral.png"); 
    static ImageIcon SUPFurious = new ImageIcon("CHAR/The Supreme/SUPFurious.png"); 
    static ImageIcon SUPSmirk = new ImageIcon("CHAR/The Supreme/SUPSmirk.png");
    static ImageIcon SUPSurprised = new ImageIcon("CHAR/The Supreme/SUPSurprised.png");

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~ ARRAYS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    //Options
    static String[] option1 = {
        "She just wanted attention", "", "", "", "", 
        "She goes in without a second thought", "", 
        "...Sol?"}; 

    static String[] option2 = {
        "Parents.",  "", "", "", "", 
        "She thinks about it , then heads home", "", 
        "No! You're my best friend, always have been...?"}; 

    static String[] option3 = {
        "I'm not sure...",  "", "", "", "", 
        "She immediately backs away from the portal and goes home", "", 
        "Who're you exactly...?"}; 

    static String[] response1 = {
        "Maybe, but I don't think so. Let's continue on and find the answer...",  "", "", "", "", 
        "Yes! Exactly right!", "", 
        "SOL: Yes! Yes, it's me!"}; 

    static String[] response2 = {
        "First try! Bravo!",  "", "", "", "", 
        "I would like to believe you were on the right track, then you went off the rails! You see...", "", 
        "SOL: So you really don't recognize me... It's Sol! The deer!!"}; 

    static String[] response3 = {
        "Don't worry, [USER NAME]! Let's get back to the story, shall we?",  "", "", "", "", 
        "Honestly, dear [USER NAME] , we've already established she's an adventurous soul! Why would you believe she would do something as mature as this?", "", 
        "SOL: I'm Sol!!"}; 

    static String[] musicInOrder = {
        "home.wav",
        "home.wav", 
        "home.wav", 
        "forest.wav",
        "forest.wav", 
        "impression.wav",
        "impression.wav", 
        "impression.wav",
        "impression.wav",
        "impression.wav",
        "alstroemeria.wav", 
        "the supreme.wav",
        "cellar.wav",
        "daffodil.wav", 
        "hyacinth.wav"
    }; 

    //Background Image
    static ImageIcon[] backgroundIMGs = {
        startingIMG, 
        homeIMG, 
        creaturePanelIMG, 
        forestNoArchIMG, 
        forestArchIMG, 
        forestPortalIMG, 
        portalInteriorIMG, 
        entranceToAstraeaIMG, 
        hideoutHiddenIMG, 
        hideoutOutsideIMG
    }; 

    //~~~~~~~~~~~~~~~~~~~~~~~~~ JTEXTAREAS ~~~~~~~~~~~~~~~~~~~~~~~~~~//
    static JTextArea contextLabel; 
    static JTextArea instructions; 

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~ EXTRAS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    //BOUNCING ANIMATION VARIABLES
    static boolean animating = true;
    static Timer bouncingTimer; 

    //VISUALS AND STORY SCENES
    static int sceneNum = 0; 
    static boolean sceneOver = false; 
    static Font Gerady_Bale = null; 
    static Font Oaty_Milk = null; 
    static String userName = ""; 
    static int gameLogoX; 
    static int gameLogoY; 
    static int gameLogoW; 
    static int gameLogoH; 

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ SET UP ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String[] args){
        //JFrame
        GameScreen = new JFrame(); 
        GameScreen.setSize(1000, 600);
        GameScreen.setResizable(false); 
        GameScreen.setMaximumSize(new Dimension(1000, 600));
        GameScreen.setLayout(null); 
        GameScreen.setDefaultCloseOperation(3); //GameScreen.EXIT_ON_CLOSE is associated with the int 3 (it had a yellow line and it annoyed me)
        GameScreen.setLocationRelativeTo(null); //Centers JFrame to the screen

        //JLabel - Text Display
        textDisplay = new JLabel(""); 
        textDisplay.setBounds(45, 400, 970, 170); 

        //Creating the JLabels for the characters
        characterDisplay = new JLabel();
        characterDisplay.setBounds(0, 0, 500, 500); 

        //~~~~~~~~~~~~~~~~~JLABELS WITH THEIR IMAGEICONS~~~~~~~~~~~~~~~~~//
        background = new JLabel();
        background.setBounds(0, 0, 1000, 600);
        background.setIcon(startingIMG); 

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
    
        //~~~~~~~~~~~~~~~~~~~JBUTTONS WITH IMAGEICONS~~~~~~~~~~~~~~~~~~~~//
        //Home Button
        homeButton = new JButton(); 
        homeButton.setBounds(0, 0, 80, 80); 
        homeButton.setIcon(homeButtonIMG); 
        homeButton.setBorderPainted(false);

        //Option 1
        Option1 = new JButton(); 
        Option1.setBounds(306, 200, 388, 68);
        Option1.setIcon(optionBoxIMG);

        Option1.setContentAreaFilled(false); 
        Option1.setOpaque(false);
        Option1.setBorderPainted(false); 
        Option1.setFocusPainted(false); 

        background.add(Option1); 
        Option1.setVisible(false); 

        //Option 2
        Option2 = new JButton(); 
        Option2.setBounds(306, 300, 388, 68);
        Option2.setIcon(optionBoxIMG);

        Option2.setContentAreaFilled(false); 
        Option2.setOpaque(false);
        Option2.setBorderPainted(false); 
        Option2.setFocusPainted(false); 

        background.add(Option2); 
        Option2.setVisible(false); 

        //Option 3
        Option3 = new JButton(); 
        Option3.setBounds(306, 400, 388, 68);
        Option3.setIcon(optionBoxIMG);
        
        Option3.setContentAreaFilled(false); 
        Option3.setOpaque(false);
        Option3.setBorderPainted(false); 
        Option3.setFocusPainted(false); 

        background.add(Option3); 
        Option3.setVisible(false); 

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
        try {
            //Gerady Bale
            Gerady_Bale = Font.createFont(Font.TRUETYPE_FONT, new File("VIS/DECOR/Gerady Bale.otf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Gerady_Bale);

            //Oaty Milk
            Oaty_Milk = Font.createFont(Font.TRUETYPE_FONT, new File("VIS/DECOR/Oaty Milk.otf"));
            GraphicsEnvironment om = GraphicsEnvironment.getLocalGraphicsEnvironment();
            om.registerFont(Oaty_Milk);
        } catch (IOException | FontFormatException e) {
           e.printStackTrace();
        }
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//



        //~~~~~~~~~~~~~~~~~~~~~~~~~DECORATIONS~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        //Element Decorating
        if (Gerady_Bale != null && Oaty_Milk != null) {
            start.setFont(Gerady_Bale.deriveFont(24f)); 
            start.setForeground(new Color (45, 93, 130, 255)); 

            exit.setFont(Gerady_Bale.deriveFont(24f));
            exit.setForeground(new Color (45, 93, 130, 255)); 

            context.setFont(Gerady_Bale.deriveFont(24f)); 
            context.setForeground(new Color (45, 93, 130, 255)); 

            howToPlay.setFont(Gerady_Bale.deriveFont(24f)); 
            howToPlay.setForeground(new Color (45, 93, 130, 255)); 

            textDisplay.setFont(Oaty_Milk.deriveFont(20f)); 
            textDisplay.setForeground(new Color (45, 93, 130, 255)); 
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

        gameLogoX = (screenWidth - logoWidth) / 2; 
        gameLogoY = (screenHeight - logoHeight) / 2; 
        gameLogoW = logoWidth; 
        gameLogoH = logoHeight; 

        //Adding all the elements to the JFrame
        GameScreen.add(astraeaLogo);
        GameScreen.add(start);
        GameScreen.add(exit); 
        GameScreen.add(context); 
        GameScreen.add(howToPlay); 
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//



        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~OBJECTS~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        //Creating an instance of this class (Display) in the method -> apparently it's so the program can access non-static variables too
        Display display = new Display(); 
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

        start.addActionListener(display);
        exit.addActionListener(display);
        context.addActionListener(display); 
        howToPlay.addActionListener(display); 
        dialogueTextBox.addActionListener(display); 
        homeButton.addActionListener(display); 

        upDownAnimation(astraeaLogo, start, 25); 
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ACTIONLISTENERS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public void actionPerformed(ActionEvent e){
        //Start button starting the game and ending the animation of the bouncing Astraea logo
        if (e.getSource() == start){
            //Before animation ends
            userName = userInputName();
            TextReader.setupScript(userName); 
            //MusicPlayer.stopMusic();
            MusicPlayer.playMusic(musicInOrder[sceneNum]);

            astraeaLogo.setBounds(gameLogoX, gameLogoY, gameLogoW, gameLogoH);

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

            background.setIcon(backgroundIMGs[sceneNum]); 
            GameScreen.setContentPane(background);

            String line = TextReader.readAndDelete("Script.txt"); 

            if (line != null && !line.isEmpty()) {
                line = updateCharacterSprite(line);
                textDisplay.setText(line);
            } 

            background.setLayout(null); 
            background.add(textDisplay); 
            background.add(textTriangle); 
            background.add(dialogueTextBox); 
            background.add(characterDisplay);
            background.add(homeButton); 

            homeButton.setVisible(true); 
            textDisplay.setVisible(true); 
            dialogueTextBox.setVisible(true);
            textTriangle.setVisible(true); 
            upDownAnimation(textTriangle, dialogueTextBox, 5);
        }

        //Exit button on the home screen of the game
        if (e.getSource() == exit){
            if (Oaty_Milk != null) {
                UIManager.put("OptionPane.messageFont", Oaty_Milk.deriveFont(25f));
                UIManager.put("OptionPane.buttonFont", Oaty_Milk.deriveFont(20f));
            }

            int choice = JOptionPane.showConfirmDialog(GameScreen,"Are you sure you want to exit the game?","Exit Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                return;
            }
        }

        //Home button -> back to intro screen
        if (e.getSource() == homeButton){
            int choice = JOptionPane.showConfirmDialog(GameScreen, "<html>Are you sure you want to return to the main menu?<br>Your progress will be lost</html>", "Return to Main Menu?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choice != JOptionPane.YES_OPTION) {
                return; 
            }

            resetGame(); 
        }

        //Context button -> popup
        if (e.getSource() == context){
            displayPopup("Story Context", "Context.txt");  
        }

        //How to Play button -> popup
        if (e.getSource() == howToPlay){
            displayPopup("Instructions", "Instructions.txt");  
        }

        //Next line of story
        if (e.getSource() == dialogueTextBox){
            if (sceneOver){
                nextBackdrop(); 
            } else {
                String line = TextReader.readAndDelete("Script.txt"); 

                if (line.equals("[CHOICE]")){
                    userChoice();
                    return; 
                }

                if (line == null || line.isEmpty()) {
                    sceneOver = true;
                    return;
                }
                
                line = updateCharacterSprite(line);
                textDisplay.setText(line);

                Option1.setVisible(false); 
                Option2.setVisible(false); 
                Option3.setVisible(false); 
            }
        }
    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void userChoice(){
        dialogueTextBox.setEnabled(false);

        Option1.setText(option1[sceneNum]); 
        Option1.setHorizontalTextPosition(JButton.CENTER);
        Option1.setVerticalTextPosition(JButton.CENTER);
        
        Option2.setText(option2[sceneNum]);
        Option2.setHorizontalTextPosition(JButton.CENTER);
        Option2.setVerticalTextPosition(JButton.CENTER);
    
        Option3.setText(option3[sceneNum]);
        Option3.setHorizontalTextPosition(JButton.CENTER);
        Option3.setVerticalTextPosition(JButton.CENTER);

    ActionListener choiceListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String response = "";
            
            if (e.getSource() == Option1) {
                response = response1[sceneNum]; 
            } else if (e.getSource() == Option2) {
                response = response2[sceneNum];
            } else if (e.getSource() == Option3) {
                response = response3[sceneNum];
            }
            
            updateCharacterSprite(response); 
            response = replaceUserName(response);
            
            Option1.setVisible(false);
            Option2.setVisible(false);
            Option3.setVisible(false);

            Option1.removeActionListener(this);
            Option2.removeActionListener(this);
            Option3.removeActionListener(this);
            
            response = updateCharacterSprite(response);
            textDisplay.setText(response);
            
            String line = TextReader.readAndDelete("Script.txt");
            if (line != null && line.equals("[CHOICE]")) {
                line = TextReader.readAndDelete("Script.txt");
            }
            
            dialogueTextBox.setEnabled(true);
        }
    };

    Option1.addActionListener(choiceListener);
    Option2.addActionListener(choiceListener);
    Option3.addActionListener(choiceListener);

    Option1.setVisible(true); 
    Option2.setVisible(true); 
    Option3.setVisible(true); 
}
    
    public static String userInputName() {
        String userName = "";
        boolean nameEntered = false;
        
        // Set custom font for JOptionPane
        if (Oaty_Milk != null) {
            UIManager.put("OptionPane.messageFont", Oaty_Milk.deriveFont(25f));
            UIManager.put("OptionPane.buttonFont", Oaty_Milk.deriveFont(20f));
        }

        while (!nameEntered) {
            Object result = JOptionPane.showInputDialog(GameScreen,"How would you like to be addressed?","Name Entry", JOptionPane.QUESTION_MESSAGE, null, null, "");

            

            // Check if user clicked Cancel or closed the dialog (X button)
            if (result == null) {
                // User clicked Cancel or closed the dialog
                int choice = JOptionPane.showConfirmDialog(GameScreen,"Are you sure you want to exit the game?","Exit Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0); 
                } else {
                    continue;
                }
            }
            
            // Convert result to String
            userName = (String) result;
            
            // Validate the input
            userName = userName.trim();
            
            if (userName.isEmpty() || userName.matches("\\s+")) {
                JOptionPane.showMessageDialog(
                    GameScreen,
                    "Please enter a name",
                    "Empty Entry",
                    JOptionPane.WARNING_MESSAGE
                );
            } else {
                nameEntered = true;
            }
        }
        // Save the name
        TextReader.write(userName, "Guest of Astraea.txt");
        TextReader.write(userName + System.lineSeparator(), "Previous Guests of Astraea.txt", true);

        return userName;
    }

    public static void nextBackdrop(){
        sceneNum++;
    
        if (sceneNum >= backgroundIMGs.length) {
            sceneNum = backgroundIMGs.length - 1;
        }

    
        if (sceneNum < musicInOrder.length && !musicInOrder[sceneNum].isEmpty()) {
            if (sceneNum == 0 || !musicInOrder[sceneNum].equals(musicInOrder[sceneNum-1])) {
                MusicPlayer.playMusic(musicInOrder[sceneNum]);
            }
        }
    
        background.setIcon(backgroundIMGs[sceneNum]); 
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

        //Hides Caret (text pointer thingy)
        textArea.setCaret(new javax.swing.text.DefaultCaret() {
            @Override
            public void setVisible(boolean vis) {
                super.setVisible(false); 
            }
        });
    
        textArea.setText(TextReader.readAll(filePath));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        
        if (Gerady_Bale != null) {
            textArea.setFont(Oaty_Milk.deriveFont(30f).deriveFont(Font.BOLD)); 
        } else {
            textArea.setFont(new Font("Serif", Font.BOLD, 30));
        }
    
        textArea.setFont(Oaty_Milk.deriveFont(30f));
        textArea.setMargin(new java.awt.Insets(15, 15, 15, 15));
        
    
        JScrollPane scrollPane = new JScrollPane(textArea);
        dialog.add(scrollPane, BorderLayout.CENTER);
    
        JButton closeButton = new JButton("Close");
        
        if (Gerady_Bale != null) {
            closeButton.setFont(Gerady_Bale.deriveFont(30f).deriveFont(Font.BOLD)); 
            textArea.setForeground(new Color (45, 93, 130, 255)); 
        }

        closeButton.addActionListener(e -> dialog.dispose());
        
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.add(closeButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    public static String replaceUserName(String response){
        if (response == null) {
            return response;
        }

        String result = response;
    
        if (userName != null && !userName.isEmpty()) {
            result = result.replace("[USER NAME]", userName);
        } else {
            result = result.replace("[USER NAME]", "friend");
        }
    
        return result;
    }
    
    public static void resetGame(){
        if (bouncingTimer != null && bouncingTimer.isRunning()) {
            bouncingTimer.stop();
        }
        
        MusicPlayer.stopMusic();
        TextReader.setupScript(userName);
        sceneNum = 0;
        sceneOver = false;
    
        GameScreen.setContentPane(homeScreenBG);
        homeScreenBG.setLayout(null);
        
        background.removeAll();

        background.add(Option1);
        background.add(Option2);
        background.add(Option3);

        homeScreenBG.add(astraeaLogo);
        homeScreenBG.add(start);
        homeScreenBG.add(exit);
        homeScreenBG.add(context);
        homeScreenBG.add(howToPlay);

        astraeaLogo.setVisible(true);
        start.setVisible(true);
        exit.setVisible(true); 
        context.setVisible(true); 
        howToPlay.setVisible(true);
        homeScreenBG.setVisible(true);
    
        homeButton.setVisible(false); 
        dialogueTextBox.setVisible(false);
        textTriangle.setVisible(false);
        Option1.setVisible(false);
        Option2.setVisible(false);
        Option3.setVisible(false);
    
        textDisplay.setVisible(false);

        GameScreen.revalidate();
        GameScreen.repaint();

        upDownAnimation(astraeaLogo, start, 25);
    }

    public static void upDownAnimation(JLabel label, JButton button, int range){
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

    public static String updateCharacterSprite(String line) {
        if (line == null) {
            characterDisplay.setIcon(null);
            return line;
        }

        if (line.contains("ATLAS:")) {
            characterDisplay.setIcon(ATLONeutral);
            characterDisplay.setBounds(0, 0, 500, 500); 
            characterDisplay.setVisible(true);

            return line.replace("ATLAS:", "").trim();

        } else if (line.contains("SOL:")) {
            characterDisplay.setIcon(SOLNeutral);
            characterDisplay.setBounds(-60, 20, 500, 500); 
            characterDisplay.setVisible(true);

            return line.replace("SOL:", "").trim();

        } else if (line.contains("THE SUPREME:")) {
            characterDisplay.setIcon(SUPNeutral);
            characterDisplay.setBounds(-55, 25, 500, 500); 
            characterDisplay.setVisible(true);

            return line.replace("THE SUPREME:", "").trim();

        } else {
            characterDisplay.setVisible(false);
            return line;
        }
    }
}/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FIN ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/