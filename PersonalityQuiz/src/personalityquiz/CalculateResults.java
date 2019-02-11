package personalityquiz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculateResults {
    
    private List<String> answers = new ArrayList<>(); 
    private CardLayout cardLayout = new CardLayout(); 
    private JPanel centerPanel = new JPanel(cardLayout);
    private AnswerLists lists;
    private List<String> scores = new ArrayList<>();
    private Results result;
    private ResultsContainer rContainer;
        
    public CalculateResults() throws FileNotFoundException{
        this.rContainer = new ResultsContainer();
        this.lists = new AnswerLists();
        this.scores = new ArrayList<>();
        
    }
    public void addResultString(String answer){
        answers.add(answer);
    }
    public List printResults(){
        return answers;
    }
    public List getScores(){
        return this.scores;
    }
    public String calculateAnswers(){
        
        Map<String, Integer> freq = new HashMap<>();
        for (String s : this.scores){
            Integer count = freq.get(s);
            if (count == null){
                freq.put(s, 1);
            } else {
                freq.put(s, count + 1);
            }
        }
        int maxValueInMap = (Collections.max(freq.values()));
        // when assigning getHouseName() or getHouseDescription() it throws up a 
        // No such element inspection on this line. i guess it's empty
        for (Entry<String, Integer> entry : freq.entrySet()){
            if (entry.getValue()==maxValueInMap){
                return entry.getKey();
            }
        }
        return "";
    }
    public JPanel createPanel() throws FileNotFoundException{
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        panel.add(new JLabel(getHouseName()));
        JPanel qPanel = new JPanel(new BorderLayout());
        panel.add(new JLabel(getHouseDescription()));
        qPanel.add(panel);
        return qPanel;
    }
    public String getHouseName() throws FileNotFoundException{
        ResultsContainer container = new ResultsContainer();
      //  String houseName;
        if (calculateAnswers().equals("t")){
            return container.getTargaryanHouseName();
        } else if (calculateAnswers().equals("s")){
            return container.getStarkHouseName();
        } else if (calculateAnswers().equals("l")){
            return container.getLannisterHouseName();
        } else if (calculateAnswers().equals("b")){
            return container.getBaratheonHouseName();
        }
       return "";
    }
    public String getHouseDescription() throws FileNotFoundException{
        
//        String houseResults;
        ResultsContainer container = new ResultsContainer();
        if (calculateAnswers().equals("s")){
            return container.getHouseStarkResults();
        } else if (calculateAnswers().equals("l")){
            return container.getLannisterResults();
        } else if (calculateAnswers().equals("t")){
            return container.getTargaryanResults();
        } else if (calculateAnswers().equals("b")){
            return container.getBaratheonResults();
        }
        return "";
    }
    public void starkAnswerCheck(){
        int i = 0; 
        while (answers.size() == lists.getStarkRestuls().size() && i < lists.getStarkRestuls().size()){
            if (answers.get(i).equals(lists.getStarkRestuls().get(i))){
                this.scores.add("s");
                i++;
            } else {
                i++;
             }
        }
    }
    public void lannisterAnswerCheck(){
        int i = 0; 
        while (answers.size() == lists.getLannisterResults().size() && i < lists.getStarkRestuls().size()){
            if (answers.get(i).equals(lists.getLannisterResults().get(i))){
                this.scores.add("l");
                i++;
            } else {
                i++;
             }
        }
    }
    public void baratheonAnswerCheck(){
        int i = 0; 
        while (answers.size() == lists.getBaratheonResults().size() && i < lists.getStarkRestuls().size()){
            if (answers.get(i).equals(lists.getBaratheonResults().get(i))){
                this.scores.add("b");
                i++;
            } else {
                i++;
             }
        }
    }
    public void targaryanAnswerCheck(){
        int i = 0; 
        while (answers.size() == lists.getTargaryanResults().size() && i < lists.getStarkRestuls().size()){
            if (answers.get(i).equals(lists.getTargaryanResults().get(i))){
                this.scores.add("t");
                i++;
            } else {
                i++;
             }
        }
    }
    public List returnScores(){
        starkAnswerCheck();
        lannisterAnswerCheck();
        baratheonAnswerCheck();
        targaryanAnswerCheck();       
        return this.scores; 
    }
}
