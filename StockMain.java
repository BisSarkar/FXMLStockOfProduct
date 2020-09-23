
package stockofproducts;
import javafx.application.Application; 
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene; 
import javafx.stage.Stage; 
 

 public class StockMain extends Application {
 
     
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Stock.fxml"));
        stage.setTitle("Stock Of Products");
   
        stage.setScene(new Scene(root));
        stage.show();
  
    }
}




