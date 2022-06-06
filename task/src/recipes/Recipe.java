package recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {
    @Id
    @JsonIgnore
    Long id;
    @NotNull
    @NotBlank
    @NotEmpty
    private String name;
    @NotNull
    @NotBlank
    @NotEmpty
    private String description;
    @NotNull
    @NotBlank
    @NotEmpty
    private String category;
    LocalDateTime date;

    @NotNull
    @Size(min = 1, max = 100)
    private String[] ingredients;

    @NotNull
    @Size(min = 1, max = 100)
    private String[] directions;

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "\n, description='" + description + '\'' +
                "\n, ingredients=[" + Arrays.toString(ingredients) +
                "]\n, directions=[" + Arrays.toString(directions) +
                "]}";
    }
}
