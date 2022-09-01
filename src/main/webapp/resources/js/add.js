const addFiles = document.getElementById("addFiles");   //div
const fileAdd = document.getElementById("fileAdd"); //버튼
const del = document.getElementsByClassName("del");


let count =0;
let idx =0;
fileAdd.addEventListener("click",function(){
    idx++;
    if(count < 5){
        count++;
    }else{
        alert("최대 다섯개까지 가능")
        return;
    }
    //부모 element 생성
    let div = document.createElement("div") //<div></div>
    // let c = document.createAttribute("class"); //<div class=""></
    // c.value = "mb-3";
    // div.setAttributeNode(c);
    let c= document.createAttribute("id");  //
    c.value ="file"+idx;
    div.setAttributeNode(c);
    let input = document.createElement("input")
    let type= document.createAttribute("type")
    type.value="file";
    input.setAttributeNode(type);   //속성 넣기
    let name = document.createAttribute("name")
    name.value ="files"
    input.setAttributeNode(name);

    div.appendChild(input)
    // addFiles.append(div);

    //삭제버튼 추가    
    let button = document.createElement("button");//태그 추가
    let type1= document.createAttribute("type")//속성 추가
    type1.value="button";
    button.setAttributeNode(type1);
    let class1 = document.createAttribute("class");
    class1.value ="del";
    button.setAttributeNode(class1);
    class1 =document.createAttribute("title");
    class1.value  =idx;
    button.setAttributeNode(class1);
    //text 추가
    let text = document.createTextNode("삭제");
    button.appendChild(text);

    div.appendChild(button);
    addFiles.append(div);
    
    
    console.log(count);

})

addFiles.addEventListener("click",function(){
    if(event.target.classList[0] == 'del'){
        console.log("실행띠")
        console.log(event.target.innerHTML)
        console.log("this : ",event.target.title);
        alert("헤이~");
        
        const id1 = document.getElementById("file"+event.target.title);

        addFiles.removeChild(id1)
        // for(d of del){
        //     addFiles.removeChild(d);
        // }
    }
})


