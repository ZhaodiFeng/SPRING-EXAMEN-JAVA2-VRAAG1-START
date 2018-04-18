package edu.ap.spring.view;

import edu.ap.spring.model.EightBall;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class UI implements InitializingBean {
	@Autowired
	EventHandler eventHandler;
	@Autowired
	EightBall eightBall;

	private JFrame jFrame;
	private JLabel labelQuestion, labelAvailableAnswers,labelAnswer,labelScore;
	private JTextField question;
	private JPanel controlPanel;
	private JButton btnAsk;
	private int availableAnswer;

	public UI() {}

	public void setupUI() {
		jFrame = new JFrame("Magic 8 Balls");
		jFrame.setLayout(new FlowLayout());
		availableAnswer=eightBall.getAnswers().length;

		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(5, 4));

		labelQuestion = new JLabel("What's your question?");
		question = new JTextField(15);
		question.setDragEnabled(true);

		labelAvailableAnswers = new JLabel(availableAnswer+" balls available.");
		labelAnswer=new JLabel(" ");
		labelScore=new JLabel(" ");

		btnAsk = new JButton();
		btnAsk.setText("Ask");
		btnAsk.setTransferHandler(new TransferHandler("text"));
		btnAsk.addActionListener(eventHandler::whenBtnAskClicked);

		controlPanel.add(labelQuestion);
		controlPanel.add(question);
		controlPanel.add(labelAvailableAnswers);
		controlPanel.add(labelAnswer);
		controlPanel.add(labelScore);
		controlPanel.add(btnAsk);
		jFrame.add(controlPanel);

		jFrame.setSize(800, 800);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}

	public EventHandler getEventHandler() {
		return eventHandler;
	}

	public void setEventHandler(EventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}

	public EightBall getEightBall() {
		return eightBall;
	}

	public void setEightBall(EightBall eightBall) {
		this.eightBall = eightBall;
	}

	public JFrame getjFrame() {
		return jFrame;
	}

	public void setjFrame(JFrame jFrame) {
		this.jFrame = jFrame;
	}

	public JLabel getLabelQuestion() {
		return labelQuestion;
	}

	public void setLabelQuestion(JLabel labelQuestion) {
		this.labelQuestion = labelQuestion;
	}

	public JLabel getLabelAvailableAnswers() {
		return labelAvailableAnswers;
	}

	public void setLabelAvailableAnswers(JLabel labelAvailableAnswers) {
		this.labelAvailableAnswers = labelAvailableAnswers;
	}

	public JLabel getLabelAnswer() {
		return labelAnswer;
	}

	public void setLabelAnswer(JLabel labelAnswer) {
		this.labelAnswer = labelAnswer;
	}

	public JLabel getLabelScore() {
		return labelScore;
	}

	public void setLabelScore(JLabel labelScore) {
		this.labelScore = labelScore;
	}

	public JTextField getQuestion() {
		return question;
	}

	public void setQuestion(JTextField question) {
		this.question = question;
	}

	public JPanel getControlPanel() {
		return controlPanel;
	}

	public void setControlPanel(JPanel controlPanel) {
		this.controlPanel = controlPanel;
	}

	public JButton getBtnAsk() {
		return btnAsk;
	}

	public void setBtnAsk(JButton btnAsk) {
		this.btnAsk = btnAsk;
	}

	public int getAvailableAnswer() {
		return availableAnswer;
	}

	public void setAvailableAnswer(int availableAnswer) {
		this.availableAnswer = availableAnswer;
	}
}
