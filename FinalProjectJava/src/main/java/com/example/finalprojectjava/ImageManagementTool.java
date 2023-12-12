package com.example.finalprojectjava;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;

import java.io.File;

public class ImageManagementTool extends Application {

    private ComboBox<String> imageCombo;
    private Label downloadTips;
    private ImageConverterFactory converterFactory;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ImageView imageView = new ImageView();
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);

        Label imageInfoLabel = new Label();
        Label locationLabel = new Label();
        StackPane root = new StackPane();

        // Set the background color for the root node
        root.setStyle("-fx-background-color: #C9A0DC;");

        stage.setTitle("Image Management Tool");

        Button button1 = new Button("Upload an image");
        button1.setStyle("-fx-background-color: #FFF0AA; -fx-text-fill: black;-fx-background-radius: 20;");

        HBox imageUploadBottom = new HBox(5);
        imageUploadBottom.setAlignment(Pos.CENTER);
        imageUploadBottom.setPadding(new Insets(5));
        imageUploadBottom.getChildren().addAll(button1);

        //creating drop down option to allow users to choose options from png,jp,jpeg and gif to convert images
        ObservableList<String> dropdownOptions = FXCollections.observableArrayList(
                "PNG",
                "JPG",
                "JPEG",
                "GIF"
        );
        imageCombo = new ComboBox<>(dropdownOptions);
        imageCombo.setPromptText("Select an option for various image formats");

        HBox dropdownBox = new HBox(5);
        dropdownBox.setAlignment(Pos.CENTER);
        dropdownBox.setPadding(new Insets(5));
        dropdownBox.getChildren().addAll(imageCombo);
        imageCombo.setStyle("-fx-background-color: #FFF0AA; -fx-background-radius: 15;");

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(imageUploadBottom, dropdownBox);

        button1.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

            //Displaying image properties (height, width, location)
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

                //When uploaded, show image(s) thumbnail(s) (100x100) to users on GUI
                Image thumbnail = new Image(selectedFile.toURI().toString());
                ImageView thumbnailView = new ImageView(thumbnail);
                thumbnailView.setFitHeight(100);
                thumbnailView.setFitWidth(100);
                vBox.getChildren().addAll(thumbnailView, imageInfoLabel);

                // Creating Download button
                Button downloadButton = new Button("Download");
                downloadButton.setStyle("-fx-background-color: #FFF0AA; -fx-text-fill: black;-fx-background-radius: 20;");
                //Setting Download button action to allow users to download converted images
                downloadButton.setOnAction(event -> {
                    try {
                        String selectedExtension = imageCombo.getValue().toUpperCase();
                        FileChooser saveChooser = new FileChooser();
                        saveChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(selectedExtension, "*." + selectedExtension.toLowerCase()));
                        File savedFile = saveChooser.showSaveDialog(stage);

                        if (savedFile != null) {
                            // Use the factory to create the converter
                            converterFactory = new ImageConverterFactoryImpl(selectedExtension);
                            ImageConverter imageConverter = converterFactory.createImageConverter();
                            imageConverter.convertAndSave(selectedFile, savedFile);
                            downloadTips.setText("Download successfully");
                        } else {
                            downloadTips.setText("Download canceled");
                        }
                    } catch (ImageConversionException | IllegalArgumentException ex) {
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
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}