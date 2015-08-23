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
            <article class="grid_12 contact-forms">
                <div class="forms grid_9 omega">
                    <section id="form-newsletter" class="contact-form active">
                        <c:if test = "${editType == 'email'}">
                            <p>Please write down your new email.</p>
                            <form action="processChangeEmail.do" method="post">
                                <fieldset>
                                    <label><span class="text-red">*</span> Email:</label>
                                    <input type="email" name="newEmail" class="text" id="newEmail"/>
                                </fieldset>
                                <input type="submit" class="submit btn-small" value="SUBMIT" />
                            </form>
                        </c:if>
                        <c:if test = "${editType == 'password'}">
                            <p>Please write down current password and a new one.</p>
                            <form action="processChangePassword.do" method="post">
                                <fieldset>
                                    <label><span class="text-red">*</span> Old password:</label>
                                    <input type="password" name="passwordOld" class="text" id="passwordOld"/>
                                </fieldset>
                                <fieldset>
                                    <label><span class="text-red">*</span> New password:</label>
                                    <input type="password" name="passwordNew" class="text" id="passwordNew"/>
                                </fieldset>
                                <fieldset>
                                    <label><span class="text-red">*</span> Repeat new password:</label>
                                    <input type="password" name="passwordNewAgain" class="text" id="passwordNewAgain"/>
                                </fieldset>
                                <input type="submit" class="submit btn-small" value="SUBMIT" />
                            </form>
                        </c:if>
                        <c:if test = "${editType == 'points'}">
                            <p>Choose operation and amount of points.</p>
                            <form action="processAddPoints.do" method="post">
                                <fieldset>
                                    <label><span class="text-red">*</span> Operation:</label>
                                    <select size="3" name="operation">
                                        <option selected value="plus">Add points</option>
                                        <option value="minus">Minus points</option>
                                    </select>
                                </fieldset>
                                <fieldset>
                                    <label><span class="text-red">*</span> Amount of points:</label>
                                    <input type="text" name="points" class="text" id="points"/>
                                </fieldset>
                                <input type="submit" class="submit btn-small" value="SUBMIT" />
                            </form>
                        </c:if>
                        <c:if test = "${editType == 'fail'}">
                            <section class="error-box">
                                <p>Can`t edit your data!</p>
                            </section>
                        </c:if>
                    </section>
                </div>
            </article>
        </article><!-- .content-sidebar-left end -->

        <%--</section>--%>

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