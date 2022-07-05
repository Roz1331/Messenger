


function sendMes(userName) {
    console.log("start sending message");
    let messageText = $("#message").val();
    if (messageText === "") return;
    $.get('/message/send', { userName: userName, message: messageText})
    .success(function() { console.log('Успешное выполнение'); })
}

// function getMessages(userName) {
//     console.log("start getting messages for " + userName)
//     $.get('/message/get', { userName: userName}, () => {
//         console.log("messages were received");
//     })
// }
//
// setTimeout(getMessages, 1000, [[${userName}]]);


// http://www.jetsource.ru/scripts/javascript_jquery/otpravka_post_i_get_zaprosov

