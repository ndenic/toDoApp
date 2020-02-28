package mainMenu;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class allTaskController implements Initializable{

    @FXML
    private JFXHamburger hamburger2;
    
    @FXML
    private JFXDrawer drawer2;
    
    @FXML
    private AnchorPane anchor2;
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            VBox vbox = FXMLLoader.load(getClass().getResource("slideMenu.fxml"));
            
            drawer2.setSidePane(vbox);
            
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
                            anchor2.getChildren().setAll(pane);
                        } catch (IOException ex) {
                            Logger.getLogger(menuController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                            break;
                           
                    }
                });
            }
        }
            
            
            
            HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(hamburger2);
            burgerTask.setRate(-1);
            hamburger2.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burgerTask.setRate(burgerTask.getRate()* -1);
                burgerTask.play();
                
                if(drawer2.isShown()){
                    drawer2.close();
                }else {
                    drawer2.open();
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(addTaskController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
