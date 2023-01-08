package com.yuan.RandomSelection.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Random {
    private String[] area;

    public Random(String[] area) {
        this.area = area;
    }
}
