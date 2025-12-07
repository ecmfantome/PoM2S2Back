package dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.entities.UserFirebase;
import dev.unchk.platformm2po.internal.features.user.presentation.exceptions.CustomFirebaseAuthException;
import dev.unchk.platformm2po.internal.shared.application.use_case.IAdminFindByIdUC;
import dev.unchk.platformm2po.internal.shared.application.use_case.IStudentFindByIdUC;
import dev.unchk.platformm2po.internal.shared.application.use_case.ITeacherFindByIdUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static dev.unchk.platformm2po.internal.shared.constant.Constants.*;

@Service
@AllArgsConstructor
public class UserServicePersistence {
    private final IStudentFindByIdUC studentFindByIdUC;
    private final ITeacherFindByIdUC teacherFindByIdUC;
    private final IAdminFindByIdUC adminFindByIdUC;

    //
    public static Map<String, Object> buildClaimsMap(UserFirebase userFirebase) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_USER_ID, userFirebase.userId);
        claims.put(CLAIM_NAME, userFirebase.name);
        claims.put(CLAIM_LASTNAME, userFirebase.lastName);
        claims.put(CLAIM_MAIL, userFirebase.email);
        claims.put(CLAIM_ROLE, userFirebase.role);
        claims.put(CLAIM_PHONE, userFirebase.phone);
        claims.put(CLAIM_IS_ACTIVE, userFirebase.isActive);
        return claims;
    }

    //
    public static Map<String, Object> updateClaimsMap(Map<String, Object> allClaims, UserFirebase userFirebase) {
        Map<String, Object> claims = new HashMap<>();
        if (userFirebase.name != null) {
            claims.put(CLAIM_NAME, userFirebase.name);
        }
        if (userFirebase.lastName != null) {
            claims.put(CLAIM_LASTNAME, userFirebase.lastName);
        }
        if (userFirebase.email != null) {
            claims.put(CLAIM_MAIL, userFirebase.email);
        }
        if (userFirebase.role != null) {
            claims.put(CLAIM_ROLE, userFirebase.role);
        }
        if (userFirebase.phone != null) {
            claims.put(CLAIM_PHONE, userFirebase.phone);
        }
        if (userFirebase.isActive != null) {
            claims.put(CLAIM_IS_ACTIVE, userFirebase.isActive);
        }
        //----ECM le allClaims de firebase est en readOnly....
        Map<String, Object> allClaimsUpdate = new HashMap<>(allClaims);
        allClaimsUpdate.putAll(claims);
        return allClaimsUpdate;
    }

    //
    public static void updateUserFirebase(String uuid, boolean isLock) {
        try {
            UserRecord.UpdateRequest updateRequest = new UserRecord.UpdateRequest(uuid)
                    .setDisabled(isLock);
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.updateUser(updateRequest);
        } catch (FirebaseAuthException e) {
            System.out.println("[updateUserFirebase]: " + e.getMessage());
            throw new CustomFirebaseAuthException(e.getMessage());
        }
    }

    //
    public static Map<String, Object> getClaimsUserFirebaseByUid(String uuid) {
        try {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            UserRecord userRecord = auth.getUser(uuid);
            return userRecord.getCustomClaims();
        } catch (FirebaseAuthException e) {
            System.out.println("[getClaimsUserFirebaseByUid]: " + e.getMessage());
            throw new CustomFirebaseAuthException(e.getMessage());
        }
    }

    //
    public Map<String, Object> getProfileByRole(String role, String userId) {
        Map<String, Object> profile = new HashMap<>();
        profile.put("role", role);
        switch (role) {
            case "STUDENT":
                profile.put("profile", studentFindByIdUC.execute(userId));
                break;
            case "TEACHER":
                profile.put("profile", teacherFindByIdUC.execute(userId));
                break;
            case "ADMIN":
                profile.put("profile", adminFindByIdUC.execute(userId));
                break;
        }
        return profile;
    }

}
