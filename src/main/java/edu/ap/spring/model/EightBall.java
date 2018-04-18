package edu.ap.spring.model;

import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EightBall {
    @Autowired
    private QuestionRepository questionRepository;

    public  int getAvailableAnswers(){
        return (int) (answers.length-questionRepository.count());
    }
    private String[] answers = {"It is certain",
            "Yes definitely",
            "Most likely",
            "Outlook good",
            "Better not tell you now",
            "Cannot predict now",
            "Don't count on it",
            "Outlook not so good"};

    public String getRandomAnswer(String question) {
        if(questionRepository.count()>=answers.length)
            questionRepository.deleteAll();
        String answer="";
        Question existsAnswer=questionRepository.findByQuestion(question);
        if(existsAnswer!=null){
            answer=existsAnswer.getAnswer();
        }
        else {
            answer=answers[new Random().nextInt(answers.length)];
            while (questionRepository.existsByAnswer(answer)){
                answer=answers[new Random().nextInt(answers.length)];
            }
            questionRepository.save(new Question(question,answer));
        }
        return answer;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }
}
