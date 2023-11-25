package com.example.demo;

import com.example.demo.entity.Shop.Shop;
import com.example.demo.repository.RecommendRepository;
import com.example.demo.service.ShopRecommendService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class ShopRecommendRepositoryTest {

    @Autowired
    ShopRecommendService shopRecommendService;

    @Autowired
    RecommendRepository recommendRepository;

    // 메뉴 추천 케이스별 작동여부 체크, 모든 케이스 테스트 완료
    // 2023.11.16 선택 사항이 2개인 경우 쿼리상 우선 순위문제로 버그가 발생햇었고 해결 완료
    @Test
    void 음식점추천테스트(){

        List<Shop> shops = recommendRepository.findSelectedShop("nsc", List.of("restaurant"), 0, 20000);
        Assertions.assertThat(shops.size()).isEqualTo(59);
    }

    @Test
    void 음식점추천테스트2(){

        List<Shop> shops = recommendRepository.findSelectedShop("nsc", List.of("pub"), 0, 20000);
        Assertions.assertThat(shops.size()).isEqualTo(29);
    }
    @Test
    void 음식점추천테스트3(){

        List<Shop> shops = recommendRepository.findSelectedShop("nsc", List.of("cafe"), 0, 20000);
        Assertions.assertThat(shops.size()).isEqualTo(29);
    }

    @Test
    void 음식점추천테스트4(){

        List<Shop> shops = recommendRepository.findSelectedShop("hssc", List.of("restaurant"), 0, 20000);
        Assertions.assertThat(shops.size()).isEqualTo(45);
    }

    @Test
    void 음식점추천테스트5(){

        List<Shop> shops = recommendRepository.findSelectedShop("hssc", List.of("pub"), 0, 20000);
        Assertions.assertThat(shops.size()).isEqualTo(25);
    }

    @Test
    void 음식점추천테스트6(){

        List<Shop> shops = recommendRepository.findSelectedShop("hssc", List.of("cafe"), 0, 20000);
        Assertions.assertThat(shops.size()).isEqualTo(30);
    }

    @Test
    void 음식점추천테스트7(){

        List<Shop> shops = recommendRepository.findSelectedShop("nsc", List.of("restaurant", "pub"), 0, 20000);
        Assertions.assertThat(shops.size()).isEqualTo(88);
    }

    @Test
    void 음식점추천테스트8(){

        List<Shop> shops = recommendRepository.findSelectedShop("nsc", List.of("cafe","restaurant"), 0, 20000);
        Assertions.assertThat(shops.size()).isEqualTo(88);
    }
    @Test
    void 음식점추천테스트9(){

        List<Shop> shops = recommendRepository.findSelectedShop("nsc", List.of("cafe", "pub"), 0, 20000);
        Assertions.assertThat(shops.size()).isEqualTo(58);
    }

    @Test
    void 음식점추천테스트10(){

        List<Shop> shops = recommendRepository.findSelectedShop("hssc", List.of("restaurant","cafe"), 0, 20000);
        Assertions.assertThat(shops.size()).isEqualTo(75);
    }

    @Test
    void 음식점추천테스트11(){

        List<Shop> shops = recommendRepository.findSelectedShop("hssc", List.of("pub", "restaurant"), 0, 20000);
        Assertions.assertThat(shops.size()).isEqualTo(70);
    }

    @Test
    void 음식점추천테스트12(){

        List<Shop> shops = recommendRepository.findSelectedShop("hssc", List.of("cafe", "pub"), 0, 20000);
        Assertions.assertThat(shops.size()).isEqualTo(55);

    }

    @Test
    void 음식점추천테스트13(){
        List<Shop> shops = recommendRepository.findSelectedShop("nsc",List.of("cafe", "restaurant", "pub"), 0, 20000);
        Assertions.assertThat(shops.size()).isEqualTo(117);
    }

    @Test
    void 음식점추천테스트14(){
        List<Shop> shops = recommendRepository.findSelectedShop("hssc",List.of("cafe", "restaurant", "pub"), 0, 20000);
        Assertions.assertThat(shops.size()).isEqualTo(100);
    }

}
