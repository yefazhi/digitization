// 维护web端cookie key值枚举列表
var CookieKeyEnum= {
    USER_IP: "user_ip",   // 后台管理菜单
    USER_CITY: "user_city"    // 前台header菜单
}

$("#seo-elem").load("/to/seo/seo");

// 置顶
// 获取置顶对象
var obj = document.getElementById('top-event');
var scrollTop = null;

// 置顶对象点击事件
obj.onclick = function() {
    var timer = setInterval(function() {
        window.scrollBy(0, -100);
        if (scrollTop == 0)
            clearInterval(timer);
    }, 2);
}

// 窗口滚动检测
window.onscroll = function() {
    scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
    obj.style.display = (scrollTop >= 300) ? "block" : "none";
}

layui.use('element', function(){
    var $ = layui.jquery
        ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
});

// 提取地址栏参数
function GetUrlParamByName(key) {
    // 获取参数
    var url = window.location.search;
    // 正则筛选地址栏
    var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)");
    // 匹配目标参数
    var result = url.substr(1).match(reg);
    //返回参数值
    return result ? decodeURIComponent(result[2]) : "";
}

$(window).scroll(function () {
    var scrollHeight = $(document).height();
    var scrollTop = $(window).scrollTop();
    var $windowHeight = $(window).innerHeight();
    scrollTop > 50 ? $("#scrollUp").fadeIn(200).css("display","block") : $("#scrollUp").fadeOut(200);
    $bottomTools.css("bottom", scrollHeight - scrollTop > $windowHeight ? 40 : $windowHeight + scrollTop + 40 - scrollHeight);
});

$('#scrollUp').click(function (e) {
    alert(1);
    e.preventDefault();
    $('html,body').animate({ scrollTop:0});
});

// 获取【n,m】区间的随机正整数
function getRandom(n, m){
    var random = Math.floor(Math.random()*(m-n+1)+n);
    return random;
}



//------------- my web cookie deal method define start ------------- //
function setCookieSetDate(key, value, n) {
    var oDate = new Date();
    oDate.setDate(oDate.getDate() + 1); // 默认web端cookie生命周期为1小时
    document.cookie = key + '=' + value + ';expires=' + oDate;
}
function setCookieDafaultOneDate(key, value) {
    setCookieSetDate(key, value, 1);
}
function removeCookie(key) {
    setCookieSetDate(key, '', -1);//这里只需要把Cookie保质期退回一天便可以删除
}
function getCookie(key) {
    var cookieString = document.cookie == "" ? window.parent.document.cookie : document.cookie;
    var cookieArr = cookieString.split(';');
    for(var i = 0; i < cookieArr.length; i++) {
        var arr = cookieArr[i].split('=');
        if(arr[0] == key) {
            return arr[1];
        }
    }
    return false;
}
//------------- my web cookie deal method define end ------------- //


// ---------------  网站放置到桌面  ----------------//
function toDesktop(sUrl, sName) {
    alert("你的浏览器可能不支持创建桌面快捷方式");
    return;
    try {
        var WshShell = new ActiveXObject("WScript.Shell");
        var oUrlLink = WshShell.CreateShortcut(WshShell
                .SpecialFolders("Desktop")
            + "\\" + sName + ".url");
        oUrlLink.TargetPath = sUrl;
        oUrlLink.Save();
        layer.msg("成功创建桌面快捷方式! 感谢您的支持");
    } catch (e) {
        layer.msg("当前IE安全级别不允许操作或您的浏览器不支持此功能！<br/>可以先收藏，以免后面找不到[这里露出尴尬的表情]",{time:8*1000});
    }
}