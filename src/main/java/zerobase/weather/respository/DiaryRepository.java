package zerobase.weather.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Diary;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Integer> {
    List<Diary> findAllByDate(LocalDate date);
    List<Diary> findAllByDateBetween(LocalDate from, LocalDate to);

    Optional<Diary> findFirstByDate(LocalDate date);

    @Transactional
    void deleteAllByDate(LocalDate date);
}
