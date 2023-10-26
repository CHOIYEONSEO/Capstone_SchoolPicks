const restaurantTag = document.getElementById('tag_restaurant');
const cafeTag = document.getElementById('tag_cafe');
const pubTag = document.getElementById('tag_pub');

let restaurant_count = 1;
let cafe_count = 1;
let pub_count = 1;

/* 음식점 태그 클릭시 색 변환 */
restaurantTag.addEventListener("click", (e) => {
    if (restaurant_count % 2 == 1) {
        e.target.style.backgroundColor = "rgba(252,180,221,0.8)";
    } else {
        e.target.style.backgroundColor = "#DFDFDF";
    }
    restaurant_count += 1;
});

/* 카페 태그 클릭시 색 변환 */
cafeTag.addEventListener("click", (e) => {
    if (cafe_count % 2 == 1) {
        e.target.style.backgroundColor = "rgba(254,214,98,0.8)";
    } else {
        e.target.style.backgroundColor = "#DFDFDF";
    }
    cafe_count += 1;
});

/* 술집 태그 클릭시 색 변환 */
pubTag.addEventListener("click", (e) => {
    if (pub_count % 2 == 1) {
        e.target.style.backgroundColor = "rgba(164,231,231,0.8)";
    } else {
        e.target.style.backgroundColor = "#DFDFDF";
    }
    pub_count += 1;
});

/* 자판기 클릭시 추천 음식점 변경 */
/* 자과캠 */
const vendingMachine = document.getElementById('vending_machine_img');

vendingMachine.addEventListener("click", (e) => {
    var recommendation = '율천회관';

    document.getElementById('recommendation_NSC').innerHTML = recommendation;
})

/* 명륜캠 */
vendingMachine.addEventListener("click", (e) => {
    var recommendation = '나누미떡볶이';

    document.getElementById('recommendation_HSSC').innerHTML = recommendation;
})