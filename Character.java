class Character {
   //BOOLS
   boolean isMainCharacter;
   boolean isInAstraea;

   //STRINGS
   String nameOfCharacter;
   String nameOfSprite;
   String tempImgPath;
   String tempVoicePath; 


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
          
       } else {
          charIndex = searchList(sideSuppCharList, nOC);
           if (charIndex != -1){
               tempVoicePath = "VOICE/Side/" + nameOfCharacter + ".wav";
           }
       }
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
}