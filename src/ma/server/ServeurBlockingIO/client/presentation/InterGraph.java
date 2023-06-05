package ma.server.ServeurBlockingIO.client.presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ma.server.ServeurBlockingIO.client.metier.Client;
import ma.server.ServeurBlockingIO.server.ServerIO;

import java.io.IOException;
import java.net.Socket;

import static java.lang.Integer.parseInt;

public class InterGraph extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button buttonC = new Button("Connect");
        Button butoonD  = new Button("Deconnect");
//        StackPane root = new StackPane();
        GridPane root = new GridPane();
        HBox hb = new HBox();

        Label portT = new Label("Server Port "),
                ipT = new Label("Server Port ");

        TextField port = new TextField();
        TextField ip = new TextField();




        buttonC.setOnAction(event -> {
            System.out.println("Connect");
            Client client = new Client(ip.getText(),parseInt(ip.getText()));
            client.connectC();
            client.Run();
        });

        butoonD.setOnAction(event->{
            System.out.println("Deconnect");
        });

        hb.getChildren().addAll(buttonC,butoonD);
        hb.setSpacing(10);
        root.addRow(0,ipT,ip);
        root.addRow(1,portT,port);
        root.addRow(2,hb);

        root.setHgap(20);
        root.setVgap(10);


        Scene scene = new Scene(root,600,600);
        root.getStylesheets().add("ma/server/ServeurBlockingIO/client/presentation/style.css");
        primaryStage.setTitle("Test App");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
