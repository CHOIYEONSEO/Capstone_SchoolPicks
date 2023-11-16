package com.example.demo.dto.Recommend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecommendDto {

    private String ShopName;
    private String ShopDescription;
    private String ShopMenuDescription;

}
