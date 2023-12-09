package com.example.finalprojectjava;//package com.example.finalprojectjava;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UploadImage extends Application {

    ComboBox<String> imageCombo;
    Label downloadTips;

    public void start(Stage stage) {
        ImageView imageView = new ImageView();
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);

        Label imageInfoLabel = new Label();
        Label locationLabel = new Label();
        VBox thumbnailVBox = new VBox();

        stage.setTitle("Uploading an Image");

        Button button1 = new Button("Upload an image");
        button1.setStyle("-fx-background-color: #B2B9F0; -fx-text-fill: black;-fx-background-radius: 20;");

        HBox imageUploadBottom = new HBox(5);
        imageUploadBottom.setAlignment(Pos.CENTER);
        imageUploadBottom.setPadding(new Insets(5));
        imageUploadBottom.getChildren().addAll(button1);

        ObservableList<String> dropdownOptions = FXCollections.observableArrayList(
                "PNG",
                "JPG",
                "JPEG",
                "GIF"
        );
        imageCombo = new ComboBox<>(dropdownOptions);
        imageCombo.setPromptText("Select an option");

        HBox dropdownBox = new HBox(5);
        dropdownBox.setAlignment(Pos.CENTER);
        dropdownBox.setPadding(new Insets(5));
        dropdownBox.getChildren().addAll(imageCombo);

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(imageUploadBottom, dropdownBox);

        button1.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

            File selectedFile = fileChooser.showOpenDialog(stage);

            if (selectedFile != null) {
                Image image = new Image(selectedFile.toURI().toString());
                imageView.setImage(image);

                String imageInfo = "Image Name: " + selectedFile.getName() + "\n" +
                        "Width: " + image.getWidth() + " pixels\n" +
                        "Height: " + image.getHeight() + " pixels";

                imageInfoLabel.setText(imageInfo);
                locationLabel.setText("Image Location: " + selectedFile.getAbsolutePath());

                int thumbnailWidth = 5;
                int thumbnailHeight = 5;

                Image thumbnail = new Image(selectedFile.toURI().toString());
                ImageView thumbnailView = new ImageView(thumbnail);
                thumbnailView.setFitHeight(100);
                thumbnailView.setFitWidth(100);
                vBox.getChildren().addAll(thumbnailView, imageInfoLabel);

                // Download button and its action
                Button downloadButton = new Button("Download");
                downloadButton.setOnAction(event -> {
                    try {
                        BufferedImage converted_image = ImageIO.read(selectedFile);

                        String selectedExtension = imageCombo.getValue().toUpperCase();
                        FileChooser saveChooser = new FileChooser();
                        saveChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(selectedExtension, "*." + selectedExtension.toLowerCase()));
                        File savedFile = saveChooser.showSaveDialog(stage);

                        if (savedFile != null) {
                            ImageIO.write(converted_image, selectedExtension, savedFile);
                            downloadTips.setText("Download successfully");
                        } else {
                            downloadTips.setText("Download canceled");
                        }
                    } catch (IOException ex) {
                        downloadTips.setText("Download failed! Try another image.");
                        ex.printStackTrace();
                    }
                });

                // Add download button to the VBox
                vBox.getChildren().add(downloadButton);
            }
        });

        downloadTips = new Label();

        HBox downloadBox = new HBox(5);
        downloadBox.setAlignment(Pos.CENTER);
        downloadBox.setPadding(new Insets(5));
        downloadBox.getChildren().addAll(downloadTips);

        vBox.getChildren().add(downloadBox);

        Scene scene = new Scene(vBox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
