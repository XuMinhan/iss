/**
 *
 * @author Zhang Yuyue
 *
 */
const images = [
    '../image/spc1.jpg',
    '../image/spc2.jpg',
    '../image/spc3.jpg',
    '../image/spc4.jpg',
];

let currentIndex = 0;
const intervalTime = 3000;
const fadeOutDuration = 500; // 渐变时间
const imageElement = document.getElementById('cart-image');

setInterval(() => {
    // 添加渐隐效果
    imageElement.classList.remove('fade-in');
    imageElement.classList.add('fade-out');

    setTimeout(() => {
        // 切换图片
        currentIndex = (currentIndex + 1) % images.length;
        imageElement.src = images[currentIndex];

        // 等图片加载完后再渐显
        imageElement.onload = function() {
            imageElement.classList.remove('fade-out');
            imageElement.classList.add('fade-in');
        };

    }, fadeOutDuration); // 在图片完全渐隐后再切换
}, intervalTime);
