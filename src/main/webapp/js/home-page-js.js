$(document).ready(function() {
    $('.subpage-btn').click(function(e) {
        e.preventDefault(); // 阻止默认的链接跳转行为
        const url = $(this).data('url');
        $('#subpage-content').load(url);

        // 移除所有按钮上的active类
        $('.subpage-btn').removeClass('active');
        // 为被点击的按钮添加active类
        $(this).addClass('active');
    });

    $('#toggle-sidebar').click(function() {
        $('#sidebar').toggleClass('collapsed');
        $('#content').toggleClass('expanded');
        $(this).toggleClass('rotated'); // 添加一个类来旋转图标
    });

});
