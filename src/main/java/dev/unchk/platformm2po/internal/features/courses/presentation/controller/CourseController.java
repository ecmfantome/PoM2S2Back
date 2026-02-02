package dev.unchk.platformm2po.internal.features.courses.presentation.controller;

import dev.unchk.platformm2po.internal.features.courses.application.dto.CourseResponse;
import dev.unchk.platformm2po.internal.features.courses.application.dto.CourseSaveRequest;
import dev.unchk.platformm2po.internal.features.courses.application.dto.CourseUpdateRequest;
import dev.unchk.platformm2po.internal.features.courses.application.use_case.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/v1/course")
@RestController
@AllArgsConstructor
public class CourseController {

    private CourseSaveUC courseSaveUC;
    private CourseFindAllUC findAllUC;
    private CourseFindByIdUC findByIdUC;
    private CourseDeleteByIdUC deleteByIdUC;
    private CourseUpdateByIdUC updateByIdUC;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<CourseResponse> saveCourses(@Valid @RequestBody Flux<CourseSaveRequest> requestFlux) {
        return requestFlux
                .collectList()
                .flatMapMany(list -> Flux.fromIterable(courseSaveUC.execute(list)));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<CourseResponse> findAllCourses() {
        return Flux.fromIterable(findAllUC.execute());
    }

    @GetMapping("{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CourseResponse> findByCourseId(@PathVariable("courseId") String courseId) {
        return Mono.fromSupplier(() -> findByIdUC.execute(courseId));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Void>> updateCourse(@Valid @RequestBody Mono<CourseUpdateRequest> courseUpdateRequestMono) {
        return courseUpdateRequestMono
                .flatMap(courseUpdateRequest -> Mono.fromRunnable(() -> updateByIdUC.execute(courseUpdateRequest)));
    }

    @DeleteMapping("{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>>  deleteCourse(@PathVariable String courseId) {
        return Mono.fromRunnable(() -> deleteByIdUC.execute(courseId));
    }
}
