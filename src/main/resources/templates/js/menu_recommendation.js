const restaurantTag = document.getElementById('tag_restaurant');
const cafeTag = document.getElementById('tag_cafe');
const pubTag = document.getElementById('tag_pub');

const detailBtn = document.getElementById('goto_detail');


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

detailBtn.addEventListener("click", (e) => {
    /*alert("음식점 세부 정보");*/
    window.location.href = "./detail.html";
})