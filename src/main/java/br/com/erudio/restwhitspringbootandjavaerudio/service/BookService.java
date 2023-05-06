package br.com.erudio.restwhitspringbootandjavaerudio.service;

import br.com.erudio.restwhitspringbootandjavaerudio.controller.BookController;
import br.com.erudio.restwhitspringbootandjavaerudio.controller.PersonController;
import br.com.erudio.restwhitspringbootandjavaerudio.data.vo.v1.BookVO;
import br.com.erudio.restwhitspringbootandjavaerudio.data.vo.v1.PersonVO;
import br.com.erudio.restwhitspringbootandjavaerudio.exception.RequireObjectIsNullException;
import br.com.erudio.restwhitspringbootandjavaerudio.exception.ResourceNotFoundException;
import br.com.erudio.restwhitspringbootandjavaerudio.mapper.DozerMapper;
import br.com.erudio.restwhitspringbootandjavaerudio.model.Book;
import br.com.erudio.restwhitspringbootandjavaerudio.model.Person;
import br.com.erudio.restwhitspringbootandjavaerudio.repository.BookRepository;
import br.com.erudio.restwhitspringbootandjavaerudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private Logger logger = Logger.getLogger(BookService.class.getName());

    public BookVO create(BookVO book) {

        if(book == null) throw new RequireObjectIsNullException();

        logger.info("create one book!");
        var entity = DozerMapper.parseObject(book, Book.class);
        BookVO vo = DozerMapper.parseObject(bookRepository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public BookVO findById(Long id) {
        logger.info("findById one book!");
        var entity = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        BookVO vo = DozerMapper.parseObject(entity, BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return vo;
    }

    public List<BookVO> findAll() {
        List<BookVO> persons = new ArrayList<>();
        logger.info("findAll one book!");
        List<BookVO> vo = DozerMapper.parseListObjects(bookRepository.findAll(), BookVO.class);
        vo.stream().forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
        return vo;
    }

    public BookVO update(BookVO book) {

        if(book == null) throw new RequireObjectIsNullException();

        logger.info("Update one book!");
        var entity = bookRepository.findById(book.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        entity.setAuthor(book.getAuthor());
        entity.setTitle(book.getTitle());
        entity.setPrice(book.getPrice());
        entity.setLaunchDate(book.getLaunchDate());
        BookVO vo = DozerMapper.parseObject(bookRepository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;

    }

    public void delete(Long key) {
        logger.info("delete one book!");
        var response = bookRepository.findById(key).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        bookRepository.delete(response);
    }
}