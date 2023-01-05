
/**
 * TableGUI: Supplier Class for GUIDice
 *
 * @author (Kelly Huang)
 * @version (APRIL 2022)
 */
// GRAPHICS TOOLS
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;

public class TableGUI extends JPanel
{
    //INSTANCE FIELDS
    final int WIDTH = 400;
    final int HEIGHT = 200;
    Hand playerHand;
    Hand compHand; 

    public TableGUI(){
        playerHand = new Hand();
        compHand = new Hand();

        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(new Color(0,153,0)); 
    }

    //player chooses hand
    public void chooseHand(int handType){
        playerHand.setHand(handType);
        repaint();
    }

    //choose comp hand
    public void chooseCompHand(){
        compHand.setCompHand();
        repaint();
    }

    //find winner
    public int findWinner(Hand player, Hand comp){
        String playerHand = player.getHand();
        String compHand = comp.getCompHand();

        return playerHand.compareTo(compHand); //returns 0 if tie, -1 if lost, 1 if win
    }

    public void paintComponent(Graphics page){
        super.paintComponent(page);
        Graphics2D page2D = (Graphics2D) page;

        //draw hands
        playerHand.draw(page);
        compHand.draw(page);

        //draw labels 
        page2D.setColor(Color.WHITE);
        page2D.setFont(new Font("Roboto", Font.BOLD, 15));
        page2D.drawString("PLAYER", 70, 130);
        page2D.drawString("PC", 285, 130);

        //print winner
        page2D.setFont(new Font("Roboto", Font.BOLD, 40));
        if(!(playerHand.getHand().equals("UNKNOWN")) && (!(compHand.getCompHand().equals("UNKNOWN")))){
            if(findWinner(playerHand, compHand) == 0){
                page2D.drawString("It's a tie!", 120, 190);
            }
            if(findWinner(playerHand, compHand) > 0){
                page2D.drawString("You lost :(", 120, 190);
            }
            if(findWinner(playerHand, compHand) < 0){
                page2D.drawString("You won :)", 120, 190);
            }
        }

    }
}
