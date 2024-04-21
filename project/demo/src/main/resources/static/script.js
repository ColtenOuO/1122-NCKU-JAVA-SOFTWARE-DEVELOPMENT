function updateTime() {
    var now = new Date();
    var hours = now.getHours();
    var minutes = now.getMinutes();
    var seconds = now.getSeconds();
    minutes = minutes < 10 ? '0' + minutes : minutes;
    seconds = seconds < 10 ? '0' + seconds : seconds;
    document.getElementById('time').innerText = hours + ':' + minutes + ':' + seconds;
}

setInterval(updateTime, 1000);
updateTime();

// 時間更新功能
function updateTime() {
    var now = new Date();
    var hours = now.getHours();
    var minutes = now.getMinutes();
    var seconds = now.getSeconds();
    minutes = minutes < 10 ? '0' + minutes : minutes;
    seconds = seconds < 10 ? '0' + seconds : seconds;
    document.getElementById('time').innerText = hours + ':' + minutes + ':' + seconds;
}
setInterval(updateTime, 1000);
updateTime();

// 確保文檔已載入
document.addEventListener('DOMContentLoaded', function() {
    var editor1 = CodeMirror.fromTextArea(document.getElementById('code1'), {
        mode: "text/x-c++src",
        lineNumbers: true,
        autoCloseBrackets: true,
        matchBrackets: true,
        continueComments: "Enter",
        extraKeys: {"Ctrl-Q": "toggleComment"},
        lineWrapping: true,
        styleActiveLine: true,
        theme: 'default'
    });
    var editor2 = CodeMirror.fromTextArea(document.getElementById('code2'), {
        mode: "text/x-c++src",
        lineNumbers: true,
        autoCloseBrackets: true,
        matchBrackets: true,
        continueComments: "Enter",
        extraKeys: {"Ctrl-Q": "toggleComment"},
        lineWrapping: true,
        styleActiveLine: true,
        theme: 'default'
    });
    var buttons = document.querySelectorAll('.button');
    buttons.forEach(function(button) {
        button.addEventListener('click', function() {
            button.classList.add('hide');  // 添加 'hide' 類來平滑地隱藏按鈕
        });
    });
});

// 獲取所有按鈕和顯示訊息的段落元素
const buttons = document.querySelectorAll('.button');
const display = document.querySelector('.topic-choose');

// 為每個按鈕添加點擊事件監聽器
buttons.forEach(button => {
  button.addEventListener('click', function() {
    // 更新段落的文本為當前按鈕的 data-message 屬性值
    display.textContent = this.getAttribute('data-message');
  });
});