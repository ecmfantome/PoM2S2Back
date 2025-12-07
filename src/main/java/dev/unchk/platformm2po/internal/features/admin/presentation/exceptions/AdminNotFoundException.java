package dev.unchk.platformm2po.internal.features.admin.presentation.exceptions;


import static dev.unchk.platformm2po.internal.features.admin.presentation.custom_labels.AdminCustomLabels.adminNotFound;
import static dev.unchk.platformm2po.internal.features.admin.presentation.custom_labels.AdminCustomLabels.getAdminCustomLabels;

public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException() {
        super(getAdminCustomLabels("Fr", adminNotFound));
    }
}
