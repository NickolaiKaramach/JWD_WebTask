function cypherText(text) {
    var cypherText = "";
    for (var i = text.length - 1; i >= 0; i--) {
        cypherText += text[i];
    }
    return cypherText;
}

function holdRegForm() {
    //TODO: Implement it

    var message = "Invalid data:\n";
    var noErrors = true;
    if (!document.getElementById("name")) {
        noErrors = false;
        message += "*   Name cannot be empty!\n";
    }
    if (!document.getElementById("email")) {
        noErrors = false;
        message += "*   Email cannot be empty!\n";
    } else {
        if (!validateEmail(document.getElementById("email").value)) {
            message += "*   Invalid email!\n"
        }
    }
    if (!document.getElementById("pass")) {
        noErrors = false;
        message += "*   Password cannot be empty!\n";
    } else {
        //TODO: Validate: is simple pass?
    }
    if (!document.getElementById("re_pass")) {
        noErrors = false;
        message += "*   Repeated password cannot be empty!\n";
    }

    if (!noErrors) {
        alert(message);
    } else {
        form.submit();
    }
    document.getElementById("form").submit();
}

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}