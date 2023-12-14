package com.example.demo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CalculatorApplication extends Application {


    @Override
    public void start(Stage primaryStage) {
        // Create the top section of the UI
        Text tNumber1 = new Text("Enter Number 1:");
        Text tNumber2 = new Text("Enter Number 2:");
        Text tResult = new Text("Result:");

        tNumber1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tNumber1.setFill(Color.WHITE);
        tNumber2.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tNumber2.setFill(Color.WHITE);
        tResult.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 10));
        tResult.setFill(Color.WHITE);

        TextField tfNumber1 = new TextField();
        TextField tfNumber2 = new TextField();
        TextField tfResult = new TextField();

        tfResult.setEditable(false);

        // Create the bottom section of the UI
        Button btAdd = new Button("Add");
        Button btSubtract = new Button("Subtract");
        Button btMultiply = new Button("Multiply");
        Button btDivide = new Button("Divide");
        Button btclear=new Button("Clear");


        btAdd.setStyle("-fx-background-color: orange; -fx-text-fill: white;-fx-background-radius: 10;");
        btAdd.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        btSubtract.setStyle("-fx-background-color: orange; -fx-text-fill: white;-fx-background-radius: 10");
        btSubtract.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        btMultiply.setStyle("-fx-background-color: orange; -fx-text-fill: white;-fx-background-radius: 10");
        btMultiply.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        btDivide.setStyle("-fx-background-color: orange; -fx-text-fill: white;-fx-background-radius: 10");
        btDivide.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        btclear.setStyle("-fx-background-color: orange; -fx-text-fill: white;-fx-background-radius: 10");
        btclear.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        tfNumber1.setStyle("-fx-background-color: orange;");
        tfNumber2.setStyle("-fx-background-color: orange;");
        tfResult.setStyle("-fx-background-color: orange;");

        // Add top and bottom UI to HBox containers
        VBox calcTop = new VBox(5);
        calcTop.getChildren().addAll(tNumber1, tfNumber1, tNumber2, tfNumber2, tResult, tfResult);
        calcTop.setAlignment(Pos.CENTER);
        calcTop.setPadding(new Insets(5));

        HBox calcBottom = new HBox(5);
        calcBottom.setAlignment(Pos.CENTER);
        calcBottom.setPadding(new Insets(5));
        calcBottom.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide,btclear);

        // Add HBox containers to a BorderPane
        BorderPane pane = new BorderPane();
        pane.setCenter(calcTop);
        pane.setBottom(calcBottom);

        // Register event handlers for buttons
        btAdd.setOnAction(e -> {
            double a = getDoubleFromTextField(tfNumber1);
            double b = getDoubleFromTextField(tfNumber2);
            tfResult.setText(String.valueOf(a + b));
        });

        btSubtract.setOnAction(e -> {
            double a = getDoubleFromTextField(tfNumber1);
            double b = getDoubleFromTextField(tfNumber2);
            tfResult.setText(String.valueOf(a - b));
        });

        btMultiply.setOnAction(e -> {
            double a = getDoubleFromTextField(tfNumber1);
            double b = getDoubleFromTextField(tfNumber2);
            tfResult.setText(String.valueOf(a * b));
        });

        btDivide.setOnAction(e -> {
            double a = getDoubleFromTextField(tfNumber1);
            double b = getDoubleFromTextField(tfNumber2);
            tfResult.setText(b == 0 ? "NaN" : String.valueOf(a / b));
        });

        btclear.setOnAction(e->{
            String a="";
            String b="";
            tfNumber1.setText(a);
            tfNumber2.setText(b);
            tfResult.setText("");
        });

        BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        // create Background
        Background background = new Background(background_fill);
        // set background
        pane.setBackground(background);
        Scene scene = new Scene(pane,300,200);
        primaryStage.setTitle("Basic Calculator App");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private static double getDoubleFromTextField(TextField t) {
        return Double.parseDouble(t.getText());
    }

    public static void main(String[] args) {
        launch(args);
    }
}