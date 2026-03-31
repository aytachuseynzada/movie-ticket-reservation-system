package dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table (name="movies")
@Entity
public class MovieEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="genre")
    private String genre;
    @Column(name="total_seats")
    private Integer totalSeats;
    @Column(name="available_seats")
    private Integer availableSeats;
    @Column(name="created_at")
    private LocalDateTime createdAt;
}
