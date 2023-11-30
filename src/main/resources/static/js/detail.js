var mapXPosition = document.getElementById("map_x_position").innerText;
var mapYPosition = document.getElementById("map_y_position").innerText;

var mapOptions = {
    center: new naver.maps.LatLng(mapXPosition, mapYPosition),
    zoom: 15
};

var map = new naver.maps.Map('map', mapOptions);

var marker = new naver.maps.Marker({
    position: new naver.maps.LatLng(mapXPosition, mapYPosition), /* 5번째줄 경도 위도와 동일한 값으로*/
    map: map,
    icon: {
        url: '/images/logo.png',
        scaledSize: new naver.maps.Size(37, 37),
        origin: new naver.maps.Point(0, 0),
      }
});