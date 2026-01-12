class Character {
    //BOOLS
    boolean isMainCharacter;
    boolean isInAstraea;

   //STRINGS
    String nameOfCharacter;
    String nameOfSprite;
    String tempImgPath;


    //CHAR LISTS
    String[] MCList = {"Atlas", "Sol", "The Supreme"};
    String[] sideSuppCharList = {""};


    //SPRITE LISTS
    String[] ATLSpriteList = {"Neutral", "Smile", "Sad", "Angry", "Thinking"};
    String[] SOLSpriteList = {"Neutral", "Awaken", "Excited", "Sad", "Angry", "Thinking"};
    String[] SUPSpriteList = {"Neutral", "Smirk", "Surprised", "Furious"};


    public Character(boolean isMC, String nOC, String nOS){
       int charIndex;
       int spriteIndex;
       nOC = nameOfCharacter;
       nOS = nameOfSprite;
      
        if (isMC){
           charIndex = searchList(MCList, nOC);
            if (charIndex != -1){
                if (nameOfSprite.equalsIgnoreCase("Atlas")){
                   spriteIndex = searchList(ATLSpriteList, nOS);
                    if (spriteIndex != -1){
                       tempImgPath = "CHAR/" + nameOfCharacter + "/" + nameOfSprite + ".png";
                    }
                } else if (nameOfSprite.equalsIgnoreCase("Sol")) {
                   spriteIndex = searchList(SOLSpriteList, nOS);
                    if (spriteIndex != -1){
                       tempImgPath = "CHAR/" + nameOfCharacter + "/" + nameOfSprite + ".png";
                    }
                } else {
                   spriteIndex = searchList(SUPSpriteList, nOS);
                    if (spriteIndex != -1){
                       tempImgPath = "CHAR/" + nameOfCharacter + "/" + nameOfSprite + ".png";
                    }
                }
            }
          
        }
    }

    public Character(){
        nameOfCharacter = ""; 
        nameOfSprite = ""; 
    }
  
    public int searchList(String[] list, String name){
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

    public String toString(){
       return "MC: " + isMainCharacter + "\nCharacter Name: " + nameOfCharacter + "\nSprite Name: " + nameOfSprite + "In Astraea?: " + isInAstraea; 
    }

    public boolean getMainCharacter(){
        return isMainCharacter; 
    }

    public boolean isInAstraea(){
        return isInAstraea; 
    }

    public String getCharacterName(){
        return nameOfCharacter; 
    }

    public String getCharacterSprite(){
        return nameOfSprite; 
    }

    public String getImagePath(){
        return tempImgPath; 
    }

    public void setCharacterSprite(String newSpriteName){
        if (searchList(ATLSpriteList, newSpriteName) != -1){
            nameOfSprite = newSpriteName; 
            tempImgPath = "CHAR/" + nameOfCharacter + "/" + nameOfSprite + ".png";
        } else {
            System.out.println("Unable to change Sprite"); 
        }
    }
}