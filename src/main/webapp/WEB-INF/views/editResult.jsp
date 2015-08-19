<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a href="profile.do">Profile page</a>
            </li>
        </ul>
    </section>

    <div class="shadow-bottom"></div>
</section>

<!-- content start -->
<div id="content-wrapper">

    <div class="container_12">

        <article class="grid_9 content-sidebar-right">

            <c:if test = "${result == 'success'}">
                <section class="success-box">
                    <p>Data has been changed successfully!</p>
                </section>
            </c:if>

            <c:if test = "${result == 'fail'}">
                <section class="error-box">
                    <p>Error during process, no change was saved!</p>
                </section>
            </c:if>

        </article><!-- .content-sidebar-left end -->

        <%--</section>--%>

        <aside class="grid_3 aside">

            <ul class="aside-widgets">

                <li class="categories">
                    <h5>Available functions</h5>
                    <ul class="arrow-list">
                        <li><a href="changePassword.do">Change password</a></li>
                        <li><a href="editEmail.do">Change email</a></li>
                        <li><a href="editPoints.do">Add points</a></li>
                    </ul>
                </li><!-- categories widget end -->
            </ul><!-- sidebar widgets end -->
        </aside><!-- sidebar end -->
    </div><!-- container_12 end -->
</div><!-- content wrapper end -->

<jsp:include page="footer.jsp" />