window.onload = function() {
    const widgets = document.querySelectorAll('.rotating-widget');
    widgets.forEach(function(widget) {
        // 获取视口宽度和高度
        const viewportWidth = window.innerWidth;
        const viewportHeight = window.innerHeight;

        // 随机设置控件的位置
        const left = Math.floor(Math.random() * (viewportWidth - widget.offsetWidth));
        const top = Math.floor(Math.random() * (viewportHeight - widget.offsetHeight));

        // 应用随机位置
        widget.style.position = 'absolute';
        widget.style.left = left + 'px';
        widget.style.top = top + 'px';
    });
};
