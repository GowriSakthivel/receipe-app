package com.strio.receipeapp.commands;

import com.strio.receipeapp.model.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;

    @Size(min = 3, max = 255)
    @NotBlank
    private String description;

    @Min(1)
    @Max(999)
    private int prepTime;

    @Min(1)
    @Max(999)
    private int cookTime;

    @Min(1)
    @Max(999)
    private int serving;
    private String source;

    @URL
    private String url;

    @NotBlank
    private String directions;
    private Byte[] image;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private NotesCommand notes = new NotesCommand();
    private Set<CategoryCommand> categories = new HashSet<>();
}
