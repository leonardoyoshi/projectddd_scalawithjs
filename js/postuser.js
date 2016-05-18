var post_button = document.getElementById("postu_submit")

post_button.addEventListener("click", function(){
  event.preventDefault()
	
  var params = { 
    "nome"    : document.querySelector("#nomeU_input").value,
    "cpf"     : document.querySelector("#cpfcnpj_input").value,
    "idade"   : document.querySelector("#idade_input").value,
    "rua"     : document.querySelector("#rua_input").value,
    "numero"  : document.querySelector("#numero_input").value,
    "cidade"  : document.querySelector("#cidade_input").value
  }

  //alert(params);
  
  var xmlhttp = new XMLHttpRequest();
  var url = "http://localhost:9000/user";
  xmlhttp.open("POST", url, true);

  //Send the proper header
  xmlhttp.setRequestHeader("Content-Type", "application/json", "charset=utf-8")

  xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
      alert(xmlhttp.responseText);
    }
  };

  string = JSON.stringify(params)
  console.log(string);
  xmlhttp.send(string);
})