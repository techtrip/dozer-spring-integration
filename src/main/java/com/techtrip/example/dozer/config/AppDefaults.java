package com.techtrip.example.dozer.config;

import java.time.ZoneId;

public interface AppDefaults {
    ZoneId CST = ZoneId.of(ZoneId.SHORT_IDS.get("CST"));

    String TOP_DIVIDER = "\n\n***************************\n";
    String BOTTOM_DIVIDER = "\n***************************\n\n";
}
