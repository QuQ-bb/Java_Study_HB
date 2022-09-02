// const all = document.getElementById("all");
const all = document.querySelector("#all"); //#id명
// const agrees = document.getElementsByClassName("agrees");
const agrees =document.querySelectorAll(".agrees"); //실제 배열 .클래스명
const btn = document.getElementById("btn");
const frm = document.getElementById("frm");
const req = document.getElementsByClassName("req");

//foreach는 유사배열
// console.log("foreach")
// agrees.foreach(function(v,i,ar){
//    console.log(v);
// })

    agrees.forEach(function(v,i,ar){
        console.log(v)
    });


all.addEventListener("click",function(){
    console.log(all.checked);
    for(let i=0; i<agrees.length; i++){
        agrees[i].checked = all.checked
    }
})

for(let i=0; i<agrees.length; i++){
    agrees[i].addEventListener("click",function(){
        let result =true;
        console.log(agrees[i].checked)
        for(let a=0; a<agrees.length; a++){
            console.log(agrees[a].checked)
            if(!agrees[a].checked){
                result =false;
                break;
            }
        }
        all.checked = result;
    })
}

//모두 필수 동의일때 
// btn.addEventListener("click",function(){
//     if(!all.checked){
//         alert("모든 약관에 동의 해주세요.");
//     }else{
//         frm.submit();
//     }
// })

//필수 약관만 선택해서 동의
btn.addEventListener("click",function(){
    let no = true;
    for(let i=0; i<req.length; i++){
        console.log(req.length)
        console.log(req[i].checked)
        if(!req[i].checked){
            no = false;
            break;
        }
    }
    if(no){

        frm.submit();
    }else{
        alert("필수약관에 동의해주세요");
    }

})