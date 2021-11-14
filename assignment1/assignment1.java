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

public class Shapes extends Application {

    @Override
    public void start(Stage stage) {

        // create a text field for shape
        TextField shapeField = new TextField();
        shapeField.setMaxWidth(200);

        // add a label so user knows what is going on
        Label shapeLabel = new Label("Enter a shape");
        shapeLabel.setTextFill(Color.BLUE);
        shapeLabel.setFont(Font.font("Arial", 24));

        // add a button to submit shape
        Button shapeButton = new Button();
        shapeButton.setText("Draw your shape");

        // create a VBox for the components
        VBox root = new VBox(25);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(shapeLabel, shapeField, shapeButton);

        // create a scene and add to stage
        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.setTitle("Shapes");
        stage.show();

        shapeButton.setOnAction(e -> {
            // check input and draw shape if input is valid and draw shape
            // draw circle
            if (shapeField.getText().equals("circle")) {

                Circle circle = new Circle();
                circle.setCenterX(100.0f);
                circle.setCenterY(100.0f);
                circle.setRadius(50.f);

                // display circle
                root.getChildren().add(circle);

                // remove the text field and button
                root.getChildren().removeAll(shapeLabel, shapeField, shapeButton);

                // tell the user to enter a colour
                // add a label so user knows what is going on
                Label colourLabel = new Label("What colour do you want?");
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
                        circle.setFill(Color.BLUE);
                    } else if (colourField.getText().equals("green")) {
                        circle.setFill(Color.GREEN);
                    } else if (colourField.getText().equals("yellow")) {
                        circle.setFill(Color.YELLOW);
                    } else {
                        Alert errorAlert = new Alert(AlertType.ERROR);
                        errorAlert.setHeaderText("Invalid colour.");
                        errorAlert.setContentText("Please try blue, green, or yellow.");
                        errorAlert.showAndWait();
                    }

                });

                // draw rectangle
            } else if (shapeField.getText().equals("rectangle")) {

                Rectangle rectangle = new Rectangle(200, 100);
                rectangle.setX(100.0f);
                rectangle.setY(100.0f);

                // display rectangle
                root.getChildren().add(rectangle);

                // remove the text field and button
                root.getChildren().removeAll(shapeLabel, shapeField, shapeButton);

                // tell the user to enter a colour
                // add a label so user knows what is going on
                Label colourLabel = new Label("What colour do you want?");
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
                        rectangle.setFill(Color.BLUE);
                    } else if (colourField.getText().equals("green")) {
                        rectangle.setFill(Color.GREEN);
                    } else if (colourField.getText().equals("yellow")) {
                        rectangle.setFill(Color.YELLOW);
                    } else {
                        Alert errorAlert = new Alert(AlertType.ERROR);
                        errorAlert.setHeaderText("Invalid colour.");
                        errorAlert.setContentText("Please try blue, green, or yellow.");
                        errorAlert.showAndWait();
                    }
                });

            } else if (shapeField.getText().equals("octagon")) {
                Polygon octagon = new Polygon();
                octagon.getPoints().addAll(new Double[] { 250.0, 50.0, 350.0, 50.0, 400.0, 100.0, 400.0, 200.0, 350.0, 250.0,
                        250.0, 250.0, 200.0, 200.0, 200.0, 100.0 });

                // display octagon
                root.getChildren().add(octagon);

                // remove the text field and button
                root.getChildren().removeAll(shapeLabel, shapeField, shapeButton);

                // tell the user to enter a colour
                // add a label so user knows what is going on
                Label colourLabel = new Label("What colour do you want?");
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
                        octagon.setFill(Color.BLUE);
                    } else if (colourField.getText().equals("green")) {
                        octagon.setFill(Color.GREEN);
                    } else if (colourField.getText().equals("yellow")) {
                        octagon.setFill(Color.YELLOW);
                    } else {
                        Alert errorAlert = new Alert(AlertType.ERROR);
                        errorAlert.setHeaderText("Invalid colour.");
                        errorAlert.setContentText("Please try blue, green, or yellow.");
                        errorAlert.showAndWait();
                    }
                });

            } else {
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("Invalid shape");
                errorAlert.setContentText("Please try circle, rectangle, or octagon.");
                errorAlert.showAndWait();
            }
        });

    }

    public static void main(String[] args) {

        launch(args);

    }
}