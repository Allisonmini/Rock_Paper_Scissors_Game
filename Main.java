/* Written by Nyein Nyein Aye (Allison)
Independent Mini Game Project 
Creating a GUI using JavaFX, FXML, CSS, and controller-based architecture

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RockPaperScissors;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nyeinnyeinaye
 */
public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{ 
            
            Parent startRoot = FXMLLoader.load(getClass().getResource("GameStarter.fxml"));
            primaryStage.setTitle("Rock, Paper, Scissors Game");
            primaryStage.setScene(new Scene(startRoot));
            primaryStage.show();    
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
}
