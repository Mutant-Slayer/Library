package com.library.kindle.data

import com.fasterxml.jackson.annotation.JsonInclude
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList
import org.springframework.data.jpa.repository.Query

@Entity
@Table(name = "Book")
@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedQuery(
    name = "Book.findByTitle",
    query = "SELECT n FROM Book n WHERE n.title LIKE ?1"
)



data class Book(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "varchar(36)")
    var isbn: String = "",
    var title:String = "",
    var pages:Long = 0,

    @ManyToOne()
    @JoinColumn(name = "author_id")
    var author: Author = Author(),

    @CreationTimestamp
    var created: Date = Date(),

    var category: ArrayList<String> = arrayListOf(),

    @Lob
    var pdf: ByteArray = byteArrayOf()

)
{
    constructor():this(
        "","",0, Author(), Date(), arrayListOf()
    )
}

