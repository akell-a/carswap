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
            <blockquote class="text-left">

                <table width="640px">
                    <tr>
                        <td>E-mail: ${user.email}</td>
                        <td>Your city: ${user.city}</td>
                    </tr>
                    <tr>
                        <td>Name: ${user.name}</td>
                        <td>Second Name: ${user.secondName}</td>
                    </tr>
                    <tr>
                        <td>Your phone: ${user.phone}</td>
                        <td>Birth date: ${user.birthDate}</td>
                    </tr>
                    <tr>
                        <td>Role: ${user.role}</td>
                        <td>Creation date: ${user.creationDate}</td>
                    </tr>
                    <tr>
                        <td>Your points amount: ${user.points}</td>
                    </tr>
                </table>
            </blockquote>
        </article><!-- .content-sidebar-left end -->

        <aside class="grid_3 aside">
            <ul class="aside-widgets">
                <li class="categories">
                    <h5>Available functions</h5>
                    <ul class="arrow-list">
                        <li><a href="changePassword.do">Change password</a></li>
                        <li><a href="editEmail.do">Change email</a></li>
                        <c:if test = "${user.role == 'ADMIN'}">
                            <li><a href="editPoints.do">Add points</a></li>
                        </c:if>
                    </ul>
                </li><!-- categories widget end -->
            </ul><!-- sidebar widgets end -->
        </aside><!-- sidebar end -->
    </div><!-- container_12 end -->
</div><!-- content wrapper end -->

<jsp:include page="footer.jsp" />