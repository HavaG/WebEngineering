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
        <form method="post" action="Example">    
            <h3><c:out value="${poll.title}" /></h3>

            <p class="text" id="open_tag">${poll.open_tag}</p>
            
            <div class="question">
                
                <c:forEach items="${questions}" var="question">

                    <div class="question_top"><c:out value="${question.text}"/></div>
                    <div class="question_body">
                        <textarea class="note">"${question.note}"</textarea>
                    
                        <c:choose>
                            <c:when test="${question.type == 'short_text'}"><input type="text"/></c:when>
                            <c:when test="${question.type == 'long_text'}"><textarea></textarea></c:when>
                            <c:when test="${question.type == 'number'}"><input type="number"/></c:when>
                            <c:when test="${question.type == 'date'}"><input type="date"/></c:when>
                            <c:when test="${question.type == 'single_choice'}">                                     
                                <c:forEach var="choice" items="${answer}"> 
                                    <input type="radio" name="${question.position}"/><label>"${choice}"</label>>
                                </c:forEach>
                            </c:when>
                            <c:when test="${question.type == 'multiple_choice'}">                                     
                                <c:forEach var="choice" items="${answer}"> 
                                    <input type="checkbox" name="${question.position}"/><label>"${choice}"</label>>
                                </c:forEach>
                            </c:when>                                                    
                        </c:choose>                 
                </c:forEach>
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