<%@ include file="taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="CSS/poll_designing.css" />
        <title>PollWeb - UNIVAQ</title>
        <link rel="shortcut icon" href="CSS/pictures/logo_univaq.png" />
    </head>
    
    <body>
        <header>
            <%@ include file="header.jsp"%>
        </header>
        
        <section>
            <form method="post" action="Designing">
                <input type="text" name="poll_title" id="poll_title" class="champ" size="25" placeholder="Name of the Poll" maxlength="40" required/>
                
                <textarea name="opening_text" id="opening_text" class="text" placeholder="Opening text" maxlength="200" rows="3" cols="56" required></textarea>

                <div class="question" id="question_1">
                    <input type="text" name="question_name_1" id="question_name_1" class="question_top" size="45" placeholder="Question" maxlength="40" required />
                    <div class="question_body" id="question_body_1">
                        <input type="text" size="53" placeholder="Answer" maxlength="50">
                    </div>
                    <div class="button_question">
                            <input type="button" class="add_answer" id="add_answer_1" value="+" />
                    </div>
                </div>
                <div class="question_choices" id="question_choices_1">
                    <label for="mandatory_yes_1">Mandatory : Yes</label><input type="radio" name="mandatory_1" value="yes" id="mandatory_yes_1"/>
                    <label for="mandatory_no_1">No</label><input type="radio" name="mandatory_1" value="no" id="mandatory_no_1" checked/><br/><br/>
                    <label for="question_type_1">Type of question : </label>
                    <select name="question_type_1" id="question_type_1">
                        <option value="short_text">Short text</option>
                        <option value="long_text">Long text</option>
                        <option value="number">Number</option>
                        <option value="date">Date</option>
                        <option value="single_choice">Single choice</option>
                        <option value="multiple_choice">Multiple choice</option>
                    </select>
                </div>

                <div class="question" id="question_2">
                    <input type="text" name="question_name_2" id="question_name_2" class="question_top" size="45" placeholder="Question" maxlength="40" />
                    <div class="question_body" id="question_body_2">
                        <input type="text" size="53" placeholder="Answer" maxlength="50">
                    </div>
                    <div class="button_question">
                            <input type="button" class="add_answer" id="add_answer_2" value="+" />
                    </div>
                </div>
                <div class="question_choices" id="question_choices_2">
                    <label for="mandatory_yes_2">Mandatory : Yes</label><input type="radio" name="mandatory_2" value="yes" id="mandatory_yes_2"/>
                    <label for="mandatory_no_2">No</label><input type="radio" name="mandatory_2" value="no" id="mandatory_no_2" checked/><br/><br/>
                    <label for="question_type_2">Type of question : </label>
                    <select name="question_type_2" id="question_type_2">
                        <option value="short_text">Short text</option>
                        <option value="long_text">Long text</option>
                        <option value="number">Number</option>
                        <option value="date">Date</option>
                        <option value="single_choice">Single choice</option>
                        <option value="multiple_choice">Multiple choice</option>
                    </select>
                </div>

                <div class="question" id="question_3">
                    <input type="text" name="question_name_3" id="question_name_3" class="question_top" size="45" placeholder="Question" maxlength="40" />
                    <div class="question_body" id="question_body_3">
                        <input type="text" size="53" placeholder="Answer" maxlength="50">
                    </div>
                    <div class="button_question">
                            <input type="button" class="add_answer" id="add_answer_3" value="+" />
                    </div>
                </div>
                <div class="question_choices" id="question_choices_3">
                    <label for="mandatory_yes_3">Mandatory : Yes</label><input type="radio" name="mandatory_3" value="yes" id="mandatory_yes_3"/>
                    <label for="mandatory_no_3">No</label><input type="radio" name="mandatory_3" value="no" id="mandatory_no_3" checked/><br/><br/>
                    <label for="question_type_3">Type of question : </label>
                    <select name="question_type_3" id="question_type_3">
                        <option value="short_text">Short text</option>
                        <option value="long_text">Long text</option>
                        <option value="number">Number</option>
                        <option value="date">Date</option>
                        <option value="single_choice">Single choice</option>
                        <option value="multiple_choice">Multiple choice</option>
                    </select>
                </div>

                <div class="question" id="question_4">
                    <input type="text" name="question_name_4" id="question_name_4" class="question_top" size="45" placeholder="Question" maxlength="40" />
                    <div class="question_body" id="question_body_4">
                        <input type="text" size="53" placeholder="Answer" maxlength="50">
                    </div>
                    <div class="button_question">
                            <input type="button" class="add_answer" id="add_answer_4" value="+" />
                    </div>
                </div>
                <div class="question_choices" id="question_choices_4">
                    <label for="mandatory_yes_4">Mandatory : Yes</label><input type="radio" name="mandatory_4" value="yes" id="mandatory_yes_4"/>
                    <label for="mandatory_no_4">No</label><input type="radio" name="mandatory_4" value="no" id="mandatory_no_4" checked/><br/><br/>
                    <label for="question_type_4">Type of question : </label>
                    <select name="question_type_4" id="question_type_4">
                        <option value="short_text">Short text</option>
                        <option value="long_text">Long text</option>
                        <option value="number">Number</option>
                        <option value="date">Date</option>
                        <option value="single_choice">Single choice</option>
                        <option value="multiple_choice">Multiple choice</option>
                    </select>
                </div>

                <div class="question" id="question_5">
                    <input type="text" name="question_name_5" id="question_name_5" class="question_top" size="45" placeholder="Question" maxlength="40" />
                    <div class="question_body" id="question_body_5">
                        <input type="text" size="53" placeholder="Answer" maxlength="50">
                    </div>
                    <div class="button_question">
                            <input type="button" class="add_answer" id="add_answer_5" value="+" />
                    </div>
                </div>
                <div class="question_choices" id="question_choices_5">
                    <label for="mandatory_yes_5">Mandatory : Yes</label><input type="radio" name="mandatory_5" value="yes" id="mandatory_yes_5"/>
                    <label for="mandatory_no_5">No</label><input type="radio" name="mandatory_5" value="no" id="mandatory_no_5" checked/><br/><br/>
                    <label for="question_type_5">Type of question : </label>
                    <select name="question_type_5" id="question_type_5">
                        <option value="short_text">Short text</option>
                        <option value="long_text">Long text</option>
                        <option value="number">Number</option>
                        <option value="date">Date</option>
                        <option value="single_choice">Single choice</option>
                        <option value="multiple_choice">Multiple choice</option>
                    </select>
                </div>

                <div class="question" id="question_6">
                    <input type="text" name="question_name_6" id="question_name_6" class="question_top" size="45" placeholder="Question" maxlength="40" />
                    <div class="question_body" id="question_body_6">
                        <input type="text" size="53" placeholder="Answer" maxlength="50">
                    </div>
                    <div class="button_question">
                            <input type="button" class="add_answer" id="add_answer_6" value="+" />
                    </div>
                </div>
                <div class="question_choices" id="question_choices_6">
                    <label for="mandatory_yes_6">Mandatory : Yes</label><input type="radio" name="mandatory_6" value="yes" id="mandatory_yes_6"/>
                    <label for="mandatory_no_6">No</label><input type="radio" name="mandatory_6" value="no" id="mandatory_no_6" checked/><br/><br/>
                    <label for="question_type_6">Type of question : </label>
                    <select name="question_type_6" id="question_type_6">
                        <option value="short_text">Short text</option>
                        <option value="long_text">Long text</option>
                        <option value="number">Number</option>
                        <option value="date">Date</option>
                        <option value="single_choice">Single choice</option>
                        <option value="multiple_choice">Multiple choice</option>
                    </select>
                </div>

                <div class="question" id="question_7">
                    <input type="text" name="question_name_7" id="question_name_7" class="question_top" size="45" placeholder="Question" maxlength="40" />
                    <div class="question_body" id="question_body_7">
                        <input type="text" size="53" placeholder="Answer" maxlength="50">
                    </div>
                    <div class="button_question">
                            <input type="button" class="add_answer" id="add_answer_7" value="+" />
                    </div>
                </div>
                <div class="question_choices" id="question_choices_7">
                    <label for="mandatory_yes_7">Mandatory : Yes</label><input type="radio" name="mandatory_7" value="yes" id="mandatory_yes_7"/>
                    <label for="mandatory_no_7">No</label><input type="radio" name="mandatory_7" value="no" id="mandatory_no_7" checked/><br/><br/>
                    <label for="question_type_7">Type of question : </label>
                    <select name="question_type_7" id="question_type_7">
                        <option value="short_text">Short text</option>
                        <option value="long_text">Long text</option>
                        <option value="number">Number</option>
                        <option value="date">Date</option>
                        <option value="single_choice">Single choice</option>
                        <option value="multiple_choice">Multiple choice</option>
                    </select>
                </div>

                <div class="question" id="question_8">
                    <input type="text" name="question_name_8" id="question_name_8" class="question_top" size="45" placeholder="Question" maxlength="40" />
                    <div class="question_body" id="question_body_8">
                        <input type="text" size="53" placeholder="Answer" maxlength="50">
                    </div>
                    <div class="button_question">
                            <input type="button" class="add_answer" id="add_answer_8" value="+" />
                    </div>
                </div>
                <div class="question_choices" id="question_choices_8">
                    <label for="mandatory_yes_8">Mandatory : Yes</label><input type="radio" name="mandatory_8" value="yes" id="mandatory_yes_8"/>
                    <label for="mandatory_no_8">No</label><input type="radio" name="mandatory_8" value="no" id="mandatory_no_8" checked/><br/><br/>
                    <label for="question_type_8">Type of question : </label>
                    <select name="question_type_8" id="question_type_8">
                        <option value="short_text">Short text</option>
                        <option value="long_text">Long text</option>
                        <option value="number">Number</option>
                        <option value="date">Date</option>
                        <option value="single_choice">Single choice</option>
                        <option value="multiple_choice">Multiple choice</option>
                    </select>
                </div>

                <div class="question" id="question_9">
                    <input type="text" name="question_name_9" id="question_name_9" class="question_top" size="45" placeholder="Question" maxlength="40" />
                    <div class="question_body" id="question_body_9">
                        <input type="text" size="53" placeholder="Answer" maxlength="50">
                    </div>
                    <div class="button_question">
                            <input type="button" class="add_answer" id="add_answer_9" value="+" />
                    </div>
                </div>
                <div class="question_choices" id="question_choices_9">
                    <label for="mandatory_yes_9">Mandatory : Yes</label><input type="radio" name="mandatory_9" value="yes" id="mandatory_yes_9"/>
                    <label for="mandatory_no_9">No</label><input type="radio" name="mandatory_9" value="no" id="mandatory_no_9" checked/><br/><br/>
                    <label for="question_type_9">Type of question : </label>
                    <select name="question_type_9" id="question_type_9">
                        <option value="short_text">Short text</option>
                        <option value="long_text">Long text</option>
                        <option value="number">Number</option>
                        <option value="date">Date</option>
                        <option value="single_choice">Single choice</option>
                        <option value="multiple_choice">Multiple choice</option>
                    </select>
                </div>

                <div class="question" id="question_10">
                    <input type="text" name="question_name_10" id="question_name_10" class="question_top" size="45" placeholder="Question" maxlength="40" />
                    <div class="question_body" id="question_body_10">
                        <input type="text" size="53" placeholder="Answer" maxlength="50">
                    </div>
                    <div class="button_question">
                            <input type="button" class="add_answer" id="add_answer_10" value="+" />
                    </div>
                </div>
                <div class="question_choices" id="question_choices_10">
                    <label for="mandatory_yes_10">Mandatory : Yes</label><input type="radio" name="mandatory_10" value="yes" id="mandatory_yes_10"/>
                    <label for="mandatory_no_10">No</label><input type="radio" name="mandatory_10" value="no" id="mandatory_no_10" checked/><br/><br/>
                    <label for="question_type_10">Type of question : </label>
                    <select name="question_type_10" id="question_type_10">
                        <option value="short_text">Short text</option>
                        <option value="long_text">Long text</option>
                        <option value="number">Number</option>
                        <option value="date">Date</option>
                        <option value="single_choice">Single choice</option>
                        <option value="multiple_choice">Multiple choice</option>
                    </select>
                </div>

                <div id="buttons"><input type="button" id="add_question" value="+" />
                     <input type="button" id="res_question" value="-" /></div>

                <textarea name="closing_text" id="closing_text" class="text" placeholder="Closing text" maxlength="200" rows="3" cols="56" required></textarea>

                <div><label for="reserved_yes">Poll reserved : Yes</label><input type="radio" name="reserved" value="yes" id="reserved_yes" />
                     <label for="reserved_no">No</label><input type="radio" name="reserved" value="no" id="reserved_no" checked/></div>

                <input type="submit" id="poll_send" value="Ok" />
                
                <c:if test="${ !empty poll_title }"><p><c:out value="Title : ${poll_title}" /></p></c:if>
                <c:if test="${ !empty opening_text }"><p><c:out value="Opening text : ${ opening_text}" /></p></c:if>
                <c:if test="${ !empty closing_text }"><p><c:out value="Closing text : ${closing_text}" /></p></c:if>
                <p><c:out value="Poll reserved : ${poll_reserved}" /></p>
                
            </form>
        </section>
            
        <footer>
            <%@ include file="footer.jsp"%>
        </footer>
        
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
        <script src="JavaScript/jquery-3.4.1.min.js"></script>
        <script src="JavaScript/poll_designing.js"></script>

    </body>
</html>