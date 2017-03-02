package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import java.util.IllegalFormatException;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageType) {
        if (imageType == imageType.BMP) {
            return new BmpReader();
        } else if (imageType == imageType.JPG) {
            return new JpgReader();
        } else if (imageType == imageType.PNG) {
            return new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
