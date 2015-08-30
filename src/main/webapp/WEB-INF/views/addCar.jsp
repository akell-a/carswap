<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add car</title>

    <spring:url value="/resources/css/normalize.css" var="normalizeCss"/>
    <spring:url value="/resources/css/style.css" var="styleCss"/>
    <spring:url value="/resources/css/font-awesome.min.css" var="fontCss"/>

    <link href="${normalizeCss}" rel="stylesheet"/>
    <link href="${styleCss}" rel="stylesheet"/>
    <link href="${fontCss}" rel="stylesheet"/>

</head>

<body>

<div class="logmod">
    <div class="logmod__wrapper">
        <div class="logmod__container">
            <ul class="logmod__tabs">
                <li data-tabtar="lgm-1"><a href="">Add new Car</a></li>
            </ul>
            <div class="logmod__tab-wrapper">
                <div class="logmod__tab lgm-1">
                    <div class="logmod__heading">
                        <span class="logmod__heading-subtitle">Enter information about car</span>
                    </div>
                    <div class="logmod__form">
                        <form accept-charset="utf-8" action="/carswap/processAddCar.do" class="simform" method="post">
                            <div>
                                <div class="input string optional">
                                    <label class="string optional" for="name">Car name *</label>
                                    <input class="string optional" maxlength="255" id="name" name="name"
                                           placeholder="Name" type="text" size="50"/>
                                </div>
                            </div>

                            <div>
                                <div class="input string optional">
                                    <label class="string optional" for="carType">Car Type </label>
                                    <select id="carType" name="carType">
                                        <option selected="selected">-</option>
                                        <option>LUX</option>
                                        <option>PREMIUM</option>
                                        <option>BUSSINES</option>
                                        <option>MIDDLE</option>
                                        <option>ECONOM</option>
                                        <option>SOVIET</option>
                                    </select>
                                </div>
                            </div>


                            <div>
                                <div class="input string optional">
                                    <label class="string optional" for="carStatus">Test drive Status</label>
                                    <select id="carStatus" name="carStatus">
                                        <option selected="selected">Choose car type</option>
                                        <option>AVAILABLE</option>
                                        <option>UNAVAILABLE</option>
                                    </select>
                                </div>
                            </div>

                            <div class="simform__actions">
                                <input class="sumbit" name="commit" type="submit" value="Add car"/>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <spring:url value="/resources/js/index.js" var="indexJs"/>
    <script src="${indexJs}"></script>
</body>
</html>
