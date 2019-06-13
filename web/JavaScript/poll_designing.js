$(document).ready(function(){

	var add_question = $('#add_question');
	var res_question = $('#res_question');
	var i = 1;

	add_question.click(function(e){
		e.preventDefault();
		i++;
		$('#question_'+i).css({
			'display':'block'
		});
		$('#question_choices_'+i).css({
			'display':'block'
		});
		if (i>9){
			add_question.css({
				'display': 'none'
			});
		}
		if (i>1){
			res_question.css({
				'display' : 'block',
				'margin-left' : '20px'
			});
		}
	});

	res_question.click(function(e){
		e.preventDefault();
		$('#question_'+i).css({
			'display':'none'
		});
		$('#question_choices_'+i).css({
			'display':'none'
		});
		if (i<=2){
			res_question.css({
				'display' : 'none'
			});
		}
		if (i<=10){
			add_question.css({
				'display' : 'block'
			});
		}
		i--;
	});


	$('#question_type_1').change(function(e){
		e.preventDefault();
		if ($('#question_type_1').val()=="short_text") {
			$('#type_answer_1').html("<input type='text' size='53' placeholder='Answer' maxlength='50' />");
			$('#add_answer_1').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_1').val()=="long_text") {
			$('#type_answer_1').html("<textarea name='reponse' placeholder='Answer' rows='3' cols='52' maxlength='200'></textarea>");
			$('#add_answer_1').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_1').val()=="number") {
			$('#type_answer_1').html("<input type='number' max='5000'/>");
			$('#add_answer_1').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_1').val()=="date") {
			$('#type_answer_1').html("<input type='date' />");
			$('#add_answer_1').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_1').val()=="single_choice") {
			$('#type_answer_1').html("<input type='radio' name='single'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_1').css({
				'display' : 'block'
			});
		}
		else if ($('#question_type_1').val()=="multiple_choice") {
			$('#type_answer_1').html("<input type='checkbox'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_1').css({
				'display' : 'block'
			});
		}
	});

	$('#question_type_2').change(function(e){
		e.preventDefault();
		if ($('#question_type_2').val()=="short_text") {
			$('#type_answer_2').html("<input type='text' size='53' placeholder='Answer' maxlength='50' />");
			$('#add_answer_2').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_2').val()=="long_text") {
			$('#type_answer_2').html("<textarea name='reponse' placeholder='Answer' rows='3' cols='52' maxlength='200'></textarea>");
			$('#add_answer_2').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_2').val()=="number") {
			$('#type_answer_2').html("<input type='number' max='5000'/>");
			$('#add_answer_2').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_2').val()=="date") {
			$('#type_answer_2').html("<input type='date' />");
			$('#add_answer_2').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_2').val()=="single_choice") {
			$('#type_answer_2').html("<input type='radio' name='single'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_2').css({
				'display' : 'block'
			});
		}
		else if ($('#question_type_2').val()=="multiple_choice") {
			$('#type_answer_2').html("<input type='checkbox'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_2').css({
				'display' : 'block'
			});
		}
	});

	$('#question_type_3').change(function(e){
		e.preventDefault();
		if ($('#question_type_3').val()=="short_text") {
			$('#type_answer_3').html("<input type='text' size='53' placeholder='Answer' maxlength='50' />");
			$('#add_answer_3').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_3').val()=="long_text") {
			$('#type_answer_3').html("<textarea name='reponse' placeholder='Answer' rows='3' cols='52' maxlength='200'></textarea>");
			$('#add_answer_3').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_3').val()=="number") {
			$('#type_answer_3').html("<input type='number' max='5000'/>");
			$('#add_answer_3').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_3').val()=="date") {
			$('#type_answer_3').html("<input type='date' />");
			$('#add_answer_3').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_3').val()=="single_choice") {
			$('#type_answer_3').html("<input type='radio' name='single'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_3').css({
				'display' : 'block'
			});
		}
		else if ($('#question_type_3').val()=="multiple_choice") {
			$('#type_answer_3').html("<input type='checkbox'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_3').css({
				'display' : 'block'
			});
		}
	});

	$('#question_type_4').change(function(e){
		e.preventDefault();
		if ($('#question_type_4').val()=="short_text") {
			$('#type_answer_4').html("<input type='text' size='53' placeholder='Answer' maxlength='50' />");
			$('#add_answer_4').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_4').val()=="long_text") {
			$('#type_answer_4').html("<textarea name='reponse' placeholder='Answer' rows='3' cols='52' maxlength='200'></textarea>");
			$('#add_answer_4').css({
				'display' : 'none'
			});			$('#add_answer_1').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_4').val()=="number") {
			$('#type_answer_4').html("<input type='number' max='5000'/>");
			$('#add_answer_4').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_4').val()=="date") {
			$('#type_answer_4').html("<input type='date' />");
			$('#add_answer_4').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_4').val()=="single_choice") {
			$('#type_answer_4').html("<input type='radio' name='single'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_4').css({
				'display' : 'block'
			});
		}
		else if ($('#question_type_4').val()=="multiple_choice") {
			$('#type_answer_4').html("<input type='checkbox'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_4').css({
				'display' : 'block'
			});
		}
	});

	$('#question_type_5').change(function(e){
		e.preventDefault();
		if ($('#question_type_5').val()=="short_text") {
			$('#type_answer_5').html("<input type='text' size='53' placeholder='Answer' maxlength='50' />");
			$('#add_answer_5').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_5').val()=="long_text") {
			$('#type_answer_5').html("<textarea name='reponse' placeholder='Answer' rows='3' cols='52' maxlength='200'></textarea>");
			$('#add_answer_5').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_5').val()=="number") {
			$('#type_answer_5').html("<input type='number' max='5000'/>");
			$('#add_answer_5').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_5').val()=="date") {
			$('#type_answer_5').html("<input type='date' />");
			$('#add_answer_5').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_5').val()=="single_choice") {
			$('#type_answer_5').html("<input type='radio' name='single'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_5').css({
				'display' : 'block'
			});
		}
		else if ($('#question_type_5').val()=="multiple_choice") {
			$('#type_answer_5').html("<input type='checkbox'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_5').css({
				'display' : 'block'
			});
		}
	});

	$('#question_type_6').change(function(e){
		e.preventDefault();
		if ($('#question_type_6').val()=="short_text") {
			$('#type_answer_6').html("<input type='text' size='53' placeholder='Answer' maxlength='50' />");
			$('#add_answer_6').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_6').val()=="long_text") {
			$('#type_answer_6').html("<textarea name='reponse' placeholder='Answer' rows='3' cols='52' maxlength='200'></textarea>");
			$('#add_answer_6').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_6').val()=="number") {
			$('#type_answer_6').html("<input type='number' max='5000'/>");
			$('#add_answer_6').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_6').val()=="date") {
			$('#type_answer_6').html("<input type='date' />");
			$('#add_answer_6').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_6').val()=="single_choice") {
			$('#type_answer_6').html("<input type='radio' name='single'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_6').css({
				'display' : 'block'
			});
		}
		else if ($('#question_type_6').val()=="multiple_choice") {
			$('#type_answer_6').html("<input type='checkbox'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_6').css({
				'display' : 'block'
			});
		}
	});

	$('#question_type_7').change(function(e){
		e.preventDefault();
		if ($('#question_type_7').val()=="short_text") {
			$('#type_answer_7').html("<input type='text' size='53' placeholder='Answer' maxlength='50' />");
			$('#add_answer_7').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_7').val()=="long_text") {
			$('#type_answer_7').html("<textarea name='reponse' placeholder='Answer' rows='3' cols='52' maxlength='200'></textarea>");
			$('#add_answer_7').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_7').val()=="number") {
			$('#type_answer_7').html("<input type='number' max='5000'/>");
			$('#add_answer_7').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_7').val()=="date") {
			$('#type_answer_7').html("<input type='date' />");
			$('#add_answer_7').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_7').val()=="single_choice") {
			$('#type_answer_7').html("<input type='radio' name='single'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_7').css({
				'display' : 'block'
			});
		}
		else if ($('#question_type_7').val()=="multiple_choice") {
			$('#type_answer_7').html("<input type='checkbox'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_7').css({
				'display' : 'block'
			});
		}
	});

	$('#question_type_8').change(function(e){
		e.preventDefault();
		if ($('#question_type_8').val()=="short_text") {
			$('#type_answer_8').html("<input type='text' size='53' placeholder='Answer' maxlength='50' />");
			$('#add_answer_8').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_8').val()=="long_text") {
			$('#type_answer_8').html("<textarea name='reponse' placeholder='Answer' rows='3' cols='52' maxlength='200'></textarea>");
			$('#add_answer_8').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_8').val()=="number") {
			$('#type_answer_8').html("<input type='number' max='5000'/>");
			$('#add_answer_8').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_8').val()=="date") {
			$('#type_answer_8').html("<input type='date' />");
			$('#add_answer_8').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_8').val()=="single_choice") {
			$('#type_answer_8').html("<input type='radio' name='single'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_8').css({
				'display' : 'block'
			});
		}
		else if ($('#question_type_8').val()=="multiple_choice") {
			$('#type_answer_8').html("<input type='checkbox'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_8').css({
				'display' : 'block'
			});
		}
	});

	$('#question_type_9').change(function(e){
		e.preventDefault();
		if ($('#question_type_9').val()=="short_text") {
			$('#type_answer_9').html("<input type='text' size='53' placeholder='Answer' maxlength='50' />");
			$('#add_answer_9').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_9').val()=="long_text") {
			$('#type_answer_9').html("<textarea name='reponse' placeholder='Answer' rows='3' cols='52' maxlength='200'></textarea>");
			$('#add_answer_9').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_9').val()=="number") {
			$('#type_answer_9').html("<input type='number' max='5000'/>");
			$('#add_answer_9').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_9').val()=="date") {
			$('#type_answer_9').html("<input type='date' />");
			$('#add_answer_9').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_9').val()=="single_choice") {
			$('#type_answer_9').html("<input type='radio' name='single'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_9').css({
				'display' : 'block'
			});
		}
		else if ($('#question_type_9').val()=="multiple_choice") {
			$('#type_answer_9').html("<input type='checkbox'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_9').css({
				'display' : 'block'
			});
		}
	});

	$('#question_type_10').change(function(e){
		e.preventDefault();
		if ($('#question_type_10').val()=="short_text") {
			$('#type_answer_10').html("<input type='text' size='53' placeholder='Answer' maxlength='50' />");
			$('#add_answer_10').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_10').val()=="long_text") {
			$('#type_answer_10').html("<textarea name='reponse' placeholder='Answer' rows='3' cols='52' maxlength='200'></textarea>");
			$('#add_answer_10').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_10').val()=="number") {
			$('#type_answer_10').html("<input type='number' max='5000'/>");
			$('#add_answer_10').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_10').val()=="date") {
			$('#type_answer_10').html("<input type='date' />");
			$('#add_answer_10').css({
				'display' : 'none'
			});
		}
		else if ($('#question_type_10').val()=="single_choice") {
			$('#type_answer_10').html("<input type='radio' name='single'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_10').css({
				'display' : 'block'
			});
		}
		else if ($('#question_type_10').val()=="multiple_choice") {
			$('#type_answer_10').html("<input type='checkbox'/><input type='text' size='43' maxlength='40' placeholder='Choice'/>");
			$('#add_answer_10').css({
				'display' : 'block'
			});
		}
	});

});