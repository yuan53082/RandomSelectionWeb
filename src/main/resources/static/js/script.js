function random(e) {
  e.preventDefault(); // 防止表單送出
  var data = $("#input").val(); // 用data變數把input內容裝起來
  var jsonData = JSON.stringify(data); // 將data轉成JSON格式
  /*
   * trim()方法是 JavaScript 中的字串方法，用於移除字串頭尾的空格。
   * 使用trim()方法移除了字串頭尾的空格，樣使用可以避免因為空格或換行符號產生的誤判，增加程式穩定性.
   */
  if ($("#input").val().trim() === "") {
    alert("請輸入抽選名單");
    return;
  }

  $.ajax({
    url: "/random", // 要呼叫的api
    type: "POST", // 呼叫類型
    contentType: "application/json", // 前端傳到後端的資料格式
    data: $("#input").val(), // 前端傳到後端的資料內容
    dataType: "text", // 前端要接收後端回傳的資料格式
    /*
     * success函式是用來處理回傳的資料，這邊回傳的資料叫做data，故function後面會寫data。
     * 如果沒有指定參數名稱, 也可以使用預設的參數名稱如: function(response)
     */
    success: function (data) {
      // 當以上執行完畢後，執行的內容
      $("#output").val(data); // 將output內容設置為由後端回傳的名為data的資料
      alert("恭喜「" + data + "」是我們的天選之人！");
    },
  });
}

function copy(e) {
  e.preventDefault();
  var copyText = document.getElementById("output"); // 用一變數copyText裝output中的文字內容
  copyText.select(); // 選取到copyText這個變數
  document.execCommand("copy"); // document.execCommand('copy') 是一個 JavaScript 方法，它會觸發瀏覽器的剪貼簿功能。其中 'copy' 就是指複製的意思。
  alert("中獎名單：「" + copyText.value + "」 複製成功！"); // 顯示複製成功訊息
}

function clean(e) {
  e.preventDefault();
  $("#input").val("");
  $("#output").val("");
}

function star() {
  $("#myForm").submit(random); // myForm標籤中的submit點擊後要執行的function為random
  $("#copy").click(copy);
  $("#clean").click(clean);
}
$(document).ready(star); // 當網頁載入完成後載入star function
