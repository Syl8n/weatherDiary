package zerobase.weather.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
}
