package com.example.demo.documents

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "tasks")
data class TaskDocument(
    @Id
    val id: String? = null,
    var title: String,
    var done: Boolean = false
)