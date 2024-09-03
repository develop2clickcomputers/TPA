package com.toyota;

import org.junit.Test;
import java.awt.Color;
import java.awt.image.BufferedImage;
import static org.junit.Assert.assertEquals;

public class LineCounterAppTest {
    @Test
    public void testCountVerticalLines_OneLine() {
        BufferedImage image = createTestImage(10, 10);
        drawVerticalLine(image, 5);
        VerticalLineCountValidate verticalLineCountValidate = new VerticalLineCountValidate();
        assertEquals(1, verticalLineCountValidate.countVerticalLines(image));
    }

    @Test
    public void testCountVerticalLines_MultipleLines() {
        BufferedImage image = createTestImage(10, 10);
        drawVerticalLine(image, 2);
        drawVerticalLine(image, 5);
        drawVerticalLine(image, 8);
        VerticalLineCountValidate verticalLineCountValidate = new VerticalLineCountValidate();
        assertEquals(3, verticalLineCountValidate.countVerticalLines(image));
    }

    @Test
    public void testCountVerticalLines_NoLines() {
        BufferedImage image = createTestImage(10, 10);
        VerticalLineCountValidate verticalLineCountValidate = new VerticalLineCountValidate();
        assertEquals(0, verticalLineCountValidate.countVerticalLines(image));
    }

    @Test
    public void testCountVerticalLines_InterruptedLines() {
        BufferedImage image = createTestImage(10, 10);
        drawInterruptedVerticalLine(image, 5);
        VerticalLineCountValidate verticalLineCountValidate = new VerticalLineCountValidate();
        assertEquals(1, verticalLineCountValidate.countVerticalLines(image));
    }

    private BufferedImage createTestImage(int width, int height) {
        return new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    private void drawVerticalLine(BufferedImage image, int x) {
        for (int y = 0; y < image.getHeight(); y++) {
            image.setRGB(x, y, Color.BLACK.getRGB());
        }
    }

    private void drawInterruptedVerticalLine(BufferedImage image, int x) {
        for (int y = 0; y < 5; y++) {
            image.setRGB(x, y, Color.BLACK.getRGB());
        }
        for (int y = 6; y < image.getHeight(); y++) {
            image.setRGB(x, y, Color.BLACK.getRGB());
        }
    }
}
