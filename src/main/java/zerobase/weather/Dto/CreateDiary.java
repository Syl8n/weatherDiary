package zerobase.weather.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class CreateDiary {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request {
        private String text;
    }
}
