package zw.co.sheltons.dronestask.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Slf4j
public class ImageUtil {

    public static byte[] compressImage(byte [] content) {
        log.info("ImageUtil::compressImage started compressing the image");
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(content);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(content.length);
        byte[] tmp = new byte[4*1024];
        while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
        }
        try {
            outputStream.close();
        } catch (Exception ex) {
            log.info("ImageUtil::compressImage failed to the image");
            log.error(ex.getMessage());
        }
        log.info("ImageUtil::compressImage finished compressing the image");
        return outputStream.toByteArray();
    }

    public static byte[] decompressImage(byte[] data) {
        log.info("ImageUtil::decompressImage started decompressing the image");
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception ex) {
            log.info("ImageUtil::decompressImage failed decompressing the image");
            log.error(ex.getMessage());
        }
        log.info("ImageUtil::decompressImage started decompressing the image");
        return outputStream.toByteArray();
    }
}