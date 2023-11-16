var groupContainer8 = document.getElementById("groupContainer8");
if (groupContainer8) {
    groupContainer8.addEventListener("click", function (e) {
        window.location.href = "./find-mate-ver1.html";
    });
}

//button for clipboard href -> need to make button for clip board
var groupContainer9 = document.getElementById("insta1");
if (groupContainer9) {
    groupContainer9.addEventListener("click", function (e) {
        var linkToCopy = window.location.href; // 현재 페이지의 링크를 가져옴
        navigator.clipboard.writeText(linkToCopy).then(function() {
            alert('링크가 클립보드에 저장되었습니다.');
        }).catch(function(err) {
            console.error('클립보드 저장 실패: ', err);
        });
    }
}

//temp for sharing: find-mate-ver1
var groupContainer10 = document.getElementById("clipbutton");
if (groupContainer10) {
    groupContainer10.addEventListener("click", function (e) {
        window.location.href = "./ver1-instagram-story.html";
    });
}

//temp for sharing: find-mate-ver2
var groupContainer11 = document.getElementById("insta2");
if (groupContainer11) {
    groupContainer11.addEventListener("click", function (e) {
        window.location.href = "./ver2-instagram-story.html";
    });
}

//temp for sharing: find-mate-ver3
var groupContainer12 = document.getElementById("insta3");
if (groupContainer12) {
    groupContainer12.addEventListener("click", function (e) {
        window.location.href = "./ver3-instagram-story.html";
    });
}