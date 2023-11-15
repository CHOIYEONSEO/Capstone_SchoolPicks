package com.example.demo.controller;

import com.example.demo.dto.Recommend.RecommendForm;
import com.example.demo.service.ShopRecommendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;



@Controller
@RequiredArgsConstructor
@Slf4j
public class MenuController {

    private final ShopRecommendService shopRecommendService;

    @GetMapping("/menu_recommendation_NSC")
    public String findRestaurantNSC(@ModelAttribute("recommend") RecommendForm recommendForm) {
        recommendForm.setPriceLow(7000);
        recommendForm.setPriceHigh(18000);
        return "menu_recommendation_NSC";
    }

    @PostMapping("/menu_recommendation_NSC")
    public String recommendNSC(@ModelAttribute("recommend") RecommendForm recommendForm, Model model) {
        log.info("purposeRestaurant = " + recommendForm.getPurposeRestaurant());
        log.info("purposeCafe = " + recommendForm.getPurposeCafe());
        log.info("purposePub = " + recommendForm.getPurposePub());
        log.info("priceLow = " + recommendForm.getPriceLow());
        log.info("priceHigh = " + recommendForm.getPriceHigh());

        List<String> purposes = new ArrayList<>();
        if (recommendForm.getPurposeRestaurant() != null) {
            purposes.add(getPurposeType(recommendForm.getPurposeRestaurant()));
        }
        if (recommendForm.getPurposeCafe() != null) {
            purposes.add(getPurposeType(recommendForm.getPurposeCafe()));
        }
        if (recommendForm.getPurposePub() != null) {
            purposes.add(getPurposeType(recommendForm.getPurposePub()));
        }

        String restaurant = shopRecommendService.recommend("nsc", purposes, recommendForm.getPriceLow(), recommendForm.getPriceHigh());
        log.info("RESTAURANT = " + restaurant);

        model.addAttribute("restaurant", restaurant);
        return "menu_recommendation_NSC";
    }

    @GetMapping("/menu_recommendation_HSSC")
    public String findRestaurantHSSC(@ModelAttribute("recommend") RecommendForm recommendForm) {
        recommendForm.setPriceLow(7000);
        recommendForm.setPriceHigh(18000);
        return "menu_recommendation_HSSC";
    }

    @PostMapping("/menu_recommendation_HSSC")
    public String recommendHSSC(@ModelAttribute("recommend") RecommendForm recommendForm, Model model) {
        log.info("purposeRestaurant = " + recommendForm.getPurposeRestaurant());
        log.info("purposeCafe = " + recommendForm.getPurposeCafe());
        log.info("purposePub = " + recommendForm.getPurposePub());
        log.info("priceLow = " + recommendForm.getPriceLow());
        log.info("priceHigh = " + recommendForm.getPriceHigh());

        List<String> purposes = new ArrayList<>();
        if (recommendForm.getPurposeRestaurant() != null) {
            purposes.add(getPurposeType(recommendForm.getPurposeRestaurant()));
        }
        if (recommendForm.getPurposeCafe() != null) {
            purposes.add(getPurposeType(recommendForm.getPurposeCafe()));
        }
        if (recommendForm.getPurposePub() != null) {
            purposes.add(getPurposeType(recommendForm.getPurposePub()));
        }


        String restaurant = shopRecommendService.recommend("hssc", purposes, recommendForm.getPriceLow(), recommendForm.getPriceHigh());
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
