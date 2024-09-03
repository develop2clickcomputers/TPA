package com.toyota;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class VerticalLineCountValidate {

    public boolean validateArguments(String[] args) {
        // Check if the user provided a command-line argument for the image path
        if (args.length != 1) {
            // Notify the user that an argument is required and exit
            System.out.println("Invalid number of arguments. Please provide exactly one argument.");
            return false;
        }
        return true;
    }
   
     /**
     * Counts the number of vertical black lines in a given image.
     *
     * @param image the BufferedImage object to be processed
     * @return the number of vertical black lines in the image
     */
    public  int countVerticalLines(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int lineCount = 0;
        boolean inLine = false;

        for (int x = 0; x < width; x++) {
            boolean columnHasBlack = false;

            for (int y = 0; y < height; y++) {
                if (isBlackPixel(image, x, y)) {
                    columnHasBlack = true;
                    break;  // No need to check further pixels in this column
                }
            }

            if (columnHasBlack) {
                if (!inLine) {
                    lineCount++;
                    inLine = true;
                }
            } else {
                inLine = false;
            }
        }

        return lineCount;
    }

      /**
     * Checks if a specific pixel in the image is black.
     *
     * @param image the BufferedImage object to be checked
     * @param x the x-coordinate of the pixel
     * @param y the y-coordinate of the pixel
     * @return true if the pixel is black, false otherwise
     */
    public  boolean isBlackPixel(BufferedImage image, int x, int y) {
        Color pixelColor = new Color(image.getRGB(x, y));
        return pixelColor.getRed() == 0 && pixelColor.getGreen() == 0 && pixelColor.getBlue() == 0;
    }

    
    public File validateImage(String imagePath) {
        File imageFile  = null;  
        try{
            imageFile = new File(imagePath);// Create a File object for the image path
            if (!imageFile.exists()) {  // Check if the file exists
                System.out.println("File not found: " + imagePath);                
            }
        } catch(Exception e){
            System.out.println("Error reading image: " + imagePath);            
        }
       
        return imageFile;
    }

    public int readLineCount(String  imagePath){
        int lineCount = -1;
        try {             
            File imageFileLocation = validateImage(imagePath);
            if(null != imageFileLocation){
                BufferedImage image = ImageIO.read(imageFileLocation);// Read the image from the file
                lineCount = countVerticalLines(image);   // Count the number of vertical black lines in the image              
            }           
        } catch (Exception ex) {
            System.out.println("readLineCount error occurred: " + ex.getMessage());
            lineCount = 0;
        }
        return lineCount;
    }
}
