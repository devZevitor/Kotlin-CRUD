package com.example.demo.service

import com.example.demo.documents.TaskDocument
import com.example.demo.dto.CreateTaskRequest
import com.example.demo.dto.TaskResponse
import com.example.demo.dto.UpdateTaskRequest
import com.example.demo.repository.RepositoryTask
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ServiceTask(private val repository: RepositoryTask) {
    fun findAll(): List<TaskResponse> {
        return repository.findAll().map { it.toResponse() }
    }

    fun create(request: CreateTaskRequest): TaskResponse {
        return repository.save(TaskDocument(title = request.title)).toResponse()
    }

    fun update(id: String, request: UpdateTaskRequest): TaskResponse {
        val doc = repository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada") }
        doc.title = request.title
        doc.done = request.done
        return repository.save(doc).toResponse()
    }

    fun delete(id: String) {
        if (!repository.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada")
        }
        repository.deleteById(id)
    }

    private fun TaskDocument.toResponse() = TaskResponse(id, title, done)
}