package com.example.demo;

import com.example.demo.entity.Shop.SchoolType;
import com.example.demo.entity.Shop.Shop;
import com.example.demo.entity.Shop.ShopType;
import com.example.demo.repository.RecommendRepository;
import com.example.demo.repository.ShopRepository;
import com.example.demo.service.ShopRecommendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class DataInjectionTest {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    EntityManager em;

    @Test
    void 데이터입력(){

        Shop shop = Shop.builder()
                .name("짱식당")
                .price(8000)
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .description("혼밥으로 보쌈 먹기 좋은 장소, 밥이랑 밑반찬 더달라고 하면 주심. 싸고보단 나은 듯.")
                .menuDescription("보쌈정식 8000원\n현금계산 7500원")
                .url("https://map.naver.com/p/search/%EC%A7%B1%EC%8B%9D%EB%8B%B9/place/1071872234?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop);

        Shop shop2 = Shop.builder()
                .name("기똥찬고기")
                .price(12500)
                .description("저렴한 가격의 고깃집, 단체 회식으로도 좋다. 고기반덩이랑 콩나물 볶음밥에 잘게 다져넣으면 개맛있음.")
                .menuDescription("생삼겹살 500g 25000원\n생목살 500g 25000원")
                .url("https://map.naver.com/p/search/%EA%B8%B0%EB%98%A5%EC%B0%AC%EA%B3%A0%EA%B8%B0/place/1375189003?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .build();

        shopRepository.save(shop2);

        Shop shop3 = Shop.builder()
                .name("제주도야지생삼겹살")
                .price(20000)
                .description("항정살이 맛있다고 한다. 가격이 좀 있다.")
                .menuDescription("제주삼겹살 19000원\n제주목항정 20000원")
                .url("https://map.naver.com/p/entry/place/307553086?c=15.00,0,0,0,dh")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .build();

        shopRepository.save(shop3);

        Shop shop4 = Shop.builder()
                .name("성대목장")
                .price(20000)
                .description("교수님 카드, 취업한 선배 없으면 못 가는 식당, 비싸지만 그 값을 한다. 다시 버튼을 누르길 바란다.")
                .menuDescription("암돼지생삼겹살 600g 47000원\n물냉면 8000원")
                .url("https://map.naver.com/p/search/%EC%84%B1%EB%8C%80%EB%AA%A9%EC%9E%A5/place/31632424?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .build();

        shopRepository.save(shop4);

        Shop shop5 = Shop.builder()
                .name("찬이네주먹고기")
                .price(15000)
                .description("고깃집 중 퀄리티는 성대목장 다음이다. 기억으론 명이나물이 나와서 좋았다.")
                .menuDescription("주먹고기 15000원\n삼겹살 15000원")
                .url("https://map.naver.com/p/search/%EC%B0%AC%EC%9D%B4%EB%84%A4%EC%A3%BC%EB%A8%B9%EA%B3%A0%EA%B8%B0/place/1797223476?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .build();

        shopRepository.save(shop5);

        Shop shop6 = Shop.builder()
                .name("보리네주먹고기")
                .price(15000)
                .description("좋은 고기를 적절한 가격에 먹을 수 있는 곳. 사실 안 가봤다.")
                .menuDescription("주먹고기 200g 15000원\n된장술밥 6000원")
                .url("https://map.naver.com/p/search/%EB%B3%B4%EB%A6%AC%EB%84%A4%EC%A3%BC%EB%A8%B9%EA%B3%A0%EA%B8%B0/place/1105966862?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .build();

        shopRepository.save(shop6);

        Shop shop7 = Shop.builder()
                .name("예국향")
                .price(7000)
                .description("닭볶음밥,육개장만 먹으러 간다. 일행이 떡만둣국 같은 거 시키면 엄청 늦게 나온다.")
                .menuDescription("닭볶음밥 7000원\n육개장밥 8000원")
                .url("https://map.naver.com/p/search/%EC%98%88%EA%B5%AD%ED%96%A5/place/34255636?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .build();

        shopRepository.save(shop7);

        Shop shop8 = Shop.builder()
                .name("서브웨이")
                .price(7000)
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .description("모르면 야채는 빼는 것만 말하고 소스는 추천소스 뿌려달라하자.")
                .menuDescription("에그마요 5500원\n쿠키세트 추가 1900원")
                .url("https://map.naver.com/p/search/%EC%84%9C%EB%B8%8C%EC%9B%A8%EC%9D%B4%20%EC%84%B1%EA%B7%A0%EA%B4%80%EB%8C%80%EC%A0%90/place/38230570?placePath=?entry=pll&from=nx&fromNxList=true")
                .build();

        shopRepository.save(shop8);

        Shop shop9 = Shop.builder()
                .name("본찌돈까스")
                .price(8000)
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .description("옛날에 비해 가성비가 많이 나빠졌지만, 메밀정식 먹으러 가는 곳")
                .menuDescription("돈가스 7500원\n메밀정식 8000원")
                .url("https://map.naver.com/p/search/%EB%B3%B8%EC%B0%8C%EB%8F%88%EA%B9%8C%EC%8A%A4/place/11701094?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop9);

        Shop shop10 = Shop.builder()
                .name("포크포크매콤돈가스칡불냉면")
                .price(9000)
                .description("신입생 때 돈까스 냉면 조합이 어색했지만 나름 잘 어울리는 집")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("돈냉면 9500원\n돈가스 2장 8900원")
                .url("https://map.naver.com/p/entry/place/35593332?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop10);

        Shop shop11 = Shop.builder()
                .name("일인자감자탕")
                .description("MT나 술 많이 먹고 해장하러 가는 곳, 밥 먹으러 가도 맛있다.")
                .price(9000)
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("뼈해장국 9000원\n선지해장국 7000원")
                .url("https://map.naver.com/p/search/%EC%9D%BC%EC%9D%B8%EC%9E%90%EA%B0%90%EC%9E%90%ED%83%95/place/31123108?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop11);

        Shop shop12 = Shop.builder()
                .name("서울24시감자탕")
                .price(9000)
                .description("자주 안 가겠지만 일인자와는 다른 숨은 감자탕 맛집. 김치가 맛있다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("뼈해장국 9000원\n선지해장국 10000원")
                .url("https://map.naver.com/p/entry/place/33885965?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop12);

        Shop shop13 = Shop.builder()
                .name("카마타케제면소")
                .price(8000)
                .description("저렴한 가격에 색다른 기분을 낼 수 있다. *치쿠텐부카게우동 강추*")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("치쿠텐 붓카게우동 8000원\n에비텐우동 9000원")
                .url("https://map.naver.com/p/entry/place/1455764222?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop13);

        Shop shop14 = Shop.builder()
                .name("찜닭에 꽂힌 닭집애")
                .price(9000)
                .description("화학관 뒷편에 사는 애들과 대학원생들만 아는 집, 닭칼국수가 맛있다. 점심에 가면 줄이 길다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("닭칼국수 9000원\n안동찜닭 24000원")
                .url("https://map.naver.com/p/search/%EB%8B%AD%EC%A7%91%EC%95%A0/place/1337366604?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop14);

        Shop shop15 = Shop.builder()
                .name("이라면")
                .price(6000)
                .description("자주 열지는 않지만 저렴하게 즉석 떡볶이에 볶음밥을 즐길 수 있다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("빨간전골 라볶이 6000원\n빨간전골 닭라볶이 8000원")
                .url("https://map.naver.com/p/search/%EC%9D%B4%EB%9D%BC%EB%A9%B4/place/32389945?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop15);

        Shop shop16 = Shop.builder()
                .name("미가라멘")
                .price(7500)
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .description("돈코츠라멘이 제일 나은 곳, 개인 취향이지만 사케동을 더 추천함.")
                .menuDescription("미가돈코츠라멘 7500원\n사케동 12000원")
                .url("https://map.naver.com/p/search/%EB%AF%B8%EA%B0%80/place/37620144?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop16);

        Shop shop17 = Shop.builder()
                .name("카와마루아지")
                .price(9000)
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .description("츠케멘과 극라멘을 먹을 수 있는 곳, 호불호가 있다.")
                .menuDescription("츠케멘 9000원\n극라멘 9000원")
                .url("https://map.naver.com/p/entry/place/36868523?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop17);

        Shop shop18 = Shop.builder()
                .name("모수밀면")
                .price(8500)
                .description("율전에서 밀면을 먹을 수 있는 곳, 국물이 굉장히 진하다. 가격은 글쎄다..?")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("물밀면 8500원\n비빔밀면 9000원")
                .url("https://map.naver.com/p/search/%EB%AA%A8%EC%88%98%EB%B0%80%EB%A9%B4/place/1048385575?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop18);

        Shop shop19 = Shop.builder()
                .name("태화루")
                .price(6000)
                .description("학교에선 멀지만 빨간버스를 타고 내렸을 때 시간이 남으면 추천한다. 깐쇼새우 세트가 미쳤다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("짜장면 5500원\n짬뽕 6500원")
                .url("https://map.naver.com/p/search/%ED%83%9C%ED%99%94%EB%A3%A8/place/21262274?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop19);

        Shop shop20 = Shop.builder()
                .name("국졔식당")
                .price(9000)
                .description("옛날과 달리 메뉴가 크게 바뀐 곳, 돈까스와 냉면, 제육을 판다. 냉면 먹을 땐 여기만 간다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("돈가스 9000원\n냉면 6500원")
                .url("https://map.naver.com/p/search/%EA%B5%AD%EC%A1%94%EC%8B%9D%EB%8B%B9/place/1534033200?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop20);

        Shop shop21 = Shop.builder()
                .name("무대뽀핫도그")
                .price(8000)
                .description("핫도그도 맛있지만 떡볶이가 맛집인 곳. 저녁에 간술하러 더 많이 간다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("베스트세트 17000원\n국물떡볶이 5500원")
                .url("https://map.naver.com/p/search/%EB%AC%B4%EB%8C%80%EB%BD%80%ED%95%AB%EB%8F%84%EA%B7%B8/place/1898671185?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop21);

        Shop shop22 = Shop.builder()
                .name("쟈스민")
                .price(8000)
                .description("넣을까말까 고민을 했는데 예약이 빡세다. 하지만 빡센만큼 퀄리티는 보장된다. 버튼을 다시 누르자.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("월남쌈 2인 24000원\n4인 세트 44000원")
                .url("https://map.naver.com/p/search/%EC%9F%88%EC%8A%A4%EB%AF%BC/place/36988941?placePath=?entry=pll&from=nx&fromNxList=true")
                .build();

        shopRepository.save(shop22);

        Shop shop23 = Shop.builder()
                .name("벨라튀니지")
                .price(12000)
                .description("목적이 뭐냐에 따라 금액이 크게 다르다. 데이트 혹은 대접할 때 들르기 괜찮은 곳")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("치킨타진 7500원\n양고기 스테이크 13000원")
                .url("https://map.naver.com/p/search/%EB%B2%A8%EB%9D%BC%ED%8A%80%EB%8B%88%EC%A7%80/place/37797164?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop23);

        Shop shop24 = Shop.builder()
                .name("알촌")
                .price(5000)
                .description("가볍게 식사하기 좋은 곳, 이 정도에 혼밥하기 좋은 곳이 없다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("순할알밥 4800원\n진매알밥 5400원")
                .url("https://map.naver.com/p/entry/place/37915435?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop24);

        Shop shop25 = Shop.builder()
                .name("한솥")
                .price(5000)
                .description("가볍게 식사하기 좋은 곳, 치킨마요덮밥만 먹는다.")
                .menuDescription("치킨마요 4300원\n치킨제육 4900원")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .url("https://map.naver.com/p/entry/place/37915435?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop25);

        Shop shop26 = Shop.builder()
                .name("행컵")
                .price(5500)
                .description("가볍게 식사하기 좋은 곳, 제육 먹으러 가는 곳")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("제육덮밥 5900원\n치킨마요덮밥 5800원")
                .url("https://map.naver.com/p/search/%ED%96%89%EC%BB%B5/place/1167136991?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop26);

        Shop shop27 = Shop.builder()
                .name("율천회관")
                .price(11000)
                .description("체감상 가게가 여는 날보다 닫은 날이 더 많은 곳, 하지만 육회비빔밥이 맛있다. *혼밥힘든장소*")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("육회비빔밥 11000원\n전복장비빔밥 12000원")
                .url("https://map.naver.com/p/search/%EC%9C%A8%EC%B2%9C%ED%9A%8C%EA%B4%80/place/1149979857?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop27);

        Shop shop28 = Shop.builder()
                .name("카츠요이")
                .price(12000)
                .description("항상 줄이 긴 곳, 가보려고 했다가 사람이 많아서 항상 명동찌개마을에서 김치찌개를 먹는다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("로스카츠 11000원\n히레카츠 12000원")
                .url("https://map.naver.com/p/search/%EC%B9%B4%EC%B8%A0%EC%9A%94%EC%9D%B4/place/1169312221?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop28);

        Shop shop29 = Shop.builder()
                .name("청년밥상")
                .price(8500)
                .description("제육, 우렁 쌈밥이나 찌개 쌈밥 세트 먹으러 가는 곳. 해물된장찌개에 토마토가 들어갔지만 의외로 괜찮다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("제육 쌈밥 9000원\n우렁쌈밥 9000원")
                .url("https://map.naver.com/p/search/%EC%B2%AD%EB%85%84%EB%B0%A5%EC%83%81/place/1243111691?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop29);

        Shop shop30 = Shop.builder()
                .name("일미닭갈비")
                .price(10000)
                .description("닭갈비 먹을 땐, 우동사리를 넣자 라면사리는 맛알못이다. 볶음밥도 잊지말자.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("닭갈비 2인 16000원\n우동사리 2000원")
                .url("https://map.naver.com/p/search/%EC%9D%BC%EB%AF%B8%EB%8B%AD%EA%B0%88%EB%B9%84/place/19440083?c=13.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop30);

        Shop shop31 = Shop.builder()
                .name("중경마라탕")
                .price(8000)
                .description("마라샹궈 먹을땐 중경마라탕, 마라탕 먹을땐 수해복마라탕")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("마라탕 100g 1800원\n마라샹궈 100g 3100원")
                .url("https://map.naver.com/p/search/%EC%A4%91%EA%B2%BD%EB%A7%88%EB%9D%BC%ED%83%95/place/1287591613?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop31);

        Shop shop32 = Shop.builder()
                .name("수해복마라탕")
                .price(8000)
                .description("마라샹궈 먹을땐 중경마라탕, 마라탕 먹을땐 수해복마라탕")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("마라탕 100g 1600원\n마라샹궈 100g 3000원")
                .url("https://map.naver.com/p/search/%EC%88%98%ED%95%B4%EB%B3%B5%EB%A7%88%EB%9D%BC%ED%83%95/place/1683734572?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop32);

        Shop shop33 = Shop.builder()
                .name("고기굽는교실")
                .price(15000)
                .description("저렴하게 고기 구워먹을 수 있는 곳")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("삼겹살 15500원\n왕창김치찌개 10000원")
                .url("https://map.naver.com/p/search/%EA%B3%A0%EA%B8%B0%EA%B5%BD%EB%8A%94%EA%B5%90%EC%8B%A4/place/1217459427?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop33);

        Shop shop34 = Shop.builder()
                .name("엉터리생고기")
                .price(14500)
                .description("고기 무한리필은 여기만 살아남았고 여기가 제일 낫다. 점심특선도 이용해보자.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("삼겹살 무한리필 14500원\n냉면 5500원")
                .url("https://map.naver.com/p/entry/place/1482806419?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop34);

        Shop shop35 = Shop.builder()
                .name("천하일면")
                .price(14500)
                .description("고기국수가 단돈 7천원에 고기도 많다. 후추 꼭 갈아서 많이 넣어먹자.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("고기국수 7000원\n아부라소바 8000원")
                .url("https://map.naver.com/p/search/%EC%B2%9C%ED%95%98%EC%9D%BC%EB%A9%B4/place/1346480236?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop35);

        Shop shop36 = Shop.builder()
                .name("생순 본점")
                .price(9000)
                .description("루다헤어 앞 생순으로 외관과 함께 맛도 변했지만 순대철판 볶음이 맛있다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("순대국 9000원\n순대철판볶음 1인 10000원")
                .url("https://map.naver.com/p/search/%EC%83%9D%EA%B0%81%EB%82%98%EB%8A%94%EC%88%9C%EB%8C%80%EA%B5%AD/place/20802231?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop36);

        Shop shop37 = Shop.builder()
                .name("생순 쪽문점")
                .price(9000)
                .description("쪽문 쪽 생순으로 매운 맛은 꽤나 매콤하고 밥도 리필이 가능하다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("순대국 9000원\n직화족발 10000원")
                .url("https://map.naver.com/p/search/%EC%83%9D%EA%B0%81%EB%82%98%EB%8A%94%EC%88%9C%EB%8C%80%EA%B5%AD/place/1264598215?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop37);

        Shop shop38 = Shop.builder()
                .name("성대밥상")
                .price(7000)
                .description("떡볶이와 반찬을 마음 껏 먹을 수 있고 찌개 밥 세트는 가성비가 최강이다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("비빔밥 6000원\n오므라이스 7000원")
                .url("https://map.naver.com/p/entry/place/1962997422?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop38);

        Shop shop39 = Shop.builder()
                .name("맥도날드")
                .price(5000)
                .description("맥도날드 앱에서 쿠폰 받아서 먹으면 더 싸다. 24시간 여는 얼마 안되는 집")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("빅맥 5900원\n맥스파이시 상하이버거 5900원")
                .url("https://map.naver.com/p/entry/place/33980562?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop39);

        Shop shop40 = Shop.builder()
                .name("맘스터치")
                .price(5000)
                .description("맛은 있는데 사람 많으면 엄청 늦게 나온다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("싸이버거 4600원\n딥치즈버거 5100원")
                .url("https://map.naver.com/p/search/%EB%A7%98%EC%8A%A4%ED%84%B0%EC%B9%98/place/38228300?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop40);

        Shop shop41 = Shop.builder()
                .name("롯데리아")
                .price(5000)
                .description("양념감자 먹으러 가는 곳. 아이스크림 돌려줘 ㅠㅠ.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("양념감자 2300원\n불고기버거 4700원")
                .url("https://map.naver.com/p/search/%EB%A1%AF%EB%8D%B0%EB%A6%AC%EC%95%84/place/17956031?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop41);

        Shop shop42 = Shop.builder()
                .name("아늑")
                .price(7000)
                .description("칼국수집이 바뀐 곳, 가성비 파스타인데 맛도 괜찮다고 한다.")
                .menuDescription("알리오올리오 6200원\n까르보나라 8200원")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .url("https://map.naver.com/p/search/%EB%A1%AF%EB%8D%B0%EB%A6%AC%EC%95%84/place/17956031?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop42);

        Shop shop43 = Shop.builder()
                .name("담은샤브칼국수")
                .price(12000)
                .description("샤브샤브, 칼국수, 볶음밥을 먹을 수 있다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("소고기샤브칼국수 12000원\n고기왕만두 6000원")
                .url("https://map.naver.com/p/search/%EB%8B%B4%EC%9D%80%EC%83%A4%EB%B8%8C%EC%B9%BC%EA%B5%AD%EC%88%98/place/1981164298?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop43);

        Shop shop44 = Shop.builder()
                .name("경복궁개성손만두메밀소바")
                .price(11000)
                .description("잘 모르는 왕만두전골 맛집, 차렌트하러 GS주유소가면 보인다. 진짜 맛있다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("만두전골 1100원\n손만두 10000원")
                .url("https://map.naver.com/p/search/%EB%A7%8C%EB%91%90/place/1443997923?c=15.00,0,0,0,dh&placePath=%3Fentry%3Dbmp")
                .build();

        shopRepository.save(shop44);

        Shop shop45 = Shop.builder()
                .name("보영만두")
                .price(11000)
                .description("군만두에 쫄면이 너무 비싸다. 혼밥하기엔 가격이 선을 넘어버렸다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("중간쫄면 8000원\n군만두 8000원")
                .url("https://map.naver.com/p/search/%EB%B3%B4%EC%98%81%EB%A7%8C%EB%91%90/place/36986467?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop45);

        Shop shop46 = Shop.builder()
                .name("먹깨비김밥")
                .price(6000)
                .description("새벽에 진짜 갈 곳 없을 때만 김밥, 어묵 먹으러 가는 곳 떡볶이만 맛없다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("참치김밥 3500원\n어묵 500원")
                .url("https://map.naver.com/p/search/%EC%9C%A8%EC%A0%84%EB%8F%99%20%EB%A7%9B%EC%A7%91/place/137557009?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop46);

        Shop shop47 = Shop.builder()
                .name("인더비엣")
                .price(12000)
                .description("학교에서 가장 가까운 베트남 식당. 맛도 괜찮다는 평이 많다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("본 쌀국수 14000원\n분짜 11500원")
                .url("https://map.naver.com/p/search/%EC%9C%A8%EC%A0%84%EB%8F%99%20%EB%A7%9B%EC%A7%91/place/1101500813?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop47);

        Shop shop48 = Shop.builder()
                .name("명륜진사갈비")
                .price(19000)
                .description("무한 리필 갈비집 셀프바가 내부에 있고 다양하다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("돼지갈비 무한리필 18900원\n된장찌개 3000원")
                .url("https://map.naver.com/p/search/%EC%9C%A8%EC%A0%84%EB%8F%99%20%EB%A7%9B%EC%A7%91/place/1230587056?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop48);

        Shop shop49 = Shop.builder()
                .name("청년다방")
                .price(10000)
                .description("율전에 몇 없는 즉석 떡볶이 집, 메뉴는 두 개 외엔 잘 안먹어봤다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("차돌떡볶이 16500원\n치즈폭포순살 떡볶이세트 28000원")
                .url("https://map.naver.com/p/search/%EC%B2%AD%EB%85%84%EB%8B%A4%EB%B0%A9/place/1670213874?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop49);

        Shop shop50 = Shop.builder()
                .name("동대문엽기떡볶이")
                .price(10000)
                .description("포장 시 엽떡앱쓰면 3000원 할인이니 포장해서 집에서 먹자")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("엽기떡볶이 14000원\n마라떡볶이 16000원")
                .url("https://map.naver.com/p/entry/place/36154447?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop50);

        Shop shop51 = Shop.builder()
                .name("신전떡볶이")
                .price(7000)
                .description("엽떡과 신전 중 그날 먹고 싶은 데로 가자.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.NSC)
                .menuDescription("떡볶이 3500원\n모등튀김 4500원")
                .url("https://map.naver.com/p/search/%EB%96%A1%EB%B3%B6%EC%9D%B4/place/35150061?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop51);

        em.flush();
        em.clear();

    }

    @Test
    void 데이터입력_카페(){

        Shop shop = Shop.builder()
                .name("자명문")
                .price(4000)
                .shopType(ShopType.CAFE)
                .description("율전초 주변, 외관 및 내관이 분위기 있고 공부하기 좋은 카페이다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 4000원\n뚱샌드위치 6000원")
                .url("https://map.naver.com/p/entry/place/1633516222?lng=126.96994666961953&lat=37.29928535360471&placePath=%2Fhome")
                .build();

        shopRepository.save(shop);

        Shop shop2 = Shop.builder()
                .name("여유당카페")
                .price(4000)
                .shopType(ShopType.CAFE)
                .description("율전중 주변, 카공족들이 많고 내부가 잘 꾸며져있다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 4000원\n흑임자라떼 6000원")
                .url("https://map.naver.com/p/search/%EC%97%AC%EC%9C%A0%EB%8B%B9%EC%B9%B4%ED%8E%98/place/1661029911?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop2);

        Shop shop3 = Shop.builder()
                .name("라잌댓")
                .price(3500)
                .shopType(ShopType.CAFE)
                .description("율전성당 앞, 카공하기 좋고 사람들이 잘 안온다. 저녁에 빵굽는 냄새가 많이난다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 3500원\n생과일 파블로파 9500원")
                .url("https://map.naver.com/p/entry/place/1467592044?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop3);

        Shop shop4 = Shop.builder()
                .name("스타벅스 성균관대점")
                .price(4500)
                .shopType(ShopType.CAFE)
                .description("성대역 주변, 2층은 카공하기 좋고 1층에선 대화하기 좋다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 4500원\n자바칩 프라푸치노 6300원")
                .url("https://map.naver.com/p/search/%EC%8A%A4%ED%83%80%EB%B2%85%EC%8A%A4%20/place/33021656?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop4);

        Shop shop5 = Shop.builder()
                .name("쉬즈베이글")
                .price(3300)
                .shopType(ShopType.CAFE)
                .description("후문 먹자골목, 음료보단 토스트 먹는 집이다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 4000원\n콰트로 햄 치즈 4300원")
                .url("https://map.naver.com/p/search/%EC%89%AC%EC%A6%88%EB%B2%A0%EC%9D%B4%EA%B8%80/place/1128446001?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop5);

        Shop shop6 = Shop.builder()
                .name("배스킨라빈스 수원성대점")
                .price(9800)
                .shopType(ShopType.CAFE)
                .description("성대역 주변, 팀플 전 간식 사가거나 대화하기 좋다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("파인트 9800원\n쿼터 18500원")
                .url("https://map.naver.com/p/search/%EB%B0%B0%EC%8A%A4%ED%82%A8%EB%9D%BC%EB%B9%88%EC%8A%A4/place/11782935?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop6);

        Shop shop7 = Shop.builder()
                .name("바바플")
                .price(3500)
                .shopType(ShopType.CAFE)
                .description("쪽문 주변, 군대가기 전 먹고 망할 줄 알았는데 아직도 살아있는 와플 집이다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("버터크림 와플 2300원\n아이스크림 와플 3500원")
                .url("https://map.naver.com/p/search/%EB%B0%94%EB%B0%94%ED%94%8C/place/1522307904?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop7);

        Shop shop8 = Shop.builder()
                .name("하삼동커피")
                .price(1500)
                .shopType(ShopType.CAFE)
                .description("쪽문 주변, 팀플이나 잠깐 할 얘기 있을 때 가면 좋다. ** 아메리카노 1500원 **")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 1500원\n바닐라라떼 3000원")
                .url("https://map.naver.com/p/search/%ED%95%98%EC%82%BC%EB%8F%99%EC%BB%A4%ED%94%BC/place/1435378930?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop8);

        Shop shop9 = Shop.builder()
                .name("설빙")
                .price(12000)
                .shopType(ShopType.CAFE)
                .description("후문 주변, 친구와 잠깐 얘기하거나 술먹고 2차가기 싫을 때 가면 좋다. ** 위층 피시방 **")
                .schoolType(SchoolType.NSC)
                .menuDescription("애플망고치즈설빙 13900원\n팥인절미설빙 10500원")
                .url("https://map.naver.com/p/search/%EC%84%A4%EB%B9%99/place/1141062992?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop9);

        Shop shop10 = Shop.builder()
                .name("엘가커피")
                .price(3500)
                .shopType(ShopType.CAFE)
                .description("성대역 주변, 무난하게 공부하기 좋다. 노트북용 플러그가 되게 넉넉했던 거로 기억한다!")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 3500원")
                .url("https://map.naver.com/p/entry/place/1496491242?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop10);

        Shop shop11 = Shop.builder()
                .name("화이트스노우빙수")
                .price(9500)
                .shopType(ShopType.CAFE)
                .description("설빙과는 또 다른 스타일, 보드게임카페 끝나고 애매할 때 가기 좋다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("녹차빙수 8000원\n망고빙수 9500원")
                .url("https://map.naver.com/p/entry/place/34778520?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop11);

        Shop shop12 = Shop.builder()
                .name("커피 93.0")
                .price(2500)
                .shopType(ShopType.CAFE)
                .description("쪽문 바로 앞, 1층에선 대화하기 좋고 2층에선 공부하기 좋다. 단, 2층에서 얘기하는 장소 외엔 조용한 편이다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 2300원\n블루베리스무디 5600원")
                .url("https://map.naver.com/p/entry/place/1069588829?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop12);

        Shop shop13 = Shop.builder()
                .name("카페나노")
                .price(3500)
                .shopType(ShopType.CAFE)
                .description("반도체관 주변, 팀플하기에 좋고 심심하면 체스도 할 수 있다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 3500원\n바닐라라떼 4500원")
                .url("https://map.naver.com/p/entry/place/38710517?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop13);

        Shop shop14= Shop.builder()
                .name("커피빈")
                .price(5000)
                .shopType(ShopType.CAFE)
                .description("N센터 내부, 팀플 할 때 멀리가기 싫을 때 좋다, 커피는 비싸나 학과 이벤트 지원비로 종종 여기 쿠폰을 지원해준다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 5000원\n마끼아토네 5300원")
                .url("https://map.naver.com/p/search/%EC%BB%A4%ED%94%BC%EB%B9%88/place/1238392117?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop14);

        Shop shop15= Shop.builder()
                .name("NU카페 제 1공")
                .price(1900)
                .shopType(ShopType.CAFE)
                .description("제 1공, 도서관에서 공부하다가 핫도그나 커피 먹기 좋다. 수업 시작 종료 시간엔 사람이 많으니 피하도록 하자.")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 1900원\n스무디 3300원")
                .url("https://map.naver.com/p/entry/place/19198544?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop15);

        Shop shop16= Shop.builder()
                .name("NU카페 복지회관")
                .price(1900)
                .shopType(ShopType.CAFE)
                .description("제 1공과 다르게 공부하고 잡담하기에 좋은 장소인 것 같다. ** 햄치즈 토스트 추천 **")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 1900원\n햄치즈토스트 3100원")
                .url("https://map.naver.com/p/entry/place/19198544?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop16);

        Shop shop17= Shop.builder()
                .name("THESHARE 34")
                .price(3000)
                .shopType(ShopType.CAFE)
                .description("종합연구동 주변, 연구실에서 쉬러가거나 연구 얘기하러 가는 곳이다. 수제청 음료가 맛있다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 3000원\n수제청차 4000원")
                .url("https://map.naver.com/p/entry/place/575116620?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop17);

        Shop shop18= Shop.builder()
                .name("카페올웨이즈")
                .price(3000)
                .shopType(ShopType.CAFE)
                .description("종합연구동 주변, 카공하기 좋고 샌드위치도 먹기 좋다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 3000원\n햄치즈샌드위치 5900원")
                .url("https://map.naver.com/p/entry/place/1413476827?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop18);

        Shop shop19= Shop.builder()
                .name("더리터")
                .price(2000)
                .shopType(ShopType.CAFE)
                .description("후문 주변, 단체 음료사기 좋다! 단체 아메리카노 사야될 때 좋음!")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 2000원\n복숭아숭숭 3000원")
                .url("https://map.naver.com/p/search/%EB%8D%94%EB%A6%AC%ED%84%B0/place/1276834209?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop19);

        Shop shop20= Shop.builder()
                .name("봄봄")
                .price(3300)
                .shopType(ShopType.CAFE)
                .description("후문 주변, 단체 음료사기 좋다. 스무디가 저렴해서 스무디나 프라푸치노 단체로 살 때 좋다!")
                .schoolType(SchoolType.NSC)
                .menuDescription("아메리카노 3300원\n스무디 4500원")
                .url("https://map.naver.com/p/entry/place/37212634?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop20);


        em.flush();
        em.clear();

    }

    @Test
    void 데이터입력_술집(){

        Shop shop = Shop.builder()
                .name("주량 성대직영점")
                .price(15000)
                .shopType(ShopType.PUB)
                .description("전통주 하이볼과 퓨전요리 전문점으로, 음식 비주얼이 예쁘다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("은하수샤브 25000원\n하이볼 8000원")
                .url("https://map.naver.com/p/search/%EC%A3%BC%EB%9F%89%20%EC%84%B1%EB%8C%80%EC%A7%81%EC%98%81%EC%A0%90/place/1041097467?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop);

        Shop shop2 = Shop.builder()
                .name("맥주호텔")
                .price(10000)
                .shopType(ShopType.PUB)
                .description("다양한 종류의 세계맥주를 팔고, 공간이 넓어 단체 손님에 적합하다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("치킨샐러드 10900원\n맥주 6900원")
                .url("https://map.naver.com/p/search/%EB%A7%A5%EC%A3%BC%ED%98%B8%ED%85%94/place/1655411254?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop2);

        Shop shop3 = Shop.builder()
                .name("금달맥주")
                .price(15000)
                .shopType(ShopType.PUB)
                .description("인테리어가 예쁘고, 파우더룸이 존재하는 게 특징")
                .schoolType(SchoolType.NSC)
                .menuDescription("금달떡볶이 16400원\n우삼겹 볶음 19400원")
                .url("https://map.naver.com/p/entry/place/1360207370?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop3);

        Shop shop4 = Shop.builder()
                .name("주야")
                .price(18000)
                .shopType(ShopType.PUB)
                .description("음식이 특히 맛있는 요리주점")
                .schoolType(SchoolType.NSC)
                .menuDescription("바지락술찜 16000원\n마라크림짬뽕 18000원")
                .url("https://map.naver.com/p/search/%EC%A3%BC%EC%95%BC/place/1590348097?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop4);

        Shop shop5 = Shop.builder()
                .name("예술상")
                .price(15000)
                .shopType(ShopType.PUB)
                .description("음식이 맛있는 집, 손님이 많고 왁자지껄한 분위기이다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("튀김수육 21900원\n생맥주 4000원")
                .url("https://map.naver.com/p/entry/place/1202400478?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop5);

        Shop shop6 = Shop.builder()
                .name("옥집")
                .price(16000)
                .shopType(ShopType.PUB)
                .description("율전동에서 10년 동안 장사한 가성비 좋은 술집, 식사도 가능하다. 간장새우&비빔알밥 추천!")
                .schoolType(SchoolType.NSC)
                .menuDescription("돼지 불백 6500원\n간장새우비빔알밥 6000원")
                .url("https://map.naver.com/p/search/%EC%98%A5%EC%A7%91/place/1601626342?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop6);

        Shop shop7 = Shop.builder()
                .name("아무술집")
                .price(20000)
                .shopType(ShopType.PUB)
                .description("레트로 느낌의 가게로, 사람이 많아 왁자지껄한 분위기이다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("한우육회 23000원\n햄폭탄부대찌개 22000원")
                .url("https://map.naver.com/p/search/%EC%95%84%EB%AC%B4%EC%88%A0%EC%A7%91/place/1798985592?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop7);

        Shop shop8 = Shop.builder()
                .name("주꼬로")
                .price(20000)
                .shopType(ShopType.PUB)
                .description("양식베이스의 퓨전 요리주점이다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("감바스스튜 17900원\n시금치 뇨끼 16900원")
                .url("https://map.naver.com/p/entry/place/1781271075?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop8);

        Shop shop9 = Shop.builder()
                .name("합 성대직영2호점")
                .price(18000)
                .shopType(ShopType.PUB)
                .description("안주가 맛있고 직원들이 친절하다. 편한 분위기를 풍긴다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("수육튀김 500g 22900원\n생맥주 4000원")
                .url("https://map.naver.com/p/search/%ED%95%A9/place/1334287821?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop9);

        Shop shop10 = Shop.builder()
                .name("옛날사람")
                .price(18000)
                .shopType(ShopType.PUB)
                .description("레트로 느낌의 분위기로 기본 안주로 라면이랑 옛날 과자들이 나온다!")
                .schoolType(SchoolType.NSC)
                .menuDescription("곱도리탕 21900원\n소주,맥주 5000원")
                .url("https://map.naver.com/p/entry/place/1301164047?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop10);

        Shop shop11 = Shop.builder()
                .name("이라부")
                .price(20000)
                .shopType(ShopType.PUB)
                .description("종종 사케 먹고 싶을 때 가는 곳, 여러 명이서 먹기도 좋고 타다끼와 타코와사비가 맛있다! 강추")
                .schoolType(SchoolType.NSC)
                .menuDescription("소고기타다끼 23000원\n타코와사비 12000원")
                .url("https://map.naver.com/p/search/%EC%9D%B4%EB%9D%BC%EB%B6%80/place/34958433?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop11);

        Shop shop12 = Shop.builder()
                .name("릴리펍")
                .price(20000)
                .shopType(ShopType.PUB)
                .description("조용하고 분위기가 좋다. 사장님이 친절하시다고 한다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("페페론치노 감바스바게트 24000원\n치즈플래터 34000원")
                .url("https://map.naver.com/p/search/%EB%A6%B4%EB%A6%AC%ED%8E%8D/place/1281001335?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop12);

        Shop shop13 = Shop.builder()
                .name("이자카야 슌")
                .price(20000)
                .shopType(ShopType.PUB)
                .description("조용한 분위기로 대화하기 적당한 이자카야, 산토리 위스키를 판다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("메로 미소구이 28000원\n하이볼 7000원")
                .url("https://map.naver.com/p/entry/place/37935974?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop13);

        Shop shop14= Shop.builder()
                .name("안도")
                .price(18000)
                .shopType(ShopType.PUB)
                .description("아늑한 분위기로 안주가 맛있는 이자카야")
                .schoolType(SchoolType.NSC)
                .menuDescription("야키토리 19000원\n시메사바 14000원")
                .url("https://map.naver.com/p/entry/place/1438224889?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop14);

        Shop shop15= Shop.builder()
                .name("대동집")
                .price(20000)
                .shopType(ShopType.PUB)
                .description("식사가 가능한 술집으로 왁자지껄한 분위기이다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("녹두해물김치전 17000원\n멸치국수 6000원")
                .url("https://map.naver.com/p/entry/place/1078299773?lng=126.97012122589702&lat=37.29892692777399&placePath=%2Fhome&entry=plt")
                .build();

        shopRepository.save(shop15);

        Shop shop16= Shop.builder()
                .name("이층포차")
                .price(17000)
                .shopType(ShopType.PUB)
                .description("사장님이 친절하고 음악이 좋다고 한다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("통골뱅이탕 29000원\n주전자오뎅탕 17000원")
                .url("https://map.naver.com/p/search/%EC%9D%B4%EC%B8%B5%ED%8F%AC%EC%B0%A8/place/1646597167?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop16);

        Shop shop17= Shop.builder()
                .name("인쌩맥주")
                .price(9000)
                .shopType(ShopType.PUB)
                .description("가성비가 좋고 안주가 맛있다. 왁자지껄한 분위기이다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("킬바소시지불닭볶음면 9000원\n살얼음맥주 3900원")
                .url("https://map.naver.com/p/search/%EC%9D%B8%EC%8C%A9%EB%A7%A5%EC%A3%BC/place/1187293011?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop17);

        Shop shop18= Shop.builder()
                .name("무지개맥주")
                .price(17000)
                .shopType(ShopType.PUB)
                .description("안주가 맛있고 인테리어가 깔끔하고 청결하다")
                .schoolType(SchoolType.NSC)
                .menuDescription("후라이드순살치킨 16900원\n차돌박이국물떡볶이 17900원")
                .url("https://map.naver.com/p/search/%EB%AC%B4%EC%A7%80%EA%B0%9C%EB%A7%A5%EC%A3%BC/place/1504596176?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop18);

        Shop shop19= Shop.builder()
                .name("뎅과꼬치로")
                .price(14000)
                .shopType(ShopType.PUB)
                .description("아묵에 특히 자부심이 있는 가게로 사장님과 직원분들이 친절하다고 한다.")
                .schoolType(SchoolType.NSC)
                .menuDescription("수제꼬치 7종 14000원\n프리미엄 오뎅 8종 16000원")
                .url("https://map.naver.com/p/search/%EB%8E%85%EA%B3%BC%EA%BC%AC%EC%B9%98%EB%A1%9C/place/1207624714?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop19);

        Shop shop20= Shop.builder()
                .name("DCT Bar")
                .price(12000)
                .shopType(ShopType.PUB)
                .description("성대역 주변으로 칵테일을 먹고 싶을 때 저렴하게 갈 수 있다. 바에 처음 가본다면, 피나콜라다 혹은 코스모폴리탄 추천")
                .schoolType(SchoolType.NSC)
                .menuDescription("코스모폴리탄 6000원\n피나콜라다 9000원")
                .url("https://map.naver.com/p/entry/place/19198224?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop20);


        em.flush();
        em.clear();

    }

    @Test
    void 데이터입력_명륜(){

        Shop shop = Shop.builder()
                .name("소친친")
                .price(13500)
                .shopType(ShopType.RESTAURANT)
                .description("중화풍 새우탕면을 판다, 꿔바로우도 추천한다.")
                .schoolType(SchoolType.HSSC)
                .menuDescription("새우탕면 12800원\n산서초꿔바로우 16000원")
                .url("https://map.naver.com/p/entry/place/36628482?lng=126.9997683&lat=37.5826089&placePath=%2Fhome&c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop);

        Shop shop2 = Shop.builder()
                .name("벅벅")
                .price(7000)
                .description("장사의 신에서 나온 맛집, 2층에서 먹을 수 있고 패티추가 강추!")
                .menuDescription("더블벅 버거 8700원\n케이준프라이 3500원")
                .schoolType(SchoolType.HSSC)
                .url("https://map.naver.com/p/entry/place/1652144509?c=15.00,0,0,0,dh")
                .shopType(ShopType.RESTAURANT)
                .build();

        shopRepository.save(shop2);

        Shop shop3 = Shop.builder()
                .name("버거파크")
                .price(9500)
                .description("미국식 버거를 연구했다는 가게")
                .menuDescription("베이컨 치즈버거 8800원\n크링클컷 감자튀김 3000원")
                .url("https://map.naver.com/p/search/%EB%B2%84%EA%B1%B0%ED%8C%8C%ED%81%AC/place/13158227?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .build();

        shopRepository.save(shop3);

        Shop shop4 = Shop.builder()
                .name("파스타마켓")
                .price(14000)
                .description("봉골레 파스타와 루꼴라 피자를 추천한다. 빠네 파스타는 빨리 안 먹으면 굳는다 ㅠ.")
                .menuDescription("파마 봉골레 파스타 15000원\n프로슈토 루꼴라 피자 21000원")
                .url("https://map.naver.com/p/search/%ED%8C%8C%EC%8A%A4%ED%83%80%EB%A7%88%EC%BC%93/place/1121062750?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .build();

        shopRepository.save(shop4);

        Shop shop5 = Shop.builder()
                .name("야스미")
                .price(11500)
                .description("양도 괜찮고 맛있는 집, 야끼소바도 추천한다.")
                .menuDescription("에비텐동 11500원\n야끼소바 14500원")
                .url("https://map.naver.com/p/search/%EC%95%BC%EC%8A%A4%EB%AF%B8/place/20871711?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .build();

        shopRepository.save(shop5);

        Shop shop6 = Shop.builder()
                .name("히든스시")
                .price(18000)
                .description("혜화에서 먹을 수 있는 스시집, 불연어, 불새우가 입에서 녹는다.")
                .menuDescription("모듭초밥 14000원\n특선초밥 18000원")
                .url("https://map.naver.com/p/entry/place/1608999501?c=15.00,0,0,0,dh")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .build();

        shopRepository.save(shop6);

        Shop shop7 = Shop.builder()
                .name("깔리")
                .price(13000)
                .description("인도식 카레/인도식 요거트 시켜 먹어도 맛있고 난도 맛있다.")
                .menuDescription("양고기 반달루(커리) 12000원, 칠리 치킨 13000원")
                .url("https://map.naver.com/p/search/%EA%B9%94%EB%A6%AC/place/12765748?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .build();

        shopRepository.save(shop7);

        Shop shop8 = Shop.builder()
                .name("서브웨이")
                .price(7000)
                .shopType(ShopType.RESTAURANT)
                .description("I인 사람은 힘들지만 모르면 야채는 빼는 것만 말하고 소스는 추천소스 뿌려달라하자. 빵은 모르면 플랫브레드 추천")
                .menuDescription("에그마요 4300원\n쿠키세트 1900원 추가")
                .schoolType(SchoolType.HSSC)
                .url("https://map.naver.com/p/search/%EB%8C%80%ED%95%99%EB%A1%9C%20%EC%84%9C%EB%B8%8C%EC%9B%A8%EC%9D%B4/place/34105503?c=14.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop8);

        Shop shop9 = Shop.builder()
                .name("포보")
                .price(8000)
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .description("맛이 엄청나기 보단 가성비가 좋다. 세트를 추천한다.")
                .menuDescription("로스세트 10500원\n치킨세트 10500원")
                .url("https://map.naver.com/p/search/%ED%8F%AC%EB%B3%B4/place/13561663?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop9);

        Shop shop10 = Shop.builder()
                .name("제순식당")
                .price(8000)
                .description("제육, 돈가스, 순두부찌개를 판다. 순두부찌개가 극락이다. 율전 사람이 오면 데려가보자.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .menuDescription("순두부찌개 7000원\n제육볶음 8000원")
                .url("https://map.naver.com/p/search/%EC%A0%9C%EC%88%9C%EC%8B%9D%EB%8B%B9/place/48142910?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop10);

        Shop shop11 = Shop.builder()
                .name("홍순두부")
                .description("가격이 진짜 저렴하다. 6000원이며 밥과 반찬이 무료다. 사장님이 뭘 남기는지 모르겠다.")
                .price(6000)
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .menuDescription("차돌 순두부 찌개 6000원\n해물 순두부 찌개 6000원")
                .url("https://map.naver.com/p/search/%ED%99%8D%EC%88%9C%EB%91%90%EB%B6%80/place/1247371776?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop11);

        Shop shop12 = Shop.builder()
                .name("준호네부대찌개")
                .price(7500)
                .description("메뉴가 정말 심플하다. 부대찌개 7500원 감튀, 밥, 음료가 무료 리필이다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .menuDescription("부대찌개(1인분)2인분부터 7500원")
                .url("https://map.naver.com/p/search/%EC%A4%80%ED%98%B8%EB%84%A4%EB%B6%80%EB%8C%80%EC%B0%8C%EA%B0%9C/place/1010064951?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop12);

        Shop shop13 = Shop.builder()
                .name("철문집온")
                .price(12000)
                .description("고기와 목살이 맛있다 1인분이 300g인데 9800원이다. 미쳤다. 단품 구매도 되니 MT때 사가세요.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .menuDescription("돼지 통목살(300g) 9800원\n야채 삼겹살(600g) 24800원")
                .url("https://map.naver.com/p/search/%EC%B2%A0%EB%AC%B8%EC%A7%91/place/1292398354?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop13);

        Shop shop14 = Shop.builder()
                .name("스시마시따")
                .price(9000)
                .description("남자 셋이서 50접시에 세트 2개 시키고 8만원 정도 나온다. 스시퀄리티보단 스시 자체가 먹고 싶은 사람에게 추천")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .menuDescription("한접시 1550원\nVIP초밥(16개) 20000원")
                .url("https://map.naver.com/p/search/%EC%8A%A4%EC%8B%9C%EB%A7%88%EC%8B%9C%EB%94%B0/place/33624760?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop14);

        Shop shop15 = Shop.builder()
                .name("혼가츠")
                .price(9000)
                .description("넓고 맛도 좋다고 한다. 율전에선 쉽게 먹을 수 없는 치즈돈까스를 먹을 수 있다. 부럽다...")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .menuDescription("치즈돈까스 9000원\n우삼겹라멘&돈가스 세트 10000원")
                .url("https://map.naver.com/p/search/%ED%98%BC%EA%B0%80%EC%B8%A0/place/40560125?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop15);

        Shop shop16 = Shop.builder()
                .name("홍곱창")
                .price(20000)
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .description("야채곱창과 데리야끼막창이 맛있는 집")
                .menuDescription("야채곱창 13000원\n데리야끼막창 15000원")
                .url("https://map.naver.com/p/search/%ED%99%8D%EA%B3%B1%EC%B0%BD/place/38556374?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop16);

        Shop shop17 = Shop.builder()
                .name("미도인")
                .price(10500)
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .description("일식 덮밥을 파는 곳인데, 신촌점이 더 맛있다.")
                .menuDescription("미도인 스테이크 덮밥 10500원\n우단스 정식 16800원")
                .url("https://map.naver.com/p/search/%EB%AF%B8%EB%8F%84%EC%9D%B8/place/1747236582?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop17);

        Shop shop18 = Shop.builder()
                .name("정통집")
                .price(20000)
                .description("콘치즈추가 하면 진짜 극락이 따로 없다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .menuDescription("돼지김치구이 25000원\n꽃껍데기 9000원")
                .url("https://map.naver.com/p/entry/place/1942122232?c=14.78,0,0,0,dh")
                .build();

        shopRepository.save(shop18);

        Shop shop19 = Shop.builder()
                .name("갸우뚱")
                .price(20000)
                .description("중국식 만두, 멘보샤, 어향동구, 동파육을 먹을 수 있는 곳, 가격이 좀 있다.")
                .menuDescription("마파두부 24000원\n어향가지 덮밥 11800원")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .url("https://map.naver.com/p/search/%EA%B0%B8%EC%9A%B0%EB%9A%B1/place/1854089051?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop19);

        Shop shop20 = Shop.builder()
                .name("쇼타돈부리")
                .price(9000)
                .description("일식 덮밥과 카레를 파는데 덮밥이 더 맛있다.")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .menuDescription("가츠동 9000원\n사케동 12000원")
                .url("https://map.naver.com/p/entry/place/300200699?c=14.00,0,0,0,dh")
                .build();

        shopRepository.save(shop20);

        Shop shop21 = Shop.builder()
                .name("나누미떡볶이")
                .price(5000)
                .description("맛이 있긴 한데 생각보다 비싸다... 어묵 1500원...")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .menuDescription("쌀떡볶이 5000원\n부산어묵 1500원")
                .url("https://map.naver.com/p/search/%EB%82%98%EB%88%84%EB%AF%B8%EB%96%A1%EB%B3%B6%EC%9D%B4/place/11681136?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop21);

        Shop shop22 = Shop.builder()
                .name("대가곱창")
                .price(13000)
                .description("인테리어가 귀엽고 친절한 사장님이 계심. 깔끔하고 안심되는 식당")
                .menuDescription("야채곱창 12000원\n산더미치즈곱창 14000원")
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/36630769?c=16.67,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .build();

        shopRepository.save(shop22);

        Shop shop23 = Shop.builder()
                .name("삼삼오오")
                .price(7500)
                .description("무난하게 맛있는 한식집. 가성비 좋고 맛도 좋다.")
                .menuDescription("오삼불고기 7500원\n부대찌개 7000원")
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/18678718?c=16.67,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .build();

        shopRepository.save(shop23);

        Shop shop24 = Shop.builder()
                .name("지지고")
                .price(4000)
                .description("이용하기 간단하고 혼밥하기에도 좋은 컵밥")
                .menuDescription("나이스라이스 4000원\n누들두들 4000원")
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/1867273513?c=16.67,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .build();

        shopRepository.save(shop24);

        Shop shop25 = Shop.builder()
                .name("작은마을생선구이")
                .price(7500)
                .description("조선시대 조상님들의 향기를 느낄 수 있다. 양이 아주 푸짐하다.")
                .menuDescription("고등어구이 7500원\n가자미구이 7500원")
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/20875465?c=16.67,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .build();

        shopRepository.save(shop25);

        Shop shop26 = Shop.builder()
                .name("프라이팬")
                .price(7000)
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .description("무난하게 맛있는 한식집. 가성비도 좋다.")
                .menuDescription("김치제육덮밥 7000원\n로제치킨스파게티 7500원")
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/80949466?c=16.67,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop26);

        Shop shop27 = Shop.builder()
                .name("일미식당")
                .price(6000)
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .description("리뉴얼 후 외관이 더 깔끔해졌으며, 음식은 든든하고 푸짐하다")
                .menuDescription("청국장찌개 9000원\n제육볶음 10000원")
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/17977261?c=16.67,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop27);

        Shop shop28 = Shop.builder()
                .name("뉴욕버거")
                .price(5000)
                .description("600주년 기념관 지하에 위치하며, 무난한 수제버거 집")
                .menuDescription("뉴욕버거 4600원\n치킹버거 4700원")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/1226515971?c=16.67,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop28);

        Shop shop29 = Shop.builder()
                .name("멕시카나치킨")
                .price(20000)
                .description("매장이 청결하고, 사장님이 친절한 치킨집. 치토스치킨 존재!")
                .menuDescription("치토스치킨 20000원\n마늘알마니치킨 21000원")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/1813970537?c=16.67,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop29);

        Shop shop30 = Shop.builder()
                .name("노가네")
                .price(6000)
                .description("쪽문 쪽에 위치한 가성비 좋은 돈까스집")
                .menuDescription("나쵸치즈돈까스 6000원\n바베큐치즈돈까스 6000원")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/18678962?c=16.67,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop30);

        Shop shop31 = Shop.builder()
                .name("맘스터치")
                .price(5000)
                .description("가성비 좋은 치킨버거를 먹고 싶다면 추천")
                .menuDescription("언빌리버블버거 5100원\n인크레더블버거 4900원")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/37394662?c=16.67,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop31);

        Shop shop32 = Shop.builder()
                .name("하이루")
                .price(10000)
                .description("메뉴가 다양하고 맛있으며 혼밥하기도 무난하다")
                .menuDescription("하이루까스 8800원\n등심까스 7500원")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/1570359370?c=16.67,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop32);

        Shop shop33 = Shop.builder()
                .name("머노까머나")
                .price(16000)
                .description("인도요리를 즐길 수 있고 양이 푸짐하다")
                .menuDescription("머노까머나세트 16000원\n탄두리치킨 18000원")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/20103854?c=15.17,0,0,0,dh&placePath=%3Fentry%253Dbmp%2526n_ad_group_type%253D10%2526n_query%253D%25EC%258B%259D%25EB%258B%25B9")
                .build();

        shopRepository.save(shop33);

        Shop shop34 = Shop.builder()
                .name("일송칼국수")
                .price(9000)
                .description("국물이 걸쭉한 느낌이고, 김치가 맛있다")
                .menuDescription("사골칼국수 8000원\n바지락칼국수 9000원")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/13534204?c=15.45,0,0,0,dh&placePath=%3Fentry%3Dbmp")
                .build();

        shopRepository.save(shop34);

        Shop shop35 = Shop.builder()
                .name("명륜진사갈비")
                .price(19000)
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .description("숯불돼지갈비 통삼겹살 등 모두 무한리필 가능한 유명한 맛집")
                .menuDescription("숯불돼지갈비 18900원\n소갈비살 9000원")
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/1233726670?c=15.45,0,0,0,dh&placePath=%3Fentry%3Dbmp")
                .build();

        shopRepository.save(shop35);

        Shop shop36 = Shop.builder()
                .name("타겟")
                .price(6000)
                .description("퓨전 타코를 즐길 수 있어 색다른 맛을 즐기고 싶다면 추천")
                .menuDescription("새우타코 6000원\n엘로떼 8500원")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/1873388687?c=15.45,0,0,0,dh&placePath=%3Fentry%3Dbmp")
                .build();

        shopRepository.save(shop36);

        Shop shop37 = Shop.builder()
                .name("백미향마라탕")
                .price(18000)
                .description("너무 맵지 않게 즐길 수 있으며, 직원분들이 친절한 마라탕집")
                .menuDescription("마라탕 18000원\n마라샹궈 15000원")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/1916048074?c=15.45,0,0,0,dh&placePath=%3Fentry%3Dbmp")
                .build();

        shopRepository.save(shop37);

        Shop shop38 = Shop.builder()
                .name("아도레 쿠치나")
                .price(20000)
                .description("자리가 넓고 편한 분위기에서 식사할 수 있다. 캐주얼, 포멀한 식사에 모두 어울리는 식당.")
                .menuDescription("깔죠네 리코타 샐러드 20000원\n통오징어 로제 파스타 16000원")
                .shopType(ShopType.RESTAURANT)
                .schoolType(SchoolType.HSSC)
                .url("https://map.naver.com/p/search/%EC%8B%9D%EB%8B%B9/place/784830705?c=15.45,0,0,0,dh&placePath=%3Fentry%3Dbmp")
                .build();

        shopRepository.save(shop38);

        em.flush();
        em.clear();

    }

    @Test
    void 데이터입력_카페_명륜(){

        Shop shop = Shop.builder()
                .name("오가다")
                .price(4000)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .menuDescription("아메리카노 4000원\n플레인 크로플 3500원")
                .description("공부하기에 괜찮고 앞사람이랑 칸막이가 쳐져있어서 공부할만한 공간이 따로 만들어져있고 콘센트도 있다. 예약 룸도 있다.")
                .url("https://map.naver.com/p/search/%EC%98%A4%EA%B0%80%EB%8B%A4/place/1160800470?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop);

        Shop shop2 = Shop.builder()
                .name("브라운에비뉴")
                .price(4500)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("사장님이 엄청 친절하시다. 사진 찍는거 좋아하는 사람이 인생샷 건질 수 있는 곳. ** 아몬드 브리즈 라떼 추천**")
                .menuDescription("아메리카노 4500원\n아몬드 브리즈 라떼 6500원")
                .url("https://map.naver.com/p/search/%EB%B8%8C%EB%9D%BC%EC%9A%B4%EC%97%90%EB%B9%84%EB%89%B4/place/35545619?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop2);

        Shop shop3 = Shop.builder()
                .name("위치스 커피")
                .price(4000)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("에그타르트 맛집으로 유명하고 시키면 구워서 잘라주신다. 자리마다 콘센트가 있어 공부하기도 좋다.")
                .menuDescription("아메리카노 4000원\n에그타르트 2900원")
                .url("https://map.naver.com/p/search/%EC%9C%84%EC%B9%98%EC%8A%A4%EC%BB%A4%ED%94%BC/place/19763664?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop3);

        Shop shop4 = Shop.builder()
                .name("삼 원 샏")
                .price(4500)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("크로플 찐 맛집이다. 내부 인테리어는 한옥형태로 꾸며져 있다. 근데 가격은?")
                .menuDescription("아메리카노 4500원\n크로플 9000원")
                .url("https://map.naver.com/p/search/%EC%A0%84%EA%B4%91%EC%88%98%EC%BB%A4%ED%94%BC%20%ED%98%9C%ED%99%94/place/17976968?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop4);

        Shop shop5 = Shop.builder()
                .name("카페 사흘")
                .price(6000)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("조명이 없는 느낌이라 공부하기 안 좋다.. 조용히 얘기하기엔 좋은 곳")
                .menuDescription("아메리카노 4500원\n오늘의커피 6000원")
                .url("https://map.naver.com/p/search/%EC%B9%B4%ED%8E%98%20%EC%82%AC%ED%9D%98/place/36059355?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop5);

        Shop shop6 = Shop.builder()
                .name("엘빈")
                .price(4000)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("음료가 맛잇는건 모르겠지만 공부하기에는 좋은 곳")
                .menuDescription("아메리카노 4000원\n스무디 6000원")
                .url("https://map.naver.com/p/search/%EC%97%98%EB%B9%88/place/11592517?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop6);

        Shop shop7 = Shop.builder()
                .name("낫컴플리트")
                .price(4300)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("완전 유명한 곳 크로플이 진짜 맛있다. 그리고 고양이가 있어서 알레르기 심한 사람은 비추...")
                .menuDescription("아메리카노 4300원\n낫크로플 7500원")
                .url("https://map.naver.com/p/search/%EB%82%AB%EC%BB%B4%ED%94%8C%EB%A6%AC%ED%8A%B8/place/1141273055?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop7);

        Shop shop8 = Shop.builder()
                .name("가비아노")
                .price(4500)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("어두컴컴한 카페+바 느낌의 장소, 친구랑 대화 나누기에 되게 좋다.")
                .menuDescription("아메리카노 4500원\n카페라떼 5500원")
                .url("https://map.naver.com/p/search/%EA%B0%80%EB%B9%84%EC%95%84%EB%85%B8/place/11609743?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop8);

        Shop shop9 = Shop.builder()
                .name("pit a pat")
                .price(3500)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("북카페 같은 느낌으로 책 무료로 다 읽을 수 있고 가성비 쿠키와 토스트를 판다.")
                .menuDescription("아메리카노 3500원\n닭안심 샌드위치 5800원")
                .url("https://map.naver.com/p/search/pit%20a%20pat/place/1281392343?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop9);

        Shop shop10 = Shop.builder()
                .name("델라")
                .price(3500)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("정문에 있는 곳 으로 수제 쿠키나 디저트 같은 걸 걸 판다.")
                .menuDescription("아메리카노 3500원\n소금빵 2200원")
                .url("https://map.naver.com/p/search/%EB%8D%B8%EB%9D%BC/place/1259713363?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop10);

        Shop shop11 = Shop.builder()
                .name("칠린")
                .price(10000)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("테이블 간격이 좁아서 불편하다. 외관에 비해 인테리어는 평범함.")
                .menuDescription("크림라떼 5500원\n시그니처 칵테일 10000원")
                .url("https://map.naver.com/p/search/%EC%B9%A0%EB%A6%B0/place/1267097142?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop11);

        Shop shop12 = Shop.builder()
                .name("블루룸")
                .price(5000)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("인스타 감성 카페 느낌, 가격이 비싸다. 무겁고 느린 음악이 나오는데 수다 떨려고 만났는데 나만 떠들고 있는 느낌이다.")
                .menuDescription("메뉴 가격을 잘 모르겠습니다. 댓글 남겨주세요.")
                .url("https://map.naver.com/p/search/%ED%98%9C%ED%99%94%EB%B8%94%EB%A3%A8%EB%A3%B8/place/1736149592?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop12);

        Shop shop13 = Shop.builder()
                .name("일월일일")
                .price(5000)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("고급화된 찰떡아이스를 먹을 수 있다. 비싸지만 맛있다.")
                .menuDescription("아메리카노 5000원\n찰떡아이스크림 5500원")
                .url("https://map.naver.com/p/search/%EC%9D%BC%EC%9B%94%EC%9D%BC%EC%9D%BC/place/1839696543?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop13);

        Shop shop14= Shop.builder()
                .name("도밍고팩토리")
                .price(5500)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("쑥 라떼가 매우 유명한 곳이고 맛있다. 하지만 카페가 좁고 의자가 불편하다.")
                .menuDescription("쑥 라떼 5500원\n섬머코코라떼 5500원")
                .url("https://map.naver.com/p/search/%EB%8F%84%EB%B0%8D%EA%B3%A0%ED%8C%A9%ED%86%A0%EB%A6%AC/place/37658488?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop14);

        Shop shop15= Shop.builder()
                .name("학림")
                .price(6500)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("오래된 역사와 같은 카페? 교수님의 추천으로 가봤는데 사람이 많아서 못 마시고 나왔다.")
                .menuDescription("비엔나커피 6500원\n크림 치즈케익 6500원")
                .url("https://map.naver.com/p/search/%ED%95%99%EB%A6%BC%EB%8B%A4%EB%B0%A9/place/11716359?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop15);

        Shop shop16= Shop.builder()
                .name("스노브")
                .price(4000)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("케이크가 메인인데 맛있는지는 모르겠고 예쁜 가게이다.")
                .menuDescription("아메리카노 4000원\n팥빙수 6000원")
                .url("https://map.naver.com/p/search/%EC%8A%A4%EB%85%B8%EB%B8%8C/place/34412589?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop16);

        Shop shop17= Shop.builder()
                .name("205도씨")
                .price(4500)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("티라미수가 맛있는데 비싸다.")
                .menuDescription("아메리카노 4500원\n티라미수 아메리카노 세트 11500원")
                .url("https://map.naver.com/p/search/%EC%9D%B4%EA%B3%B5%EC%98%A4%EB%8F%84%EC%94%A8/place/20300076?c=15.00,0,0,0,dh&isCorrectAnswer=true")
                .build();

        shopRepository.save(shop17);

        Shop shop18= Shop.builder()
                .name("첫만남")
                .price(3000)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("정돈 근처에 있고 꽃과 정원의 감성, 여름에 파는 망고빙수가 진짜 엄청 맛있음.")
                .menuDescription("아메리카노 4000원\n에그 푸딩 4500원")
                .url("https://map.naver.com/p/search/%EC%B2%AB%EB%A7%8C%EB%82%A8/place/13331683?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop18);

        Shop shop19= Shop.builder()
                .name("무던")
                .price(8000)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("잠깐 있다 가기엔 좋다. 겨울에는 난로에서 둘이서만 젤라또 먹으면서 얘기할 수 있다.")
                .menuDescription("젤라또 컵/콘 6500원\n젤라또 XS 20000원")
                .url("https://map.naver.com/p/search/%EB%AC%B4%EB%8D%98/place/1912032850?c=15.00,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop19);

        Shop shop20= Shop.builder()
                .name("건강한빵")
                .price(4500)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("앙버터와 토토바가 맛있는 집, 토토바 갓 나와서 따뜻한 거 겨울에 먹으면 진짜 맛있다.")
                .menuDescription("앙버터 4500원\n토토바 5500원")
                .url("https://map.naver.com/p/entry/place/37842090?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop20);

        Shop shop21= Shop.builder()
                .name("솔트24")
                .price(2800)
                .shopType(ShopType.CAFE)
                .schoolType(SchoolType.HSSC)
                .description("버스 정류장에서 서브웨이가기 싫어서 간 곳, 시오빵과 솔트 크로상이 주 메뉴인데 개인적으로 난 건강한 빵 감.")
                .menuDescription("시오빵 2800원\n솔트 크로아상 3800원")
                .url("https://map.naver.com/p/entry/place/37842090?c=15.00,0,0,0,dh")
                .build();

        shopRepository.save(shop21);


        em.flush();
        em.clear();

    }

    @Test
    void 데이터입력_술집_인문사회(){

        Shop shop = Shop.builder()
                .name("마님은왜돌쇠에게만술을주시나")
                .price(20000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("이름이 특이한 술집. 안주가 맛있고, 내부는 작지만 아늑한 느낌.")
                .menuDescription("오뎅 닭볶음탕 25000원\n오목이 15000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/1686067670?c=15.30,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop);

        Shop shop2 = Shop.builder()
                .name("04판")
                .price(20000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("너무 조용하지도 않고 너무 시끄럽지도 않은 술집으로 안주가 고퀄리티다")
                .menuDescription("특별한 조개술찜 38000원\n투쁠한우 육회 김밥 23000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/1409207151?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop2);

        Shop shop3 = Shop.builder()
                .name("동화")
                .price(20000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("이색적이면서도 편안한 맛을 제공한다. 특이한 안주들이 많음.")
                .menuDescription("동화닭갈비 24000원\n청양고추크림파스타+돈까스 22000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/1669566053?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop3);

        Shop shop4 = Shop.builder()
                .name("술비")
                .price(20000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("끝없이 메뉴를 개발한다고 하며 한식과 양식을 한 그릇에 담아낸 표전 요리주점")
                .menuDescription("바지락버터 술찜과 파스타 26000원\n청양 쉬림프 파스타 19000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/1123934065?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop4);

        Shop shop5 = Shop.builder()
                .name("달빛마루")
                .price(20000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("한옥에 빈티지한 동양느낌의 요리주점")
                .menuDescription("소시지스테이크 29000원\n해파리냉채족발 28000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/20724809?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop5);

        Shop shop6 = Shop.builder()
                .name("고엔")
                .price(20000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("안주가 맛있고 하이볼이 잘 어울리는 이자카야")
                .menuDescription("매콤해물파스타전골 25000원\n고엔 명-치-감 18500원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/21074680?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop6);

        Shop shop7 = Shop.builder()
                .name("머쉬룸서울")
                .price(10000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("음식 종류가 많고, 단체모임 하기에 적당한 술집")
                .menuDescription("치킨&청양크림떡볶이 24500원\n진라면 투움바 9500원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/1079143859?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop7);

        Shop shop8 = Shop.builder()
                .name("비스라운지")
                .price(14000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("가성비 좋고 데이트 코스에 알맞은 술집")
                .menuDescription("이태리 감자채전 13900원\n소다 하이볼 7000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/1326247511?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop8);

        Shop shop9 = Shop.builder()
                .name("서울바당")
                .price(20000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("얼마 없는 해산물 포차로 가격이 나가는 만큼 맛있는 술집")
                .menuDescription("바당한상 40000원\n육사시미 23000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/1793838609?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop9);

        Shop shop10 = Shop.builder()
                .name("단골손님")
                .price(14000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("한국식 주점으로 밥과 술을 함께 먹기 좋은 술집")
                .menuDescription("꼬막육회비빔밥 23500원\n블루베리 막걸리 12000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/1159737702?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop10);

        Shop shop11 = Shop.builder()
                .name("독일주택")
                .price(12000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("분위기있는 한옥에서 맥주를 즐길 수 있다")
                .menuDescription("소시지 플레이트 25000원\n해레틱 이블트윈 레드에일 11000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/35457552?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop11);

        Shop shop12 = Shop.builder()
                .name("토라")
                .price(9000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("가성비 최강 이자카야 집")
                .menuDescription("감튀 오꼬노미야끼 9900원\n새우오꼬노미야끼 8900원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/1293675280?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop12);

        Shop shop13 = Shop.builder()
                .name("수도원")
                .price(15000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("호그와트 분위기 나는 와인 맥주집")
                .menuDescription("성찬 플레이트 29000원\n델리리움 트레멘스 15000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/37691225?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop13);

        Shop shop14 = Shop.builder()
                .name("퍼센트")
                .price(24000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("닭발 먹고 싶다면 가는 집. 술 값도 저렴하다.")
                .menuDescription("무뼈 화산닭발 24000원\n순살 곱도리탕 26000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/1428920522?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop14);

        Shop shop15 = Shop.builder()
                .name("맥덕스")
                .price(12000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("맥주와 피자를 함께 먹는 술집으로 야외 테이블도 존재함")
                .menuDescription("더블치즈피자 12000원\n페페로니피자 12000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/33586500?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop15);

        Shop shop16 = Shop.builder()
                .name("민들레처럼")
                .price(20000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("레트로 감성의 막걸리집으로 아늑한 느낌")
                .menuDescription("깔끔상 2인 40000원\n김치전 20000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/37673536?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop16);

        Shop shop17 = Shop.builder()
                .name("삼촌은총각")
                .price(8000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("메뉴가 다양하고 가벼운 안주들도 많은 이자카야")
                .menuDescription("돈까스정식 8000원\n함박스테이크 12000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/35965816?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop17);

        Shop shop18 = Shop.builder()
                .name("동숭골")
                .price(20000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("정성가득한 안주와 레트로한 분위기의 주막")
                .menuDescription("땡초장육 26000원\n애호박돼지찌개 23000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/20207427?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop18);

        Shop shop19 = Shop.builder()
                .name("혜화식당")
                .price(20000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("신선한 생고기를 이용한 육회와 육사시미가 대표적인 하이볼이 맛있는 요리주점")
                .menuDescription("매운사태찜 25000원\n한우튀김 20000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/71138318?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop19);

        Shop shop20 = Shop.builder()
                .name("집시포차")
                .price(25000)
                .shopType(ShopType.PUB)
                .schoolType(SchoolType.HSSC)
                .description("가성비 좋고 직원분들도 친절한 포차")
                .menuDescription("수육전골 25000원\n순살치킨+해물볶음우동 29000원")
                .url("https://map.naver.com/p/search/%EC%88%A0%EC%A7%91/place/1438050869?c=15.15,0,0,0,dh&placePath=%3Fentry%253Dbmp")
                .build();

        shopRepository.save(shop20);


        em.flush();
        em.clear();

    }

    @Autowired
    ShopRecommendService shopRecommendService;

    @Autowired
    RecommendRepository recommendRepository;

    @Test
    void 동적쿼리작동확인(){


        // 0개
        List<String> shopType = new ArrayList<>();
        Shop selectedShop1 = recommendRepository.findSelectedShop("nsc", shopType, 1000, 20000).get(0);
        System.out.println(selectedShop1);

        List<String> shopType1 = new ArrayList<>();
        Shop selectedShop2 = recommendRepository.findSelectedShop("hssc", shopType1, 1000, 20000).get(0);
        System.out.println(selectedShop2);

        List<String> shopType2 = new ArrayList<>();
        shopType2.add("cafe");
        Shop selectedShop3 = recommendRepository.findSelectedShop("nsc", shopType2, 1000, 20000).get(0);
        System.out.println(selectedShop3);

        List<String> shopType3 = new ArrayList<>();
        shopType3.add("cafe");
        Shop selectedShop4 = recommendRepository.findSelectedShop("hssc", shopType3, 1000, 20000).get(0);
        System.out.println(selectedShop4);

        List<String> shopType4 = new ArrayList<>();
        shopType4.add("restaurant");
        shopType4.add("cafe");
        Shop selectedShop5 = recommendRepository.findSelectedShop("nsc", shopType4, 1000, 20000).get(0);
        System.out.println(selectedShop5);

        List<String> shopType5 = new ArrayList<>();
        shopType5.add("restaurant");
        shopType5.add("cafe");
        Shop selectedShop6 = recommendRepository.findSelectedShop("nsc", shopType5, 1000, 20000).get(56);
        System.out.println(selectedShop6);

        List<String> shopType6 = new ArrayList<>();
        shopType6.add("restaurant");
        shopType6.add("cafe");
        shopType6.add("pub");
        Shop selectedShop7 = recommendRepository.findSelectedShop("nsc", shopType6, 1000, 20000).get(56);
        System.out.println(selectedShop7);
    }


}