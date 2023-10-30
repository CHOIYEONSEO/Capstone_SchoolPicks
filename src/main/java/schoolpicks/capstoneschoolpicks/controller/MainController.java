package schoolpicks.capstoneschoolpicks.controller;

import schoolpicks.capstoneschoolpicks.service.ShopRecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {
    final ShopRecommendService shopRecommendService;

//    @PostMapping("/jumechu")
//    public ResponseDto<?> jumechu(@RequestBody RecommendDto requestBody){
//
//        RecommendResponseDto recommendResponseDto = null;
//        Shop shop = shopRecommendService.recommend(requestBody);
//
//        if(shop == null)
//            return ResponseDto.setFailed("데이터를 가져오지 못했습니다.");
//        else{
//
//            recommendResponseDto.setAnswer(shop.getName());
//            recommendResponseDto.setDescription(shop.getDescription());
//            return ResponseDto.setSuccess("Success!", recommendResponseDto);
//        }
//
//    }

}
