package com.gameEntities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Jump {
    private int start;
    private int end;
}
