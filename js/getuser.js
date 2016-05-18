var xmlhttp = new XMLHttpRequest();
var url = "http://localhost:9000/user/1";

function myFunction(obj) {
  var i;
  for(i=0; i<obj.length; i++) {
  
  document.getElementById("nomeU_input").value = obj.nomeU;
  document.getElementById("cpfcnpj_input").value = obj.cpf;
  document.getElementById("idade_input").value = obj.idade;
  document.getElementById("rua_input").value = obj.rua;
  document.getElementById("numero_input").value = obj.numero;
  document.getElementById("cidade_input").value = obj.cidade;

  }
}

xmlhttp.onreadystatechange = function() {
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
    var myObj = JSON.parse(xmlhttp.responseText);
    myFunction(myObj);
  }
};
xmlhttp.open("GET", url, true);
console.log()
xmlhttp.send(null);
