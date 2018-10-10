<%@ page import="com.reimburse.common.util.ShiroUtils" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!-- saved from url=(0045)http://wow.techbrood.com/fiddle/fork?id=30287 -->
<html class=" -webkit- js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths"
      style="">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>HTML5 Preview Panel</title>
    <script src="${pageContext.request.contextPath}/dist/js/prefixfree.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/modernizr.js"></script>
    <style>h1 {
        font-size: 25px;
        text-align: left;
        text-transform: capitalize;
    }

    .service-box {
        position: relative;
        overflow: hidden;
        margin-bottom: 10px;
        perspective: 1000px;
        -webkit-perspective: 1000px;
    }

    .service-icon {
        width: 100%;
        height: 220px;
        padding: 20px;
        text-align: center;
        transition: all .5s ease;
    }

    .service-content {
        position: absolute;
        top: 0;
        left: 0;
        z-index: 1;
        opacity: 0;
        width: 100%;
        height: 220px;
        padding: 20px;
        text-align: center;
        transition: all .5s ease;
        background-color: #474747;
        backface-visibility: hidden;
        transform-style: preserve-3d;
        -webkit-transform: translateY(110px) rotateX(-90deg);
        -moz-transform: translateY(110px) rotateX(-90deg);
        -ms-transform: translateY(110px) rotateX(-90deg);
        -o-transform: translateY(110px) rotateX(-90deg);
        transform: translateY(110px) rotateX(-90deg);
    }

    .service-box .service-icon .front-content {
        position: relative;
        top: 80px;
        -webkit-transform: translateY(-50%);
        -moz-transform: translateY(-50%);
        -ms-transform: translateY(-50%);
        -o-transform: translateY(-50%);
        transform: translateY(-50%);
    }

    .service-box .service-icon .front-content i {
        font-size: 28px;
        color: #fff;
        font-weight: normal;
    }

    .service-box .service-icon .front-content h3 {
        font-size: 15px;
        color: #fff;
        text-align: center;
        margin-bottom: 15px;
        text-transform: uppercase;
    }

    .service-box .service-content h3 {
        font-size: 15px;
        font-weight: 700;
        color: #fff;
        margin-bottom: 10px;
        text-transform: uppercase;
    }

    .service-box .service-content p {
        font-size: 13px;
        color: #b1b1b1;
        margin: 0;
    }

    .yellow {
        background-color: #ffc000;
    }

    .orange {
        background-color: #fc7f0c;
    }

    .red {
        background-color: #e84b3a;
    }

    .grey {
        background-color: #474747;
    }

    .service-box:hover .service-icon {
        opacity: 0;
        -webkit-transform: translateY(-110px) rotateX(90deg);
        -moz-transform: translateY(-110px) rotateX(90deg);
        -ms-transform: translateY(-110px) rotateX(90deg);
        -o-transform: translateY(-110px) rotateX(90deg);
        transform: translateY(-110px) rotateX(90deg);
    }

    .service-box:hover .service-content {
        opacity: 1;
        -webkit-transform: rotateX(0);
        -moz-transform: rotateX(0);
        -ms-transform: rotateX(0);
        -o-transform: rotateX(0);
        transform: rotateX(0);
    }</style>
    <script src="${pageContext.request.contextPath}/dist/js/jquery-2.1.1.min.js"></script>
</head>
<body>
<script src="${pageContext.request.contextPath}/dist/js/jquery-1.11.1.min.js"></script>


<title>Service Box Style</title>
<style media="" data-href="https://fonts.googleapis.com/css?family=Alegreya+Sans">/* cyrillic-ext */
@font-face {
    font-family: 'Alegreya Sans';
    font-style: normal;
    font-weight: 400;
    src: local('Alegreya Sans Regular'), local('AlegreyaSans-Regular'), url(https://fonts.gstatic.com/s/alegreyasans/v8/5aUz9_-1phKLFgshYDvh6Vwt7VdtvXVX.woff2) format('woff2');
    unicode-range: U+0460-052F, U+1C80-1C88, U+20B4, U+2DE0-2DFF, U+A640-A69F, U+FE2E-FE2F;
}

/* cyrillic */
@font-face {
    font-family: 'Alegreya Sans';
    font-style: normal;
    font-weight: 400;
    src: local('Alegreya Sans Regular'), local('AlegreyaSans-Regular'), url(https://fonts.gstatic.com/s/alegreyasans/v8/5aUz9_-1phKLFgshYDvh6Vwt7V5tvXVX.woff2) format('woff2');
    unicode-range: U+0400-045F, U+0490-0491, U+04B0-04B1, U+2116;
}

/* greek-ext */
@font-face {
    font-family: 'Alegreya Sans';
    font-style: normal;
    font-weight: 400;
    src: local('Alegreya Sans Regular'), local('AlegreyaSans-Regular'), url(https://fonts.gstatic.com/s/alegreyasans/v8/5aUz9_-1phKLFgshYDvh6Vwt7VZtvXVX.woff2) format('woff2');
    unicode-range: U+1F00-1FFF;
}

/* greek */
@font-face {
    font-family: 'Alegreya Sans';
    font-style: normal;
    font-weight: 400;
    src: local('Alegreya Sans Regular'), local('AlegreyaSans-Regular'), url(https://fonts.gstatic.com/s/alegreyasans/v8/5aUz9_-1phKLFgshYDvh6Vwt7VltvXVX.woff2) format('woff2');
    unicode-range: U+0370-03FF;
}

/* vietnamese */
@font-face {
    font-family: 'Alegreya Sans';
    font-style: normal;
    font-weight: 400;
    src: local('Alegreya Sans Regular'), local('AlegreyaSans-Regular'), url(https://fonts.gstatic.com/s/alegreyasans/v8/5aUz9_-1phKLFgshYDvh6Vwt7VVtvXVX.woff2) format('woff2');
    unicode-range: U+0102-0103, U+0110-0111, U+1EA0-1EF9, U+20AB;
}

/* latin-ext */
@font-face {
    font-family: 'Alegreya Sans';
    font-style: normal;
    font-weight: 400;
    src: local('Alegreya Sans Regular'), local('AlegreyaSans-Regular'), url(https://fonts.gstatic.com/s/alegreyasans/v8/5aUz9_-1phKLFgshYDvh6Vwt7VRtvXVX.woff2) format('woff2');
    unicode-range: U+0100-024F, U+0259, U+1E00-1EFF, U+2020, U+20A0-20AB, U+20AD-20CF, U+2113, U+2C60-2C7F, U+A720-A7FF;
}

/* latin */
@font-face {
    font-family: 'Alegreya Sans';
    font-style: normal;
    font-weight: 400;
    src: local('Alegreya Sans Regular'), local('AlegreyaSans-Regular'), url(https://fonts.gstatic.com/s/alegreyasans/v8/5aUz9_-1phKLFgshYDvh6Vwt7VptvQ.woff2) format('woff2');
    unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02BB-02BC, U+02C6, U+02DA, U+02DC, U+2000-206F, U+2074, U+20AC, U+2122, U+2191, U+2193, U+2212, U+2215, U+FEFF, U+FFFD;
}
</style>
<style media="" data-href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">/*!
 *  Font Awesome 4.6.3 by @davegandy - http://fontawesome.io - @fontawesome
 *  License - http://fontawesome.io/license (Font: SIL OFL 1.1, CSS: MIT License)
 */
@font-face {
    font-family: 'FontAwesome';
    src: url("https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/../fonts/fontawesome-webfont.eot?v=4.6.3");
    src: url("https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/../fonts/fontawesome-webfont.eot?#iefix&v=4.6.3") format('embedded-opentype'), url("https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/../fonts/fontawesome-webfont.woff2?v=4.6.3") format('woff2'), url("https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/../fonts/fontawesome-webfont.woff?v=4.6.3") format('woff'), url("https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/../fonts/fontawesome-webfont.ttf?v=4.6.3") format('truetype'), url("https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/../fonts/fontawesome-webfont.svg?v=4.6.3#fontawesomeregular") format('svg');
    font-weight: normal;
    font-style: normal
}

.fa {
    display: inline-block;
    font: normal normal normal 14px/1 FontAwesome;
    font-size: inherit;
    text-rendering: auto;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale
}

.fa-ul > li {
    position: relative
}

@-webkit-keyframes fa-spin {
    0% {
        -webkit-transform: rotate(0deg);
        transform: rotate(0deg)
    }
    100% {
        -webkit-transform: rotate(359deg);
        transform: rotate(359deg)
    }
}

@keyframes fa-spin {
    0% {
        -webkit-transform: rotate(0deg);
        transform: rotate(0deg)
    }
    100% {
        -webkit-transform: rotate(359deg);
        transform: rotate(359deg)
    }
}

/*# sourceMappingURL=bootstrap.min.css.map */</style>


<div class="container">
    <h1>Service box</h1>
    <div class="row">
        <div class="col-md-3 col-sm-6 ">
            <div class="service-box">
                <div class="service-icon yellow">
                    <div class="front-content">
                        <i class="fa fa-trophy"></i>
                        <h3>我的审批</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>我的审批</h3>
                    <div id="reimburse"></div>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6 ">
            <div class="service-box">
                <div class="service-icon orange">
                    <div class="front-content">
                        <i class="fa fa-anchor"></i>
                        <h3>审批中</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>审批中</h3>
                    <div id="before_reimburse"></div>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="service-box ">
                <div class="service-icon red">
                    <div class="front-content">
                        <i class="fa fa-trophy"></i>
                        <h3>已审批</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>已审批</h3>
                    <div id="ing_reimburse"></div>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="service-box">
                <div class="service-icon grey">
                    <div class="front-content">
                        <i class="fa fa-paper-plane-o"></i>
                        <h3>未通过</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>未通过</h3>
                    <div id="after_reimburse"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        var url = "accountant/findAllByAccountant.do";
        var params = {"user": "<%=ShiroUtils.getPrincipal() %>"};
        $.post(url, params, function (result) {
            if (result.state === 1) {
                setTableBodyRows(result.data);
            } else {
                alert(result.message);
            }
        });
    });

    function setTableBodyRows(data) {
        var reimburse = $("#reimburse");
        var before = $("#before_reimburse");
        var ing = $("#ing_reimburse");
        var after = $("#after_reimburse");
        reimburse.empty();
        before.empty();
        ing.empty();
        after.empty();
        var pAll = "<p style='font-size: 72px'>"+data.all+"元</p>";
        var pBefore = "<p style='font-size: 72px'>"+data.ing+"元</p>";
        var pIng = "<p style='font-size: 72px'>"+data.pass+"元</p>";
        var pAfter = "<p style='font-size: 72px'>"+data.fail+"元</p>";
        reimburse.append(pAll);
        before.append(pBefore);
        ing.append(pIng);
        after.append(pAfter);
    }
</script>
</body>
</html>