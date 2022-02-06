package com.library.kindle.data

import lombok.AllArgsConstructor
import lombok.Data
import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.Lob
import kotlin.collections.ArrayList

@Data
@AllArgsConstructor
class BookDTO {

    var isbn: String = ""
    var title: String = ""
    var pages: Long = 0
    var author: AuthorDTO = AuthorDTO()

    @CreationTimestamp
    var created: Date = Date()

    var category: ArrayList<String> = arrayListOf()

    @Lob
    var pdf: ByteArray = byteArrayOf()

}
