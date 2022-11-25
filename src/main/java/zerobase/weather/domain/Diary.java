package zerobase.weather.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String weather;
    private String icon;
    private double temperature;
    private String text;
    private LocalDate date;

    public static Diary from(DateWeather dateWeather, String text){
        return Diary.builder()
                .date(dateWeather.getDate())
                .weather(dateWeather.getWeather())
                .icon(dateWeather.getIcon())
                .temperature(dateWeather.getTemperature())
                .text(text)
                .build();
    }
}
