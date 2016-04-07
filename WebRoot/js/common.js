$(function() {
	/*	document.documentElement.style.overflow = 'hidden';*/

	var screenW = $(window).width(), screenH = $(window).height();
	$(".container,.leftCol").css("min-height", screenH - 60);
	$(".leftCol").css("height", $(".rightCol").height() + 20);
	$(".rightCol").width(screenW - $(".leftCol").width() - 77);
	$(window).resize(function() {
		var screenW = $(window).width(), screenH = $(window).height();
		$(".container,.leftCol").css("min-height", screenH - 60);
		$(".leftCol").css("height", $(".rightCol").height() + 20);
		$(".rightCol").width(screenW - $(".leftCol").width() - 77);
	})
});

$(function() {

	$('.main-con ul li').click(function(e) {
		$(this).addClass('current').siblings().removeClass('current')
		$('.content').hide();
		$('.right-con .main').hide();
		$('.content').eq($(this).index()).show();
		$('.right-con .main').eq($(this).index()).show();
	});

	$('.sample_con ul li,.sampleji_con ul li')
			.click(
					function(e) {
						$(this)
								.children(
										'.sample_con ul li .smallbox,.sampleji_con ul li .smallbox')
								.show();

						return false
					});
	$('.smallbox .no').click(function(e) {
		$(this).siblings('.smallbox .dele').show();
	});
	$('.smallbox .dele .quxiao').click(function(e) {
		$(this).parent('.dele').hide();
	});
	$(document).click(function(e) {
		$('.sample_con ul li .smallbox,.sampleji_con ul li .smallbox').hide();
	});

	$('.content .xuanze .qiyong').click(
			function(e) {
				$(this).css('color', '#979797').siblings('.jinyong').css(
						'color', '#cccccc')
			});
	$('.content .xuanze .jinyong').click(
			function(e) {
				$(this).css('color', '#979797').siblings('.qiyong').css(
						'color', '#cccccc')
			});
	$('.add_con .right span select option').click(function(e) {
		$('#A,#B').toggle()
	});

	$('.people4,.people5,.people6').click(function(e) {
		$(this).children('.contact').toggle()
	});
	/*   $('.people5').click(function(e) {
	 if($('.contact').css('display')=='none'){
	 $(this).css('color','#ff9900').children('.contact').show()
	 }else{
	 $(this).css('color','#979797').children('.contact').hide()
	
	 }
	 });	
	 $('.people6').click(function(e) {
	 if($('.contact').css('display')=='none'){
	 $(this).css('color','#ff9900').children('.contact').show()
	 }else{
	 $(this).css('color','#979797').children('.contact').hide()
	
	 }
	 });	
	 */$(' .middle .pen1').click(function(e) {
		$('.add_zhibanshang').toggle();
	});
	$('.add_zhibanshang .toubu .no1').click(function(e) {
		$('.add_zhibanshang').hide();
	});
	$('.right .pen2').click(function(e) {
		$('.add_yangpinji').toggle();
	});
	$('.add_yangpinji .toubu .no1').click(function(e) {
		$('.add_yangpinji').hide();
	});

	$('.down-top .tianjia1').click(function(e) {
		$('.add_bangunqingkuang').toggle();
	});
	$('.add_bangunqingkuang .toubu .no1').click(function(e) {
		$('.add_bangunqingkuang').hide();
	});
	$('.add_bangunqingkuang .name2 .pen3').click(function(e) {
		$('.add_bangunqingkuang').hide();
		$('.add_newchangqu').show();
	});
	$('.add_newchangqu .toubu .no22').click(function(e) {
		$('.add_newchangqu').hide();
		$('.add_bangunqingkuang').show();

	});

	$('.add_newbianji .toubu .no1').click(function(e) {
		$('.add_newbianji').hide();
	});

	$('.add_newbianji .name2 .pen3').click(function(e) {
		$('.add_newbianji').hide();
		$('.add_changqu').show();
	});

	$('.add_changqu .toubu .no1').click(function(e) {
		$('.add_changqu').hide();
		$('.add_newbianji').show();
	});

	$('.down-top .tianjia2').click(function(e) {
		$('.add_histroy').toggle();
	});
	$('.add_histroy .toubu .no1').click(function(e) {
		$('.add_histroy').hide();
	});

	$('.add_histroy .span1').click(function(e) {
		$('.add_histroy').hide();
		$('.down2 .add_customer').show()
	});
	$('.add_customer .toubu .no1').click(function(e) {
		$('.down2 .add_customer').hide()
		$('.add_histroy').show();
	});

	$('.add_histroy .span2').click(function(e) {
		$('.add_histroy').hide();
		$('.down2 .add_people').show()
	});
	$('.add_people .toubu .no1').click(function(e) {
		$('.down2 .add_people').hide()
		$('.add_histroy').show();
	});

	$('.bianji_histroy .toubu .nono').click(function(e) {
		$('.bianji_histroy').hide();
	});

	$('.bianji_histroy .span1').click(function(e) {
		$('.bianji_histroy').hide();
		$('.down2 .new_customer').show()
	});
	$('.new_customer .toubu .no1').click(function(e) {
		$('.down2 .new_customer').hide()
		$('.bianji_histroy').show();
	});
	$('.bianji_histroy .span2').click(function(e) {
		$('.bianji_histroy').hide();
		$('.down2 .new_people').show()
	});

	$('.new_people .toubu .no1').click(function(e) {
		$('.down2 .new_people').hide()
		$('.bianji_histroy').show();
	});

	$('.photo-con button').click(function(e) {
		$('.photo .password').toggle();
	});
	$('.password-top span').click(function(e) {
		$('.photo .password').hide();
	});

	$('.anniu .zhanghao').click(function(e) {
		$('.right-con .account').toggle();
	});

	$('.account-top .span22').click(function(e) {
		$('.right-con .account').hide();
	});

	$('.inf-top span').click(function(e) {
		$('.right-con .information').hide();
	});

	$('.beijing p .no').click(function(e) {
		$('.beijing').hide();
	});
	$('.touming p .no').click(function(e) {
		$('.touming').hide();
	});

	$('.add_con .btn1').click(function(e) {
		$('.right-con .add_house').toggle();
	});
	$('.house-top span').click(function(e) {
		$('.add_house').hide();
	});

	$('.add_con .btn2').click(function(e) {
		$('.right-con .add_quyu').toggle();
	});
	$('.quyu-top span').click(function(e) {
		$('.add_quyu').hide();
	});

	$('.quyu2 span').click(function(e) {
		$('.right-con .add_more').toggle();
	});
	$('.more-top span').click(function(e) {
		$('.right-con .add_more').hide();
		$('.add_quyu').show();
	});

	$('.xiugai-top span').click(function(e) {
		$('.xiugaiquyu').hide();
	});

	$('.content caption button').click(function(e) {
		$('.sure-no').toggle();
	});
	$('.sure-top span,.no2').click(function(e) {
		$('.sure-no').hide();
	});

	$('.customer-con .top button').click(function(e) {
		$('.customer-con .add_customer').toggle();
	});

	$('.customer-con .add_customer .no1').click(function(e) {
		$('.customer-con .add_customer').hide();
	});
	$('.touming1 p .no,.touming2 p .no').click(function(e) {
		$('.customer-con .touming1').hide();
		$('.right-con .touming1').hide();
		$('.down1 .touming2').hide();
		$('.down2 .touming2').hide();
	});
	$('.name-top button').click(function(e) {
		$('.right-con .add_customer').toggle()
	});
	$('.right-con .add_customer .no1').click(function(e) {
		$(' .add_customer').hide();
	});
	$('.bianji-top .no1').click(function(e) {
		$('.bianji-people').hide();
	});

	$('.customer-top button').click(function(e) {
		$('.data_content .customer-people').toggle();
	});
	$('.customer-people .toubu .no1').click(function(e) {
		$('.customer-people').hide();
	});

	$('.touming5 p .no').click(function(e) {
		$('.touming5').hide();
	});

	$('.bianji-bangun .toubu .no1').click(function(e) {
		$('.bianji-bangun').hide();
	});
	$('.add_histroy .toubu .no1').click(function(e) {
		$('#bianji-histroy').hide();
	});

})
