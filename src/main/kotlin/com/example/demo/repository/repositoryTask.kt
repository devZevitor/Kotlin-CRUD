package com.example.demo.repository

import com.example.demo.documents.TaskDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface RepositoryTask : MongoRepository<TaskDocument, String>