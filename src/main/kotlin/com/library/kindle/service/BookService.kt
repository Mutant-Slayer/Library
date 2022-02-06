package com.library.kindle.service

import com.library.kindle.data.AuthorDTO
import com.library.kindle.data.Book
import com.library.kindle.data.BookDTO
import com.library.kindle.mapper.BookMapper
import com.library.kindle.repository.AuthorRepository
import com.library.kindle.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.persistence.Cacheable
import kotlin.collections.ArrayList

@Service("Book service")
class BookService() {

    @Autowired
    lateinit var repository: BookRepository

    @Autowired
    lateinit var bookMapper: BookMapper

    @Autowired
    lateinit var service: AuthorService

    @Autowired
    lateinit var authorRepository: AuthorRepository

    fun getBook(): List<BookDTO> {
        val bookDtolist: MutableList<BookDTO> = mutableListOf()
        val bookList = repository.findAll()
        for(book: Book in bookList){
            bookDtolist.add(bookMapper.toDTO(book))
        }
        return bookDtolist
    }

    fun insertBook(titleName: String,Totalpages: Int,authorName: String,idA: Int,cat: ArrayList<String>,content: ByteArray): String {
        val book = Book()
        book.apply {
            isbn = UUID.randomUUID().toString()
            title = titleName
            pages = Totalpages.toLong()
            pdf = content

            val exist: Boolean = authorRepository.existsById(idA)

            if (!exist) {
                val auth = AuthorDTO()
                auth.apply {
                    id = idA
                    author_name = authorName
                }
                var temp: String = service.insertAuthor(auth)
            }
            author.apply {
                id = idA
                author_name = authorName
            }
            created = Date()
            var temp: ArrayList<String> = arrayListOf()
            for (s: String in cat) {
                temp.add(s)
            }
            category = cat
        }
            repository.save(book)

        return "Book inserted successfully"
    }


    fun deleteBook(id: String): String {
        repository.deleteById(id)
        return "Book deleted successfully"
    }


    fun findByTitle(title: String): Iterable<BookDTO>{
        val bookDtolist: MutableList<BookDTO> = mutableListOf()
        val bookList = repository.findByTitle(title)
        for(book: Book in bookList){
            bookDtolist.add(bookMapper.toDTO(book))
        }

        return bookDtolist
    }

    fun findByCategory(genre: String): Iterable<BookDTO>{
        val bookDtolist: MutableList<BookDTO> = mutableListOf()
        val bookList = repository.findAll().filter { it.category.contains(genre) }
        for(book: Book in bookList){
            bookDtolist.add(bookMapper.toDTO(book))
        }

        return bookDtolist
    }

}