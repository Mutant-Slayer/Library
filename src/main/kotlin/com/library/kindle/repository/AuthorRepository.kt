package com.library.kindle.repository


import com.library.kindle.data.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository: JpaRepository<Author,Int>{
    fun findAuthor(author: String): Author
}