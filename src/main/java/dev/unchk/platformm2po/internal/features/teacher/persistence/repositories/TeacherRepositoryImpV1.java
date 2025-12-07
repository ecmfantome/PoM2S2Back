package dev.unchk.platformm2po.internal.features.teacher.persistence.repositories;

import dev.unchk.platformm2po.internal.features.teacher.application.dto.TeacherUpdateRequest;
import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;
import dev.unchk.platformm2po.internal.features.teacher.domain.repository.TeacherRepository;
import dev.unchk.platformm2po.internal.features.teacher.persistence.entities.TeacherJpa;
import dev.unchk.platformm2po.internal.features.teacher.persistence.jpa.TeacherRepositoryJpa;
import dev.unchk.platformm2po.internal.features.teacher.persistence.mapper.TeacherMapperPersistence;
import dev.unchk.platformm2po.internal.features.teacher.presentation.exceptions.TeacherNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class TeacherRepositoryImpV1 implements TeacherRepository {

    private final TeacherRepositoryJpa teacherRepositoryJpa;

    @Override
    public String saveTeacher(Teacher teacher) {
        //-----Mapping
        TeacherJpa teacherJpa = TeacherMapperPersistence.toJpa(teacher);
        //-----Save
        TeacherJpa saved = teacherRepositoryJpa.save(teacherJpa);
        //-----Response
        return saved.getId();
    }

    @Override
    public void deleteTeacher(String teacherId) {
        boolean isPresent = teacherRepositoryJpa.findById(teacherId).isPresent();
        if (!isPresent) throw new TeacherNotFoundException();
        teacherRepositoryJpa.deleteById(teacherId);
    }

    @Override
    public void updateTeacher(String teacherId, Teacher teacher) {
        System.out.println("updateTeacher****************");
        Optional<TeacherJpa> teacherJpaFind = teacherRepositoryJpa.findById(teacherId);
        if (teacherJpaFind.isEmpty()) throw new TeacherNotFoundException();
        TeacherJpa teacherJpaUpdate = TeacherMapperPersistence.toJpa(teacher);
        teacherJpaUpdate.setId(teacherId);
        teacherRepositoryJpa.save(teacherJpaUpdate);
    }
}
