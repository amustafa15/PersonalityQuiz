
package personalityquiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionsContainer {
    
    private List<Questions> questions = new ArrayList<>();
    private List<String> answers;
    private int questionCount = 0; 
    
    public QuestionsContainer() throws FileNotFoundException {
    
        File file = new File("src/house1.txt");
        try (Scanner reader = new Scanner(file)) {
            String question = "";
            answers = new ArrayList<>();
            
            while (reader.hasNextLine()){
                

                String line = reader.nextLine();
                if (line.startsWith("QUESTION: ")) {
                    question = line.substring(10);
                } else if (line.startsWith("ANSWER")){
                    String answer = line.substring(9);
                    answers.add(answer);
                } else if (line.isEmpty()) {
                    questions.add(new Questions(question, answers));
                    question = "";
                    answers = new ArrayList<>();
                    questionCount++;
                }
            }
        }
    }
    public List<Questions> getQuestions() {
        return questions;
    }
    public int getQuestionCount(){
        return questionCount;
    }
    public int questionsLength(){
        return questions.size();
    }
    public void printQuestionCount(){
        System.out.println(questionCount);
    }
}
