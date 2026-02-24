package com.gianmdp03.brand_website.extra.servicedetail.software;

import com.gianmdp03.brand_website.extra.servicedetail.ServiceDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class WindowsOptimization implements ServiceDetail {
    private boolean updateDrivers;
    private boolean virusClean;
    private boolean programOptimization;
    private boolean remoteWork;
}
