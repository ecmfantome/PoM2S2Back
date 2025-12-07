package dev.unchk.platformm2po.internal.features.student.application.use_case;

import dev.unchk.platformm2po.internal.features.student.application.dto.StudentUpdateRequest;
import dev.unchk.platformm2po.internal.features.student.domain.repository.StudentRepository;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestUpdateClaims;
import dev.unchk.platformm2po.internal.shared.application.use_case.IUserUpdateClaimsUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static dev.unchk.platformm2po.internal.features.student.application.mapper.StudentMapper.mapToUserRequestUpdateWithNullValues;


@AllArgsConstructor
@Service
public class StudentUpdateRequestUC {
    StudentRepository repository;
    IUserUpdateClaimsUC userUpdateClaimsUC;

    public void execute(StudentUpdateRequest studentUpdateRequest) {
        //------Mapping
        UserRequestUpdateClaims userRequestUpdateClaims = mapToUserRequestUpdateWithNullValues(studentUpdateRequest);
        //------Update Claims

        String studentId = userUpdateClaimsUC.execute(userRequestUpdateClaims);

        if (studentId == null || studentUpdateRequest.backToSchoolYear() == null) return;
        //-----update backToSchoolYear
        repository.updateBackToSchoolYearStudent(studentId, studentUpdateRequest.backToSchoolYear());
    }
}
