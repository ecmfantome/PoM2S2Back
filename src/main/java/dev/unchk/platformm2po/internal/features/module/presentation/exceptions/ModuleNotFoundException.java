package dev.unchk.platformm2po.internal.features.module.presentation.exceptions;


import static dev.unchk.platformm2po.internal.features.module.presentation.custom_labels.ModuleCustomLabels.getModuleCustomLabels;
import static dev.unchk.platformm2po.internal.features.module.presentation.custom_labels.ModuleCustomLabels.moduleNotFound;

public class ModuleNotFoundException extends RuntimeException {
    public ModuleNotFoundException() {
        super(getModuleCustomLabels("Fr", moduleNotFound));
    }
}
