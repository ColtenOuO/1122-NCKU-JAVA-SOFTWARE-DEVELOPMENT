var editor1, editor2;

document.addEventListener('DOMContentLoaded', function() {

    // 更新時間函數
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

    // 初始化 CodeMirror 編輯器
    editor1 = CodeMirror.fromTextArea(document.getElementById('code1'), {
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
    editor2 = CodeMirror.fromTextArea(document.getElementById('code2'), {
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

    editor1.on('change', function() {
        updateContent();
    });

    // 為按鈕添加事件監聽器
    var buttons = document.querySelectorAll('.button');
    buttons.forEach(function(button) {
        button.addEventListener('click', function() {
            var display = document.querySelector('.topic-choose');
            display.textContent = this.getAttribute('data-message');
            button.classList.add('hide');  // 添加 'hide' 類來平滑地隱藏按鈕
        });
    });
});

function getText() {
    var content = editor1.getValue(); // 使用 CodeMirror 的 getValue 方法
    alert(content);
}