package jpd.hallt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import jpd.hallt.model.Warehouse;


public class Mains extends Application {
	public void start(Stage primaryStage) {
	    try {
	        //final Warehouse warehouse = createWarehouse();
	    		final FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("UI.fxml"));
	        loader.setController(new ViewController());
	        final Parent root = loader.load();
	        final Scene scene = new Scene(root, 600, 600);
	        primaryStage.setTitle("Warehouse Simulation"); 
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    } catch(Exception e) {
	      e.printStackTrace();
	      }
	    }	    
	    /** private Warehouse createWarehouse() {
			// TODO Auto-generated method stub
	    		final Warehouse p = new Warehouse(0, 0);
	    		return p;
		}
		*/
	    
	    public static void main(String[] args) {
			// TODO Auto-generated method stub
	    	launch(args);
	    	}
}

	