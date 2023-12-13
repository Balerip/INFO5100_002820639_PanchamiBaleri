package com.example.finalprojectjava;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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


        VBox root = new VBox(10);
        root.setStyle("-fx-background-color: #e6f6fe;");
        stage.setTitle("Image Management Tool");

        Label headingLabel1 = new Label("Imagement: Pixels meet giggles!!");
        headingLabel1.setStyle("-fx-text-fill: #040813; -fx-font-size: 15pt; -fx-font-family: Helvetica;");
        HBox headingBox = new HBox();
        headingBox.setAlignment(Pos.TOP_CENTER);
        headingBox.getChildren().add(headingLabel1);

        Button button1 = new Button("Upload an image");
        button1.setStyle("-fx-background-color: #91ddfb; -fx-text-fill: #040813; -fx-font-size: 12pt; -fx-font-family: Helvetica;");

        ObservableList<String> dropdownOptions = FXCollections.observableArrayList(
                "PNG",
                "JPG",
                "JPEG",
                "GIF"
        );
        imageCombo = new ComboBox<>(dropdownOptions);
        imageCombo.setPromptText("Select Image Format");
        imageCombo.setStyle("-fx-background-color: #91ddfb; -fx-text-fill: #040813; -fx-font-size: 12pt; -fx-font-family: Helvetica");

        Button downloadButton = new Button("Download");
        downloadButton.setStyle("-fx-background-color: #91ddfb; -fx-text-fill: #040813; -fx-font-size : 12pt; -fx-font-family : Helvetica");
        downloadButton.setFont(Font.font("System", FontWeight.BOLD, 16));
        downloadButton.setDisable(true); // Disable initially

        VBox uploadAndFormatBox = new VBox(10);
        uploadAndFormatBox.setAlignment(Pos.CENTER);
        uploadAndFormatBox.setPadding(new Insets(50, 10, 10, 10));

        uploadAndFormatBox.getChildren().addAll(button1, imageCombo, downloadButton);

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(headingBox, uploadAndFormatBox);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);

        Label imageInfoLabel = new Label();
        Label locationLabel = new Label();

        button1.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

            // Displaying image properties (height, width, location)
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

                // When uploaded, show image(s) thumbnail(s) (100x100) to users on GUI
                Image thumbnail = new Image(selectedFile.toURI().toString());
                ImageView thumbnailView = new ImageView(thumbnail);
                thumbnailView.setFitHeight(100);
                thumbnailView.setFitWidth(100);

                // Clear previous content from vBox
                vBox.getChildren().clear();
                vBox.getChildren().addAll(headingBox, uploadAndFormatBox, thumbnailView, imageInfoLabel);

                // Enable the download button
                downloadButton.setDisable(false);

                // Creating Download button
                downloadButton.setOnAction(event -> {
                    try {
                        String selectedExtension = imageCombo.getValue().toUpperCase();
                        String originalExtension = getFileExtension(selectedFile).toUpperCase();

                        if (selectedExtension.equals(originalExtension)) {
                            downloadTips.setText("Image is already in the" + "." + originalExtension.toLowerCase() + " Format. Choose a different extension for image download.");
                        } else {
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
                        }
                    } catch (ImageConversionException | IllegalArgumentException ex) {
                        downloadTips.setText("Download failed! Try another image.");
                        ex.printStackTrace();
                    }
                });

                // Add download button to the vBox
                vBox.getChildren().add(downloadButton);

                downloadTips = new Label();

                HBox downloadBox = new HBox(5);
                downloadBox.setAlignment(Pos.CENTER);
                downloadBox.setPadding(new Insets(5));
                downloadBox.getChildren().addAll(downloadTips);

                vBox.getChildren().add(downloadBox);
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

    private String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
}
