package com.library.kindle.mapper

import com.library.kindle.data.BookDTO
import com.library.kindle.data.Book

interface BookMapper {
    fun toDTO(book: Book): BookDTO
    fun toEntity(bookDto: BookDTO,category: ArrayList<String>,content: ByteArray): Book
}
