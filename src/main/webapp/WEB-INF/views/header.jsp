<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Alexx - Home</title>
  <meta name="description" content="Multipurpose Responsive Site Theme">
  <meta name="author" content="pixel-industry">
  <meta name="viewport" content="initial-scale=1, maximum-scale=1">
  <meta name="viewport" content="width=device-width">

  <!-- stylesheets -->

  <spring:url value="/resources/css/basic.css" var="basicCss" />
  <link href="${basicCss}" rel="stylesheet" />
  <spring:url value="/resources/css/style.css" var="styleCss" />
  <link href="${styleCss}" rel="stylesheet" />
  <spring:url value="/resources/css/nivo-slider.css" var="nivosliderCss" />
  <link href="${nivosliderCss}" rel="stylesheet" />
  <spring:url value="/resources/css/prettyPhoto.css" var="prettyPhotoCss" />
  <link href="${prettyPhotoCss}" rel="stylesheet" />

  <!--[if IE 8]>
  <spring:url value="/resources/css/ie8.css" var="ie8Css" />
  <link href="${ie8Css}" rel="stylesheet" />
  <![endif]-->

  <!-- navigation icons using "font awesome" -->
  <spring:url value="/resources/Font-Awesome/css/font-awesome.css" var="fontawesomeCss" />
  <link href="${fontawesomeCss}" rel="stylesheet" />

  <!-- google web fonts -->
  <link href='http://fonts.googleapis.com/css?family=Arimo' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>

  <!-- js files -->
  <spring:url value="/resources/js/jquery-1.7.2.js" var="jquery" />
  <script src="${jquery}"></script>
  <spring:url value="/resources/js/jquery.placeholder.min.js" var="placeholder" />
  <script src="${placeholder}"></script>
  <spring:url value="/resources/js/jquery.nivo.slider.js" var="nivoSlider" />
  <script src="${nivoSlider}"></script>
  <spring:url value="/resources/js/jquery.prettyPhoto.js" var="prettyPhoto" />
  <script src="${prettyPhoto}"></script>
  <spring:url value="/resources/js/jquery.tweetscroll.js" var="tweetscroll" />
  <script src="${tweetscroll}"></script>
  <spring:url value="/resources/js/socialstream.jquery.js" var="socialstream" />
  <script src="${socialstream}"></script>
  <spring:url value="/resources/js/jquery.carouFredSel-6.0.0-packed.js" var="carouFredSel" />
  <script src="${carouFredSel}"></script>
  <spring:url value="/resources/js/include.js" var="include" />
  <script src="${include}"></script>

  <%--login--%>
  <spring:url value="/resources/css/normalize.css" var="normalizeCss" />
  <link href="${normalizeCss}" rel="stylesheet" />
  <spring:url value="/resources/css/font-awesome.min.css" var="fontCss" />
  <link href="${fontCss}" rel="stylesheet" />

  <spring:url value="/resources/js/index.js" var="indexJs" />
  <script src="${indexJs}"></script>
  <%--/login--%>

  <!--[if (gte IE 6)&(lte IE 8)]>
  <spring:url value="/resources/js/selectivizr.js" var="selectivizr" />
  <script src="${selectivizr}"></script>
  <![endif]-->
  <!--[if lt IE 9]>
  <spring:url value="/resources/js/html5shiv.js" var="html5shiv" />
  <script src="${html5shiv}"></script>
  <![endif]-->
</head>

<body>
<!-- header start -->
<header id="header" class="clearfix">

  <!-- logo start -->
  <section id="logo">
    <a href="main.do">
      <img src="resources/img/logo.png" alt="logo"/>
    </a>
  </section><!-- #logo end -->

  <!-- nav container start -->
  <section id="nav-container">

    <!-- main navigation start  -->
    <nav id="nav">
      <ul class="nav nav-list">
        <li>
          <a href="main.do">
            <i class="icon-nav icon-home"></i>
            Main
          </a>
        </li>
        <li>
          <a href="profile.do">
            <i class="icon-nav icon-user"></i>
            Profile</a>
        </li>
        <li>
          <a href="#">
            <i class="icon-nav icon-th-large"></i>
            Your Cars</a>
        </li>
        <li>
          <a href="#">
            <i class="icon-nav icon-search"></i>
            Test Drives</a>
        </li>
        <li>
          <a href="login.do">
            <i class="icon-nav icon-key"></i>
            Log in</a>
        </li>
        <li>
          <a href="register.do">
            <i class="icon-nav icon-plus-sign"></i>
            Register</a>
        </li>
        <li>
          <a href="#">
            <i class="icon-nav icon-map-marker"></i>
            Contact us</a>
        </li>
      </ul>
    </nav><!-- main navigation end -->

  </section><!-- nav container end -->

  <!-- search start -->
  <section id="search">
    <form action="#" method="get">
      <input id="search-submit" type="submit" />
      <input id="search-bkg" type="text" placeholder="Type and press enter.." />
    </form>
  </section><!-- search end -->

</header><!-- header end -->