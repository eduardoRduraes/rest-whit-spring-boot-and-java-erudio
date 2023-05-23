package br.com.erudio.restwhitspringbootandjavaerudio.repository;

import br.com.erudio.restwhitspringbootandjavaerudio.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
