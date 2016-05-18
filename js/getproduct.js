var xmlhttp = new XMLHttpRequest();
var url = "http://localhost:9000/product/1";

function myFunction(obj) {
  var i;
  
  document.getElementById("nomeP_input").value = obj.nome;
  document.getElementById("preco_input").value = obj.preco;
  document.getElementById("categoria_input").value = obj.categoria;
}

xmlhttp.onreadystatechange = function() {
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
    var myObj = JSON.parse(xmlhttp.responseText);
    myFunction(myObj);
  }
};

xmlhttp.open("GET", url, true);
xmlhttp.send(); 
