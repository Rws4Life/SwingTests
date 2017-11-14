package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class RandomGame extends JFrame {
	
	private int wonGames;
	private int randomNumber, chosenNumber, upperLimit;
	
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem save;
	private JMenuItem load;
	private JMenuItem exit;
	
	private JButton buttonPlay;
	private JButton setUpperLimitButton;
	private JTextField upperLimitTextField;
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
		upperLimitTextField = new JTextField(5);
		add(upperLimitTextField);
		setUpperLimitButton = new JButton("Set upper Limit!");
		add(setUpperLimitButton);
		
		promptLabel = new JLabel("");
		add(promptLabel);
		
		textField = new JTextField(5);
		
		buttonPlay = new JButton("Guess!");
		
		resultLabel = new JLabel("");
		add(resultLabel);
		
		randomLabel = new JLabel("");
		add(randomLabel);
	}
	
	public RandomGame(){
		setLayout(new FlowLayout());
		setMenu();
		setGameGUI();
		
		setUpperLimit s = new setUpperLimit();
		setUpperLimitButton.addActionListener(s);
		
	}
	
	public class exitGame implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
	
	public class loadGame implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	public class saveGame implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	public class setUpperLimit implements ActionListener{
		public void actionPerformed(ActionEvent e){
			upperLimit = (int)(Double.parseDouble(upperLimitTextField.getText()));
			promptLabel.setText("Enter a number between 1 and " + upperLimit);
			
			
			add(textField);
			
			
			add(buttonPlay);
			
			playGame e2 = new playGame();
			buttonPlay.addActionListener(e2);
		}
	}
	
	
	public class playGame implements ActionListener{
		public void actionPerformed(ActionEvent e){
			randomNumber = (int)(Math.random() * upperLimit + 1);
			
			try{
				chosenNumber = (int)(Double.parseDouble(textField.getText()));
				
				if(chosenNumber > upperLimit || chosenNumber < 0){
					resultLabel.setText("Please enter a number between 0 and " + upperLimit);
					randomLabel.setText("");
				}
				else if(chosenNumber == randomNumber){
					resultLabel.setText("You won the game!");
					randomLabel.setText("The random number was: " + randomNumber);
				}
				else if(chosenNumber != randomNumber){
					resultLabel.setText("You lost!");
					randomLabel.setText("The random number was: " + randomNumber);
				}
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
