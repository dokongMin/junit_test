package juint.test.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

// DB 와 관련된 컴포넌트들만 메모리에 로딩된다.
// 즉, controller, service 는 메모리에 뜨지 않는다.
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void 책등록_test() throws Exception{
        // given
            String title = "junit5";
            String author = "두콩";
            Book book = Book.builder()
                    .title(title)
                    .author(author)
                    .build();
        // when
        Book bookPS = bookRepository.save(book); // 영속화됨

        // then
        Assertions.assertThat(title).isEqualTo(bookPS.getTitle());
        Assertions.assertThat(author).isEqualTo(bookPS.getAuthor());
     }
}