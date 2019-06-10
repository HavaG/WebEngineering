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
            <div class="login">
                <form method="post" action="Login">
                    <div class="top_login"><p>Login :</p></div>
                    <div><div id="email">
                        <label for="email">Mail Adress :</label>
                        <input type="email" name="email" placeholder="Ex : john.smith@gmail.com" size="30" maxlength="40"/>
                    </div>
                    <div id="password">
                        <label for="password">Password :</label>
                        <input type="password" name="password" placeholder="Ex : C~&;3H:t5*dD" size="20" maxlength="12"/>
                    </div></div>
                    <div id="button"><input type="submit" value="Login"/></div>
                </form>
            </div>

            <a href="Administrator" id="admin_page">Administrator</a><a href="Manager" id="mana_page">Manager</a>
        </section>
            
        <footer>
            <%@ include file="footer.jsp"%>
        </footer>
    </body>
</html>
