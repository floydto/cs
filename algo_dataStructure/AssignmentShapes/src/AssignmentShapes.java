
import java.nio.file.FileSystems;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class AssignmentShapes extends Application {

	@Override
	public void start(Stage stage) {

		// text field is created
		TextField shapeField = new TextField();
		shapeField.setMaxWidth(200);

		// add shape number label
		Label shapeLabel = new Label("Enter the number of sides of the shape");
		shapeLabel.setTextFill(Color.BLACK);
		shapeLabel.setFont(Font.font("Arial", 16));

		// add a button to submit sides of shape
		Button shapeButton = new Button();
		shapeButton.setText("create your shape");

		// create a VBox for the components
		VBox root = new VBox(25);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(shapeLabel, shapeField, shapeButton);

		// create a scene and add to stage
		Scene scene = new Scene(root, 600, 600);
		stage.setScene(scene);
		stage.setTitle("Shapes");
		stage.show();
		
		//set Square
		Rectangle square = new Rectangle(100, 100);
		square.setX(100.0f);
		square.setY(100.0f);
		square.setFill(Color.YELLOW);

		//set Pentagon
		Polygon pentagon = new Polygon();
		pentagon.getPoints().addAll(new Double[] {
				110.0, 200.0,
				110.0, 120.0,
				180.0, 70.0,
				240.0, 120.0,
				240.0, 200.0});
		pentagon.setFill(Color.GREEN);

		//set Hexagon
		Polygon hexagon = new Polygon();
		hexagon.getPoints().addAll(new Double[] {
				100.0, 25.0,
				200.0, 25.0,
				225.0, 75.0,
				200.0, 125.0,
				100.0, 125.0,
				75.0, 75.0});
		hexagon.setFill(Color.YELLOW);

		//set Heptagon
		Polygon heptagon = new Polygon();
		heptagon.getPoints().addAll(new Double[] {
				150.0, 12.5,
				200.0, 50.0,
				200.0, 100.0,
				175.0, 125.0,
				125.0, 125.0,
				100.0, 100.0,
				100.0, 50.0
		});
		heptagon.setFill(Color.GREEN);

		//set Octagon
		Polygon octagon = new Polygon();
		octagon.getPoints().addAll(new Double[]{
				125.0, 25.0,
				175.0, 25.0,
				200.0, 50.0,
				200.0, 100.0,
				175.0, 125.0,
				125.0, 125.0,
				100.0, 100.0,
				100.0, 50.0
		});
		octagon.setFill(Color.YELLOW);
		
		//set condition for different shapes
		shapeButton.setOnAction(e -> {
			if (shapeField.getText().isEmpty() == true) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Invalid shape");
				errorAlert.setContentText("Please try number 4-8.");
				errorAlert.showAndWait();
			} else {
			
			int shapeFieldNumber = Integer.parseInt(shapeField.getText());
			int shapeNumber = shapeFieldNumber;
			
			// case if side = 4
			if (shapeNumber == 4) {
				int[] shapesNumber = {shapeFieldNumber};
				// remove the text field and button
				root.getChildren().removeAll(shapeLabel, shapeField, shapeButton);

				// tell the user to enter number of sides
				Label colourLabel = new Label("increase or decrease the number of side(s)");
				colourLabel.setTextFill(Color.BLACK);
				colourLabel.setFont(Font.font("Arial", 16));

				//show current sides of shapes
				Label currentSides = new Label("current sides : " + shapesNumber[0]);
				currentSides.setFont(Font.font("Arial", 16));
				currentSides.setAlignment(Pos.CENTER);
				currentSides.setMaxWidth(200);

				//create a increment and decrement button
				Button incrementButton = new Button("+");
				Button decrementButton = new Button("-");

				//add all elements including the shape
				root.getChildren().addAll(colourLabel, currentSides, incrementButton, decrementButton, square);

				//add button to handle action
				incrementButton.setOnAction(e1 -> {
					if (shapesNumber[0] < 8 ) {
						shapesNumber[0]++;
						currentSides.setText("current sides : " + shapesNumber[0]);
						root.getChildren().removeAll(shapeLabel, shapeField, shapeButton, square, pentagon, hexagon, heptagon, octagon);
						if (shapesNumber[0]== 4) {
							root.getChildren().add(square);
						}
						else if (shapesNumber[0]== 5) {
							root.getChildren().add(pentagon);
						}
						else if (shapesNumber[0]== 6) {
							root.getChildren().add(hexagon);

						} else if (shapesNumber[0]== 7) {
							root.getChildren().add(heptagon);

						} else if (shapesNumber[0]== 8) {
							root.getChildren().add(octagon);
						};
					} else {
						Alert errorAlert = new Alert(AlertType.ERROR);
						errorAlert.setHeaderText("Invalid input.");
						errorAlert.setContentText("The number of sides cannot be greater than 8, Please try again.");
						errorAlert.showAndWait();
					}});

				//add button to handle action
				decrementButton.setOnAction(e1 -> {
					if (shapesNumber[0] > 4 ) {
						shapesNumber[0]--;
						currentSides.setText("current sides : " + shapesNumber[0]);
						root.getChildren().removeAll(shapeLabel, shapeField, shapeButton, square, pentagon, hexagon, heptagon, octagon);
						root.getChildren().removeAll(octagon);
						if (shapesNumber[0]== 4) {
							root.getChildren().add(square);
						}
						else if (shapesNumber[0]== 5) {
							root.getChildren().add(pentagon);
						}
						else if (shapesNumber[0]== 6) {
							root.getChildren().add(hexagon);

						} else if (shapesNumber[0]== 7) {
							root.getChildren().add(heptagon);

						} else if (shapesNumber[0]== 8) {
							root.getChildren().add(octagon);
						};
					} else {
						Alert errorAlert = new Alert(AlertType.ERROR);
						errorAlert.setHeaderText("Invalid input.");
						errorAlert.setContentText("The number of sides cannot be less than 4, Please try again.");
						errorAlert.showAndWait();
					}
				});

				// case if side = 5
			} else if (shapeNumber == 5) {
				int[] shapesNumber = {shapeFieldNumber};
				// remove the text field and button
				root.getChildren().removeAll(shapeLabel, shapeField, shapeButton);

				// tell the user to enter number of sides
				Label colourLabel = new Label("increase or decrease the number of side(s)");
				colourLabel.setTextFill(Color.BLACK);
				colourLabel.setFont(Font.font("Arial", 16));

				//show current sides of shapes
				Label currentSides = new Label("current sides : " + shapesNumber[0]);
				currentSides.setFont(Font.font("Arial", 16));
				currentSides.setAlignment(Pos.CENTER);
				currentSides.setMaxWidth(200);

				//create a increment and decrement button
				Button incrementButton = new Button("+");
				Button decrementButton = new Button("-");

				//add all elements including the shape
				root.getChildren().addAll(colourLabel, currentSides, incrementButton, decrementButton, pentagon);

				//add button to handle action
				incrementButton.setOnAction(e1 -> {
					if (shapesNumber[0] < 8 ) {
						shapesNumber[0]++;
						currentSides.setText("current sides : " + shapesNumber[0]);
						root.getChildren().removeAll(shapeLabel, shapeField, shapeButton, square, pentagon, hexagon, heptagon, octagon);
						if (shapesNumber[0]== 4) {
							root.getChildren().add(square);
						}
						else if (shapesNumber[0]== 5) {
							root.getChildren().add(pentagon);
						}
						else if (shapesNumber[0]== 6) {
							root.getChildren().add(hexagon);

						} else if (shapesNumber[0]== 7) {
							root.getChildren().add(heptagon);

						} else if (shapesNumber[0]== 8) {
							root.getChildren().add(octagon);
						};
					} else {
						Alert errorAlert = new Alert(AlertType.ERROR);
						errorAlert.setHeaderText("Invalid input.");
						errorAlert.setContentText("The number of sides cannot be greater than 8, Please try again.");
						errorAlert.showAndWait();
					}});

				//add button to handle action
				decrementButton.setOnAction(e1 -> {
					if (shapesNumber[0] > 4 ) {
						shapesNumber[0]--;
						currentSides.setText("current sides : " + shapesNumber[0]);
						root.getChildren().removeAll(shapeLabel, shapeField, shapeButton, square, pentagon, hexagon, heptagon, octagon);
						root.getChildren().removeAll(octagon);
						if (shapesNumber[0]== 4) {
							root.getChildren().add(square);
						}
						else if (shapesNumber[0]== 5) {
							root.getChildren().add(pentagon);
						}
						else if (shapesNumber[0]== 6) {
							root.getChildren().add(hexagon);

						} else if (shapesNumber[0]== 7) {
							root.getChildren().add(heptagon);

						} else if (shapesNumber[0]== 8) {
							root.getChildren().add(octagon);
						};
					} else {
						Alert errorAlert = new Alert(AlertType.ERROR);
						errorAlert.setHeaderText("Invalid input.");
						errorAlert.setContentText("The number of sides cannot be less than 4, Please try again.");
						errorAlert.showAndWait();
					}
				});

				// case if side = 6
			} else if (shapeNumber == 6) {
				int[] shapesNumber = {shapeFieldNumber};
				// remove the text field and button
				root.getChildren().removeAll(shapeLabel, shapeField, shapeButton);

				// tell the user to enter number of sides
				Label colourLabel = new Label("increase or decrease the number of side(s)");
				colourLabel.setTextFill(Color.BLACK);
				colourLabel.setFont(Font.font("Arial", 16));

				//show current sides of shapes
				Label currentSides = new Label("current sides : " + shapesNumber[0]);
				currentSides.setFont(Font.font("Arial", 16));
				currentSides.setAlignment(Pos.CENTER);
				currentSides.setMaxWidth(200);

				//create a increment and decrement button
				Button incrementButton = new Button("+");
				Button decrementButton = new Button("-");

				//add all elements including the shape
				root.getChildren().addAll(colourLabel, currentSides, incrementButton, decrementButton, hexagon);

				//add button to handle action
				incrementButton.setOnAction(e1 -> {
					if (shapesNumber[0] < 8 ) {
						shapesNumber[0]++;
						currentSides.setText("current sides : " + shapesNumber[0]);
						root.getChildren().removeAll(shapeLabel, shapeField, shapeButton, square, pentagon, hexagon, heptagon, octagon);
						if (shapesNumber[0]== 4) {
							root.getChildren().add(square);
						}
						else if (shapesNumber[0]== 5) {
							root.getChildren().add(pentagon);
						}
						else if (shapesNumber[0]== 6) {
							root.getChildren().add(hexagon);

						} else if (shapesNumber[0]== 7) {
							root.getChildren().add(heptagon);

						} else if (shapesNumber[0]== 8) {
							root.getChildren().add(octagon);
						};
					} else {
						Alert errorAlert = new Alert(AlertType.ERROR);
						errorAlert.setHeaderText("Invalid input.");
						errorAlert.setContentText("The number of sides cannot be greater than 8, Please try again.");
						errorAlert.showAndWait();
					}});

				//add button to handle action
				decrementButton.setOnAction(e1 -> {
					if (shapesNumber[0] > 4 ) {
						shapesNumber[0]--;
						currentSides.setText("current sides : " + shapesNumber[0]);
						root.getChildren().removeAll(shapeLabel, shapeField, shapeButton, square, pentagon, hexagon, heptagon, octagon);
						root.getChildren().removeAll(octagon);
						if (shapesNumber[0]== 4) {
							root.getChildren().add(square);
						}
						else if (shapesNumber[0]== 5) {
							root.getChildren().add(pentagon);
						}
						else if (shapesNumber[0]== 6) {
							root.getChildren().add(hexagon);

						} else if (shapesNumber[0]== 7) {
							root.getChildren().add(heptagon);

						} else if (shapesNumber[0]== 8) {
							root.getChildren().add(octagon);
						};
					} else {
						Alert errorAlert = new Alert(AlertType.ERROR);
						errorAlert.setHeaderText("Invalid input.");
						errorAlert.setContentText("The number of sides cannot be less than 4, Please try again.");
						errorAlert.showAndWait();
					}
				});

				// case if side = 7
			} else if (shapeNumber == 7) {
				int[] shapesNumber = {shapeFieldNumber};
				// remove the text field and button
				root.getChildren().removeAll(shapeLabel, shapeField, shapeButton);

				// tell the user to enter number of sides
				Label colourLabel = new Label("increase or decrease the number of side(s)");
				colourLabel.setTextFill(Color.BLACK);
				colourLabel.setFont(Font.font("Arial", 16));

				//show current sides of shapes
				Label currentSides = new Label("current sides : " + shapesNumber[0]);
				currentSides.setFont(Font.font("Arial", 16));
				currentSides.setAlignment(Pos.CENTER);
				currentSides.setMaxWidth(200);

				//create a increment and decrement button
				Button incrementButton = new Button("+");
				Button decrementButton = new Button("-");

				//add all elements including the shape
				root.getChildren().addAll(colourLabel, currentSides, incrementButton, decrementButton, heptagon);

				//add button to handle action
				incrementButton.setOnAction(e1 -> {
					if (shapesNumber[0] < 8 ) {
						shapesNumber[0]++;
						currentSides.setText("current sides : " + shapesNumber[0]);
						root.getChildren().removeAll(shapeLabel, shapeField, shapeButton, square, pentagon, hexagon, heptagon, octagon);
						if (shapesNumber[0]== 4) {
							root.getChildren().add(square);
						}
						else if (shapesNumber[0]== 5) {
							root.getChildren().add(pentagon);
						}
						else if (shapesNumber[0]== 6) {
							root.getChildren().add(hexagon);

						} else if (shapesNumber[0]== 7) {
							root.getChildren().add(heptagon);

						} else if (shapesNumber[0]== 8) {
							root.getChildren().add(octagon);
						};
					} else {
						Alert errorAlert = new Alert(AlertType.ERROR);
						errorAlert.setHeaderText("Invalid input.");
						errorAlert.setContentText("The number of sides cannot be greater than 8, Please try again.");
						errorAlert.showAndWait();
					}});

				//add button to handle action
				decrementButton.setOnAction(e1 -> {
					if (shapesNumber[0] > 4 ) {
						shapesNumber[0]--;
						currentSides.setText("current sides : " + shapesNumber[0]);
						root.getChildren().removeAll(shapeLabel, shapeField, shapeButton, square, pentagon, hexagon, heptagon, octagon);
						root.getChildren().removeAll(octagon);
						if (shapesNumber[0]== 4) {
							root.getChildren().add(square);
						}
						else if (shapesNumber[0]== 5) {
							root.getChildren().add(pentagon);
						}
						else if (shapesNumber[0]== 6) {
							root.getChildren().add(hexagon);

						} else if (shapesNumber[0]== 7) {
							root.getChildren().add(heptagon);

						} else if (shapesNumber[0]== 8) {
							root.getChildren().add(octagon);
						};
					} else {
						Alert errorAlert = new Alert(AlertType.ERROR);
						errorAlert.setHeaderText("Invalid input.");
						errorAlert.setContentText("The number of sides cannot be less than 4, Please try again.");
						errorAlert.showAndWait();
					}
				});
				
				// case if side = 8
			} else if (shapeFieldNumber == 8) {
				int[] shapesNumber = {shapeFieldNumber};
				// remove the text field and button
				root.getChildren().removeAll(shapeLabel, shapeField, shapeButton);

				// tell the user to enter number of sides
				Label colourLabel = new Label("increase or decrease the number of side(s)");
				colourLabel.setTextFill(Color.BLACK);
				colourLabel.setFont(Font.font("Arial", 16));

				//show current sides of shapes
				Label currentSides = new Label("current sides : " + shapesNumber[0]);
				currentSides.setFont(Font.font("Arial", 16));
				currentSides.setAlignment(Pos.CENTER);
				currentSides.setMaxWidth(200);

				//create a increment and decrement button
				Button incrementButton = new Button("+");
				Button decrementButton = new Button("-");

				//add all elements including the shape
				root.getChildren().addAll(colourLabel, currentSides, incrementButton, decrementButton, octagon);

				//add button to handle action
				incrementButton.setOnAction(e1 -> {
					if (shapesNumber[0] < 8 ) {
						shapesNumber[0]++;
						currentSides.setText("current sides : " + shapesNumber[0]);
						root.getChildren().removeAll(shapeLabel, shapeField, shapeButton, square, pentagon, hexagon, heptagon, octagon);
						if (shapesNumber[0]== 4) {
							root.getChildren().add(square);
						}
						else if (shapesNumber[0]== 5) {
							root.getChildren().add(pentagon);
						}
						else if (shapesNumber[0]== 6) {
							root.getChildren().add(hexagon);

						} else if (shapesNumber[0]== 7) {
							root.getChildren().add(heptagon);

						} else if (shapesNumber[0]== 8) {
							root.getChildren().add(octagon);
						};
					} else {
						Alert errorAlert = new Alert(AlertType.ERROR);
						errorAlert.setHeaderText("Invalid input.");
						errorAlert.setContentText("The number of sides cannot be greater than 8, Please try again.");
						errorAlert.showAndWait();
					}});

				//add button to handle action
				decrementButton.setOnAction(e1 -> {
					if (shapesNumber[0] > 4 ) {
						shapesNumber[0]--;
						currentSides.setText("current sides : " + shapesNumber[0]);
						root.getChildren().removeAll(shapeLabel, shapeField, shapeButton, square, pentagon, hexagon, heptagon, octagon);
						root.getChildren().removeAll(octagon);
						if (shapesNumber[0]== 4) {
							root.getChildren().add(square);
						}
						else if (shapesNumber[0]== 5) {
							root.getChildren().add(pentagon);
						}
						else if (shapesNumber[0]== 6) {
							root.getChildren().add(hexagon);

						} else if (shapesNumber[0]== 7) {
							root.getChildren().add(heptagon);

						} else if (shapesNumber[0]== 8) {
							root.getChildren().add(octagon);
						};
					} else {
						Alert errorAlert = new Alert(AlertType.ERROR);
						errorAlert.setHeaderText("Invalid input.");
						errorAlert.setContentText("The number of sides cannot be less than 4, Please try again.");
						errorAlert.showAndWait();
					}
				});
				//add error box 
			} else {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Invalid shape");
				errorAlert.setContentText("Please try number 4-8.");
				errorAlert.showAndWait();
				}
			}});
		}
	
	public static void main(String[] args) {
		launch(args);
	}
}