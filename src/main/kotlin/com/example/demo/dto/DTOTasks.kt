package com.example.demo.dto

import jakarta.validation.constraints.NotBlank

data class TaskResponse(val id: String?, val title: String, val done: Boolean)
data class CreateTaskRequest(@field:NotBlank val title: String)
data class UpdateTaskRequest(@field:NotBlank val title: String, val done: Boolean)