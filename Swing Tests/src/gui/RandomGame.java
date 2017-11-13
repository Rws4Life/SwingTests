package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class RandomGame extends JFrame {
	
	private int wonGames;
	
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem save;
	private JMenuItem load;
	private JMenuItem exit;
	
	
	private int randomNumber, chosenNumber;
	private JButton button;
	private JTextField textField;
	private JLabel promptLabel;
	private JLabel resultLabel;
	private JLabel randomLabel;
	
	public void setMenu(){
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		file = new JMenu("File");
		menuBar.add(file);
		
		save = new JMenuItem("Save");
		file.add(save);
		load = new JMenuItem("Load");
		file.add(load);
		exit = new JMenuItem("Exit");
		file.add(exit);
	}
	
	public void setGameGUI(){
		promptLabel = new JLabel("Enter a number between 1 and 10");
		add(promptLabel);
		
		textField = new JTextField(5);
		add(textField);
		
		button = new JButton("Guess!");
		add(button);
		
		resultLabel = new JLabel("");
		add(resultLabel);
		
		randomLabel = new JLabel("");
		add(randomLabel);
	}
	
	public RandomGame(){
		setLayout(new FlowLayout());
		setMenu();
		setGameGUI();
		playGame e = new playGame();
		button.addActionListener(e);
	}
	
	
	public class playGame implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			randomNumber = (int)(Math.random() * 10 + 1);
			
			try{
				chosenNumber = (int)(Double.parseDouble(textField.getText()));
				
				if(chosenNumber == randomNumber){
					resultLabel.setText("You won the game!");
				}
				else if(chosenNumber != randomNumber){
					resultLabel.setText("You lost!");
				}
				randomLabel.setText("The random number was: " + randomNumber);
			}
			catch (Exception ex){
				randomLabel.setText("Please enter numbers only!");
			}
			
		}
	}
	
	
	
	
	public static void main(String[] args) {
		RandomGame rgame = new RandomGame();
		rgame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rgame.setVisible(true);
		rgame.setSize(300, 150);
		rgame.setTitle("Random Number Game");
	}

}
