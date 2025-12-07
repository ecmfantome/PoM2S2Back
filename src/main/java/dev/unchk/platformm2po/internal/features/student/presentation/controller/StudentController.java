package dev.unchk.platformm2po.internal.features.student.presentation.controller;

import dev.unchk.platformm2po.internal.features.student.application.dto.StudentRequest;
import dev.unchk.platformm2po.internal.features.student.application.dto.StudentUpdateRequest;
import dev.unchk.platformm2po.internal.features.student.application.use_case.StudentCreateUC;
import dev.unchk.platformm2po.internal.features.student.application.use_case.StudentDeleteUC;
import dev.unchk.platformm2po.internal.features.student.application.use_case.StudentUpdateRequestUC;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("api/v1/student")
@RestController
@AllArgsConstructor
public class StudentController {

    private StudentCreateUC studentCreateUC;
    private StudentDeleteUC studentDeleteUC;
    private StudentUpdateRequestUC studentUpdateRequestUC;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<String> createStudent(@Valid @RequestBody Mono<StudentRequest> studentRequestMono) {
        return studentRequestMono
                .flatMap(studentRequest ->
                        Mono.fromCallable(() -> studentCreateUC.execute(studentRequest))
                );


    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Void>> updateStudent(@Valid @RequestBody Mono<StudentUpdateRequest> studentUpdateRequestMono) {
        return studentUpdateRequestMono
                .flatMap(studentUpdateRequest ->
                        Mono.fromRunnable(() -> studentUpdateRequestUC.execute(studentUpdateRequest))
                );
    }

    @DeleteMapping("{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<String> deleteStudent(@PathVariable String studentId) {
        return Mono.fromRunnable(() -> studentDeleteUC.execute(studentId));

    }
}
