var	post_button = document.getElementById("postp_submit")

post_button.addEventListener("click", function(){
  event.preventDefault()

  var params = { 
    "nome"         : document.querySelector("#nomeP_input").value,
    "preco"         : document.querySelector("#preco_input").value,
    "categoria"   : document.querySelector("#categoria_input").value
  }

  var xmlhttp = new XMLHttpRequest();
  var url = "http://localhost:9000/product";
  xmlhttp.open("POST", url, true);

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