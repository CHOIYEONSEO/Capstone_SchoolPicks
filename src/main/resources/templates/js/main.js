$(document).ready(function(){

    //오른쪽 상단 사람 이미지 클릭시 dropdown 보이기/숨기기
    var dropdown = document.getElementById("dropdown_div");

    $('#top_button_div').click(function(){
        if(dropdown.style.display=='none' || dropdown.style.display == ''){
            dropdown.style.display='block';
        } else{
            dropdown.style.display='none';
        }
        
    });

 
})


