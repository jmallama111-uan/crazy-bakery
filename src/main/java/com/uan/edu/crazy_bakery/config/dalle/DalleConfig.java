package com.uan.edu.crazy_bakery.config.dalle;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.api.OpenAiImageApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;


public class DalleConfig {

    @Bean
    @Primary
    public ImageModel imageModel(OpenAiImageApi openAiImageApi) {
        return new OpenAiImageModel(openAiImageApi);
    }
}
