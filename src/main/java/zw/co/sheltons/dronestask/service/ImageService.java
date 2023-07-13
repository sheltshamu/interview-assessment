package zw.co.sheltons.dronestask.service;

import zw.co.sheltons.dronestask.dto.ImageDto;
import zw.co.sheltons.dronestask.service.impl.image.ImageResponse;

public interface ImageService {
    ImageResponse uploadImage(ImageDto imageDto);
    byte[] getImageById(Long imageId);
}
