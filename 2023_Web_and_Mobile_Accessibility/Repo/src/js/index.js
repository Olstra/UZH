function adjustFontSize() {
    var html = document.documentElement;
    var fontSize = parseFloat(localStorage.getItem('fontSize')) || parseFloat(window.getComputedStyle(html).fontSize);

    html.style.fontSize = fontSize + 'px';

    document.getElementById('font-increase-button').addEventListener('click', function() {
        fontSize += 1;
        html.style.fontSize = fontSize + 'px';
        localStorage.setItem('fontSize', fontSize);
    });

    document.getElementById('font-decrease-button').addEventListener('click', function() {
        fontSize -= 1;
        html.style.fontSize = fontSize + 'px';
        localStorage.setItem('fontSize', fontSize);
    });
}

adjustFontSize();