
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
	
	 public static void main(String[] args) {

	        launch(args);

	    }
	 
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

        //set condition for different shapes 
        shapeButton.setOnAction(e -> {
        	int shapeFieldNumber = Integer.parseInt(shapeField.getText());
            int shapeNumber = shapeFieldNumber;
            
            
        	// case if side = 4
            // draw rectangle
        	if (shapeNumber == 4) {
        		int[] shapesNumber = {shapeFieldNumber};
        		Rectangle square = new Rectangle(100, 100);
        		square.setX(100.0f);
        		square.setY(100.0f);
        		square.setFill(Color.YELLOW);

                // display rectangle
                root.getChildren().add(square);

                // remove the text field and button
                root.getChildren().removeAll(shapeLabel, shapeField, shapeButton);

                // tell the user to enter a colour
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

                root.getChildren().addAll(colourLabel, currentSides, incrementButton, decrementButton);
                
                // colour shape
                incrementButton.setOnAction(e1 -> {
                	if (shapesNumber[0] < 8 ) {
                		shapesNumber[0]++;
                		currentSides.setText("current sides : " + shapesNumber[0]);
                }});
                
                decrementButton.setOnAction(e1 -> {
                	if (shapesNumber[0] > 4 ) {
                		shapesNumber[0]--;
                		currentSides.setText("current sides : " + shapesNumber[0]);
                }});
             
        		} else if (shapeNumber == 5) {
        			// case if side = 5
        			Polygon pentagon = new Polygon();
        			pentagon.getPoints().addAll(new Double[] {
                			110.0, 200.0, 
                			110.0, 120.0, 
                			180.0, 70.0, 
                			240.0, 120.0, 
                			240.0, 200.0});
                	pentagon.setFill(Color.GREEN);

                    // display pentagon
                    root.getChildren().add(pentagon);

                    // remove the text field and button
                    root.getChildren().removeAll(shapeLabel, shapeField, shapeButton);

                    // tell the user to enter a colour
                    // add a label so user knows what is going on
                    Label colourLabel = new Label("increase or decrease the number of side(s)");
                    colourLabel.setTextFill(Color.BLUE);
                    colourLabel.setFont(Font.font("Arial", 24));

                    // create a text field for shape
                    TextField colourField = new TextField();
                    colourField.setMaxWidth(200);

                    // add a button to submit shape
                    Button colourButton = new Button();
                    colourButton.setText("Colour shape");

                    root.getChildren().addAll(colourLabel, colourField, colourButton);

                    // colour shape
                    colourButton.setOnAction(e1 -> {
                        if (colourField.getText().equals("blue")) {
                        	pentagon.setFill(Color.BLUE);
                        } else if (colourField.getText().equals("green")) {
                        	pentagon.setFill(Color.GREEN);
                        } else if (colourField.getText().equals("yellow")) {
                        	pentagon.setFill(Color.YELLOW);
                        } else {
                            Alert errorAlert = new Alert(AlertType.ERROR);
                            errorAlert.setHeaderText("Invalid colour.");
                            errorAlert.setContentText("Please try blue, green, or yellow.");
                            errorAlert.showAndWait();
                        }

                    });
                } else if (shapeNumber == 6) {
                	// case if side = 6
                	Polygon hexagon = new Polygon();
                	hexagon.getPoints().addAll(new Double[] {200.0, 50.0,400.0, 50.0,450.0, 150.0,400.0, 250.0,200.0, 250.0,150.0, 150.0});

                	// display hexagon	
                	root.getChildren().add(hexagon);

                	// remove the text field and button
                	root.getChildren().removeAll(shapeLabel, shapeField, shapeButton);

                	// tell the user to enter a colour
                	// add a label so user knows what is going on
                	Label colourLabel = new Label("increase or decrease the number of side(s)");
                	colourLabel.setTextFill(Color.BLUE);
                	colourLabel.setFont(Font.font("Arial", 24));

                	// create a text field for shape
                	TextField colourField = new TextField();
                	colourField.setMaxWidth(200);

                	// add a button to submit shape
                	Button colourButton = new Button();
                	colourButton.setText("Colour shape");

                	root.getChildren().addAll(colourLabel, colourField, colourButton);

                // colour shape
                	colourButton.setOnAction(e1 -> {
                		if (colourField.getText().equals("blue")) {
                			hexagon.setFill(Color.BLUE);
                		} else if (colourField.getText().equals("green")) {
                			hexagon.setFill(Color.GREEN);
                		} else if (colourField.getText().equals("yellow")) {
                			hexagon.setFill(Color.YELLOW);
                		} else {
                			Alert errorAlert = new Alert(AlertType.ERROR);
                			errorAlert.setHeaderText("Invalid colour.");
                			errorAlert.setContentText("Please try blue, green, or yellow.");
                			errorAlert.showAndWait();
                		}
                	});

                
                } else if (shapeNumber == 7) {
    			// case if side = 7
                	Polygon heptagon = new Polygon();
                	heptagon.getPoints().addAll(new Double[] {
                			300.0, 25.0, 
                			400.0, 100.0, 
                			400.0, 200.0, 
                			350.0, 250.0,
                			250.0, 250.0, 
                			200.0, 200.0, 
                			200.0, 100.0
                	});
                	heptagon.setFill(Color.GREEN);

                    // display heptagon
                    root.getChildren().add(heptagon);

                    // remove the text field and button
                    root.getChildren().removeAll(shapeLabel, shapeField, shapeButton);

                    // tell the user to enter a colour
                    // add a label so user knows what is going on
                    Label colourLabel = new Label("increase or decrease the number of side(s)");
                    colourLabel.setTextFill(Color.BLUE);
                    colourLabel.setFont(Font.font("Arial", 24));

                    // create a text field for shape
                    TextField colourField = new TextField();
                    colourField.setMaxWidth(200);

                    // add a button to submit shape
                    Button colourButton = new Button();
                    colourButton.setText("Colour shape");

                    root.getChildren().addAll(colourLabel, colourField, colourButton);

                    // colour shape
                    colourButton.setOnAction(e1 -> {
                        if (colourField.getText().equals("blue")) {
                        	heptagon.setFill(Color.BLUE);
                        } else if (colourField.getText().equals("green")) {
                        	heptagon.setFill(Color.GREEN);
                        } else if (colourField.getText().equals("yellow")) {
                        	heptagon.setFill(Color.YELLOW);
                        } else {
                            Alert errorAlert = new Alert(AlertType.ERROR);
                            errorAlert.setHeaderText("Invalid colour.");
                            errorAlert.setContentText("Please try blue, green, or yellow.");
                            errorAlert.showAndWait();
                        }
                    });

                } else if (shapeFieldNumber == 8) {
                // case if side = 8
                	Polygon octagon = new Polygon();
                	octagon.getPoints().addAll(new Double[]{
                			250.0, 50.0, 
                			350.0, 50.0, 
                			400.0, 100.0, 
                			400.0, 200.0, 
                			350.0, 250.0,
                			250.0, 250.0, 
                			200.0, 200.0, 
                			200.0, 100.0
                	});
                	octagon.setFill(Color.YELLOW);

                	// display octagon
                	root.getChildren().add(octagon);

                	// remove the text field and button
                	root.getChildren().removeAll(shapeLabel, shapeField, shapeButton);

                	// tell the user to enter a colour
                	// add a label so user knows what is going on	
                	Label colourLabel = new Label("increase or decrease the number of side(s)");
                
                	colourLabel.setTextFill(Color.BLUE);
                	colourLabel.setFont(Font.font("Arial", 22));

                	// create a text field for shape
                	TextField colourField = new TextField();
                	colourField.setMaxWidth(200);

                	// add a button to submit shape
                	Button colourButton = new Button();
                	colourButton.setText("Colour shape");

                	root.getChildren().addAll(colourLabel, colourField, colourButton);

                	// colour shape
                	colourButton.setOnAction(e1 -> {
                		if (colourField.getText().equals("blue")) {
                        octagon.setFill(Color.BLUE);
                		} else if (colourField.getText().equals("green")) {
                        octagon.setFill(Color.GREEN);
                		} else if (colourField.getText().equals("yellow")) {
                        octagon.setFill(Color.YELLOW);
                		} else {
                        Alert errorAlert = new Alert(AlertType.ERROR);
                        errorAlert.setHeaderText("Invalid number.");
                        errorAlert.setContentText("Please try blue, green, or yellow.");
                        errorAlert.showAndWait();
                    }
                });

            } else {
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("Invalid shape");
                errorAlert.setContentText("Please try number 4-8.");
                errorAlert.showAndWait();
            }
        });

    }
}