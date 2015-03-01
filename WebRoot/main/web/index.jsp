<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- <base href="<%=basePath%>"> --%>

<title>北京丽颜堂科贸有限公司</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="./css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<link
	href='http://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700'
	rel='stylesheet' type='text/css'>

</head>

<body>
<body>
	<div class="header">
		<div class="header-top">
			<div class="wrap">
				<div class="logo">
					<a href="index.html"><img src="./images/logo.png" alt="" />
					</a>
				</div>
				<div class="cssmenu">
					<ul id="nav">
						<li class="current"><a href="#section-1">首页</a>
						</li>
						<li class="current"><a
							href="<%=request.getContextPath()%>/main/add.jsp">会员申请</a>
						</li>
						<li><a href="#section-2">会员制分销模式介绍</a>
						</li>
						<li><a href="#section-3">返利查询--口碑传播奖</a>
						</li>
						<li><a href="#section-4">返利查询--优秀个人奖</a>
						</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="header-bottom section" id="section-1">
			<div class="wrap">
				<div class="img-banner">
					<div class="img-banner-info">
						<h1>
							北京丽颜堂 <br />科贸有限公司
						</h1>
						<h3>公司简介：</h3>

						<div class="sign_up">
							<p>北京丽颜堂科贸有限公司位于北京市丰台区刘家窑南里5号2层3号2266室交通便利。北京丽颜堂科贸有限公司本着“客户第一，诚信至上”的原则，与多家企业建立了长期的合作关系。公司拥有一支较强的技术研发队伍并和国内大专院校强强联手，研发出拥有自主知识产权。热诚欢迎各界朋友前来参观、考察、洽谈业务。梁新龙代表北京丽颜堂科贸有限公司欢迎新老客户来电咨询。</p>
							<form action="<%=request.getContextPath()%>/main/add.jsp">
								<!-- <input type="text" value="" placeholder="Your E-mail  Address" />  -->
								<input type="submit" value="会员申请">
								<div class="clear"></div>
							</form>
						</div>
					</div>
					<div class="img-banner-pic">
						<img src="./images/hand-with-iphone.png" alt="" />
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<!-- <div class="clients">
  			                     <div class="wrap">
  			 					  <div id="owl-demo" class="owl-carousel">
						                <div class="item"><img src="./images/evernote.png" alt="" /></div>
						                <div class="item"><img src="./images/microsoft.png" alt="" /></div>
						                <div class="item"><img src="./images/google.png" alt="" /></div>
						                <div class="item"><img src="./images/sony.png" alt="" /></div>
						                <div class="item"><img src="./images/firefox.png" alt="" /></div>
						                <div class="item"><img src="./images/evernote.png" alt="" /></div>
						                <div class="item"><img src="./images/microsoft.png" alt="" /></div>
						                <div class="item"><img src="./images/google.png" alt="" /></div>
						                <div class="item"><img src="./images/sony.png" alt="" /></div>
						                <div class="item"><img src="./images/firefox.png" alt="" /></div>
						             </div>
						          </div>
						      </div> -->
	</div>
	<!-- End Header -->
	<div class="main">
		<div class="features section" id="section-2">
			<div class="wrap">
				<h2>会员制分销模式介绍</h2>
			</div>
			<div id="cbp-so-scroller" class="cbp-so-scroller">
				<section class="cbp-so-section cbp-so-init cbp-so-animate">
				<article class="cbp-so-side cbp-so-side-left">
				<div class="features-list">
					<ul>
						<li>
							<div class="heading">
								<div class="icon">
									<img src="./images/reliable-secure.png" alt="" />
								</div>
								<div class="heading-desc">
									<h3>会员加入方式</h3>
								</div>
								<div class="clear"></div>
							</div>
							<p>
								●钻卡：一次性购买10盒*198元/盒=1980元即可成为钻卡会员，钻卡会员重复消费享受3折优惠。<br>
								●金卡：一次性购买5盒*198元/盒=990元即可成为金卡会员，金卡会员重复消费享受4折优惠。<br>
								●银卡：一次性购买1盒*198元/盒=198元即可成为银卡会员，银卡会员重复消费享受5折优惠。
							</p></li>
						<li>
							<div class="heading">
								<div class="icon">
									<img src="./images/alarm.png" alt="" />
								</div>
								<div class="heading-desc">
									<h3>口碑传播奖</h3>
								</div>
								<div class="clear"></div>
							</div>
							<p>
								凡丽颜堂会员为公司推荐成功新会员：<br> ●钻卡奖励1000元；<br> ●金卡奖励500元；<br>
								●银卡奖励100元。
							</p></li>
						<li>
							<div class="heading">
								<div class="icon">
									<img src="./images/tweet.png" alt="" />
								</div>
								<div class="heading-desc">
									<h3>优秀个人奖</h3>
								</div>
								<div class="clear"></div>
							</div>
							<p>
								●月累计推荐会员50名，奖励优秀个人1000元，每月累计一次<br> ●
								月累计推荐会员100名，奖励优秀个人3000元，每月累计一次
							</p></li>
						<li>
							<div class="heading">
								<div class="icon">
									<img src="./images/eclipse.png" alt="" />
								</div>
								<div class="heading-desc">
									<h3>经营理念</h3>
								</div>
								<div class="clear"></div>
							</div>
							<p>您不仅是丽颜堂的消费者，更是丽颜堂的经营者。 用低廉的价格享受优质的产品。</p></li>
					</ul>
				</div>
				</article> <figure class="cbp-so-side cbp-so-side-right app-overview-img">
				<img src="./images/mac.png" alt="" /> </figure> </section>
			</div>
		</div>

		<!-- 		<div class="content-middle section" id="section-3">
			<div class="testimonials">
			     <div class="wrap">
			     		<h2>Why tank app different ?</h2>
					<div class="slider single-item">
								<div>
									<h3><span><img src="./images/clouds.png" alt="" /></span>Works on any device anyware</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea com Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut</p>
								</div>
								<div>
									<h3><span><img src="./images/clouds.png" alt="" /></span>Brenda Gonzales, Feddapps</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea com Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut</p>
							   </div>
								<div>
									 <h3><span><img src="./images/clouds.png" alt="" /></span>Works on any device anyware</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea com Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut</p>
							    </div>
							    <div>
							    	<h3><span><img src="./images/clouds.png" alt="" /></span>Brenda Gonzales, Stockapps</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea com Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut</p>
								</div>
								<div>
									<h3><span><img src="./images/clouds.png" alt="" /></span>Works on any device anyware</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea com Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut</p>
							   </div>
						</div>	 		
					</div>						
			   </div>
		</div> -->
	</div>
	<!--  <div class="footer section" id="section-4">
       <div class="footer-top">
       	  <div class="wrap">
     	  Contact
				<div class="contact">
				       <h2>SAVE TIME & GAIN AGILITY</h2>
				     <h4>Using our cloud Monitoring Services So you can Focous on Runing Yours Better </h4>
				       <div class="contact-form">				  	
							 <form>
							  		<input type="text" value="" placeholder="Enter Your E-mail Address"> 
							 		<input type="submit" value="Sign Up">
							 		<div class="clear"></div>
							  </form>
					  </div>
				  </div>
			    </div>
		 End Contact
     </div>
    </div> -->
	<div class="footer-bottom">
		<div class="wrap">
			<div class="footer-btm-left">
				<a href="#"><img src="./images/footer-logo.png" alt="" />
				</a>
			</div>
			<div class="footer-btm-right">
				<ul class="footer-links">
					<li><a href="#section-1" class="scroll">首页</a>
					</li>
					<li><a href="#section-2" class="scroll">会员制分销模式介绍</a>
					</li>
					<!-- <li><a href="#section-1" class="scroll">How it works</a></li>
					 <li><a href="#section-3" class="scroll">Blog</a></li>
					 <li><a href="#section-4" class="scroll">Contact</a></li> -->
				</ul>
				<ul class="social-icons">
					<li class="tweeter"><a href="#"></a>
					</li>
					<li class="facebook"><a href="#"></a>
					</li>
					<li class="google-pluse"><a href="#"></a>
					</li>
					<div class="clear"></div>
				</ul>
				<div class="copy">
					<p>

						北京丽颜堂科贸有限公司 <a href="http://" target="_blank"></a>
					</p>
				</div>
			</div>
			<div class="clear"></div>
		</div>

	</div>
	<script src="./js/jquery-1.10.2.min.js" type="text/javascript"></script>
	<script src="./js/modernizr.custom.js" type="text/javascript"></script>
	<script src="./js/classie.js"></script>
	<script src="./js/cbpScroller.js"></script>
	<script>
		new cbpScroller(document.getElementById('cbp-so-scroller'));
	</script>

	<script src="./js/owl.carousel.js"></script>
	<link href="./css/owl.carousel.css" rel="stylesheet">
	<script>
		$(document).ready(function() {
			$("#owl-demo").owlCarousel({
				slideSpeed : 300,
				autoPlay : 2000,
				pagination : false,
				navigationText : false,
				itemsMobile : false
			// 
			});
		});
	</script>
	<link rel="stylesheet" type="text/css" href="./css/slick.css" />
	<script type="text/javascript" src="./js/slick.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.single-item').slick({
				dots : true,
				infinite : true,
				speed : 300,
				autoplay : true,
				arrows : false,
				slidesToShow : 1,
				slidesToScroll : 1
			});
		});
	</script>
	<script src="./js/jquery.scrollTo.js"></script>
	<script src="./js/jquery.nav.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#nav').onePageNav({
				begin : function() {
					console.log('start')
				},
				end : function() {
					console.log('stop')
				}
			});
		});
	</script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event) {
				event.preventDefault();
				$('html,body').animate({
					scrollTop : $(this.hash).offset().top
				}, 1200);
			});
		});
	</script>
	</div>
</body>
</body>
</html>
