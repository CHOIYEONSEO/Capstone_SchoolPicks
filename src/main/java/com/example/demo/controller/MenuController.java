package com.example.demo.controller;

import com.example.demo.dto.RecommendDto;
import com.example.demo.service.ShopRecommendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.demo.entity.ShopType.RESTAURANT;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MenuController {

    private final ShopRecommendService shopRecommendService;

    @GetMapping("/menu_recommendation_NSC")
    public String findRestaurantNSC(@ModelAttribute("recommend") RecommendDto recommendDto) {
        recommendDto.setPriceLow(7000);
        recommendDto.setPriceHigh(18000);
        return "menu_recommendation_NSC";
    }

    @PostMapping("/menu_recommendation_NSC")
    public String recommendNSC(@ModelAttribute("recommend") RecommendDto recommendDto, Model model) {
        log.info("Purpose = " + recommendDto.getPurpose());
        log.info("priceLow = " + recommendDto.getPriceLow());
        log.info("priceHigh = " + recommendDto.getPriceHigh());
        String purpose = recommendDto.getPurpose();
        purpose = getPurposeType(purpose);

        String restaurant = shopRecommendService.recommend(purpose, recommendDto.getPriceLow(), recommendDto.getPriceHigh());
        log.info("RESTAURANT = " + restaurant);

        model.addAttribute("restaurant", restaurant);
        return "menu_recommendation_NSC";
    }

    @GetMapping("/menu_recommendation_HSSC")
    public String findRestaurantHSSC(@ModelAttribute("recommend") RecommendDto recommendDto) {
        recommendDto.setPriceLow(7000);
        recommendDto.setPriceHigh(18000);
        return "menu_recommendation_HSSC";
    }

    @PostMapping("/menu_recommendation_HSSC")
    public String recommendHSSC(@ModelAttribute("recommend") RecommendDto recommendDto, Model model) {
        log.info("Purpose = " + recommendDto.getPurpose());
        log.info("priceLow = " + recommendDto.getPriceLow());
        log.info("priceHigh = " + recommendDto.getPriceHigh());
        String purpose = recommendDto.getPurpose();
        purpose = getPurposeType(purpose);

        String restaurant = shopRecommendService.recommend(purpose, recommendDto.getPriceLow(), recommendDto.getPriceHigh());
        log.info("RESTAURANT = " + restaurant);

        model.addAttribute("restaurant", restaurant);
        return "menu_recommendation_HSSC";
    }



    private static String getPurposeType(String purpose) {
        if (purpose.equals("음식점")) {
            purpose = "restaurant";
        } else if (purpose.equals("카페")) {
            purpose = "cafe";
        } else if (purpose.equals("술집")) {
            purpose = "pub";
        }
        return purpose;
    }
}
