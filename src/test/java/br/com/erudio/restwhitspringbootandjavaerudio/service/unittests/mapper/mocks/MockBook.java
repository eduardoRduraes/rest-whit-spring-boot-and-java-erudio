package br.com.erudio.restwhitspringbootandjavaerudio.service.unittests.mapper.mocks;


import br.com.erudio.restwhitspringbootandjavaerudio.data.vo.v1.BookVO;
import br.com.erudio.restwhitspringbootandjavaerudio.model.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {

    public Book mockEntity() {
        return mockEntity(0);
    }

    public BookVO mockVO() {
        return mockVO(0);
    }

    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockVO(i));
        }
        return books;
    }

    public Book mockEntity(Integer number) {
        Book book = new Book();
        book.setAuthor("Author Test" + number);
        book.setPrice(BigDecimal.valueOf(125.00));
        book.setTitle("Title Test"+number);
        book.setLaunchDate(new Date(2017-11-29));
        book.setId(number.longValue());
        return book;
    }

    public BookVO mockVO(Integer number) {
        BookVO book = new BookVO();
        book.setAuthor("Author Test" + number);
        book.setPrice(BigDecimal.valueOf(125.00));
        book.setTitle("Title Test"+number);
        book.setLaunchDate(new Date(2017-11-29));
        book.setKey(number.longValue());
        return book;
    }

}

