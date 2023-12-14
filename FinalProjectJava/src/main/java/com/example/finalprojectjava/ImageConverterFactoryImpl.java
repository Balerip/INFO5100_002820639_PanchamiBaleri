    package com.example.finalprojectjava;
    import javax.imageio.ImageIO;
    import java.awt.image.BufferedImage;
    import java.io.File;
    import java.io.IOException;

    /***The ImageConverterFactoryImpl class implements the ImageConverterFactory interface.
     It takes an image type as a parameter during construction,
     and its createImageConverter method creates an instance of ImageConverter based on the specified image type.***/
    // Implementation of ImageConverterFactory
    class ImageConverterFactoryImpl implements ImageConverterFactory {
        private String imageType;

        public ImageConverterFactoryImpl(String imageType) {
            this.imageType = imageType;
        }

        @Override
        public ImageConverter createImageConverter() {
            return new ImageConverter() {
                @Override
                public void convertAndSave(File inputImage, File outputImage) throws ImageConversionException {
                    try {
                        BufferedImage image = ImageIO.read(inputImage);
                        ImageIO.write(image, imageType.toLowerCase(), outputImage);
                    } catch (IOException e) {
                        throw new ImageConversionException(imageType + " conversion failed", e);
                    }
                }
            };
        }
    }