const form = document.getElementById("form");
const btn = document.getElementById("btn");
const id = document.getElementById("userName");
const pw = document.getElementById("password");
const id_check = document.getElementById("id_check");
const pw_check = document.getElementById("pw_check");

function loginCheck(){
    btn.addEventListener("click",function(){
        console.log("히이잉");
        // if(id.value == ""){ //(id.length>0 && pw.length>0)
        //     alert("아이디를 입력해주세요.")
        //     id.focus();
        //     // return; 단일 if일때 사용하면 return을 만날시 그 즉시 종료
        // }else if (pw.value == ""){
        //     alert("비밀번호를 입력해주세요.")
        //     console.log("아이디또는 비밀번호를 입력하세요.")
        //     pw.focus();
        // }else{
        //     form.submit();
        // }
    
        // if(id.value ==""){
        //     alert("아이디 입력찌!!!")
        //     return;
        // }
        // if(pw.value ==""){
        //     alert("비번 입력찌!!!")
        //     return;
        // }
        if(id.value ==""){
            id_check.innerHTML='ID를 입력해주세요.';
            id.focus();
        }else if(pw.value ==""){
            pw_check.innerHTML='PW를 입력해주세요';
            pw.focus();
        }
        
    })
}

