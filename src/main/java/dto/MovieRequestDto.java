package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieRequestDto {
    private String title;
    private String genre;
    private Integer totalSeats;
    private Integer availableSeats;
}
