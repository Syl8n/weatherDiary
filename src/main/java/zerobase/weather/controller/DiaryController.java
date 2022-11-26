package zerobase.weather.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.weather.Dto.CreateDiary;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @ApiOperation(value = "일기 텍스트와 날씨를 이용해서 DB에 일기 저장", notes = "이것은 노트")
    @PostMapping("/create/diary")
    void createDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                     @RequestBody CreateDiary.Request request){
        diaryService.createDiary(date, request.getText());
    }

    @ApiOperation("선택한 날짜의 모든 일기 데이터를 받아옵니다")
    @GetMapping("/read/diary")
    List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return diaryService.readDiary(date);
    }

    @ApiOperation("선택한 기간 안의 일기를 모두 받아옵니다")
    @GetMapping("/read/diaries")
    List<Diary> readDiaries(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                            @ApiParam(value = "조회할 기간의 첫번째날", example = "2022-01-01") LocalDate from,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                            @ApiParam(value = "조회할 기간의 마지막날", example = "2022-01-01") LocalDate to){
        return diaryService.readDiaries(from, to);
    }

    @ApiOperation("일기를 수정합니다")
    @PutMapping("/update/diary")
    void updateDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                     @RequestBody CreateDiary.Request request){
        diaryService.updateDiary(date, request.getText());
    }

    @ApiOperation("일기를 삭제합니다")
    @DeleteMapping("delete/diary")
    void deleteDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        diaryService.deleteDiary(date);
    }
}
