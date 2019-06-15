<%@ include file="taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="CSS/home.css" />
        <title>PollWeb - UNIVAQ</title>
        <link rel="shortcut icon" href="CSS/pictures/logo_univaq.png" />
    </head>
    
    <body>
        <header>
            <%@ include file="header.jsp"%>
        </header>
        
        <section>
            <div id="poll_list">
                <c:forEach items="${polls}" var="poll">
                    <c:url var="URL" value="/Example">
                        <c:param name="ID" value="${poll.key}"/>
                    </c:url>
                    <a href="URL">"${poll.title}"</a>
                </c:forEach>
            </div>
        </section>
            
        <footer>
            <%@ include file="footer.jsp"%>
        </footer>
    </body>
</html> 