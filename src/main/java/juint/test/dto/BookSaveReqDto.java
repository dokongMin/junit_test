package juint.test.dto;

import juint.test.domain.Book;
import lombok.Setter;

@Setter // Controller 에서 Setter 호출 되면서 Dto 에 값이 채워짐
public class BookSaveReqDto {

    private String title;
    private String author;

    public Book toEntity(){
        return Book.builder()
                .title(title)
                .author(author)
                .build();
    }
}
