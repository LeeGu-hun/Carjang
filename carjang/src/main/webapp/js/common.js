$(document).ready(
		function() {
			// 현재 보고싶은 페이지를 기억할 변수
			var nowPage = 0;
			// 페이지가 멈춰있는지 기억할 변수
			var pageStop = true;
			// 페이지를 움직이는 기계(함수)
			function movePage() {
				$('html,body').clearQueue().animate({
					scrollTop : $(window).height() * nowPage
				}, 500, function() {
					pageStop = true;
				});
				$('.button').removeClass('on').eq(nowPage).addClass('on');
			}
			// .button에 인덱스를 기억할 속성을 넣어줌
			$('.button').attr({
				'data-index' : function(index) {
					return index;
				}
			// $('.button').click(function(){};
			}).click(function() {
				nowPage = $(this).attr('data-index');
				movePage();
			});
			// 휠을 굴렸을 때 굴리는 방향에 따라 페이지 이동
			$(window).on('mousewheel', function(e) {

				if (pageStop) {
					pageStop = false;
					// 휠을 내렸을때 다음페이지가 나와야함
					if (e.originalEvent.wheelDelta < 0) {
						nowPage++;
						// 휠을 올리면 이전 페이지가 나옴
					} else {
						nowPage--;
					}
					// 첫페이지에서 휠을 위로 굴릴때 멈춘다.
					if (nowPage < 0) {
						nowPage = 0;
						pageStop = true;
						// 마지막 페이지에서 휠을 아래로 굴릴때 멈춘다.
					} else if (nowPage > 5) {
						nowPage = 5;
						pageStop = true;
					} else {
						movePage();
					}
					movePage();
				}
			});
			// -------------------------------
			// -------view_box 관련 시작-------
			// -------------------------------
			var nowView = 0;
			var nowVinwIn = 0;

			$('.view').hide();
			$('#view_box').hide();

			// .pro에 순서를 정함
			$('.work:eq(0) .pro').attr({
				'data-view' : function(index) {
					return index;
				},
				'data-viewin' : 0
			});
			$('.work:eq(1) .pro').attr({
				'data-view' : function(index) {
					return index;
				},
				'data-viewin' : 1
			});
			$('.work:eq(2) .pro').attr({
				'data-view' : function(index) {
					return index;
				},
				'data-viewin' : 2
			});

			$('.pro').click(
					function() {
						nowView = $(this).attr('data-view');
						nowViewIn = $(this).attr('data-viewin');
						$('.view_in').eq(nowViewIn).children('.view').hide()
								.eq(nowView).show();
						$('.view_in').hide().eq(nowViewIn).show();
						$('#view_box').fadeIn(200);
					});
			$('#close').click(function() {
				$('#view_box').fadeOut(200);
			});
		});// --document.ready 끝!!



function drivScore(score) {  
	var marks = document.querySelectorAll('#star_on'); //배열
	var score = document.getElementById('#drv_score'); //선택자 getElementByName,getElementByClassName,

	for(var i =1; i<=score; i++){
	var mark = marks[i].style.color = 'yellow';
	}
	
}



