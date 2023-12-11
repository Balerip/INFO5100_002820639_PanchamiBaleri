package com.example.finalprojectjava;

import java.io.File;

public interface ImageConverter {

        void convertAndSave(File inputImage, File outputImage) throws ImageConversionException;
    }

