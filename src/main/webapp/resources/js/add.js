const addFiles = document.getElementById("addFiles");   //div
const fileAdd = document.getElementById("fileAdd"); //버튼

let count =0;
fileAdd.addEventListener("click",function(){
    if(count < 5){
        count++;
    }else{
        alert("최대 다섯개까지 가능")
        return;
    }

    let tr = document.createElement("tr");
    // let div = document.createElement("div")
    // let th = document.createElement("th");
    let td = document.createElement("td")
    let input = document.createElement("input")
    // let file = document.createTextNode("FILE");
    let type= document.createAttribute("type")
    type.value="file";
    input.setAttributeNode(type);   //속성 넣기
    let name = document.createAttribute("name")
    name.value ="files"
    input.setAttributeNode(name);

    td.appendChild(input)
    // th.appendChild(td)
    // th.appendChild(file)    //text넣기
    // div.appendChild(th)
    tr.appendChild(td)

    addFiles.before(tr);
    
    
    console.log(count);

})


