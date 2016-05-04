$(document).ready(function() {
    var e = ($.cookie("pm[remember]"), $.cookie("pm[email]"));
    void 0 != e && "null" != e ? ($("#user-name").val($.cookie("pm[email]")), $("#user-password").val($.cookie("pm[pass]")), $("#stying").prop("checked", !0)) : $("#stying").prop("checked", !1)
});