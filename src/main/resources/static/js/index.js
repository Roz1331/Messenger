
$(document).ready(function () {

    $("#sendMessage").click(function () {

        let messageText = $("#message").val();
        console.log("start sending message: " + messageText);
        if (messageText === "") return; // if message is empty
        $.get('/message/send', { userName: userName, message: messageText}, function(data) {
            console.log("message was sent");
            $("#message").val("")
        })
    })

    setInterval(function () {
        // let userName = [[${userName}]];
        console.log("start getting messages for " + userName)
        $.get('/message/get', { userName: userName}, function(data) {
            data.forEach(function(element) {
                console.log(element)
                let messageSplit = element.split(separator)
                let sender = messageSplit[0]
                let textMessage = messageSplit.slice(1, messageSplit.length).join(separator)

                let newMessage = document.createElement("p")
                if (sender === userName) {
                    newMessage.setAttribute("class", "right")
                }
                else {
                    textMessage = sender + ": " + textMessage
                    newMessage.setAttribute("class", "left")
                }

                let text = document.createTextNode(textMessage)
                newMessage.appendChild(text)
                let messagesList = document.getElementById("messages")
                messagesList.appendChild(newMessage)
            })
        })
            .fail(function (data) {
                console.log("failed((((((((((");
                console.log(data);
            })
    }, 1000);
});
// http://www.jetsource.ru/scripts/javascript_jquery/otpravka_post_i_get_zaprosov

