package com.example.demo.entity.Shop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor // constructor 생성
@NoArgsConstructor // getter, setter 생성
public class Shop {

    @Id @GeneratedValue
    @Column(name = "SHOP_ID")
    private Long Id;

    private String name;

    private int price;

    @Enumerated(EnumType.STRING)
    private ShopType shopType;

    @Enumerated(EnumType.STRING)
    private SchoolType schoolType;

    private String url;

    private String description;
    private String menuDescription;

}
