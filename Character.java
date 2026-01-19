class Character {
    //BOOLS
    boolean receivedHeadband;

   //STRINGS
    String nameOfCharacter;
    String nameOfSprite;


    //CHAR LISTS
    String[] MCList = {"Atlas", "Sol", "The Supreme"};


    //SPRITE LISTS
    String[] ATLSpriteList = {"Neutral", "Smile", "Sad", "Angry", "Thinking"};
    String[] SOLSpriteList = {"Neutral", "Awaken", "Excited", "Sad", "Angry", "Thinking"};
    String[] SUPSpriteList = {"Neutral", "Smirk", "Surprised", "Furious"};

    public Character(String charName, String spriteName){
        nameOfCharacter = charName;
        nameOfSprite = spriteName; 
    } 

    public String spritePath(String charName, String spriteName){
        String filePath = "";

        if (charName.equals("Atlas")){
            int exists = check(ATLSpriteList, spriteName); 

            if (exists != -1){
                if (receivedHeadband){
                    filePath = "CHAR/Atlas/ATLA" + spriteName +  ".png"; 
                } else {
                    filePath = "CHAR/Atlas/ATLO" + spriteName +  ".png"; 
                }
            }

        } else if (charName.equals("Sol")){
            int exists = check(SOLSpriteList, spriteName); 

            if (exists != -1){
                filePath = "CHAR/Sol/SOL" + spriteName +  ".png"; 
            }

        } else {
            int exists = check(SUPSpriteList, spriteName); 

            if (exists != -1){
                filePath = "CHAR/The Supreme/SUP" + spriteName + ".png"; 
            }
        }

        return filePath; 
    }

    public int check(String[] list, String name){
      int index = -1;
       for (int i = 0; i < list.length; i++){
           if (list[i].equals(name)){
              index = i;
           }
       }
       if (index == -1){
          System.out.println("Not found");
       }
    
      return index;
    }

}