<%@ include file="taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="CSS/admin.css" />
        <title>PollWeb - UNIVAQ</title>
        <link rel="shortcut icon" href="CSS/pictures/logo_univaq.png" />
    </head>
    
    <body>
        <header>
            <%@ include file="header.jsp"%>
        </header>
        
        <section>
            <div class="add_manager">
                <form method="post" action="Administrator">
                    <div class="top_add_manager"><p>Add a manager :</p></div>
                    <div><div id="email">
                        <label for="email">Mail Adress :</label>
                        <input type="email" name="email" placeholder="Ex : john.smith@gmail.com" size="30" maxlength="40"/>
                    </div>
                    <div id="password">
                        <label for="password">Password :</label>
                        <input type="password" name="password" placeholder="Ex : C~&;3H:t5*dD" size="20" maxlength="12"/>
                    </div></div>
                    <div id="button"><input type="submit" value="Add" name="create"/></div>
                </form>
            </div>

            <div id="manager_list">
                <div class="manager">
                    <p>Manager 1 :</p>
                    <ul>
                        <li><a href="Example">Poll 1</a></li>
                        <li><a href="Example">Poll 2</a></li>
                        <li><a href="Example">Poll 3</a></li>
                    </ul>
                </div>
                <div class="manager">
                    <p>Manager 2 :</p>
                    <ul>
                        <li><a href="Example">Poll 1</a></li>
                    </ul>
                </div>
                <div class="manager">
                    <p>Manager 3 :</p>
                    <ul>
                        <li><a href="Example">Poll 1</a></li>
                        <li><a href="Example">Poll 2</a></li>
                    </ul>
                </div>
                <div class="manager">
                    <p>Manager 4 :</p>
                    <ul>
                        <li><a href="Example">Poll 1</a></li>
                    </ul>
                </div>
                <div class="manager">
                    <p>Manager 5 :</p>
                    <ul>
                        <li><a href="Example">Poll 1</a></li>
                        <li><a href="Example">Poll 2</a></li>
                        <li><a href="Example">Poll 3</a></li>
                    </ul>
                </div>

            </div>
        </section>
            
        <footer>
            <%@ include file="footer.jsp"%>
        </footer>

    </body>
</html>