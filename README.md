# Messenger

Приложение представляет собой несложный мессенджер.

Используемые технологии:
- Maven
- Spring
- Hibernate
- PostgreSQL
- ActiveMQ
- Thymeleaf
- jQuery

В начале пользователю будет предложено зарегистрироваться
Данные о зарегестрированном пользователе записываются в БД, пароль шифруется с помощью BCryptPasswordEncoder 
Каждый пользователь является представителем одной из ролей: обычный пользователь или администратор.
Администратор может быть создан только вручную. Через регистрацию мессенджера создается только обычный пользователь (нельзя зарегестрировать себя как администратора)

У пользователя есть возможность выйти, просмотреть новости или присоединиться к чату.
![image](https://user-images.githubusercontent.com/45918469/179863139-7e894654-fdb8-454d-b3df-63cba893d91f.png)

Администратор может просмотреть данные по всем пользователям. Данные берутся из бд с помощью: userRepository.findAll()

Для обмена испольуется брокер сообщений ActiveMQ. С помощью ActiveMQConnectionFactory по адресу tcp://127.0.0.1:61616 устанавлиается соединение, через которое проходят все сообщения.
Для двух пользователей использование мессенджера выглядит следующим образом:

![image](https://user-images.githubusercontent.com/45918469/179863599-0ef3bf50-27e1-4d7a-b5e0-76a79eccf013.png)


