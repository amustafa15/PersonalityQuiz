
package personalityquiz;

import java.util.List;

public class Questions {

    private final String question;
    private final List<String> answer;

    Questions(String question, List<String> answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswer() {
        return answer;
    }
}
