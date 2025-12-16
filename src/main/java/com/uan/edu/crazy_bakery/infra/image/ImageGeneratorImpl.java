package com.uan.edu.crazy_bakery.infra.image;

import com.uan.edu.crazy_bakery.interfaces.ImageGenerator;
import org.springframework.ai.image.Image;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageGeneratorImpl implements ImageGenerator {

    @Autowired
    private final ImageModel imageModel;

    public ImageGeneratorImpl(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    @Override
    public String generate(String prompt) {
        ImagePrompt imagePrompt = new ImagePrompt(prompt);
        ImageResponse imageResponse = imageModel.call(imagePrompt);
        return resolveImageContent(imageResponse);
    }

    private String resolveImageContent(ImageResponse imageResponse) {
        Image image = imageResponse.getResult().getOutput();
        return Optional
                .ofNullable(image.getUrl())
                .orElseGet(image::getB64Json);
    }
}
