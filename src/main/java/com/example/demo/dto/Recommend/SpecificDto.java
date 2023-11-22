package com.example.demo.dto.Recommend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpecificDto {

    String x_position;
    String y_position;

    String shopName;
    String shopDescription;
    String shopMenuDescription;
}
