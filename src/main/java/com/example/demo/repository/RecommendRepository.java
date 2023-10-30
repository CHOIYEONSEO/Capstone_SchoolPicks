package com.example.demo.repository;

import com.example.demo.entity.Shop;
import com.example.demo.entity.ShopType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;
@Repository
@RequiredArgsConstructor
public class RecommendRepository {

    final EntityManager em;


    public List<Shop> findSelectedShop(String type, int priceMin, int priceMax) {

        ShopType sType = null;
        List<Shop> shops = null;

        // type 설정
        if(Objects.equals(type, "restaurant"))
            sType = ShopType.RESTAURANT;
        else if (Objects.equals(type, "cafe"))
            sType = ShopType.CAFE;
        else if (Objects.equals(type, "pub"))
            sType = ShopType.PUB;

        if(sType == null){
            // All인 경우에는 전부 다 가져옴.
            TypedQuery<Shop> query = em.createQuery("SELECT s FROM Shop s WHERE s.price >= :price_low AND s.price <= :price_high", Shop.class);
            query.setParameter("price_low", priceMin);
            query.setParameter("price_high", priceMax);

            shops = query.getResultList(); // 모든 객체 반환
        }
        else{
            // 음식점 종류별 DB 질의
            TypedQuery<Shop> query = em.createQuery("SELECT s FROM Shop s WHERE s.shopType = :shop_type AND s.price >= :price_low AND s.price <= :price_high", Shop.class);

            if(sType.equals(ShopType.RESTAURANT))
                query.setParameter("shop_type", ShopType.RESTAURANT);
            else if(sType.equals(ShopType.CAFE))
                query.setParameter("shop_type", ShopType.CAFE);
            else
                query.setParameter("shop_type", ShopType.PUB);

            query.setParameter("price_low", priceMin); // 가격 하한선
            query.setParameter("price_high", priceMax); // 가격 상한선

            shops = query.getResultList(); // 결과 리스트
        }


        return shops;
    }
}
