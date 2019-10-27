<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Grayscale - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="../../../static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="../../../static/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../../static/grayscale/css/grayscale.css" rel="stylesheet">




</head>

<body id="page-top">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="logAndregister.jsp">登陆/注册</a>
        <button class="navbar-toggler navbar-toggler-right"
                type="button" data-toggle="collapse"
                data-target="#navbarResponsive"
                aria-controls="navbarResponsive"
                aria-expanded="false" aria-label="Toggle navigation">
            菜单
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="#about">关于我们</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="#projects">名宠简介</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="#signup">联系我们</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Header -->
<header class="masthead">
    <div class="container d-flex h-100 align-items-center">
        <div class="mx-auto text-center">
            <h1 class="mx-auto my-0 text-uppercase">JPETSTORE</h1>
            <h2 class="text-white-50 mx-auto mt-2 mb-5">A Convenient and Excellent Pet Store.</h2>
            <a href="#about" class="btn btn-primary js-scroll-trigger">Have a Visit</a>
        </div>
    </div>
</header>

<!-- About Section -->
<section id="about" class="about-section text-center">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <h2 class="text-white mb-4">这是你从未体验过的全新宠物商店</h2>
                <p class="text-white-50">JPetStore是一个网上浏览、销售宠物的商店，我们卖的是真的宠物，而不是这种
                    <a href="https://17roco.qq.com/">电子宠物</a>.<br />喜欢撸猫撸狗的爱宠人士收藏夹必备！赶快来选购自己心仪的宠物吧！.</p>
            </div>
        </div>
        <img src="../../../static/img/catAnddog.png" class="img-fluid" alt="">
    </div>
</section>

<!-- Projects Section -->
<section id="projects" class="projects-section bg-light">
    <div class="container">

        <!-- Featured Project Row -->
        <div class="row align-items-center no-gutters mb-4 mb-lg-5">
            <div class="col-xl-8 col-lg-7">
                <img class="img-fluid mb-3 mb-lg-0" src="../../../static/img/Parrot.jpg" alt="蓝黄金刚鹦鹉">
            </div>
            <div class="col-xl-4 col-lg-5">
                <div class="featured-text text-center text-lg-left">
                    <h4>蓝黄金刚鹦鹉</h4>
                    <p class="text-black-50 mb-0">
                        It is a member of the large group of neotropical parrots known as macaws.
                        It inhabits forest (especially varzea, but also in open sections of terra firme or unflooded forest), woodland and savannah of tropical South America.
                        They are popular in aviculture because of their striking color, ability to talk, ready availability in the marketplace, and close bonding to humans.
                    </p>
                </div>
            </div>
        </div>

        <!-- Project One Row -->
        <div class="row justify-content-center no-gutters mb-5 mb-lg-0">
            <div class="col-lg-6">
                <img class="img-fluid" src="../../../static/img/Corgi.jpg" alt="威尔士柯基犬">
            </div>
            <div class="col-lg-6">
                <div class="bg-black text-center h-100 project">
                    <div class="d-flex h-100">
                        <div class="project-text w-100 my-auto text-center text-lg-left">
                            <h4 class="text-white">威尔士柯基犬</h4>
                            <p class="mb-0 text-white-50">Welsh Corgis have historically been used as herding dogs, specifically for cattle.
                                They are of the type of herding dog referred to as "heelers",
                                meaning that they would nip at the heels of the larger animals to keep them on the move.</p>
                            <hr class="d-none d-lg-block mb-0 ml-0">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Project Two Row -->
        <div class="row justify-content-center no-gutters">
            <div class="col-lg-6">
                <img class="img-fluid" src="../../../static/img/PersianCat.jpg" alt="">
            </div>
            <div class="col-lg-6 order-lg-first">
                <div class="bg-black text-center h-100 project">
                    <div class="d-flex h-100">
                        <div class="project-text w-100 my-auto text-center text-lg-right">
                            <h4 class="text-white">波斯猫</h4>
                            <p class="mb-0 text-white-50">
                                Persian cat is a kind of breed that was born in 1860 after more than 100 years of breeding in Britain,
                                based on the indigenous long haired cat in Afghanistan and Angora long haired cat in Turkey.
                                Persian cat has a lovely face, long and gorgeous back hair, elegant behavior,
                                is one of the world's favorite pure cat cat, occupies an extremely important position.
                            </p>
                            <hr class="d-none d-lg-block mb-0 mr-0">
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</section>

<!-- Signup Section -->
<section id="signup" class="signup-section">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-lg-8 mx-auto text-center">

                <i class="far fa-paper-plane fa-2x mb-2 text-white"></i>
                <h2 class="text-white mb-5">Subscribe to receive updates</h2>

                <form class="form-inline d-flex">
                    <input type="email" class="form-control flex-fill mr-0 mr-sm-2 mb-3 mb-sm-0" id="inputEmail" placeholder="Enter email address...">
                    <button type="submit" class="btn btn-primary mx-auto">Subscribe</button>
                </form>

            </div>
        </div>
    </div>
</section>

<!-- Contact Section -->
<section class="contact-section bg-black">
    <div class="container">

        <div class="row">

            <div class="col-md-4 mb-3 mb-md-0">
                <div class="card py-4 h-100">
                    <div class="card-body text-center">
                        <i class="fas fa-map-marked-alt text-primary mb-2"></i>
                        <h4 class="text-uppercase m-0">Address</h4>
                        <hr class="my-4">
                        <div class="small text-black-50">湖南省长沙市天心区铁道学院</div>
                    </div>
                </div>
            </div>

            <div class="col-md-4 mb-3 mb-md-0">
                <div class="card py-4 h-100">
                    <div class="card-body text-center">
                        <i class="fas fa-envelope text-primary mb-2"></i>
                        <h4 class="text-uppercase m-0">Email</h4>
                        <hr class="my-4">
                        <div class="small text-black-50">
                            <a href="#">Chritopher@foxmail.com</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-4 mb-3 mb-md-0">
                <div class="card py-4 h-100">
                    <div class="card-body text-center">
                        <i class="fas fa-mobile-alt text-primary mb-2"></i>
                        <h4 class="text-uppercase m-0">Phone</h4>
                        <hr class="my-4">
                        <div class="small text-black-50">911</div>
                    </div>
                </div>
            </div>
        </div>

        <div class="social d-flex justify-content-center">
            <a href="#" class="mx-2 fab fa-twitter">
            </a>
            <a href="#" class="mx-2 fab fa-facebook-f">
            </a>
            <a href="#" class="mx-2 fab fa-github">
            </a>
        </div>

    </div>
</section>

<!-- Footer -->
<footer class="bg-black small text-center text-white-50">
    <div class="container">
        Copyright &copy; 2019 Dyp. All rights reserved.
    </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="../../../static/jquery/jquery.min.js"></script>
<script src="../../../static/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="../../../static/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for this template -->
<script src="../../../static/grayscale/js/grayscale.min.js"></script>

</body>

<script>
    function serachempbypage(page) {
        $.ajax({
            type: "post",
            url: "/meeting/serachemp?page="+page+"&status=${status}&employeename=${employeename}&username=${username}",
            data: {},
            success: function (data) {
                $("#mainPage").html(data);
            }
        })
    }
</script>
</html>