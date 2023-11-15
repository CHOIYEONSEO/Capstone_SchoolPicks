var groupContainer8 = document.getElementById("groupContainer8");
if (groupContainer8) {
    groupContainer8.addEventListener("click", function (e) {
        window.location.href = "./find-mate-ver1.html";
    });
}

//temp for sharing: find-mate-ver1
var groupContainer8 = document.getElementById("insta1");
if (groupContainer8) {
    groupContainer8.addEventListener("click", function (e) {
        window.location.href = "./ver1-instagram-story.html";
    });
}

//현재 url 변수로 가져오기
let nowUrl = window.location.href;

function copyUrl(){ 
  //nowUrl 변수에 담긴 주소를
  	navigator.clipboard.writeText(nowUrl).then(res=>{
	  alert("주소가 복사되었습니다!");
	})
}


//temp for sharing: find-mate-ver2
var groupContainer8 = document.getElementById("insta2");
if (groupContainer8) {
    groupContainer8.addEventListener("click", function (e) {
        window.location.href = "./ver2-instagram-story.html";
    });
}

//temp for sharing: find-mate-ver2
var groupContainer8 = document.getElementById("insta3");
if (groupContainer8) {
    groupContainer8.addEventListener("click", function (e) {
        window.location.href = "./ver3-instagram-story.html";
    });
}