const d1 = document.getElementById("d1");
const int = document.getElementById("int");
const result = document.getElementById("result");
d1.addEventListener("click",function(){
    console.log("tlqkfkfkfkkf")

    //1.ajax로 요청하는 객체 생성
    let xhttp = new XMLHttpRequest();

    //2.요청 정보
    
    xhttp.open("GET","https://jsonplaceholder.typicode.com/posts/"+int.value);   //"method타입","주소"

    //3.요청 발생
    xhttp.send();   //get방식일때는 안에 parameter를 넣어주지않음

    //4.응답 결과 처리
    xhttp.onreadystatechange = function(){
        //this는 xhttp 객체
        // console.log(this.status);
        // console.log(this.readyState);
        // console.log("===================================")
        if(this.readyState==4 && this.status==200){
        //     console.log(this.responseText); //응답 내용
        
        let response = this.responseText.trim();
        response = JSON.parse(response);    //문자열을 JSON타입의 객체로 변경해줌
        console.log(response.userId);
        console.log(response.id);
        console.log(response.title);
        console.log(response.body);
        
        let tag  = document.createElement("h3");
        let uid = document.createTextNode(response.userId);
        tag.appendChild(uid);
        result.append(tag);
          
        tag = document.createElement("h3");
        let id =document.createTextNode(response.id);
        tag.appendChild(id);
        result.append(tag);

        tag = document.createElement("h3");
        let tit = document.createTextNode(response.title);
        tag.appendChild(tit);
        result.append(tag);

        tag = document.createElement("h3");
        let body = document.createTextNode(response.body);
        tag.appendChild(body);
        result.append(tag);
        }
    }

    console.log("AJAX 발생");
})