package com.example.demo;

import com.example.demo.dto.Recommend.SpecificDto;
import com.example.demo.entity.Shop.SchoolType;
import com.example.demo.entity.Shop.Shop;
import com.example.demo.entity.Shop.ShopType;
import com.example.demo.service.ShopRecommendService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class ShopRecommendServiceTest {
    @Autowired
    ShopRecommendService shopRecommendService;

    @Test
    void 없는가게검색(){
        Shop shop = shopRecommendService.recommend("nsc", List.of("restaurant"), 200000, 300000);
        Assertions.assertThat(shop).isEqualTo(null);
    }
    
    @Test
    void 있는가게검색(){
        Shop shop = shopRecommendService.recommend("nsc", List.of("restaurant"), 0, 20000);
        Assertions.assertThat(shop.getSchoolType()).isEqualTo(SchoolType.NSC);
    }

    @Test
    void 가게상세정보검색(){
        SpecificDto specificDto = shopRecommendService.findShopById(170L);
        Assertions.assertThat(specificDto.getX_position()).isEqualTo("37.2971");
    }

    @Test
    void 가게상세정보검색_오류(){
        Assertions.assertThatThrownBy(()-> shopRecommendService.findShopById(1000L))
                .isInstanceOf(NoSuchElementException.class);
    }

}
