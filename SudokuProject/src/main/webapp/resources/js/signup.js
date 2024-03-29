console.log("Singup.js");
const checkObj = {
    "inputId" : false,
    "inputPw" : false,
    "inputPw2" : false,
    "inputName" : false
};

const inputId = document.getElementById("inputId");

inputId.addEventListener("change", function() {
    const regExp = /^[a-z0-9!@#\$%\^\&*\)\(+=._-]{5,13}$/g;
    if(regExp.test(this.value)){
        this.classList.add("valid");
        this.classList.remove("invalid");
        this.style.border = "2px solid green";
        checkObj.inputId = true;
    } else{
        this.classList.add("invalid");
        this.classList.remove("valid");
        this.style.border = "2px solid red";
        checkObj.inputId = false;
    }

});

const inputPw = document.getElementById("inputPw");
const inputPw2 = document.getElementById("inputPw2");

inputPw2.addEventListener("keyup", function() {

    if(inputPw.value.length == 0) {
        this.value = null;
        alert("Password Required");
        inputPw.focus();
        checkObj.inputPw = false;
    }
});

const pwMessage = document.getElementById("pwMessage");

inputPw.addEventListener("keyup", function() {
    if((inputPw.value == inputPw2.value) && inputPw.value.length != 0) {
        pwMessage.innerText = "Password Confirmed";
        pwMessage.style.color = "green";
        checkObj.inputPw = true;
        checkObj.inputPw2 = true;
    } else {
        pwMessage.innerText = "Password Not Confirmed";
        pwMessage.style.color = "red";
        checkObj.inputPw2 = false;
    }
});

inputPw2.addEventListener("keyup", function(){
    if((inputPw.value == inputPw2.value) && inputPw.value.length != 0) {
        pwMessage.innerText = "Password Confirmed";
        pwMessage.style.color = "green";
        checkObj.inputPw = true;
        checkObj.inputPw2 = true;
    } else {
        pwMessage.innerText = "Password Not Confirmed";
        pwMessage.style.color = "red";
        checkObj.inputPw2 = false;
    }
});

const inputName = document.getElementById("inputName");
const nameMessage = document.getElementById("nameMessage");

inputName.addEventListener("change", function(){
    const regExp = /^[a-zA-Z가-힣]{2,5}$/g;
    if(regExp.test(this.value)){
        nameMessage.innerText = "Name Confirmed";
        nameMessage.style.color = "green";
        inputName.style.border = "2px solid green";
        checkObj.inputName = true;
    } else {
        nameMessage.innerText = "Name Not Confirmed";
        nameMessage.style.color = "red";
        inputName.style.border = "2px solid red";
        checkObj.inputName = false;
    }
});

function valudadte() {
    for(let key in checkObj) {
        if(!checkObj[key]) {
            alert("Signup Error")
            return false;
        }
    }
    return true;
}