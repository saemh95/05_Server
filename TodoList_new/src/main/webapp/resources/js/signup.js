// console.log("signup.js loaded");

const checkObj = {
    "inputId" : false,
    "inputPw" : false,
    "inputPw2" : false,
    "inputName" : false
};

const inputId = document.getElementById("inputId");

inputId.addEventListener("change", function() {
    const regExp = /^[a-z0-9!@#\$%\^\&*\)\(+=._-]{5,13}$/g;
    if(regExp.test(this.value)) {
        this.style.backgroundColor = "green";
        this.style.color = "white";
        checkObj.inputId = true;
    } else {
        this.style.backgroundColor = "red";
        this.style.color = "white";
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
        pwMessage.innerText = "Password Confirmed"
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");
        checkObj.inputPw = true;
        checkObj.inputPw2 = true;
    } else {
        pwMessage.innerText = "Password Not Confirmed"
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
        checkObj.inputPw2 = false;
    }
});

inputPw2.addEventListener("keyup", function() {
    if((inputPw.value == inputPw2.value) && inputPw.value.length != 0) {
        pwMessage.innerText = "Password Confirmed"
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");
        checkObj.inputPw = true;
        checkObj.inputPw2 = true;
    } else {
        pwMessage.innerText = "Password Not Confirmed"
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
        checkObj.inputPw2 = false;
    }
});


const inputName = document.getElementById("inputName");
const nameMessage = document.getElementById("nameMessage");
inputName.addEventListener("change", function() {

    const regExp = /^[a-zA-Z가-힣]{2,5}$/g;
    if(!regExp.test(this.value)) {
        nameMessage.innerText = "Nickname Not Confirmed";
        nameMessage.classList.add("error");
        nameMessage.classList.remove("confirm");
        this.style.backgroundColor = "red";
        this.style.color = "white";
        checkObj.inputName = false;
    } else {
        nameMessage.innerText = "Nickname Confirm";
        nameMessage.classList.add("confirm");
        nameMessage.classList.remove("error");
        this.style.backgroundColor = "green";
        this.style.color = "white";
        checkObj.inputName = true;
    }

});

function validate() {
    for(let key in checkObj) {
        if(!checkObj[key]) {
            alert("Signup Error")
            return false;
        }
    }
    return true;
}