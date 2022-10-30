//
//import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.stage.Stage;
//import javafx.scene.Scene;
//import javafx.scene.layout.VBox;
//import javafx.scene.shape.Circle;
//import javafx.scene.paint.*;
//
//public class kesh extends Application{
//    @Override
//    public void start(Stage stage) throws Exception {
//
//        Circle[] circle = new Circle[3];          // create 3 circles
//        VBox vBox = new VBox();                   // vbox will put circles in vertical row
//        vBox.setAlignment(Pos.CENTER);            // center circles
//
//        for(int i = 0; i < circle.length; i++){
//            circle[i] = new Circle(50);           // initialize circles with radius of 50
//            vBox.getChildren().add(circle[i]);
//        }
//
//        circle[0].setFill(Color.RED);
//        circle[1].setFill(Color.YELLOW);
//        circle[2].setFill(Color.GREEN);
//
//        // add vbox to scene
//
//        Scene scene = new Scene(vBox, 300, 800);
//        stage.setTitle("Circle");
//        stage.setScene(scene);
//        stage.show();
//    }
//    public static void main (String [] args){
//        Application.launch(args);
//    }
//
//}