package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.respository.JpaMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo newMemo = new Memo(3, "sfddfs");
        //when
        Memo memo = jpaMemoRepository.save(newMemo);
        //then
        Optional<Memo> result = jpaMemoRepository.findById(memo.getId());
        assertEquals(result.get().getText(), "sfddfs");
    }

    @Test
    void findAllMemoTest() {
        //given
        //when
        List<Memo> memos = jpaMemoRepository.findAll();
        System.out.println(memos);
        //then
        assertNotNull(memos);
    }
}
