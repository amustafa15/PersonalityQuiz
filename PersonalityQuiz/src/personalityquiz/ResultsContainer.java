
package personalityquiz;


import java.awt.CardLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JPanel;

public class ResultsContainer extends JPanel{
    
    private Results result = new Results();
    private List<Results> resultList = new ArrayList<>();
    private Map<String, String> results;
    private CardLayout cardLayout = new CardLayout();
    private JPanel centerPanel = new JPanel(cardLayout);

    
    public ResultsContainer() throws FileNotFoundException{
        
        File file = new File("src/results.txt");
        try (Scanner reader = new Scanner(file)){
            String houseName = "";
            String houseResults = "";
            this.results = new HashMap<>(); 
            
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                if (line.contains(":")){
                    String[] resultSplit = line.split("\\: ");
                    houseName = resultSplit[0];
                    houseResults = resultSplit[1];
                    this.results.put(houseName, houseResults);
                }
                this.result = new Results();
                if (line.isEmpty()){
                    resultList.add(new Results());
                    this.results.put(houseName, houseResults);
                    houseName = "";
                    houseResults = "";
                }
            }
            
        }
    }
    public String getStarkHouseName(){
        return "House Stark";
    }
    public String getHouseStarkResults(){
        return this.results.get("STARK");
    }
    public String getLannisterHouseName(){
        return "House Lannister";
    }
    public String getLannisterResults(){
        return this.results.get("LANNISTER");
    }
    public String getBaratheonHouseName(){
        return "House Baratheon";
    }
    public String getBaratheonResults(){
        return this.results.get("BARATHEON");
    }
    public String getTargaryanHouseName(){
        return "House Targaryan";
    }
    public String getTargaryanResults(){
        return this.results.get("TARGARYAN");
    }
}
