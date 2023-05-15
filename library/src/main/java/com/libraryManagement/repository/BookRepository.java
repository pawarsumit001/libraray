package com.libraryManagement.repository;

import com.libraryManagement.entity.Book;
import com.libraryManagement.enumeration.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book ,Integer> {


   /* List<Book> findByStatus(BookStatus bookStatus);

*/

    Book findByStatus(BookStatus bookStatus);

}
