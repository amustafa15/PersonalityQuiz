package personalityquiz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class UserInterface extends JPanel {
    public static final Object QUESTION = "question";
    private JLabel resultLabel = new JLabel(String.format("%150s", " "));

    private CardLayout cardLayout = new CardLayout();
    private JPanel centerPanel = new JPanel(cardLayout);
    private JPanel resultsPanel = new JPanel(cardLayout);
    private List<String> answers = new ArrayList<>();
    private int currentCard = 0; 
    private QuestionsContainer containers;
    private CalculateResults calculate;
    private AnswerLists answersList;
    private ResultsContainer rContainer = new ResultsContainer();
    private JLayeredPane layeredPane = new JLayeredPane();
    
    public UserInterface(QuestionsContainer container) throws FileNotFoundException {

        this.answersList = new AnswerLists();
        this.calculate = new CalculateResults();
        this.containers = new QuestionsContainer();

        setLayout(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        for (Questions question : container.getQuestions()) {
            centerPanel.add(createQPanel(question), null);
        }
        add(centerPanel);
        
        JPanel navigationPane = new JPanel(new GridBagLayout());
        navigationPane.setBorder(new EmptyBorder(8, 8, 8, 8));
        JButton navButton = new JButton("Next");
        navButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {  
                if (evt.getActionCommand().equals("Next")) {
                    currentCard++;
                    if (currentCard == container.questionsLength() - 1) {
                        ((JButton) evt.getSource()).setText("Get results");
                    }
                    cardLayout.next(centerPanel);
                } 
                else {
                        System.out.println(calculate.returnScores());
                        System.out.println(calculate.calculateAnswers());
                        // to test that they're being recorded correctly. they are
                    try {
                        System.out.println(calculate.getHouseName());
                        System.out.println(calculate.getHouseDescription());
                        // the right answers are getting printed here but not to the 
                        // JLabels in the ResultsContainer class
                        switchPanels(resultsPanel);
                        
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                }
            }
        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 1;
        navigationPane.add(navButton, gbc);
        add(navigationPane, BorderLayout.SOUTH);
    }
    private JPanel createResultsPanel() throws FileNotFoundException{
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.RED));
    //    panel.add(new JLabel(calculate.getHouseName()));
        JPanel rPanel = new JPanel(new BorderLayout());
    //    rPanel.add(new JLabel(calculate.getHouseDescription()));
        panel.add(rPanel);
        return panel;
    }
    // tried this instead of the ResultsPanel() class. same result. 
    
    private JPanel createQPanel(Questions question) {
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        radioPanel.add(new JLabel(question.getQuestion()), BorderLayout.PAGE_START);
        ButtonGroup buttonGroup = new ButtonGroup();

        for (String answer : question.getAnswer()) {
            JRadioButton answerButton = new JRadioButton(answer);

            answerButton.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    JRadioButton source = (JRadioButton) e.getSource();

                    if (e.getSource() instanceof JRadioButton){
                        JRadioButton btn = (JRadioButton) e.getSource();
                        String answer = btn.getText();
                        calculate.addResultString(answer);
                }
                }
            });
            
            buttonGroup.add(answerButton);

            radioPanel.add(answerButton);
        }

        JPanel qPanel = new JPanel(new BorderLayout());
        qPanel.add(radioPanel);
        return qPanel;
    }

    public void displayResult(String selectedText) {
        resultLabel.setText(selectedText);
    }
    public void switchPanels(JPanel panel) throws FileNotFoundException{
        centerPanel.removeAll();
        centerPanel.add(new ResultsPanel());
        centerPanel.repaint();
        centerPanel.validate();
    }
    public static void createAndShowGui() throws FileNotFoundException {

        UserInterface mainPanel = new UserInterface(new QuestionsContainer());
        ResultsPanel rPanel = new ResultsPanel();
        CardLayout layouts = new CardLayout();
        JPanel p = new JPanel();
        p.add(rPanel);
        p.setVisible(true);
        JFrame frame = new JFrame("User Interface");
        frame.setLayout(layouts);
        frame.getContentPane().add(mainPanel);
        frame.getContentPane().add(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    //    layouts.show(frame.getContentPane(), "Results");
        frame.pack();
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
    }
}


