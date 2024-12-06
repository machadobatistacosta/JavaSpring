package projeto.java.mind.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
        @Positive
        Integer id,
        @NotEmpty 
        String title) {
    public Run {
        // Construtor implícito gerado pelo record
    }
}
