package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.respository.JdbcMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class JdbcMemoRepositoryTest {

    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo newMemo = new Memo(2, "sfddfs");
        //when
        jdbcMemoRepository.save(newMemo);
        //then
        Optional<Memo> result = jdbcMemoRepository.findById(2);
        assertEquals(result.get().getText(), "sfddfs");
    }

    @Test
    void findAllMemoTest() {
        //given
        //when
        List<Memo> memos = jdbcMemoRepository.findAll();
        System.out.println(memos);
        //then
        assertNotNull(memos);
    }
}
