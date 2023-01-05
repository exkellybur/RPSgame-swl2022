/**
 * RPSDriver: The client class (Driver)
 * driver class with the ability to listen to button clicks
 *
 * @author (Kelly)
 * @version (SWL 2022)
 */

//GUI TOOLS
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Dimension;

public class RPSDriver implements ActionListener
{
    //INSTANCE FIELDS
    TableGUI table;
    JButton btnRock, btnPaper, btnScissors; //declaring buttons
    boolean isPlay = true;

    public static void main(String[] args){
        RPSDriver game = new RPSDriver();
    }

    //find source of mouse click
    public void actionPerformed(ActionEvent ae){
        JButton source = (JButton) ae.getSource();
        if(isPlay == true){
            if(source == btnRock){
                table.chooseHand(0);
                table.chooseCompHand();

            }
            if(source == btnPaper){
                table.chooseHand(1);
                table.chooseCompHand();
            }
            if(source == btnScissors){
                table.chooseHand(2);
                table.chooseCompHand();
            }
        }
        String msg = JOptionPane.showInputDialog(table, "Would you like to play again? (Y/N)");
        if(msg.equalsIgnoreCase("YES") || msg.equalsIgnoreCase("Y")){
            isPlay = true;
        }
        else if(msg.equalsIgnoreCase("NO") || msg.equalsIgnoreCase("N")){
            isPlay = false;
        }
    }

    //default constructor
    public RPSDriver(){
        //setup  window frame
        JFrame frame = new JFrame();
        frame.setTitle("RPS GAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setup a new panel for controlling layout of multiple components 
        //using flow-layout
        table = new TableGUI(); //create instance of table

        //organize buttons
        btnRock = new JButton("ROCK");
        btnPaper = new JButton("PAPER");
        btnScissors = new JButton("SCISSORS");

        //attach listener to buttons
        btnRock.addActionListener(this); //attatch ears to button 
        btnPaper.addActionListener(this); //sharing the listener
        btnScissors.addActionListener(this);

        btnRock.setMaximumSize(btnScissors.getPreferredSize());
        btnPaper.setMaximumSize(btnScissors.getPreferredSize());

        JPanel masterPanel = new JPanel();//default fow layout

        //create a panel just for the buttons
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel,BoxLayout.Y_AXIS));
        btnPanel.add(btnRock);
        btnPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        btnPanel.add(btnPaper);
        btnPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        btnPanel.add(btnScissors);

        masterPanel.add(btnPanel);
        masterPanel.add(table);

        frame.getContentPane().add(masterPanel);

        frame.pack();
        frame.setVisible(true);
    }

}
