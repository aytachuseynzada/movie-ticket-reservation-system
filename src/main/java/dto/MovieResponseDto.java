package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieResponseDto {
    private Long id;
    private String title;
    private String genre;
    private Integer totalSeats;
    private Integer availableSeats;
    private LocalDateTime createdAt;
}
