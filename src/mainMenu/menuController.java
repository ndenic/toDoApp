package mainMenu;

import com.jfoenix.controls.*;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class menuController implements Initializable{

    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXButton addtask;
    
    @FXML
    private JFXHamburger hamburger;
    
    @FXML
    private JFXDrawer drawer;
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
   
        
    try{    
        VBox vbox = FXMLLoader.load(getClass().getResource("slideMenu.fxml"));
        
        drawer.setSidePane(vbox);
        
        for(Node node : vbox.getChildren()){
            if(node.getAccessibleText()!= null){
                node.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
                    switch(node.getAccessibleText()){
                        case "close": System.exit(0);
                            break;
                        case "add":
                    {
                        try {
                            AnchorPane pane = FXMLLoader.load(getClass().getResource("addTask.fxml"));
                            anchor.getChildren().setAll(pane);
                        } catch (IOException ex) {
                            Logger.getLogger(menuController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                            break;
                        case "all":
                    {
                        try {
                            AnchorPane pane = FXMLLoader.load(getClass().getResource("allTasks.fxml"));
                            anchor.getChildren().setAll(pane);
                        } catch (IOException ex) {
                            Logger.getLogger(menuController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                            break;     
                    }
                });
            }
        }
        
        
        HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(hamburger);
        burgerTask.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            burgerTask.setRate(burgerTask.getRate()* -1);
            burgerTask.play();
            
            if(drawer.isShown()){ //why d fuk is this happenig ?? 
                drawer.close();
            }else {
                drawer.open();
            }
        });
    }
    catch (Exception e) {
    
    }
  }
   
}
