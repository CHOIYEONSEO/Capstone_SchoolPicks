package com.example.demo.service;

import com.example.demo.dto.Recommend.SpecificDto;
import com.example.demo.entity.Shop.Shop;
import com.example.demo.repository.RecommendRepository;
import com.example.demo.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ShopRecommendService {

    final ShopRepository shopRepository; // shop Entity의 기본적인 내용을 뽑아오는 Repository
    final RecommendRepository recommendRepository; // 가게 가격정보에 따라 뽑아오는 Repository

    // 일단 연서님이 만들어주신 내용이 가게 이름만 반환하면 되니까
    // 해당 내용에 맞춰서 작성을 했습니다.
    public Shop recommend(String schoolTypes, List<String> shopTypes, int priceMin, int priceMax){

        List<Shop> shops = recommendRepository.findSelectedShop(schoolTypes, shopTypes, priceMin, priceMax);
        String answer; // 결과 값 리턴

        // 조건에 맞는 경우가 없으면?
        if(shops.isEmpty()){
//            return "다시 선택해주세요.";
            return null;
            // 이 경우에 인터넷 위에 뜨는 Toast 메세지 같은 거처럼
            // 금액조건에 맞는 식당이 없습니다, 금액의 범위를 더 넓게 조정해주세요.
            // 라고 띄워주시면 될 것 같습니다.
        }
        Random random = new Random();

        int idx = random.nextInt(shops.size());
        Shop shop = shops.get(idx);
//        return shop.getName();
        return shop;
    }

    public SpecificDto findShopById(Long id){

        Optional<Shop> optionalShop = shopRepository.findById(id);

        Shop shop = optionalShop.orElseThrow(() -> new NoSuchElementException("Shop not found"));

        SpecificDto specificDto = SpecificDto.builder()
                .x_position(shop.getXPosition())
                .y_position(shop.getYPosition())
                .shopName(shop.getName())
                .shopDescription(shop.getDescription())
                .shopMenuDescription(shop.getMenuDescription())
                .build();

        return specificDto;
    }


}