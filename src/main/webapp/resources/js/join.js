const userName = document.getElementById("userName");
const pass = document.getElementById("pass");
const pass2 = document.getElementById("pass2");
const name1 = document.getElementById("name");
const email1 = document.getElementById("email");
const phone = document.getElementById("phone");
const btn = document.getElementById("btn");
const joinfrm = document.getElementById("joinfrm");
const user_check = document.getElementById("user_check");
const pass_check = document.getElementById("pass_check");
const pass2_check =document.getElementById("pass2_check");
const name_check = document.getElementById("name_check");
const email1_check = document.getElementById("email_check")
const phone_check = document.getElementById("phone_check");
const regpass = /^[A-Za-z0-9!@]{6,}$/;
const regemail = /^[a-zA-Z0-9]([-_\.]?[a-zA-Z0-9])*@[a-zA-Z0-9]([-_\.]?[a-zA-Z0-9])*\.[a-zA-Z]{2,3}$/;
const idCheckBtn = document.querySelector("#idCheckBtn");

btn.addEventListener("click",function(){
    if(userName.value==""){
        console.log(userName.value)
        user_check.innerHTML='ID를 입력해주세요.';
        userName.focus();
    }else if(pass.value ==""){
        pass_check.innerHTML='PW를 입력해주세요.';
        pass.focus();
    }else if(pass2.value ==""){
        pass2_check.innerHTML='re PW를 확인해주세요.'
        pass2.focus();
    }else if(name1.value==""){
        name_check.innerHTML='NAME을 입력해주세요';
        name1.focus();
    }else if(email1.value ==""){
        email1_check.innerText='email을 입력해주세요';
        email1.focus();
    }else if(phone.value==""){
        phone_check.innerHTML='phone을 입력해주세요.';
        phone.focus();
    }else{
        joinfrm.submit();
    }
})



userName.addEventListener("blur",function(){
    let u = userName.value
    // if(userName == ""){
    //     userName.innerHTML='ID를 입력해주세요.'
    //     userName.focus();
     if(u.length < 2){
        user_check.innerHTML ='ID는 2글자 이상이여야 합니다.';
        userName.focus();
    }else{
        user_check.innerHTML =' ';
    } 
    
});

pass.addEventListener("keyup",function(){
    let p = pass.value
    let p2 =pass2.value
 
        pass_check.innerHTML='최소 6글자 이상이어야 합니다.';
        pass.focus();   

});
pass.addEventListener("blur",function(){
    let p = pass.value
    console.log(regpass.test(pass.value))
    if(p.length <= 5){
        pass_check.innerHTML='최소 6글자 이상이어야 합니다.';
        pass.focus();   
    }else if(regpass.test(pass.value) != true){
        pass_check.innerHTML='특수문자는 !,@만 가능합니다 대소문자 구분';
        pass.focus();
    }else{
        pass_check.innerHTML=' ';

    }
})

pass2.addEventListener("blur",function(){
    let p = pass.value
    let p2 =pass2.value
    if(p != p2){
        pass2_check.innerHTML='비밀번호가 다릅니다.';
        pass2.focus();
    }else{
        pass2_check.innerHTML='비밀번호가 일치합니다..';
    }
});

name1.addEventListener("blur",function(){
    let n = name1.value
    if(n.length <= 0){
        name_check.innerHTML='이름은 최소 1글자 이상이여야 합니다.';
        name1.focus();
    }else{
        name_check.innerHTML='';
    }
})

email1.addEventListener("blur",function(){
    let e = email1.value
    console.log(regemail.test(email1.value))
    if(e.length <= 0){
        email_check.innerHTML='email은 최소 1글자 이상이여야 합니다.';
        email1.focus();
    }else if(regemail.test(email1.value) != true){
        email1_check.innerHTML='대문자,소문자,숫자를 포함한 이메일을 입력해주세요.';
        email1.focus();
    }else{
        email_check.innerHTML='';
    }
})

phone.addEventListener("blur",function(){
    let ph = phone.value
    if(ph.length<=0){
        phone_check.innerHTML='phone은 최소 1글자 이상이여야 합니다.'
        phone.focus();
    }else{
        phone_check.innerHTML=''
    }
})


idCheckBtn.addEventListener("click",function(){
    console.log("쀼쀼?")
     //1.XMLHttpRequest 생성
     const xhttp = new XMLHttpRequest();
     //2.Method,url 요청정보
     xhttp.open("POST","./IdCheck");
     //3.Header 정보넘김
     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
     //4.요청실행
     xhttp.send("userName="+userName.value);
     //5.응답처리
     xhttp.onreadystatechange=function(){
         if(xhttp.readyState==4 && xhttp.status==200){
             let result = xhttp.responseText.trim();
             console.log("넘어온거",xhttp.responseText);
 
             if(result == 1){
                 user_check.innerHTML="이미 사용중인 아이디입니다.";
                 console.log("야야 똑바로해")
                 userName.focus();
             }else{
                 user_check.innerHTML="사용 가능한 아이디입니다.";
                 
             }
         }
     }
})


