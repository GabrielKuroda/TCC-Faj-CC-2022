let pages = ['page_home', 
            'page_add_question','page_view_question'];

let urlQuestions = "http://localhost:8080/questions"


 function showPage(currPage){
     let found = false;
     for (var i = 0; i < pages.length; i++) {
         if (pages[i] == currPage) {
             document.getElementById(pages[i]).style.display = 'block';
             found = true;
         } else {
             document.getElementById(pages[i]).style.display = 'none';
         }
     }
     if (!found) {
         alert('Página não encontrada:' + currPage);
     }
 }

 function searchQuestions() {
    var difficulty_filter = document.getElementById("difficulty_filter").value;
    var operation_filter = document.getElementById("operation_filter").value;

    if(difficulty_filter != "all" && operation_filter != "all"){
        url = urlQuestions + "/filter/" + difficulty_filter + "/" + operation_filter
    }else if(difficulty_filter != "all"){
        url = urlQuestions + "/filter/difficulty/" + difficulty_filter
    }else if(difficulty_filter != "all"){
        url = urlQuestions + "/filter/operation/" + operation_filter
    }else{
        url = urlQuestions
    }

    var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var resp = JSON.parse(this.responseText);
			showQuestions(resp);
		}
	};
	xhttp.open("GET", url, true);
	xhttp.send();
}

function showQuestions(list) {
    var table = '<br><table class="table">' +
                   '<thead class="table-info">'+
                       '<tr>'+
                           '<th scope="col">Dificuldade</th>'+
                           '<th scope="col">Operação</th>'+
                           '<th scope="col">Conta</th>'+
                           '<th scope="col">Resposta</th>'+
                       '</tr>'+
                   '</thead>';
    for (var i = 0; i < list.length; i++) {
        var question = list[i];

        var line = "<tr>" +
                      "<td>" + question.difficulty + "</td>" +
                      "<td>" + question.operation + "</td>" +
                      "<td>" + question.equation + "</td>" +
                      "<td>" + question.answer + "</td>" +
                    "<tr>";

        table += line;
    }
    table +="</table>";
    document.getElementById("divMainQuestions").innerHTML = table;
}

function insertQuestion() {
    var difficulty = document.getElementById("difficulty").value;
    var operation = document.getElementById("operation").value;
    var account = document.getElementById("account").value;
    var answer = document.getElementById("answer").value;

	var inst = {};
	inst.difficulty = difficulty;
    inst.operation = operation;
    inst.equation = account;
    inst.answer = answer;
	
	if(verifyNewQuestion(inst) == Boolean(true)) {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function () {
			if (this.readyState == 4 && this.status == 200) {
                var resp = JSON.parse(this.responseText);
                alert("Conta " + inst.equation + " inserida com Sucesso!")
                limparAddQuestion();
                showPage('page_add_question');
			}

            if (this.readyState == 4 && this.status == 400) {
                var resp = JSON.parse(this.responseText);
                alert(resp.errors[0].detail);
                limparAddQuestion();
                showPage('page_add_question');
			}
		};
		xhttp.open("POST", urlQuestions + "/addQuestion", true);
		xhttp.setRequestHeader("Content-Type", "application/json");
		xhttp.send(JSON.stringify(inst));
	}

    function verifyNewQuestion(object){
        var answerRgx = /^[-+]?[0-9]+$/;
        var sumRgx = /^([0-9]+[+][0-9]+)+$/;
        var subRgx = /^([0-9]+[-][0-9]+)+$/;
        var multRgx = /^([0-9]+[*][0-9]+)+$/;
        var divRgx = /^([0-9]+[/][0-9]+)+$/;

        if(object.equation == "" && object.answer == ""){
            alert("Preencha todos os campos!")
            return new Boolean(false)
        }else if(object.equation == ""){
            alert("Campo Conta em Branco!")
            return new Boolean(false)
        }else if(object.answer == ""){
            alert("Campo Resposta em Branco!")
            return new Boolean(false)
        }

        if(!object.answer.match(answerRgx)){
            alert("Insira somente números!")
            return new Boolean(false)
        }

        switch(object.operation) {
            case "adicao":
                if(!object.equation.match(sumRgx)){
                    alert("A conta inserida está errada! Verificar Operação e formarto da conta!")
                    return new Boolean(false)
                }
                break;
            case "subtracao":
                if(!object.equation.match(subRgx)){
                    alert("A conta inserida está errada! Verificar Operação e formarto da conta!")
                    return new Boolean(false)
                }
                break;
            case "multiplicacao":
                if(!object.equation.match(multRgx)){
                    alert("A conta inserida está errada! Verificar Operação e formarto da conta!")
                    return new Boolean(false)
                }
                break;
            case "divisao":
                if(!object.equation.match(divRgx)){
                    alert("A conta inserida está errada! Verificar Operação e formarto da conta!")
                    return new Boolean(false)
                }
                break;
            default:
              break;
        }
        
        return new Boolean(true)
    }

    function limparAddQuestion() {
        document.getElementById("account").value = "";
        document.getElementById("answer").value = "";
    }
 }