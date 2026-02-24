package com.gianmdp03.brand_website.extra.servicedetail.hardware;

import com.gianmdp03.brand_website.extra.servicedetail.ServiceDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HardwareCleaning implements ServiceDetail {
    private boolean ramCleaning;
    private boolean cpuThermalPastReplacement;
    private boolean generalCleaning;
}
