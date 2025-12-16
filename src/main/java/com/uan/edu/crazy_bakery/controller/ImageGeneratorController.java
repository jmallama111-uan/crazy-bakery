package com.uan.edu.crazy_bakery.controller;

import com.uan.edu.crazy_bakery.interfaces.ImageGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageGeneratorController {

    private final ImageGenerator imageGenerator;

    public ImageGeneratorController(ImageGenerator imageGenerator) {
        this.imageGenerator = imageGenerator;
    }

    @GetMapping("/image/generator")
    public ResponseEntity<String> generateImage() {
        String prompt = "Créame una imagen de una torta donde su masa sea una genovesa, su relleno en la mitad sea merengue suizo con mantequilla y su cobertura sea completa de un ganache suave de caramelo de 6 porciones , sin decoración y evita el realismo";
        var resultImage = imageGenerator.generate(prompt);
        return ResponseEntity.ok(resultImage);
    }
}
