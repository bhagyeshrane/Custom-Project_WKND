/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function headerFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function (event) {
    if (!event.target.matches('.dropbtn')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
    if (!event.target.matches(['.custom-popup', '.popup-message', '.popup-custom-message', '.press-me-button'])) {
        var popup = document.querySelector(".custom-popup");
        if (popup.style.visibility === "visible") {
            popup.style.visibility = "hidden";
        }
    }
}
