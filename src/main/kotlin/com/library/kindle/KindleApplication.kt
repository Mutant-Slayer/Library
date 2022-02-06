package com.library.kindle

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
@OpenAPIDefinition
@EnableCaching
class KindleApplication

fun main(args: Array<String>) {
	//SpringApplication.run(KindleApplication::class.java, *args)
	runApplication<KindleApplication>(*args)
}
