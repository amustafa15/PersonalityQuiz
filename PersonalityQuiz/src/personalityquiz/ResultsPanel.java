
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
        panel.add(new JLabel("no"));
        JPanel rPanel = new JPanel(layout);
        rPanel.add(new JLabel("nop"));
        panel.add(rPanel);
        add(panel);
    }
}
