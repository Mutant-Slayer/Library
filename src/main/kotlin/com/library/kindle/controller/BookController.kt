package com.library.kindle.controller

import com.library.kindle.data.BookDTO
import com.library.kindle.service.BookService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.persistence.Cacheable


@RestController
@RequestMapping("/books")
class BookController {

    @Autowired
    private lateinit var service: BookService


    @GetMapping(
        value=["/"]
    )
    fun getBook(): List<BookDTO>{
        return service.getBook()
    }


    @PostMapping(
        value=["/insert"],
        consumes = ["multipart/form-data"]
    )

    fun insertBook(
        @RequestParam(name = "title")title: String,
        @RequestParam(name = "pages")pages: Int,
        @RequestParam(name = "authorname")author_name: String,
        @RequestParam(name = "id")id: Int,
        @RequestParam(name = "category")category: ArrayList<String>,
        @RequestParam(name = "content")content: MultipartFile
    ): String = service.insertBook(title,pages,author_name,id,category,content.bytes)


    @DeleteMapping(
        value = ["/{id}"]
    )

    fun deleteNote(
        @PathVariable(name = "id") id: String
    ): String = service.deleteBook(id)



    @GetMapping(
        value = ["/search/{title}"]
    )
    fun searchBook(
        @PathVariable(name = "title") title: String
    ) = service.findByTitle(title)

    @GetMapping(
        value = ["search/"]
    )

    fun searchBycategory(
        @RequestParam(name = "category") category: String
    ) = service.findByCategory(category)

}