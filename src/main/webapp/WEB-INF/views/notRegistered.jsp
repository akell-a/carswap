<jsp:include page="header.jsp" />

<!-- page-title start-->
<section class="page-title-container">

    <!-- top shadow on container -->
    <div class="shadow-top"></div>

    <section class="page-title">
        <div class="title">
            <h1>Profile</h1>
            <p>Here you can see and edit your profile data</p>
        </div>

        <ul class="breadcrumbs">
            <li>
                You are here:
            </li>
            <li>
                <a href="main.do">Main / </a>
            </li>
            <li class="active">
                <a href="profile.jsp">Profile page</a>
            </li>
        </ul>
    </section>

    <div class="shadow-bottom"></div>
</section>

<!-- content start -->
<div id="content-wrapper">

    <div class="container_12">

        <section class="infobox">
            <p>Only for registered user, please <a href="register.do">register</a> OR <a href="login.do">login</a>.</p>
        </section>
    </div><!-- container_12 end -->
</div><!-- content wrapper end -->

<jsp:include page="footer.jsp" />