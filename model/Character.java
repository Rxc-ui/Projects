package model;

public class Character {


    public Character () {
        xPosition = 0;

        yPosition = 0;
    }

    int xPosition;

    int yPosition;

    public void moveCharacter(int x, int y) {
        xPosition += x;

        yPosition += y;
    }


}
