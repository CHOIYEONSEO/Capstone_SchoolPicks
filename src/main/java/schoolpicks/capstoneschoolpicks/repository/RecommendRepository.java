package schoolpicks.capstoneschoolpicks.repository;

import schoolpicks.capstoneschoolpicks.entity.Shop.SchoolType;
import schoolpicks.capstoneschoolpicks.entity.Shop.Shop;
import schoolpicks.capstoneschoolpicks.entity.Shop.ShopType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class RecommendRepository {

    final EntityManager em;

    public List<Shop> findSelectedShop(String schoolTypes, List<String> shopTypes, int priceMin, int priceMax) {

        List<ShopType> shopType  = setShopType(shopTypes);// shopType 설정
        SchoolType schoolType = setSchoolType(schoolTypes); // schoolType 설정

        List<Shop> shops = null;

        if(shopTypes.isEmpty() || shopTypes.size() == 3){ // All인 경우에는 전부 다 가져옴.

            TypedQuery<Shop> query = em.createQuery("SELECT s FROM Shop s WHERE s.price >= :price_low AND s.price <= :price_high AND s.schoolType = :school_type", Shop.class);

            query.setParameter("price_low", priceMin);
            query.setParameter("price_high", priceMax);

            schoolParam(query, schoolType); // 자연과학 인문사회 설정

            shops = query.getResultList(); // 모든 객체 반환

        } else if (shopTypes.size() == 1) { // 1개일 때에는 해당 설정에 맞게 가져옴
            // 음식점 종류별 DB 질의
            TypedQuery<Shop> query = em.createQuery("SELECT s FROM Shop s WHERE s.shopType = :shop_type AND s.price >= :price_low AND s.price <= :price_high AND s.schoolType = :school_type", Shop.class);

            query.setParameter("price_low", priceMin); // 가격 하한선
            query.setParameter("price_high", priceMax); // 가격 상한선

            schoolParam(query, schoolType); // 자연과학 인문사회 설정
            shopParam(query, shopType, 0); // 식당 설정

            shops = query.getResultList(); // 결과 리스트
        }
        else if(shopTypes.size() == 2){
            // 음식점 종류별 DB 질의
            TypedQuery<Shop> query = em.createQuery("SELECT s FROM Shop s WHERE s.shopType = :shop_type OR s.shopType = :shop_type2 AND s.price >= :price_low AND s.price <= :price_high AND s.schoolType = :school_type", Shop.class);

            query.setParameter("price_low", priceMin); // 가격 하한선
            query.setParameter("price_high", priceMax); // 가격 상한선

            schoolParam(query, schoolType); // 자연과학 인문사회 설정
            shopParam(query, shopType, 0); // 식당 설정
            shopParam2(query, shopType, 1);

            shops = query.getResultList(); // 결과 리스트
        }

        return shops;
    }


    public void schoolParam(TypedQuery<Shop> query, SchoolType schoolType){
        if(schoolType.equals(SchoolType.NSC))
            query.setParameter("school_type", SchoolType.NSC);
        else
            query.setParameter("school_type", SchoolType.HSSC);
    }

    public void shopParam(TypedQuery<Shop> query, List<ShopType> shopType, int idx){
        if(shopType.get(idx).equals(ShopType.RESTAURANT))
            query.setParameter("shop_type", ShopType.RESTAURANT);
        else if(shopType.get(idx).equals(ShopType.CAFE))
            query.setParameter("shop_type", ShopType.CAFE);
        else
            query.setParameter("shop_type", ShopType.PUB);
    }

    public void shopParam2(TypedQuery<Shop> query, List<ShopType> shopType, int idx){
        if(shopType.get(idx).equals(ShopType.RESTAURANT))
            query.setParameter("shop_type2", ShopType.RESTAURANT);
        else if(shopType.get(idx).equals(ShopType.CAFE))
            query.setParameter("shop_type2", ShopType.CAFE);
        else
            query.setParameter("shop_type2", ShopType.PUB);
    }

    public SchoolType setSchoolType(String schoolTypes){
        SchoolType schoolType;
        if(Objects.equals(schoolTypes, "nsc"))
            schoolType = SchoolType.NSC;
        else
            schoolType = SchoolType.HSSC;

        return schoolType;
    }

    public List<ShopType> setShopType(List<String> shopTypes){

        List<ShopType> shopType = new ArrayList<>();

        for (String type : shopTypes) {
            if (Objects.equals(type, "restaurant"))
                shopType.add(ShopType.RESTAURANT);
            else if (Objects.equals(type, "cafe"))
                shopType.add(ShopType.CAFE);
            else
                shopType.add(ShopType.PUB);
        }

        return shopType;
    }
}
