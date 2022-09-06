const btn = document.getElementById("btn");
const writer =document.getElementById("writer");
const contents =document.getElementById("contents")

getCommentList();

btn.addEventListener("click",function(){
    // console.log(writer.value);
    // console.log(contents.value);
    // console.log(btn.getAttribute("data-book-num"));
    let bookNum = btn.getAttribute("data-book-num");
    let wv = writer.value;
    let cv = contents.value;
   

    //---------------------------------------------
    //ajax
    //1.XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2.Method,URL 준비
    xhttp.open("POST","./commentAdd");

    //3. Enctype
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4.POST 파라미터 전송
    xhttp.send("bookNum="+bookNum+"&writer="+wv+"&contents="+cv);

    //5.요청 발생
    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            let result = xhttp.responseText.trim();
            result = JSON.parse(result);
            console.log(result.result);
            writer.value="";
            contents.value="";
            
            console.log("result==",result);
            if(result.result ==1){
                alert("뱌ㅇyㅇ");
                getCommentList();
            }else{
                console.log("왜 1인데 실패야?")
            }
          }
        }

})  //click Event끝

function getCommentList(){
    //1.XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();
    //2. Method,URL 준비
    xhttp.open("GET","./commentList?page=1&bookNum=2");
    //3. 요청 전송
    xhttp.send();
    //4.응답처리
    xhttp.addEventListener("readystatechange",function(){
        if(xhttp.readyState==4 && xhttp.status==200){
            console.log(xhttp.responseText);
            //1.jsp 사용한 결과물
            // commentList.innerHTML=xhttp.responseText.trim();

            //2. json 결과물
            let al = JSON.parse(xhttp.responseText.trim());

            let table = document.createElement("table")
            let tableattr = document.createAttribute("class");
            tableattr.value="table table-striped table-hover";
            table.setAttributeNode(tableattr);

            for(let i=0; i<al.length; i++){
                let tr = document.createElement("tr");
                let td = document.createElement("td");

                let text = document.createTextNode(al[i].contents)
                    td.appendChild(text);
                    tr.appendChild(td);
              
                    td = document.createElement("td");
                 text = document.createTextNode(al[i].writer);
                    td.appendChild(text);
                    tr.appendChild(td);
           
                  td = document.createElement("td");
                 text = document.createTextNode(al[i].regdate);
                    td.appendChild(text);
                    tr.appendChild(td);

                    table.appendChild(tr);
            }

            
            // tr.appendChild(td);
            // table.appendChild(tr);

            const commentList = document.getElementById("commentList");
            commentList.append(table);

        }
    })
    
}
