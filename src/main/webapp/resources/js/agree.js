const all = document.getElementById("all");
const agrees = document.getElementsByClassName("agrees");
const btn = document.getElementById("btn");
const frm = document.getElementById("frm");
const req = document.getElementsByClassName("req");

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