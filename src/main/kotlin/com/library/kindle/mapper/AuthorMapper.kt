package com.library.kindle.mappers

import com.library.kindle.data.AuthorDTO
import com.library.kindle.data.Author

interface AuthorMapper {
    fun toDTO(author: Author): AuthorDTO

    fun toEntity(authorDto: AuthorDTO): Author
}
