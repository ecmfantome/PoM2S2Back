package dev.unchk.platformm2po.internal.features.teacher.presentation.controller;

import dev.unchk.platformm2po.internal.features.teacher.application.dto.TeacherRequest;
import dev.unchk.platformm2po.internal.features.teacher.application.dto.TeacherUpdateRequest;
import dev.unchk.platformm2po.internal.features.teacher.application.use_case.TeacherCreateUC;
import dev.unchk.platformm2po.internal.features.teacher.application.use_case.TeacherDeleteUC;
import dev.unchk.platformm2po.internal.features.teacher.application.use_case.TeacherUpdateUC;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("api/v1/teacher")
@RestController
@AllArgsConstructor
public class TeacherController {
    private TeacherCreateUC teacherCreateUC;
    private TeacherDeleteUC teacherDeleteUC;
    private TeacherUpdateUC teacherUpdateUC;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<String> createTeacher(@Valid @RequestBody Mono<TeacherRequest> teacherRequestMono) {
        return teacherRequestMono
                .flatMap(teacherRequest ->
                        Mono.fromCallable(() -> teacherCreateUC.execute(teacherRequest))
                );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Void>> updateTeacher(@Valid @RequestBody Mono<TeacherUpdateRequest> teacherUpdateRequestMono) {
        return teacherUpdateRequestMono
                .flatMap(teacherUpdateRequest ->
                        Mono.fromRunnable(() -> teacherUpdateUC.execute(teacherUpdateRequest))
                );
    }

    @DeleteMapping("{teacherId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<String> deleteTeacher(@PathVariable String teacherId) {
        return Mono.fromRunnable(() -> teacherDeleteUC.execute(teacherId));
    }
}
