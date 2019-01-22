function confirm_test_finish() {
    if (confirm("Are you sure want finish test?")) {
        window.location = 'controller?command=finish_test'
    }
}