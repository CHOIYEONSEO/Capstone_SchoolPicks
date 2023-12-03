package com.example.demo.controller;

import com.example.demo.dto.Recommend.RecommendForm;
import com.example.demo.dto.Recommend.SpecificDto;
import com.example.demo.entity.Shop.Shop;
import com.example.demo.service.ShopRecommendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;



@Controller
@RequiredArgsConstructor
@Slf4j
public class MenuController {

    private final ShopRecommendService shopRecommendService;

    @GetMapping("/menu_recommendation_NSC")
    public String findRestaurantNSC(@ModelAttribute("recommend") RecommendForm recommendForm, Model model) {
        recommendForm.setPriceLow(7000);
        recommendForm.setPriceHigh(18000);
        Shop restaurant = shopRecommendService.recommend("nsc", List.of("cafe", "pub", "restaurant"), recommendForm.getPriceLow(), recommendForm.getPriceHigh());
        log.info("RESTAURANT = " + restaurant.getName());

        model.addAttribute("restaurant", restaurant.getName());
        model.addAttribute("restaurantId", restaurant.getId());
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

        Shop restaurant = shopRecommendService.recommend("nsc", purposes, recommendForm.getPriceLow(), recommendForm.getPriceHigh());
        log.info("RESTAURANT = " + restaurant.getName());

        model.addAttribute("restaurant", restaurant.getName());
        model.addAttribute("restaurantId", restaurant.getId());
        return "menu_recommendation_NSC";
    }

    @GetMapping("/menu_recommendation_HSSC")
    public String findRestaurantHSSC(@ModelAttribute("recommend") RecommendForm recommendForm, Model model) {
        recommendForm.setPriceLow(7000);
        recommendForm.setPriceHigh(18000);

        Shop restaurant = shopRecommendService.recommend("hssc", List.of("cafe", "pub", "restaurant"), recommendForm.getPriceLow(), recommendForm.getPriceHigh());
        log.info("RESTAURANT = " + restaurant.getName());

        model.addAttribute("restaurant", restaurant.getName());
        model.addAttribute("restaurantId", restaurant.getId());
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

        Shop restaurant = shopRecommendService.recommend("hssc", purposes, recommendForm.getPriceLow(), recommendForm.getPriceHigh());
        log.info("RESTAURANT = " + restaurant.getName());

        model.addAttribute("restaurant", restaurant.getName());
        model.addAttribute("restaurantId", restaurant.getId());
        return "menu_recommendation_HSSC";
    }

    @GetMapping("/detail/{restaurantId}")
    public String showDetail(@PathVariable String restaurantId, @ModelAttribute("specific") SpecificDto specificDto) {
        log.info("restaurant = " + restaurantId);

        SpecificDto specific = shopRecommendService.findShopById(Long.parseLong(restaurantId));
        List<String> menus = List.of(specific.getShopMenuDescription().split("\n"));
        specificDto.setShopName(specific.getShopName());
        specificDto.setShopMenuDescription(menus.get(0));
        specificDto.setShopMenuDescription2(menus.get(1));
        specificDto.setShopDescription(specific.getShopDescription());
        specificDto.setX_position(specific.getX_position());
        specificDto.setY_position(specific.getY_position());

        return "detail";
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
