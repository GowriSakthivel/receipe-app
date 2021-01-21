package com.strio.receipeapp.service;

import com.strio.receipeapp.model.Recipe;
import com.strio.receipeapp.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService{
    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long id, MultipartFile file) {
        try {
            Recipe recipe =  recipeRepository.findById(id).get();
            Byte[] bytes = new Byte[file.getBytes().length];

            int i = 0;
            for(byte b: file.getBytes()){
                bytes[i++] = b;
            }
            recipe.setImage(bytes);

            recipeRepository.save(recipe);

        }catch (IOException e){
            log.error("Error occured " + e.getMessage());
        }
        log.info("Received image file " +file.getName());
    }
}
