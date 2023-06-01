<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC >
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Start Simple Web</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/board/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/board/css/clean-blog.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/board/css/board.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-image: url('${pageContext.request.contextPath}/board/img/about-bg.jpg'); height: 200px">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="site-heading" style="margin-top: 10px; padding-top: 35px; padding-bottom: 35px">
                        <h2>SAMPLE</h2>
                        <span class="subheading">BULLETIN BOARD</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <div class="board-field">
        <div class="list-group">
            <div class="list-group-item board-title">
                <div class="board-title">
                    <span class="board-category">${info.brd_category}</span>
                    <a href="#">${info.brd_subject}</a>
                </div>
                <div class="board-meta" style="font-weight: 400; font-size: 1.2rem; color: #404040">
                    <p>
                        <i class="glyphicon glyphicon-user"></i> ${info.brd_writer} 님
                        <i class="glyphicon glyphicon-comment"></i> 0
                        <i class="glyphicon glyphicon-ok"></i> ${info.brd_readcount}
                        <i class="glyphicon glyphicon-time"></i> ${info.brd_date}
                        <i class="glyphicon glyphicon-thumbs-up"></i> 0
                        <i class="glyphicon glyphicon-thumbs-down"></i> 0
                    </p>
                </div>
                <div class="clear"></div>
            </div>
            <div class="list-group-item">
                <div class="board-contents">
                    ${info.brd_content}
                </div>
                <img src="${pageContext.request.contextPath}/upload/${info.brd_file}" width="400" height="400"/>
                <p style="text-align: center; margin-top: 30px">
                    <button class="btn btn-success">
                        <i class="glyphicon glyphicon-thumbs-up"></i>공감
                    </button>
                    <button class="btn btn-warning">
                        <i class="glyphicon glyphicon-thumbs-down"></i>비공감
                    </button>
                </p>
            </div>
            <div class="bottom" style="margin: 10px;margin-top: 20px; text-align: right">
                <a href="${pageContext.request.contextPath}/board.do?cmd=list" class="btn btn-default btn-xs pull-left">목록으로</a>
                <a href="${pageContext.request.contextPath}/modify.do?cmd=modify&no=${info.brd_idx}" class="btn btn-default btn-xs">수정</a>
                <a href="${pageContext.request.contextPath}/delete.do?cmd=delete&no=${info.brd_idx}" target="_action_frame_bbs" class="btn btn-default btn-xs"
                   onclick="return confirm('정말로 삭제하시겠습니까?');">삭제</a>
                <a href="#" class="btn btn-default btn-xs">답변</a>
                <a href="#" class="btn btn-default btn-xs">스크랩</a>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <ul class="list-inline text-center">
                        <li><a href="#"> <span class="fa-stack fa-lg"> <i
                                class="fa fa-circle fa-stack-2x"></i> <i
                                class="fa fa-envelope-o fa-stack-1x fa-inverse"></i>
                                </span>
                        </a></li>
                        <li><a href="#"> <span class="fa-stack fa-lg"> <i
                                class="fa fa-circle fa-stack-2x"></i> <i
                                class="fa fa-home fa-stack-1x fa-inverse"></i>
                                </span>
                        </a></li>
                        <li><a href="#"> <span class="fa-stack fa-lg"> <i
                                class="fa fa-circle fa-stack-2x"></i> <i
                                class="fa fa-github fa-stack-1x fa-inverse"></i>
                                </span>
                        </a></li>
                    </ul>
                    <p class="copyright text-muted">Copyright &copy;2016 SIST. All
                        rights reserved | code by milib</p>
                </div>
            </div>
        </div>
    </footer>
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/board/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/board/js/bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/board/js/clean-blog.min.js"></script>
</body>

</html>
