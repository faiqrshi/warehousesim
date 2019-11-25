package jpd.hallt;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import jpd.hallt.model.Orders;
import jpd.hallt.model.PackingStation;
import jpd.hallt.model.Robot;
import jpd.hallt.model.Shelf;

public class SimuController {
		private int tick;
		private List<Robot> robots;
		private List<PackingStation> packStations;
		private List<Shelf> shelves;
		@FXML private GridPane grid;
		@FXML private Pane gridPos;
		@FXML private ListView<Robot> listRobot;
		@FXML private ListView<PackingStation> listStation;
		@FXML private ListView<Orders> assignedO, unassignedO, dispatchedO;
		@FXML private Button oneTick, tenTicks, goToEnd, returnButton; 
		
		
		
		public SimuController(GridPane grid, List<Robot> robots, List<PackingStation> packStation) {
			this.grid = grid;
		}
		
		public void initialize() {
			gridPos.getChildren().add(grid);
		}
		public void oneTickPressed() {
			
		}
		
		public void tenTicksPressed() {
			
		}
		
		public void goToEndPressed() {
			
		}
		
		public void returnButtonPressed() {
			
		}
}
