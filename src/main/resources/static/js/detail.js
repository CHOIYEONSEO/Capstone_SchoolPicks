var mapOptions = {
    center: new naver.maps.LatLng(37.293927, 126.974376),
    zoom: 15
};

var map = new naver.maps.Map('map', mapOptions);

var marker = new naver.maps.Marker({
    position: new naver.maps.LatLng(37.293927, 126.974376), /* 2번째줄 경도 위도와 동일한 값으로*/
    map: map,
    icon: {
        url: '/images/logo.png',
        scaledSize: new naver.maps.Size(37, 37),
        origin: new naver.maps.Point(0, 0),
      }
});