package jpd.hallt;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jpd.hallt.model.PackingStation;
import jpd.hallt.model.Robot;
import jpd.hallt.model.Warehouse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;


public class ViewController {
	
	private Scanner scanner;
	private ListProperty<Robot> robots;
	private ListProperty<PackingStation> packStation;
	private Warehouse warehouse;
	
	@FXML private Slider hSlider, wSlider, capSlider, chargeSlider;
	@FXML private Button robot, shelf, station, delete, clear, load, save, start;
	@FXML private TextField orderField, orderArea;
	@FXML private GridPane grid, grid2;
	@FXML private Label hLabel, wLabel, capLabel, chargeLabel;
		  
		  
	
	public ViewController() {
		robots = new SimpleListProperty<Robot>(FXCollections.observableArrayList());
		packStation = new SimpleListProperty<PackingStation>(FXCollections.observableArrayList());
	}
	
	public void initialize() {
			grid2 = new GridPane();
			
			
			hSlider.valueProperty().addListener(new ChangeListener <Number>() {
				public void changed(ObservableValue<? extends Number> ov,
						Number old_val, Number new_val) {
						hLabel.setText("Height: " + new_val.intValue());
				}
			});
			wSlider.valueProperty().addListener(new ChangeListener <Number>() {
				public void changed(ObservableValue<? extends Number> ov,
						Number old_val, Number new_val) {
						wLabel.setText("Width: " + new_val.intValue());
		}
	});
			capSlider.valueProperty().addListener(new ChangeListener <Number>() {
				public void changed(ObservableValue<? extends Number> ov,
						Number old_val, Number new_val) {
						capLabel.setText("Capacity: " + new_val.intValue());
		}
	});
			chargeSlider.valueProperty().addListener(new ChangeListener <Number>() {
				public void changed(ObservableValue<? extends Number> ov,
						Number old_val, Number new_val) {
						chargeLabel.setText("Charge Speed: " + new_val.intValue());
		}
	});
		
	}
			
	public void robotPressed() {
		 grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent click) {
			    int col = (int) Math.floor(click.getX()/50);
				int row = (int) Math.floor(click.getY()/50);
				Circle circle = new Circle();
				circle.setRadius(22.5);
				circle.setFill(Color.RED);
				circle.toBack();
				Rectangle charger = new Rectangle(40, 22.5, 20, 20);
				charger.toFront();
				charger.fillProperty();
			    grid.add(circle, col, row);	
			    grid.add(charger, col, row);
			    String id = "robot";
				double capacity = capSlider.getValue();
				double charge = chargeSlider.getValue();
			    Robot robot = new Robot(id, col, row, capacity, charge);
				robots.add(robot);
				} 
		});
		
	}
	
	public void shelfPressed() {
		grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent click) {
			    int col = (int) Math.floor(click.getX()/50);
				int row = (int) Math.floor(click.getY()/50);
				Rectangle shelf = new Rectangle(40, 22.5, 20, 20);
			    shelf.setFill(Color.DARKGREEN);
			    grid.add(shelf, col, row);	
			    
			} 
				
		}); 
	
	} 
	
	public void stationPressed() {
		grid.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent click) {
				int col = (int) Math.floor(click.getX() / 45);
				int row = (int) Math.floor(click.getY() / 45);
				Rectangle station = new Rectangle(40, 22.5, 20, 20);
			    station.setFill(Color.DARKGRAY);
			    grid.add(station, col, row);		
				
			}
		}); 
	
	}
	
	public void startPressed() {
		final FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SimUI.fxml"));
        final SimuController controller = new SimuController(grid, robots, packStation);
        loader.setController(controller);
        try {
        		final Parent parent = (Parent) loader.load();
            final Stage simStage = new Stage();
            simStage.initModality(Modality.APPLICATION_MODAL);
            simStage.setTitle("Warehouse Simulation"); 
            simStage.setScene(new Scene(parent));
            simStage.showAndWait();
        } catch(Exception e) {
          e.printStackTrace();
          }
        }
	
	public void generatePressed() {
		
	}
	
	public void savePressed() {
		
	}
	
	public void deletePressed() {
	
	}
	
	public void clearPressed() {
		Node node = grid.getChildren().get(0);
		grid.getChildren().clear();
		grid.getChildren().add(0, node);
	}
	
	public void loadPressed() throws FileNotFoundException {
		FileChooser chooser = new FileChooser();
		chooser.getExtensionFilters().add(
				new FileChooser.ExtensionFilter("SIM", "*.sim"));
		chooser.setTitle("Pick File");
		File file = chooser.showOpenDialog(grid.getScene().getWindow());
		scanner = new Scanner(file);
	}
	
	
	
}


