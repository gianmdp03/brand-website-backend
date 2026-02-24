package com.gianmdp03.brand_website.model.servicedetail.hardware;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HardwareRepair {
    private boolean cpu;
    private boolean gpu;
    private boolean ram;
    private boolean disk;
    private boolean mother;
    private boolean psu;
}
