<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<!DOCTYPE html>
<html>
<head>
<title>Carjang~!</title>
<script src="jquery-3.0.0.min.js"></script>
<script src="./js/jquery.mousewheel.js"></script>
<script>
$(document).ready(function() {
	 //현재 보고싶은 페이지를 기억할 변수
			var nowPage = 0;
			//페이지가 멈춰있는지 기억할 변수
			var pageStop = true;
			//페이지를 움직이는 기계(함수)
			function movePage() {
				$('html,body').clearQueue().animate({
					scrollTop : $(window).height() * nowPage
				}, 700, function() {
					pageStop = true;
				});
				$('.button').removeClass('on').eq(nowPage).addClass('on');
			}
			//.button에 인덱스를 기억할 속성을 넣어줌
			$('.button').attr({
				'data-index' : function(index) {
					return index;
				}
			//$('.button').click(function(){};
			}).click(function() {
				nowPage = $(this).attr('data-index');
				movePage();
			});
			//휠을 굴렸을 때 굴리는 방향에 따라 페이지 이동
			$(window).on('mousewheel', function(e) {

				if (pageStop) {
					pageStop = false;
					//휠을 내렸을때 다음페이지가 나와야함
					if (e.originalEvent.wheelDelta < 0) {
						nowPage++;
						//휠을 올리면 이전 페이지가 나옴
					} else {
						nowPage--;
					}
					//첫페이지에서 휠을 위로 굴릴때 멈춘다.
					if (nowPage < 0) {
						nowPage = 0;
						pageStop = true;
						//마지막 페이지에서 휠을 아래로 굴릴때 멈춘다.
					} else if (nowPage > 2) {
						nowPage = 2;
						pageStop = true;
					} else {
						movePage();
					}
					movePage();
				}
			}); 
			
			$('page').css({
	            height : 3000
	        });
	        $(window).scroll(function () {
	            $('#suncheonbay1').css({
	                top: -$(window).scrollTop()*1
	            });
	            $('#redCar').css({
	                top: 400 + $(window).scrollTop()*1
	            });
	        });

				
		});//--document.ready 끝!!
</script>
</head>
<body text="black" link="black" vlink="black" alink="black">
	<%@include file="/include/header.jsp"%>
	<c:choose>
		<c:when test="${page == null}">
			<div class="page" id="pageFirst">

				<div id="sentence1">
					편하게 이동하자 <span id="sen1word">카장~!</span>
				</div>
				<div id="sentence2">
					두근두근 여행<br>전국 곳곳을 누벼 보세요
				</div>
				<img id="suncheonbay1"
					src="<%=request.getContextPath()%>/images/suncheonbay1.jpg">
				<div>
					<img id="redCar"
						src="<%=request.getContextPath()%>/images/redCar.png">
				</div>
			</div>
			<div class="page" id="pageSecond">
				<div id="sentence3">
					언제나 원하는 대로<br>선택할 수 있는<br>차량 운행 서비스<br>목적지에 상관없이<br>최선의
					방법으로 이동
				</div>
				<img id="gwangan bridge1"
					src="<%=request.getContextPath()%>/images/gwangan bridge1.jpg">
			</div>
			<div class="page" id="pageThird">
				<div id="sentence4">
					<span class="sen4word">Carjang</span>은 <span class="sen4word">전국</span>에서<br>이용할
					수 있습니다.
				</div>
				<img id="beach1"
					src="<%=request.getContextPath()%>/images/beach1.jpg">

			</div> 

			<!-- 네비게이션 -->
			<div id="button_wrap">
				<div class="button on"></div>
				<div class="button"></div>
				<div class="button"></div>
			</div>
		</c:when>
		<c:when test="${page == 'board'}">
			<%@ include file="/board/boardMain.jsp"%>
		</c:when>
	</c:choose>
	<%@include file="/include/footer.jsp"%>

</body>
</html>