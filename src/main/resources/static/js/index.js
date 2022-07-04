


function sendMes(userName) {
    console.log("start sending message");
    let messageText = $("#message").val();
    $.get('/message/send', { userName: userName, message: messageText}, () => {
        console.log("message was sent");
    })
}


// http://www.jetsource.ru/scripts/javascript_jquery/otpravka_post_i_get_zaprosov

