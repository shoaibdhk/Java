import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HackerChallenge extends JFrame
{
    public static void main (String[] args){

        // Choice is either 0, 1 or -1
        int choice;
        do {
	        choice=
	        JOptionPane.showConfirmDialog(null, "Are you 21 years of age or older?", "Age Verification", JOptionPane.YES_NO_OPTION);
	        switch (choice)
	        {
	            case JOptionPane.YES_OPTION:
	                // Adult
	                JOptionPane.showMessageDialog(null, "Proceed on adult", "you are an adult", JOptionPane.INFORMATION_MESSAGE);
	
	                break;
	            case JOptionPane.NO_OPTION:
	                //Minor
	                JOptionPane.showMessageDialog(null, "You shall not pass", "Minor Detected", JOptionPane.ERROR_MESSAGE);
	                break;
	            case JOptionPane.DEFAULT_OPTION:
	                //Aversion
	                JOptionPane.showMessageDialog(null, "You must ask the question", "Aversion Detected", JOptionPane.ERROR_MESSAGE);
	        }
        } while (choice == JOptionPane.DEFAULT_OPTION);

    }
}
