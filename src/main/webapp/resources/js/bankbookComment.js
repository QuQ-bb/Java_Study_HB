const btn = document.getElementById("btn");
const writer =document.getElementById("writer");
const contents =document.getElementById("contents")
const commentList = document.getElementById("commentList");
const more = document.getElementById("more");



//page번호 담는 변수
let page =1;
//bookNum을 담을 변수
const bookNum = btn.getAttribute("data-book-num");
getCommentList(page,bookNum);


btn.addEventListener("click",function(){
    // console.log(writer.value);
    // console.log(contents.value);
    // console.log(btn.getAttribute("data-book-num"));
    // let bookNum = btn.getAttribute("data-book-num");
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

                // if(commentList.children.length !=0){
                    for(let i=0; i<commentList.children.length;){
                        commentList.children[0].remove();
                    }
                // }
                page =1;

                getCommentList(page,bookNum);
            }else{
                console.log("왜 1인데 실패야?")
            }
          }
        }

})  //click Event끝

function getCommentList(p,bn){
    //1.XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();
    //2. Method,URL 준비
    xhttp.open("GET","./commentList?page="+p+"&bookNum="+bn);
    //3. 요청 전송
    xhttp.send();
    //4.응답처리
    xhttp.addEventListener("readystatechange",function(){
        if(xhttp.readyState==4 && xhttp.status==200){
            console.log(xhttp.responseText);
            //1.jsp 사용한 결과물
            // commentList.innerHTML=xhttp.responseText.trim();

            //2. json 결과물
            let result = JSON.parse(xhttp.responseText.trim());

            // let table = document.createElement("table")
            // let tableattr = document.createAttribute("class");
            // tableattr.value="table table-striped table-hover";
            // table.setAttributeNode(tableattr);
            let pager = result.pager;   //commentPager
            let al =result.list;        //al: 댓글리스트 

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
                    //날짜 format 변경
                    // text = new Date(al[i].regdate);
                    // console.log("text=",text)
                    // let y = text.getFullYear();
                    // let m = text.getMonth()+1;
                    // let d = text.getDate();
                    // console.log("mmmm=",m)
                    // console.log("ddd=",d)
                    // text = document.createTextNode(y+"-"+m+"-"+d);

                    text = document.createTextNode(al[i].regdate);
                       td.appendChild(text);
                       tr.appendChild(td);
           
                  td = document.createElement("td");
                 text = document.createTextNode("수정");
                let tdAttr = document.createAttribute("class");
                    tdAttr.value="update";
                    td.setAttributeNode(tdAttr);
                    td.appendChild(text);
                    tr.appendChild(td);

                    tdAttr = document.createAttribute("data-comment-num");
                    tdAttr.value= (al[i].num);
                    td.setAttributeNode(tdAttr);
                       td.appendChild(text);
                       tr.appendChild(td);

                    td = document.createElement("td");
                    text = document.createTextNode("삭제");
                    tdAttr = document.createAttribute("class");
                    tdAttr.value="delete";
                    td.setAttributeNode(tdAttr);
                    tdAttr = document.createAttribute("data-comment-num");
                    tdAttr.value= (al[i].num);
                    td.setAttributeNode(tdAttr);
                       td.appendChild(text);
                       tr.appendChild(td);

                    commentList.append(tr);

                    if(page >= pager.totalPage){
                        more.classList.add("disabled");
                    }else{
                        more.classList.remove("disabled");
                    }
            }
            // tr.appendChild(td);
            // table.appendChild(tr);
            
            console.log(commentList.children);

            // let t = commentList.children;

            // if(t.length !=0){
            //     commentList.children[0].remove();
            // }
            // try{
            //     console.log(commentList.children);
            //     throw new Error("삐용삐용 에러발생 ㅇㅍㅇ@!!!");
            // }catch(exeception){

            // }finally{

            // }
            // commentList.append(table);
            
            //  commentList.children.remove();
           
        }//if
    })//xhttp
    
}//getCommentList

//-----------더보기-----------------------------

more.addEventListener("click",function(){
    console.log("히엥")
    page++; //page = page+1;
    console.log(page);
    console.log(bookNum);

    getCommentList(page,bookNum);

})//more
//------------------------------------------------------
commentList.addEventListener("click", function(event){
    console.log(event.target);
    if(event.target.className=="update"){
        //1.
        // let contents = event.target.previousSibling.previousSibling;
        // console.log("con",contents);
        // let v =contents.innerHTML;
        // contents.innerHTML="<textarea>"+v+"</textarea>";

        //2.
        let contents = event.target.previousSibling.previousSibling.previousSibling.innerHTML;
        let writer = event.target.previousSibling.previousSibling.innerHTML;
        let num = event.target.getAttribute("data-comment-num");
        console.log(contents);
        console.log(writer);
        document.querySelector("#updateContents").value=contents;
        document.querySelector("#updateWriter").value=writer;
        document.querySelector("#num").value=num;

        document.querySelector("#up").click();
    }


    if(event.target.className == "delete"){
        console.log("delete");
        
        let check = window.confirm("삭제 눌려야 삭제하지")
        if(check){
            let num = event.target.getAttribute("data-comment-num");
            console.log("num=",num);
            //1.XMLHTTPRequest 생성
            const xhttp = new XMLHttpRequest();
            //2.method,url 요청정보
            xhttp.open("POST","./commentDelete?num="+num);
            //3. post일 때, Header정보를 넘김
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            //4.parameter+요청
            xhttp.send("num="+num);
            //5.
            xhttp.onreadystatechange=function(){
                if(xhttp.readyState==4 && xhttp.status==200){
                    let result = (xhttp.responseText.trim());
                    console.log("넘어온것",xhttp.responseText)  //1
                    console.log(result);    //1

                    if(result ==1){
                        alert("삭제 완")
                        for(let i=0; i<commentList.children.length;){
                            commentList.children[0].remove();
                        }
                        page =1;
                        getCommentList(page,bookNum);
                    }else{
                        alert("퉤")
                    }
                }
            }

        }
        console.log(check)
    }
})//delete

//-----------------------------------------------------------------------------------
//Modal Update Button
const send = document.querySelector("#send");

send.addEventListener("click",function(event){
    console.log("먀하")
    console.log(event.target);
    //modal에서 num,contents
    let num = document.querySelector("#num").value;
    let contents = document.querySelector("#updateContents").value;


    //1.XMLHttpRequest 생성
    const xhttp = new XMLHttpRequest();
    //2.Method, url요청 정보/request 정보
    xhttp.open("POST","./commentUpdate");
    //3.Header 정보 넘김(Enctype)
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //4.parameter값 넘겨주기/요청실행
    xhttp.send("num="+num+"&contents="+contents)
    //5.응답처리
    xhttp.onreadystatechange=function(){
        if(xhttp.readyState==4 && xhttp.status==200){
            let result = xhttp.responseText.trim();
            console.log("넘어온것",this.responseText);
            console.log(result);

            if(result ==1){
                console.log("수정성고옹")
                alert("수정완료")
                for(let i=0; i<commentList.children.length;){
                    commentList.children[0].remove();
                }
                page=1;
                getCommentList(page,bookNum);
            }
        }
    }
})
