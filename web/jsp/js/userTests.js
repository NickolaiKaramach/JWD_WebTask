function change_display_type() {
    var formDiv = document.getElementById("new_test");
    if (formDiv.style.display === "none") {
        formDiv.style.display = "block";
    } else {
        formDiv.style.display = "none";
    }
}