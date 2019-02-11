
package personalityquiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AnswerLists {
   
    private List<String> starkResults;
    private List<String> lannisterRestults;
    private List<String> baratheonResults;
    private List<String> targaryanResults;
    
    public AnswerLists() throws FileNotFoundException{
        
        this.starkResults = new ArrayList<>(); 
        this.lannisterRestults = new ArrayList<>();
        this.baratheonResults = new ArrayList<>();
        this.targaryanResults = new ArrayList<>();
        
        File file = new File("src/house1.txt");
        try(Scanner reader = new Scanner(file)){
            
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                
                if (line.startsWith("ANSWER0: ")){
                    String answer = line.substring(9);
                    this.starkResults.add(answer);
                } else if (line.startsWith("ANSWER1: ")){
                    String answer = line.substring(9);
                    this.lannisterRestults.add(answer);
                } else if (line.startsWith("ANSWER2: ")){
                    String answer = line.substring(9);
                    this.baratheonResults.add(answer);
                } else if (line.startsWith("ANSWER3: ")){
                    String answer = line.substring(9);
                    this.targaryanResults.add(answer);
                }
            }
            
        }
    }
    public List getStarkRestuls(){
        return this.starkResults;
    }
    public List getLannisterResults(){
        return this.lannisterRestults;
    }
    public List getBaratheonResults(){
        return this.baratheonResults;
    }
    public List getTargaryanResults(){
        return this.targaryanResults;
    }
}
