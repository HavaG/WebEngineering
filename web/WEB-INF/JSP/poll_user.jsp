<%-- 
    Document   : poll_user
    Created on : 2019.06.15., 15:30:53
    Author     : HavaG
--%>


<%@ include file="taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="CSS/poll_user.css" />
        <title>PollWeb - UNIVAQ</title>
        <link rel="shortcut icon" href="CSS/pictures/logo_univaq.png" />
    </head>

    <body>
        <header>
            <%@ include file="header.jsp"%>
        </header>

        <section>
            <form method="post" action="PollCreate">
                <div name="message">Add all the users' email addres. Divide with ',' caracters</div>

                <div class="row">
                    <div>
                        Emails<textarea type="text" name="emails"/></textarea>
                    </div>

                    <div>
                        <button name="submit">Submit</button>
                    </div>
            </form>
        </section>

        <footer>
            <%@ include file="footer.jsp"%>
        </footer>
    </body>
</html>