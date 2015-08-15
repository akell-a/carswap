<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
                <li data-tabtar="lgm-2"><a href="">Login</a></li>
            </ul>
            <div class="logmod__tab-wrapper">
                <div class="logmod__tab lgm-2">
                    <div class="logmod__heading">
                        <span class="logmod__heading-subtitle">Enter your email and password <strong>to sign in</strong></span>
                    </div>
                    <div class="logmod__form">
                        <form accept-charset="utf-8" action="/carswap/processLogin.do" class="simform" method="post">
                            <div class="sminputs">
                                <div class="input full">
                                    <label class="string optional" for="email-sminputs">Email*</label>
                                    <input class="string optional" maxlength="255" id="email-sminputs" name="email" placeholder="Email" type="email" size="50" />
                                </div>
                            </div>
                            <div class="sminputs">
                                <div class="input full">
                                    <label class="string optional" for="password-sminputs">Password *</label>
                                    <input class="string optional" maxlength="255" id="password-sminputs" name="password" placeholder="Password" type="password" size="50" />
                                    <span class="hide-password">Show</span>
                                </div>
                            </div>
                            <div class="simform__actions">
                                <input class="sumbit" name="commit" type="submit" value="Log In" />
                                <span class="simform__actions-sidetext"><a class="special" role="link" href="#">Forgot your password?<br>Click here</a></span>
                            </div>
                        </form>
                    </div>
                    <div class="logmod__alter">
                        <div class="logmod__alter-container">
                            <a href="register.do" class="connect facebook">
                                <div class="connect__context">
                                    <span><strong>Register</strong></span>
                                </div>
                            </a>
                            <a href="main.do" class="connect googleplus">
                                <div class="connect__context">
                                    <span><strong>Go Home</strong></span>
                                </div>
                            </a>
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