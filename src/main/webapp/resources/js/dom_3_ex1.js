const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");
const btn = document.getElementById("btn");
const btn2 = document.getElementById("btn2");
const btn3 = document.getElementById("btn3");
const btn4 =document.getElementById("btn4");
const select = document.getElementById("select");
const c1 = document.getElementsByClassName("c1");

d1.getAttribute("id");
d2.getAttribute("id");


// let fn = function (d1,d2){
//      let result = d1+d2;
//      fn2();
//      console.log(d1.);
//      console.log(d2);
//      return result;
// }
// let fn2 = function(){
//     d3.innerText = result;
// }

btn.addEventListener("click",function(){
    console.log("뭐여 이거 어려워");
    console.log("Operator",select.value);
     console.log("d1",d1.value);
     console.log("d2",d2.value);
    //  d3.value = d1.value*d2.value
    //덧셈을 하면 문자열이기때문에 7+2 = "7"+"2" =72 
    //하지만 곱셉은 숫자로 인식
    //  d3.setAttribute("value",d1.value*1+d2.value*1) //뒤에 각자 1을 곱해주면 정상적으로 덧셈이 가능

    if(select.value == "+"){
        d3.value = d1.value*1 + d2.value;
    }else if(select.value == "-"){
        d3.value = d1.value*1 - d2.value*1;
    }else if(select.value == "*"){
        d3.value = d1.value*d2.value;
    }else if(select.value =="/"){
        d3.value = d1.value*1 /d2.value*1;
    }else{
        d3.value = d1.value*1 % d2.value*1;
    }
});

btn2.addEventListener("click",function(){
    console.log("집갈래");
});
btn3.addEventListener("click",function(){
    alert("졸립다 버틍3")
    //Event 강제실행
    btn2.click();
   
});

btn4.addEventListener("click", function(){
    alert(c1);
    console.log(c1);
    console.log(c1.value);
    for(let i = 0; i<c1.length; i++ ){
        console.log(c1[i].selected)
        c1[i].selected = true;
    }
});


