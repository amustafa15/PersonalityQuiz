
package personalityquiz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
     
public class ResultsPanel extends JPanel{
    
    private CardLayout layout;
    private CalculateResults results;
    
    public ResultsPanel() throws FileNotFoundException{

        this.layout = new CardLayout();
        this.results = new CalculateResults();
        this.setLayout(layout);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        panel.setBorder(BorderFactory.createLineBorder(Color.RED));
      //  panel.add(new JLabel("no"));
      //  this does not throw up an error
        panel.add(new JLabel(results.getHouseName()));
      // this throws up an error
        JPanel rPanel = new JPanel(layout);
      //  rPanel.add(new JLabel("nop"));
      //  this does not throw up an error
        rPanel.add(new JLabel(results.getHouseDescription()));
      // this throws up an error
        panel.add(rPanel);
        add(panel);
    }
}
