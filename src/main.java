import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Scanner;
public class main extends  Application {
    public static int nodeNum;
    public static int in1;
    public static int in2;
    public static int edgeNum;
    public static int[][] edges;
    public static HashMap<Integer, Integer> node = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        nodeNum = scan.nextInt();
        edgeNum = scan.nextInt();

        Graph g = new Graph(nodeNum);


        /***************************************************************************************************************/
        /**baraye add kardan in1 va in2 baraye keshidan line(yal)**/
        edges = new int[edgeNum][2];
        /***************************************************************************************************************/



        for (int i = 0; i < edgeNum; i++) {
            in1 = scan.nextInt();
            in2 = scan.nextInt();
            edges[i][0] = in1;
            edges[i][1] = in2;
            g.addEdge(in1, in2);

        }
        g.BFS(0);
        int k = 0;
        for (int i = 1; i < g.ras.size() + 1; i++) {
            k = g.ras.get(i);
            node.put(i, k);
        }
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane layout = new Pane();
        /**************************************************************************************************************/
        /**tarif kardan node ha**/
        HashMap<Integer, Circle> s = new HashMap<>();
        s.put(0, new Circle(178, 700, 25, Color.BLACK));
        s.put(1, new Circle(380, 150, 25, Color.BLACK));
        s.put(2, new Circle(700, 400, 25, Color.BLACK));
        s.put(3, new Circle(80, 400, 25, Color.BLACK));
        s.put(4, new Circle(150, 255, 25, Color.BLACK));
        s.put(5, new Circle(450, 700, 25, Color.BLACK));
        s.put(6, new Circle(600, 200, 25, Color.BLACK));
        s.put(7, new Circle(655, 590, 25, Color.BLACK));
        s.put(8, new Circle(464, 792, 25, Color.BLACK));
        s.put(9, new Circle(90, 520, 25, Color.BLACK));
        /***************************************************************************************************************/
        /** keshidan khat va yall beyn rous**/
        for (int i = 0; i < edgeNum; i++) {
            Line line = new Line(s.get(edges[i][0]).getCenterX(), s.get(edges[i][0]).getCenterY(), s.get(edges[i][1]).getCenterX(), s.get(edges[i][1]).getCenterY());
            layout.getChildren().add(line);
        }
        /***************************************************************************************************************/
        /**zadan adad balaye har node va print**/
        for (int i = 0; i < nodeNum; i++) {
            Text text = new Text((int) s.get(i).getCenterX(), (int) s.get(i).getCenterY() - 30, String.valueOf(i));
            layout.getChildren().add(text);
            text.setFont(Font.font(null, 30));
        }
        /***************************************************************************************************************/
        /**print ashkal**/
        for (int i = 0; i < nodeNum; i++) {
            layout.getChildren().add(s.get(i));
        }
        /***************************************************************************************************************/
        /**zadan dokme baraye bfs**/
        Button button = new Button("click here for do BFS");
        button.setLayoutX(650);
        button.setLayoutY(750);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                new Thread(() -> {
                    try {
                        runBFS(s);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        });
        layout.getChildren().add(button);
        /***************************************************************************************************************/
        /**sakhtan safe **/
        layout.setStyle("-fx-background-color: rgb(66, 209, 244)");
        Scene scene = new Scene(layout, 800, 800);
        stage.setTitle("Circle");
        stage.setScene(scene);
        stage.show();
    }

    void runBFS(HashMap<Integer, Circle> s) throws InterruptedException {
        int b = 0;
        for (int i = 1; i < node.size() + 1; i++) {
            b = node.get(i);
            s.get(b).setFill(Color.ORANGE);
            Thread.sleep(1000);

        }
    }
}










