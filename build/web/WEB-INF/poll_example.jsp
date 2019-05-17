<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="CSS/poll_example.css" />
        <title>PollWeb - UNIVAQ</title>
        <link rel="shortcut icon" href="CSS/pictures/logo_univaq.png" />
    </head>
    
    <body>
        <header>
            <%@ include file="header.jsp"%>
        </header>
        
        <section>
            <h3>Answer the questions :</h3>

            <div class="question" id="question1">
                <form method="post" action="traitement">
                    <div class="fond_question"><p>Question 1/4 : Choose your age range</p></div>
                    <div><input type="radio" name="age" value="less than 18 years" id="less18" /><label for="less18">Less than 18 years</label><br/>
                    <input type="radio" name="age" value="between 18-25" id="between18-25" /><label for="between18-25">From 18 to 25 years</label><br/>
                    <input type="radio" name="age" value="between 25-60" id="between25-60" /><label for="between25-60">From 25 to 60 years</label><br/>
                    <input type="radio" name="age" value="More than 60" id="more60" /><label for="more60">More than 60 years</label></div>
                </form>
            </div>

            <div class="question" id="question2">
                <form method="post" action="traitement">
                    <div class="fond_question"><p>Question 2/4 : Select your interests</p></div>
                    <div><input type="checkbox" name="sport"/><label for="sport">Sport</label><br/>
                    <input type="checkbox" name="cinema"/><label for="cinema">Cinema</label><br/>
                    <input type="checkbox" name="museum"/><label for="museum">Museum</label><br/>
                    <input type="checkbox" name="party"/><label for="party">Party</label></div>
                </form>
            </div>
        </section>
            
        <footer>
            <%@ include file="footer.jsp"%>
        </footer>

    </body>
</html>