document.addEventListener('DOMContentLoaded', function() {
    const carouselInner = document.querySelector('.carousel-inner');
    const carouselImages = document.querySelectorAll('.carousel-inner img');
    const prevButton = document.querySelector('.carousel-prev');
    const nextButton = document.querySelector('.carousel-next');
    let index = 0;
    const imageWidth = carouselImages[0].clientWidth + parseInt(window.getComputedStyle(carouselImages[0]).marginRight);

    function showImage(idx) {
        const offset = -idx * imageWidth;
        carouselInner.style.transform = `translateX(${offset}px)`;
    }

    prevButton.addEventListener('click', function() {
        index = (index > 0) ? index - 1 : carouselImages.length - 1;
        showImage(index);
    });

    nextButton.addEventListener('click', function() {
        index = (index < carouselImages.length - 1) ? index + 1 : 0;
        showImage(index);
    });
});
