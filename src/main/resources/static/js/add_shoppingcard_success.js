/**
 *
 * @author Zhang Yuyue
 *
 */
window.onload = function () {
    showToast("Item added to cart!"); // 页面加载时自动触发
};

function showToast(message) {
    const toast = document.getElementById("toast");
    toast.textContent = message;
    toast.style.visibility = "visible";
    setTimeout(function () {
        toast.style.visibility = "hidden";
    }, 2000); // 显示消息2秒后隐藏
}
