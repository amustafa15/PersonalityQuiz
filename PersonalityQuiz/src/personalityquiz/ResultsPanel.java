
package personalityquiz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
     
public class ResultsPanel extends JPanel{
    
    private CardLayout layout;
    
    public ResultsPanel(CalculateResults results) throws FileNotFoundException{

        this.layout = new CardLayout();
        this.setLayout(layout);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        panel.setBorder(BorderFactory.createLineBorder(Color.RED));
        JLabel label = new JLabel(results.getHouseName());
        label.setFont(new Font("Helvetica", Font.BOLD, 18));
        panel.add(label);
        JPanel rPanel = new JPanel(layout);
        JLabel label2 = new JLabel("<html>" + results.getHouseDescription() + "<html>");
        label2.setFont(new Font("Helvetica", Font.BOLD, 12));
        panel.add(label2);
        panel.add(rPanel);
        add(panel);
    }
}
