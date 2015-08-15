<!-- footer wrapper start -->
<div id="footer-wrapper">

  <div class="shadow-top"></div>

  <!-- copyright container start -->
  <section class="copyright-container">

    <div class="copyright container_12">
      <p>
        Copyright Carswap 2015. All rights reserved.
      </p>

      <ul class="breadcrumbs">
        <li class="active">
          <a href="main.do">Main</a>
        </li>
        <li>
          <a href="profile.do">Profile</a>
        <li>
          <a href="#">Your Cars</a>
        </li>
        <li>
          <a href="#">Test Drives</a>
        </li>
        <li>
          <a href="login.do">Log in</a>
        </li>
        <li>
          <a href="register.do">Register</a>
        </li>
        <li>
          <a href="register.do">Contuct us</a>
        </li>
      </ul>
    </div>
  </section><!-- copyright container end -->
</div><!-- footer wrapper end -->

<script>
  $(window).load(function() {
    $('#slider').nivoSlider();
  });

  /* ================ TWEETS SCROLL ================ */
  $('.tweets-list-container').tweetscroll({
    username: 'pixel_industry',
    time: true,
    limit: 11,
    replies: true,
    position: 'append',
    date_format: 'style2',
    animation: 'slide_up',
    visible_tweets: 1
  });

  $("#foo3").carouFredSel({
    items: 1,
    auto: true,
    scroll: 1,
    pagination  : "#foo3_pag"
  });

  //placeholder fix
  $('input[placeholder], textarea[placeholder]').placeholder();

</script>
</body>
</html>
