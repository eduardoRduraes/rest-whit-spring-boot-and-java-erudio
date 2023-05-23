package br.com.erudio.restwhitspringbootandjavaerudio.service.unittests.mapper;

import br.com.erudio.restwhitspringbootandjavaerudio.data.vo.v1.BookVO;
import br.com.erudio.restwhitspringbootandjavaerudio.data.vo.v1.PersonVO;
import br.com.erudio.restwhitspringbootandjavaerudio.mapper.DozerMapper;
import br.com.erudio.restwhitspringbootandjavaerudio.model.Book;
import br.com.erudio.restwhitspringbootandjavaerudio.model.Person;
import br.com.erudio.restwhitspringbootandjavaerudio.service.unittests.mapper.mocks.MockBook;
import br.com.erudio.restwhitspringbootandjavaerudio.service.unittests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DozerConverterBookTest {
    
    MockBook inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockBook();
    }

    @Test
    public void parseEntityToVOTest() {
        BookVO output = DozerMapper.parseObject(inputObject.mockEntity(), BookVO.class);
        assertEquals(Long.valueOf(0L), output.getKey());
        assertEquals("Author Test0", output.getAuthor());
        assertEquals("Title Test0", output.getTitle());
        assertEquals(BigDecimal.valueOf(125.00), output.getPrice());
        assertEquals(new Date(2017-11-29), output.getLaunchDate());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<BookVO> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), BookVO.class);
        BookVO outputZero = outputList.get(0);
        assertEquals(Long.valueOf(0L), outputZero.getKey());
        assertEquals("Author Test0", outputZero.getAuthor());
        assertEquals("Title Test0", outputZero.getTitle());
        assertEquals(BigDecimal.valueOf(125.00), outputZero.getPrice());
        assertEquals(new Date(2017-11-29), outputZero.getLaunchDate());

        BookVO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getKey());
        assertEquals("Author Test7", outputSeven.getAuthor());
        assertEquals("Title Test7", outputSeven.getTitle());
        assertEquals(BigDecimal.valueOf(125.00), outputSeven.getPrice());
        assertEquals(new Date(2017-11-29), outputSeven.getLaunchDate());

        BookVO outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        assertEquals("Author Test12", outputTwelve.getAuthor());
        assertEquals("Title Test12", outputTwelve.getTitle());
        assertEquals(BigDecimal.valueOf(125.00), outputTwelve.getPrice());
        assertEquals(new Date(2017-11-29), outputTwelve.getLaunchDate());
    }

    @Test
    public void parseVOToEntityTest() {
        Book output = DozerMapper.parseObject(inputObject.mockVO(), Book.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Author Test0", output.getAuthor());
        assertEquals("Title Test0", output.getTitle());
        assertEquals(BigDecimal.valueOf(125.00), output.getPrice());
        assertEquals(new Date(2017-11-29), output.getLaunchDate());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Book> outputList = DozerMapper.parseListObjects(inputObject.mockVOList(), Book.class);
        Book outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Author Test0", outputZero.getAuthor());
        assertEquals("Title Test0", outputZero.getTitle());
        assertEquals(BigDecimal.valueOf(125.00), outputZero.getPrice());
        assertEquals(new Date(2017-11-29), outputZero.getLaunchDate());
        
        Book outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Author Test7", outputSeven.getAuthor());
        assertEquals("Title Test7", outputSeven.getTitle());
        assertEquals(BigDecimal.valueOf(125.00), outputSeven.getPrice());
        assertEquals(new Date(2017-11-29), outputSeven.getLaunchDate());
        
        Book outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Author Test12", outputTwelve.getAuthor());
        assertEquals("Title Test12", outputTwelve.getTitle());
        assertEquals(BigDecimal.valueOf(125.00), outputTwelve.getPrice());
        assertEquals(new Date(2017-11-29), outputTwelve.getLaunchDate());
    }
}
