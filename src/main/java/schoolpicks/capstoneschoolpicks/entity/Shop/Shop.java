package schoolpicks.capstoneschoolpicks.entity.Shop;

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

    private String url;

    @Enumerated(EnumType.STRING)
    private SchoolType schoolType;

    private String menuDescription;

    private String description;

}
