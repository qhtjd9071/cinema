<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>slide</title>

<style>    
	.slide_container {width:100%; height:774px; position:relative; overflow:hidden;}
	
	.myslide {width:100%; height:100%; background-color:brown;background-size:cover; background-position:center; display:block; position:absolute; top:0; left:100%;}
	.myslide:first-child {left:0;}
	.myslide:nth-child(11) {left:-100%;}
	
	.button_prev {width:31px; height:60px; position:absolute; left:30px; top:50%; color:white; background-image:url('images/main/arr_lf_31_wht.png'); opacity:0.8; transition:opacity 0.3s; z-index:10;}
	.button_prev:hover {opacity:1;}
	.button_next {width:31px; height:60px; position:absolute; right:30px; top:50%; color:white; background-image:url('images/main/arr_rg_31_wht.png');  opacity:0.8; transition:opacity 0.3s; z-index:10;}
	.button_next:hover {opacity:1;}
	
	.myslide1_bg {width:100%; height:100%; background-image:url(images/main/Ella_1920774.jpg); background-size:cover; background-position:center; display:flex; flex-direction:column; justify-content:center;}
	.myslide2_bg {width:100%; height:100%; background-image:url(images/main/Spiral_1920774.jpg); background-size:cover; background-position:center; display:flex; flex-direction:column; justify-content:center;}
	.myslide3_bg {width:100%; height:100%; background-image:url(images/main/InTheHeights_1920774.jpg); background-size:cover; background-position:center; display:flex; flex-direction:column; justify-content:center;}
	.myslide4_bg {width:100%; height:100%; background-image:url(images/main/TheFast_1920774.jpg); background-size:cover; background-position:center; display:flex; flex-direction:column; justify-content:center;}
	.myslide5_bg {width:100%; height:100%; background-image:url(images/main/Place_1920774.jpg); background-size:cover; background-position:center; display:flex; flex-direction:column; justify-content:center;}
	.myslide6_bg {width:100%; height:100%; background-image:url(images/main/Line_1920774.jpg); background-size:cover; background-position:center; display:flex; flex-direction:column; justify-content:center;}
	.myslide7_bg {width:100%; height:100%; background-image:url(images/main/Voyagers_1920774.jpg); background-size:cover; background-position:center; display:flex; flex-direction:column; justify-content:center;}
	.myslide8_bg {width:100%; height:100%; background-image:url(images/main/Killer_1920774.jpg); background-size:cover; background-position:center; display:flex; flex-direction:column; justify-content:center;}
	.myslide9_bg {width:100%; height:100%; background-image:url(images/main/Luca_1920774.jpg); background-size:cover; background-position:center; display:flex; flex-direction:column; justify-content:center;}
	.myslide10_bg {width:100%; height:100%; background-image:url(images/main/Truck_1920774.jpg); background-size:cover; background-position:center; display:flex; flex-direction:column; justify-content:center;}
	.myslide11_bg {width:100%; height:100%; background-image:url(images/main/Conjuring_1920774.jpg); background-size:cover; background-position:center; display:flex; flex-direction:column; justify-content:center;}
</style>
</head>

<body>
    <div class="slide_container">
        <div class="myslide">
            <div class="myslide1_bg">
            </div>
        </div>
        <div class="myslide">
            <div class="myslide2_bg">
            </div>
        </div>
        <div class="myslide">
            <div class="myslide3_bg">
            </div>
        </div>
        <div class="myslide">
            <div class="myslide4_bg">
            </div>
        </div>
        <div class="myslide">
            <div class="myslide5_bg">
            </div>
        </div>
        <div class="myslide">
            <div class="myslide6_bg">
            </div>
        </div>
        <div class="myslide">
            <div class="myslide7_bg">
            </div>
        </div>
        <div class="myslide">
            <div class="myslide8_bg">
            </div>
        </div>
        <div class="myslide">
            <div class="myslide9_bg">
            </div>
        </div>
        <div class="myslide">
            <div class="myslide10_bg">
            </div>
        </div>
        <div class="myslide">
            <div class="myslide11_bg">
            </div>
        </div>
        
        <!-- 
        <div class="slide_progressbar_bg">
            <span class="slide_progressbar" id="current_progressbar"></span>
        </div>
        -->

        <a class="button_prev" onclick="slidePrev()"></a>
        <a class="button_next" onclick="slideNext()"></a>

		<!-- 
        <div class="slide_num">
            <strong id="slide_current_num">1</strong> | 4
        </div>
        -->
    </div>

    <script>
        var slideIndex = 0; //현재 보여지는 슬라이드의 넘버
        var mySlide = document.getElementsByClassName("myslide");
        var slideInter = setInterval(slideNext, 5000);
        //window.onload=function() {};
        function setInterSlide() {
            slideInter = setInterval(slideNext, 5000);
        }
        function clearInterSlide() {
            clearInterval(slideInter);
        }
        function slidePrev() {
        	console.log(slideIndex);
			console.log(mySlide[0]);
            clearInterSlide();
            if (slideIndex == 0) { //첫번째 슬라이드일 경우
                mySlide[mySlide.length - 2].style = "left:-100%;";
                mySlide[0].style = "left:100%; transition:left 0.5s;";
                mySlide[mySlide.length - 1].style = "left:0px; transition:left 0.5s;";
            } else if (slideIndex == 1) { //두번째 슬라이드일 경우
                mySlide[mySlide.length - 1].style = "left:-100%;";
                mySlide[slideIndex].style = "left:100%; transition:left 0.5s;";
                mySlide[slideIndex - 1].style = "left:0px; transition:left 0.5s;";
            }
            /* 마지막 슬라이드일 경우 > 아래 else에 포함 됌
            else if (slideIndex == mySlide.length-1) {
                mySlide[slideIndex-2].style="left:-100%;";
                mySlide[slideIndex].style="left:100%; transition:left 0.5s;";
                mySlide[slideIndex - 1].style="left:0px; transition:left 0.5s;";
            }
            */
            else {
                mySlide[slideIndex - 2].style = "left:-100%;";
                mySlide[slideIndex].style = "left:100%; transition:left 0.5s;";
                mySlide[slideIndex - 1].style = "left:0px; transition:left 0.5s;";
            }
            slideIndex = slideIndex - 1;
            if (slideIndex < 0) {
                slideIndex = mySlide.length - 1;
            }
            //setTimeout (setInterSlide, 500);
            setInterSlide();

        }

        function slideNext() {
            console.log(mySlide.length); //4가 출력됌 (슬라이드 갯수)
            clearInterSlide();
            if (slideIndex == 0) {
                mySlide[mySlide.length - 1].style = "left:100%;"; //다음 다음 스라이드를 오른쪽에 준비 - 4번 슬라이드를 준비
                mySlide[slideIndex].style = "left:-100%; transition:left 0.5s;"; //현재 슬라이드를 왼쪽으로 아웃
                mySlide[slideIndex + 1].style = "left:0px; transition:left 0.5s;"; //다음 슬라이드를 오른쪽에서 왼쪽으로 인
            } else if (slideIndex == mySlide.length - 1) { //마지막 슬라이드 일 경우
                mySlide[slideIndex - 1].style = "left:100%;"; //다음 다음 스라이드를 오른쪽에 준비 - 3번 슬라이드를 준비

                mySlide[slideIndex].style = "left:-100%; transition:left 0.5s;"; //현재 슬라이드를 왼쪽으로 아웃
                mySlide[0].style = "left:0px; transition:left 0.5s;"; //다음 슬라이드를 오른쪽에서 왼쪽으로 인
            } else {
                mySlide[slideIndex - 1].style = "left:100%;"; //다음 다음 스라이드를 오른쪽에 준비 - 2번 슬라이드를 준비
                mySlide[slideIndex].style = "left:-100%; transition:left 0.5s;"; //현재 슬라이드를 왼쪽으로 아웃
                mySlide[slideIndex + 1].style = "left:0px; transition:left 0.5s;"; //다음 슬라이드를 오른쪽에서 왼쪽으로 인
            }

            slideIndex = slideIndex + 1;
            if (slideIndex > mySlide.length - 1) {
                slideIndex = 0;
            }

            //setTimeout (setInterSlide, 500);
            setInterSlide();
        }
    </script>
</body>

</html>