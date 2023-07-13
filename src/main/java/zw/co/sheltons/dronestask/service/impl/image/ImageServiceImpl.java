package zw.co.sheltons.dronestask.service.impl.image;

import org.springframework.stereotype.Service;
import zw.co.sheltons.dronestask.dto.ImageDto;
import zw.co.sheltons.dronestask.exceptions.ItemNotFoundException;
import zw.co.sheltons.dronestask.model.Image;
import zw.co.sheltons.dronestask.repository.ImageRepository;
import zw.co.sheltons.dronestask.service.ImageService;
import zw.co.sheltons.dronestask.utils.ImageUtil;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public ImageResponse uploadImage(ImageDto imageDto) {
        Image image =
         imageRepository.save(Image.builder()
        .name(imageDto.getName())
        .type(imageDto.getType())
        .content(ImageUtil.compressImage(imageDto.getContent()))
        .build());
        return new ImageResponse(image);
    }
    @Override
    public byte[] getImageById(Long imageId) {
        Image returnedImage = imageRepository.findById(imageId).orElseThrow(() -> new ItemNotFoundException("No image found by id {0}", imageId));
        return ImageUtil.decompressImage(returnedImage.getContent());
    }
}