<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login/Sign-In</title>

    <spring:url value="/resources/css/normalize.css" var="normalizeCss" />
    <spring:url value="/resources/css/style.css" var="styleCss" />
    <spring:url value="/resources/css/font-awesome.min.css" var="fontCss" />

    <link href="${normalizeCss}" rel="stylesheet" />
    <link href="${styleCss}" rel="stylesheet" />
    <link href="${fontCss}" rel="stylesheet" />

</head>

<body>

<div class="logmod">
    <div class="logmod__wrapper">
        <div class="logmod__container">
            <ul class="logmod__tabs">
                <li data-tabtar="lgm-1"><a href="">Sign Up</a></li>
            </ul>
            <div class="logmod__tab-wrapper">
                <div class="logmod__tab lgm-1">
                    <div class="logmod__heading">
                        <span class="logmod__heading-subtitle">Enter your personal details <strong>to create an acount</strong></span>
                    </div>
                    <div class="logmod__form">
                        <form accept-charset="utf-8" action="/carswap/processRegister.do" class="simform" method="post">
                            <div class="sminputs">
                                <div class="input string optional">
                                    <label class="string optional" for="email">Email *</label>
                                    <input class="string optional" maxlength="255" id="email" name="email" placeholder="Email" type="email" size="50" />
                                </div>
                                <div class="input string optional">
                                    <label class="string optional" for="birthDate">Birth Day </label>
                                    <input class="string optional" maxlength="255" id="birthDate" name="birthDate" placeholder="dd.MM.YYYY" type="text" size="50" />
                                </div>
                            </div>

                            <div class="sminputs">
                                <div class="input string optional">
                                    <label class="string optional" for="name">Name *</label>
                                    <input class="string optional" maxlength="255" id="name" name="name" placeholder="Name" type="text" size="50" />
                                </div>
                                <div class="input string optional">
                                    <label class="string optional" for="secondName">Second Name *</label>
                                    <input class="string optional" maxlength="255" id="secondName" name="secondName" placeholder="Second Name" type="text" size="50" />
                                </div>
                            </div>

                            <div class="sminputs">
                                <div class="input string optional">
                                    <label class="string optional" for="phone">Phone</label>
                                    <input class="string optional" maxlength="255" id="phone" name="phone" placeholder="You contact phone" type="text" size="50" />
                                </div>
                                <div class="input string optional">
                                    <label class="string optional" for="city">City</label>
                                    <input class="string optional" maxlength="255" id="city" name="city" placeholder="City" type="text" size="50" />
                                </div>
                            </div>
                            <div class="sminputs">
                                <div class="input string optional">
                                    <label class="string optional" for="password">Password *</label>
                                    <input class="string optional" maxlength="255" id="password" name="password" placeholder="Password" type="password" size="50" />
                                </div>
                                <div class="input string optional">
                                    <label class="string optional" for="password-repeat">Repeat password *</label>
                                    <input class="string optional" maxlength="255" id="password-repeat" placeholder="Repeat password" type="password" size="50" />
                                </div>
                            </div>
                            <div class="simform__actions">
                                <input class="sumbit" type="submit" value="Create Account" />
                                <span class="simform__actions-sidetext">By creating an account you agree to our <a class="special" href="#" target="_blank" role="link">Terms & Privacy</a></span>
                            </div>
                        </form>
                    </div>
                    <div class="logmod__alter">
                        <div class="logmod__alter-container">
                            <a href="login.do" class="connect facebook">
                                <div class="connect__context">
                                    <span><strong>Login</strong></span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<spring:url value="/resources/js/index.js" var="indexJs" />
<script src="${indexJs}"></script>

</body>
</html>