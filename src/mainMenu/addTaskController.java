/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainMenu;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author nikol
 */
public class addTaskController implements Initializable{

    @FXML
    private JFXHamburger hamburger1;
    
    @FXML
    private JFXDrawer drawer1;
    
    @FXML
    private JFXButton tipBtn;
    
    @FXML
    private AnchorPane addTask;
    
    @FXML
    private StackPane stackPane;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //DODAJ OSTATAK IZ menuControllera for petlja itd ..
        try {
            VBox vbox = FXMLLoader.load(getClass().getResource("slideMenu.fxml"));
            
            drawer1.setSidePane(vbox);
            
             for(Node node : vbox.getChildren()){
            if(node.getAccessibleText()!= null){
                node.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
                    switch(node.getAccessibleText()){
                        case "close": System.exit(0);
                            break;
                        case "all":
                    {
                        try {
                            AnchorPane pane = FXMLLoader.load(getClass().getResource("allTasks.fxml"));
                            addTask.getChildren().setAll(pane);
                        } catch (IOException ex) {
                            Logger.getLogger(menuController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                            break;
                           
                    }
                });
            }
        }
            
            
            
            HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(hamburger1);
            burgerTask.setRate(-1);
            hamburger1.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burgerTask.setRate(burgerTask.getRate()* -1);
                burgerTask.play();
                
                if(drawer1.isShown()){
                    drawer1.close();
                }else {
                    drawer1.open();
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(addTaskController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void dialog(ActionEvent e){
        
        
        
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Advice"));
        content.setBody(new Text("Here you have three diffrent colors to choose.My suggestion is to\n"                 
                + "use RED for  something that you need to do right away.\n"
                + "BLUE is like medium priority and last one is GREEN for least needed."));
        JFXDialog dlg = new JFXDialog(stackPane,content,JFXDialog.DialogTransition.CENTER);
        JFXButton btn = new JFXButton("Sir yes sir!");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dlg.close();
            }
        });
        content.setActions(btn);
        
        dlg.show();
        
    }
    
}
