package com.gianmdp03.brand_website.extra.servicedetail.software;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class WindowsReinstallation {
    private boolean backupBeforeReinstallation;
    private boolean remoteWork;
    private List<String> customPrograms = new ArrayList<>();
}
