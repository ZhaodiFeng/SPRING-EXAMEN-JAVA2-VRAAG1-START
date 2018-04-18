package edu.ap.spring.view;


import edu.ap.spring.jpa.QuestionRepository;
import edu.ap.spring.model.EightBall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;

@Service
public class EventHandler {
    @Autowired
    private UI ui;
    @Autowired
    private EightBall eightBall;


    public void whenBtnAskClicked(ActionEvent actionEvent) {
        String question=ui.getQuestion().getText();
        String answer=eightBall.getRandomAnswer(question);

        ui.getLabelAnswer().setText(answer);
        ui.setAvailableAnswer(eightBall.getAvailableAnswers());
        ui.getLabelAvailableAnswers().setText(ui.getAvailableAnswer()+" balls available.");
    }
}
