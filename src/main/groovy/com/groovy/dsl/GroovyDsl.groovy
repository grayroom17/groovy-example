package com.groovy.dsl


import static com.groovy.dsl.MailBuilder.mail

mail {
    from "ivanov@gmail.com"
    to "petrov@gmail.com"
    title "Test email"
    body {
        text "Some text"
        image "image.jpg"
        images(["1.png", "2.jpg", "3.jpeg"])
    }
}

