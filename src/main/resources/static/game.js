var divs = document.querySelectorAll(".board div")

for (var i = 0; i < divs.length; i++) divs[i].onclick = function() {
    if (canPlayerMove(this)) {
        playerMove(this);
    } else {
        console.log("can't move");
    }
};

function canPlayerMove(element){
    return element.innerHTML == "" || element.innerHTML == undefined;
}

function playerMove(element){
    element.innerHTML = "x";
    sendNumber(element.id.substr(6,1));
}

function sendNumber(i) {
    var xhr = new XMLHttpRequest();
    var url = "/";
    var data = JSON.stringify({"number": i});
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            // do something with response
            var json = JSON.parse(xhr.responseText);
            bootMove(json);
        }
    };
    xhr.send(data);
}


function bootMove(field){
    var element = document.getElementById("field_"+field.number);
    element.innerHTML = "O"
}


