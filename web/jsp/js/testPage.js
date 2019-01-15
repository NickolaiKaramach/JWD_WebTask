function change_display_type(str) {
    var formDiv = document.getElementById(str);
    if (formDiv.style.display === "none") {
        formDiv.style.display = "block";
    } else {
        formDiv.style.display = "none";
    }
}

