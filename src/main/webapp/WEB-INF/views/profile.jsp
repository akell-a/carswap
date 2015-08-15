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

        <article class="grid_9 content-sidebar-right">
            <p>
                ${sessionScope.user.name}  Sed ut perspiciatis unde omnis iste natus error sit
                voluptatem accusantium doloremque laudantium, totam
                rem aperiam, eaque ipsa quae ab illo inventore
                veritatis et quasi architecto beatae vitae dicta
                sunt explicabo. Nemo enim ipsam voluptatem quia
                voluptas sit aspernatur aut. Sed ut perspiciatis
                unde omnis iste natus error sit voluptatem
                accusantium doloremque laudantium, totam rem
                aperiam, eaque ipsa quae ab illo inventore
                veritatis et quasi architecto beatae vitae dicta
                sunt explicabo. Nemo enim ipsam voluptatem quia
                voluptas sit aspernatur aut.
            </p>

            <p>
                Sed ut perspiciatis unde omnis iste natus error sit
                voluptatem accusantium doloremque laudantium, totam
                rem aperiam, eaque ipsa quae <span class="text-light">
                            ab illo inventore veritatis et quasi architecto beatae
                            vitae dicta sunt explicabo. Nemo enim</span> ipsam voluptatem
                quia volupta sit aspernatur aut. Sed ut perspiciatis
                unde omnis iste natus error sit voluptatem
                accusantium doloremque laudantium, totam rem
                aperiam, eaque ipsa quae ab illo inventore
                veritatis et quasi architecto beatae vitae dicta
                sunt explicabo. Nemo enim ipsam voluptatem quia
                voluptas sit aspernatur aut.
            </p>

            <blockquote class="text-left">

                This is an example of a blockquote. It's
                simple, clean and very easy to use. And you can
                use it on all of your pages.

            </blockquote>

            <p>
                Sed ut perspiciatis unde omnis iste natus error
                sit voluptatem accusantium doloremque laudantium,
                totam rem aperiam, eaque ipsa quae ab illo
                inventore veritatis et quasi architecto beatae
                vitae dicta sunt explicabo. Nemo enim ipsam
                voluptatem quia voluptas sit aspernatur aut.


                Net quasi architecto beatae vitae dicta sunt
                explicabo. Sed ut perspiciatis unde omnis iste natus error
                sit voluptatem accusantium doloremque laudantium,
                totam rem aperiam, eaque ipsa quae ab illo
                inventore veritatis et quasi architecto beatae
                vitae dicta sunt explicabo.
                Sed ut perspiciatis unde omnis iste natus error
                sit voluptatem accusantium doloremque laudantium,
                totam rem aperiam, eaque ipsa quae ab illo
                inventore veritatis quasi
                architecto beatae vitae dicta sunt explicabo.
                Nemo enim ipsam
                voluptatem quia voluptas sit aspernatur aut.
                Net quasi architecto beatae vitae dicta sunt
                explicabo.
            </p>
        </article><!-- .content-sidebar-left end -->



        <aside class="grid_3 aside">

            <ul class="aside-widgets">

                <li class="categories">
                    <h5>Available functions</h5>
                    <ul class="arrow-list">
                        <li><a href="#">Change password</a></li>
                        <li><a href="#">Change email</a></li>
                        <li><a href="#">Add points</a></li>
                    </ul>
                </li><!-- categories widget end -->
            </ul><!-- sidebar widgets end -->
        </aside><!-- sidebar end -->
    </div><!-- container_12 end -->
</div><!-- content wrapper end -->

<jsp:include page="footer.jsp" />