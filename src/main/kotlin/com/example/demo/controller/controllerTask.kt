package com.example.demo.controller

import com.example.demo.dto.CreateTaskRequest
import com.example.demo.dto.TaskResponse
import com.example.demo.dto.UpdateTaskRequest
import com.example.demo.service.ServiceTask
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class ControllerTask(private val service: ServiceTask) {

    @GetMapping
    fun list(): List<TaskResponse> = service.findAll()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@Valid @RequestBody request: CreateTaskRequest): TaskResponse =
        service.create(request)

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: String,
        @Valid @RequestBody request: UpdateTaskRequest
    ): TaskResponse = service.update(id, request)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) = service.delete(id)
}