/**
 * Hand Class that draws hand
 *
 * @author (Kelly)
 * @version (APRIL 2022)
 */
//GUI TOOLS
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;

public class Hand
{
    //INSTANCE FIELDS
    String[] handType = {"ROCK", "PAPER", "SCISSORS"}; 
    String playerHand;
    String compHand;

    public Hand(){
        playerHand = "UNKNOWN";
        compHand = "UNKNOWN";

    }

    //method to set hand 
    public void setHand(int isHand){
        playerHand = handType[isHand]; 
    }

    //getter method for playerHand
    public String getHand(){
        return playerHand;
    }

    //method to generate computer hand 
    public void setCompHand(){
        int temp = (int)(3*Math.random());
        compHand = handType[temp];

    }

    public String getCompHand(){
        return compHand;
    }


    public void draw(Graphics page){
        Graphics2D page2D = (Graphics2D) page;

        page.setColor(Color.black);
        page2D.setFont(new Font("Roboto", Font.BOLD, 50));
        //draw player hand 
        if(getHand().equals(handType[0])){
            page2D.drawString("\u270A", 70, 105);
        }
        else if(getHand().equals(handType[1])){
            page2D.drawString("\u270B", 70, 105);
        }
        else if(getHand().equals(handType[2])){
            page2D.drawString("\u270C", 90, 105);
        }

        //draw computer hand
        if(getCompHand().equals(handType[0])){
            page2D.drawString("\u270A", 270, 105);
        }
        else if(getCompHand().equals(handType[1])){
            page2D.drawString("\u270B", 270, 105);
        }
        else if(getCompHand().equals(handType[2])){
            page2D.drawString("\u270C", 280, 105);
        }

    }

}
