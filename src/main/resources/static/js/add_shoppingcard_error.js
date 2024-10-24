/**
 *
 * @author Zhang Yuyue
 *
 */
const buttons = document.querySelectorAll('.card .button'); // 只选择 "Add to cart" 按钮
buttons.forEach(button => {
    button.addEventListener('click', function (event) {
        showToast("Failed to add shopping cart");
    });
});

function showToast(message) {
    const toast = document.getElementById("toast");
    toast.textContent = message;
    toast.style.visibility = "visible";
    setTimeout(function () {
        toast.style.visibility = "hidden";
    }, 2000);
}
