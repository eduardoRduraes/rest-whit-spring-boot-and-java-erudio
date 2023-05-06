package br.com.erudio.restwhitspringbootandjavaerudio.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"id", "author", "title" ,"price" ,"launchDate" })
public class BookVO extends RepresentationModel<BookVO> implements Serializable {
    private static final long serialVersionID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private Long key;

    private String author;

    private String title;

    private BigDecimal price;

    private Date launchDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookVO bookVO = (BookVO) o;
        return key.equals(bookVO.key) && author.equals(bookVO.author) && title.equals(bookVO.title) && price.equals(bookVO.price) && launchDate.equals(bookVO.launchDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, author, title, price, launchDate);
    }

    public BookVO() {

    }

    public BookVO(Link initialLink, String author, String title, BigDecimal price, Date launchDate) {
        super(initialLink);
        this.author = author;
        this.title = title;
        this.price = price;
        this.launchDate = launchDate;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }
}
