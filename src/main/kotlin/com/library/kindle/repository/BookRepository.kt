package com.library.kindle.repository

import com.library.kindle.data.Author
import com.library.kindle.data.Book
import com.library.kindle.data.BookDTO
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<Book, String> {
    fun findByTitle(title: String): Iterable<Book>
    fun findAllByAuthor(author: Author) : List<Book>
}