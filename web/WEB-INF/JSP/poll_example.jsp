<%@ include file="taglibs.jsp"%>
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
        <form method="post" action="treatment">    
            <h3><c:out value="${title}" /></h3>

            <p class="text" id="opening_text">${opening_text}</p>

            <div class="question" id="question1">
                <div class="fond_question">Select your date of birth</div>
                <input type="date" name="date" required/>
            </div>

            <div class="question" id="question2">
                <div class="fond_question">Select your interests</div>
                <div><input type="checkbox" name="sport"/><label for="sport">Sport</label><br/>
                <input type="checkbox" name="cinema"/><label for="cinema">Cinema</label><br/>
                <input type="checkbox" name="museum"/><label for="museum">Museum</label><br/>
                <input type="checkbox" name="party"/><label for="party">Party</label></div>
            </div>

            <div class="question" id="question3">
                <div class="fond_question">Select your time spent on hobbies in a day</div>
                <div><input type="radio" name="time" value="less than 1 hour" id="less18" required/><label for="less1">Less than 1 hour</label><br/>
                <input type="radio" name="time" value="between 1 and 2 hours" id="between1-2" required/><label for="between1-2">From 1 to 2 hours</label><br/>
                <input type="radio" name="time" value="between 2 and 3 hour" id="between2-3" required/><label for="between2-3">From 2 to 3 hours</label><br/>
                <input type="radio" name="time" value="More than 4 hours" id="more60" required/><label for="more3">More than 4 hours</label></div>
            </div>

            <div class="question" id="question4">
                <div class="fond_question">How many sports do you practice?</div>
                <input type="number" name="sports" required/>
            </div>

            <div class="question" id="question5">
                <div class="fond_question">What is your favorite tv program?</div>
                <input type="text" name="tv" required/>
            </div>

            <div class="question" id="question6">
                <div class="fond_question">What are the hobbies in your life?</div>
                <textarea name="life" maxlength="200" rows="3" cols="56" required></textarea>
            </div>

            <p class="text" id="closing_text">${closing_text}</p>

            <input type="submit" id="poll_send" value="Send" />

        </form>
        </section>
            
        <footer>
            <%@ include file="footer.jsp"%>
        </footer>

    </body>
</html>