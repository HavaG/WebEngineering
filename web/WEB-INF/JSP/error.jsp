<%@ include file="taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="CSS/login.css" />
        <title>PollWeb - UNIVAQ</title>
        <link rel="shortcut icon" href="CSS/pictures/logo_univaq.png" />
    </head>
    
    <body>
        <header>
            <%@ include file="header.jsp"%>
        </header>
        
        <section>
            <div class="error">
                <form method="post" action="error">
                    <div class="top_login"><p>Error message:</p></div>
                        <input type="text" name="message" value='<%=request.getAttribute("message")%>'/> 
                </form>
            </div>
        </section>
            
        <footer>
            <%@ include file="footer.jsp"%>
        </footer>
    </body>
</html>
