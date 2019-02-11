
package personalityquiz;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;


public class Main {

    
    public static void main(String[] args) throws Exception {
        
        UserInterface ui = new UserInterface(new QuestionsContainer());

        SwingUtilities.invokeLater(() -> {
            try {
                UserInterface.createAndShowGui();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
