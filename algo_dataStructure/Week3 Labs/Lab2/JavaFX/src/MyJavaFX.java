
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MyJavaFX extends Application {
    public void start(Stage stage) {
        Circle circle = new Circle(40, 40, 30);
        Group root = new Group(circle);
        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }
    

   
    public static void main(String[] args)     
    {         
    	launch(args);
    }   
}
