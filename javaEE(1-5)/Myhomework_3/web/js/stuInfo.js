
// function onChange(obj) {

// var val = obj.value;
//
// if (val == 'stuName') {
//     var sec = document.getElementById('operate');
//     sec.innerHTML = "<option>包含</option><option>等于</option>";
//
// } else {
//     var sec = document.getElementById('operate');
//     sec.innerHTML = "<option>大于</option><option>大于等于</option>" +
//         "<option>小于</option><option>小于等于</option>";
// }

// }


function onChange() {

    var type = document.getElementById("attribute");
    var index = type.selectedIndex;

    //选中数值
    var value = type.options[index].value;

    var operate = document.getElementById("operate");

    if(value == "姓名" || value == '学号') {
        operate.options.length = 0;
        operate[0] = new Option("包含");
        operate[1] = new Option("等于");
    }
    else {
        operate.options.length = 0;
        operate[0] = new Option("大于");
        operate[1] = new Option("大于等于");
        operate[2] = new Option("小于");
        operate[3] = new Option("小于等于");
    }
}



