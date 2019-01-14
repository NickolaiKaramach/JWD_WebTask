function cypherText(text) {
    var cypherText = "";
    for (var i = text.length - 1; i >= 0; i--) {
        cypherText += text[i];
    }
    return cypherText;
}

function showError(container, errorMessage) {
    container.className = 'error';
    var msgElem = document.createElement('span');
    msgElem.className = "error-message";
    msgElem.innerHTML = errorMessage;
    container.appendChild(msgElem);
}

function holdForm() {
    var message = "Invalid data:\n";
    var noErrors = true;

    if (!document.getElementById("email")) {
        noErrors = false;
        message += "*   Email cannot be empty!\n";
    } else {
        if (!validateEmail(document.getElementById("email").value)) {
            noErrors = false;
            message += "*   Invalid email!\n"
        }
    }
    if (!document.getElementById("pass")) {
        noErrors = false;
        message += "*   Password cannot be empty!\n";
    } else {
        document.getElementById("pass").value = cypherText(document.getElementById("pass").value);
    }

    if (noErrors) {
        document.getElementById("form").submit();
    } else {
        alert(message);
    }
}

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}