function getchatbox() {
    const gif = document.getElementById('gif');
    const chatbox = document.getElementById('chatterbox');

    $(document).ready(function () {
        $(gif).click(function () {
            $(chatbox).toggle();
        });
    });
}