package com.example.finalprojectjava;

import javafx.scene.image.Image;

import java.io.File;

/* This interface declares a method convertAndSave,which is responsible for converting an input image file to a specific format
 and saving the result to an output file.The method throws an ImageConversionException to indicate that an error occurred during the image conversion process.*/
// Interface for ImageConverter
public interface ImageConverter {
    void convertAndSave(Image inputImage, File outputImage) throws ImageConversionException;
}

