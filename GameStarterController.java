/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package RockPaperScissors;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nyeinnyeinaye
 */
public class GameStarterController implements Initializable {
    
   @FXML
   private Button letsPlay;
   
   @FXML
   private Pane pane;
   
   @FXML
   private Label title1;
   
   private Scene scene;
   private Stage stage;
   private Parent root;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane.setBackground(new Background(new BackgroundFill(Color.YELLOWGREEN, null, null)));
        
        // Load and apply the custom font
        Font customFont = Font.loadFont(getClass().getResourceAsStream("PressStart2P.ttf"), 20);
        Font btnFont = Font.loadFont(getClass().getResourceAsStream("PressStart2P.ttf"), 15);

        if (customFont != null) {
            title1.setFont(customFont);
            letsPlay.setFont(btnFont);
        } else {
            System.out.println("Failed to load PressStart2P font");
        }
    }
    
    public void startPlay(ActionEvent evt){
         try {
            root = FXMLLoader.load(getClass().getResource("GameConsole.fxml"));
            stage = (Stage)((Node)evt.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            // TODO
        } catch (IOException ex) {
            Logger.getLogger(GameStarterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
