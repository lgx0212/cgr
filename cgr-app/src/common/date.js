// date.js
export function formatDate (date, fmt) {
  if (/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
  }
  let o = {
    'M+': date.getMonth() + 1,
    'd+': date.getDate(),
    'h+': date.getHours(),
    'm+': date.getMinutes(),
    's+': date.getSeconds()
  };
  for (let k in o) {
    if (new RegExp(`(${k})`).test(fmt)) {
      let str = o[k] + '';
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : padLeftZero(str));
    }
  }
  return fmt;
};

function padLeftZero (str) {
  return ('00' + str).substr(str.length);
};

export function NowDate() {
  var padaDate = function(value) {
    return value < 10 ? "0" + value : value;
  };
  //创建一个时间日期对象
  var date = new Date();
  var year = date.getFullYear(); //存储年
  var month = padaDate(date.getMonth() + 1); //存储月份
  var day = padaDate(date.getDate()); //存储日期
  var hours = padaDate(date.getHours()); //存储时
  var minutes = padaDate(date.getMinutes()); //存储分
  var seconds = padaDate(date.getSeconds()); //存储秒
  //返回格式化后的日期
  var value =
    year +
    "-" +
    month +
    "-" +
    day +
    " " +
    hours +
    ":" +
    minutes +
    ":" +
    seconds
  return value
}
