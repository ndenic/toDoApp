package mainMenu;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main_Class extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
      
        AnchorPane root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
       
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
