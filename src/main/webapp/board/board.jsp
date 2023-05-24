<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="UTF-8" %>
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
    <link href="${pageContext.request.contextPath}/board/css/bootstrap.css" rel="stylesheet" type="text/css">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/board/css/clean-blog.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/board/css/board.css" rel="stylesheet" type="text/css">

    <!-- Custom Fonts -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script>
        $(function(){
            $("a#search").click(function() {
                document.location.href = "${pageContext.request.contextPath}/search.do?cmd=paging&category=" + $("select#section_category").val() + "&inputText=" + $("input#input_search").val();
            });
        });

    </script>

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
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="board-toolbar" style="text-align: right; margin-bottom: 20px">
                <select id="section_category" class="section-heading">
                    <option value="SELECT" <c:if test="${empty category or category eq 'SELECT'}">selected</c:if>>선택하세요</option>
                    <option value="brd_subject" <c:if test="${category eq 'brd_subject'}">selected</c:if>>TITLE</option>
                    <option value="brd_writer" <c:if test="${category eq 'brd_writer'}">selected</c:if>>WRITER</option>
                    <option value="brd_category" <c:if test="${curcol eq 'brd_category'}">selected</c:if>>CATEGORY</option>
                    <option value="brd_date" <c:if test="${curcol eq 'brd_date'}">selected</c:if>>REGDATE</option>
                </select>
                <input id="input_search" type="text" class="input-lg">
                <a href="#" id="search" class="btn btn-primary btn-sm">
                    <i class="glyphicon glyphicon-search" style="margin-right: 15px"></i>검색
                </a>

                <a href="write.jsp" class="btn btn-primary btn-sm">
                    <i class="glyphicon glyphicon-pencil" style="margin-right: 15px"></i>쓰기
                </a>
            </div>

            <div class="list-group">
                <c:forEach var="entry" items="${list}">
                    <a href="info.jsp" class="list-group-item">
                        <%-- 카테고리, 제목, New --%>
                        <div class="board-title">
                            <span class="board-category">[${entry.brd_category}]</span>
                            ${entry.brd_subject}
                            <span class="badge">New</span>
                        </div>

                        <%-- 작성자, 댓글수, 조회수, 날짜 --%>
                        <div class="board-meta" style="font-weight: 400; font-size: 1.2rem; color: #404040">
                            <p>
                                <i class="glyphicon glyphicon-user"></i> ${entry.brd_writer} 님
                                <i class="glyphicon glyphicon-comment"></i> ${entry.brd_readcount}
                                <i class="glyphicon glyphicon-ok"></i> ${entry.brd_readcount}
                                <i class="glyphicon glyphicon-time"></i> ${entry.brd_date}
                            </p>
                        </div>
                    </a>
                </c:forEach>
            </div>

            <div class="col-md-2"></div>
            <div class="col-md-8">
                <ul class="pagination">
                    <li><a href="${pageContext.request.contextPath}/listPaging.do?cmd=paging&p=1&category=${sessionScope.curCategory}&inputText=${sessionScope.curInput}">처음페이지</a></li>

                    <c:choose>
                        <c:when test="${sessionScope.currentPage > 1}">
                            <li><a href="${pageContext.request.contextPath}/listPaging.do?cmd=paging&p=${sessionScope.currentPage-1}&category=${sessionScope.curCategory}&inputText=${sessionScope.curInput}">이전</a></li>
                        </c:when>

                        <c:otherwise>
                            <a href="#">이전</a>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach var="i" begin="${sessionScope.startPage}" end="${sessionScope.totalPage}">
                        <c:choose>
                            <c:when test="${i==sessionScope.currentPage}">
                                <li class="active"><a href="${pageContext.request.contextPath}/listPaging.do?cmd=paging&p=${i}&category=${sessionScope.curCategory}&inputText=${sessionScope.curInput}">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${pageContext.request.contextPath}/listPaging.do?cmd=paging&p=${i}&category=${sessionScope.curCategory}&inputText=${sessionScope.curInput}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${sessionScope.totalPage > sessionScope.currentPage}">
                            <li><a href="${pageContext.request.contextPath}/listPaging.do?cmd=paging&p=${sessionScope.currentPage+1}&category=${sessionScope.curCategory}&inputText=${sessionScope.curInput}">다음</a></li>
                        </c:when>
                        <c:otherwise>
                            <a href="#">다음</a>
                        </c:otherwise>
                    </c:choose>

                    <li><a href=${pageContext.request.contextPath}/listPaging.do?cmd=paging&p=${sessionScope.totalPage}&category=${sessionScope.curCategory}&inputText=${sessionScope.curInput}">마지막페이지</a></li>
                </ul>
            </div>
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
