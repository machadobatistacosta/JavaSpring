package projeto.java.mind.run;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
        @Positive
        @Id
        Integer id,
        @NotEmpty 
        String title,
        @Version
        Integer version) {
    public Run {
        // Construtor implícito gerado pelo record
    }
}
