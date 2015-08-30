<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<jsp:useBean id="car" class="com.carswap.model.Car"/>

<!-- page-title start-->
<section class="page-title-container">

  <!-- top shadow on container -->
  <div class="shadow-top"></div>

  <section class="page-title">
    <div class="title">
      <h1>Cars</h1>
      <p>Here you can see your cars</p>
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

        <form action="/carswap/editCars.do">
        <table width="640px">
          <c:forEach items="${user.cars}" var="car">
              <td>Car name: ${car.name}</td>
              <td>Testdrive status: ${car.carStatus}</td>
            <td><input type="submit" value="Edit car"></td>
            </tr>
          </c:forEach>
          </table>
        </form>

    </article><!-- .content-sidebar-left end -->

    <aside class="grid_3 aside">
      <ul class="aside-widgets">
        <li class="categories">
          <h5>Available functions</h5>
          <ul class="arrow-list">
            <li><a href="addCar.do">Add car</a></li>
            <%--<li>Edit selected car</li>--%>
            <%--<li>Delete selected car</li>--%>
          </ul>
        </li><!-- categories widget end -->
      </ul><!-- sidebar widgets end -->
    </aside><!-- sidebar end -->
  </div><!-- container_12 end -->
</div><!-- content wrapper end -->

<jsp:include page="footer.jsp" />