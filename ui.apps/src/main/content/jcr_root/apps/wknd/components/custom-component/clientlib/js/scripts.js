function buttonScript(param) {
    const element = document.querySelector(".custom-popup");
    element.style.visibility = "visible";
    console.log(param);
}

function buttonClose() {
    const element = document.querySelector(".custom-popup");
    element.style.visibility = "hidden";
}