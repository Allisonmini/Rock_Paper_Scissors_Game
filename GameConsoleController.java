/* Written by Nyein Nyein Aye (Allison)
Independent Mini Game Project 
Creating a GUI using JavaFX, FXML, CSS, and controller-based architecture
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package RockPaperScissors;


import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author nyeinnyeinaye
 */

public class GameConsoleController implements Initializable {
    @FXML
    private BorderPane consolePane;
    
    @FXML
    private ImageView bot;

    @FXML
    private Label computerScore;

    @FXML
    private ImageView human;

    @FXML
    private Button paperBtn;

    @FXML
    private Label playerScore;

    @FXML
    private Label result;

    @FXML
    private Button rockBtn;

    @FXML
    private Button scissorsBtn;
    
    @FXML
    private Label playerTitle;
    
    @FXML
    private Label botTitle;
    
    //@FXML
    //private Label spacer;
    
    @FXML
    private Button resetBtn;
    
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";
    
    private Image gameImage;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        consolePane.setBackground(new Background(new BackgroundFill(Color.YELLOWGREEN, null, null)));
        Font customFont = Font.loadFont(getClass().getResourceAsStream("PressStart2P.ttf"), 15);
        Font btnFont = Font.loadFont(getClass().getResourceAsStream("PressStart2P.ttf"), 10);
        Font resetFont = Font.loadFont(getClass().getResourceAsStream("PressStart2P.ttf"), 8);

        if (customFont != null) {
            playerTitle.setFont(customFont);
            playerScore.setFont(customFont);
            //spacer.setFont(customFont);
            computerScore.setFont(customFont);
            botTitle.setFont(customFont);
            result.setFont(customFont);
            
        } else {
            System.out.println("Failed to load PressStart2P font");
        }
        
        if (btnFont != null) {
            rockBtn.setFont(btnFont);
            paperBtn.setFont(btnFont);
            scissorsBtn.setFont(btnFont);
            resetBtn.setFont(resetFont);
        } else {
            System.out.println("Failed to load PressStart2P font");
        }
        
        // TODO
    }  
    
    public void playerTurn(ActionEvent evt){
        Button clicked = (Button)evt.getSource();
        String playerPick ="";
        
        if(clicked == rockBtn){
            playerPick = ROCK;
            gameImage = new Image(getClass().getResourceAsStream("rock.png"));
            human.setImage(gameImage);
            
        }
        else if(clicked == paperBtn){
            playerPick = PAPER;
            gameImage = new Image(getClass().getResourceAsStream("paper.png"));
            human.setImage(gameImage);
        }
        else {
            playerPick = SCISSORS;
            gameImage = new Image(getClass().getResourceAsStream("scissors.png"));
            human.setImage(gameImage);
            
        }
        computerTurn();
        winner (playerPick, computerTurn());
    

    }
    
    public String computerTurn(){
        String botPick = null;
        int randomPick = (int)(Math.random()*3);
        switch (randomPick){
            case 0:
                gameImage = new Image(getClass().getResourceAsStream("rock.png"));
                botPick = ROCK;
                break;
            case 1:
                gameImage = new Image(getClass().getResourceAsStream("paper.png"));
                botPick = PAPER;
                break;
            case 2:
                gameImage = new Image(getClass().getResourceAsStream("scissors.png"));
                botPick = SCISSORS;
                break;
          
        }
        
        bot.setImage(gameImage);
        return botPick;
    
    }
    
    public void playerWin(){
        result.setText("YOU WIN");
        playerScore.setText(String.valueOf(Integer.parseInt(playerScore.getText())+1));
        
    }
    
    public void playerLose(){
        result.setText("YOU LOSE");
        computerScore.setText(String.valueOf(Integer.parseInt(computerScore.getText())+1));
    }
    
    
    public void winner(String playerPick, String botPick){
        if (playerPick.equals(ROCK) && botPick.equals(SCISSORS)){
            playerWin();      
        }
        else if (playerPick.equals(PAPER)&& botPick.equals(ROCK)){
            playerWin();
        }
        else if (playerPick.equals(SCISSORS) && botPick.equals(PAPER)){
            playerWin();
        }
        
        else if (playerPick.equals(ROCK) && botPick.equals(PAPER)){
            playerLose();
        }
        else if (playerPick.equals(PAPER) && botPick.equals(SCISSORS)){
            playerLose();
            
        }else if (playerPick.equals(SCISSORS) && botPick.equals(ROCK)){
            playerLose();
        }
        
        else
            result.setText("DRAW");
        
    }
    
    @FXML
    public void resetGame(ActionEvent evt) {
        playerScore.setText("0");
        computerScore.setText("0");
        
        result.setText("");
        
        human.setImage(null);
        bot.setImage(null);
    }
}
