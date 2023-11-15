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
        // 현재 페이지의 URL을 클립보드에 복사
        var currentUrl = window.location.href;
        navigator.clipboard.writeText(currentUrl).then(function() {
            alert("주소가 복사되었습니다!");
        }).catch(function(err) {
            console.error('클립보드 복사 실패: ', err);
        });

        window.location.href = "./ver1-instagram-story.html";
    });
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