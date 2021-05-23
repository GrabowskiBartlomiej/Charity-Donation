document.addEventListener("DOMContentLoaded", function () {

    const btn = document.querySelector("form");
    let psw;
    let psw2;
    const failedPswCheck = document.getElementById("failPswCheck");

    btn.addEventListener('submit', checkPasswords);

    function checkPasswords(event){
        psw = document.getElementById("psw");
        psw2 = document.getElementById("psw2");

        if(psw.value !== psw2.value){
            psw.value = "";
            psw2.value = "";
            event.preventDefault();
            failedPswCheck.style.display = "block";
            psw.style.backgroundColor = "lightcoral";
            psw2.style.backgroundColor = "lightcoral";
        }
    }
})