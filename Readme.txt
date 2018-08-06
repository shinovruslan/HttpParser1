Проект для IDEA. Необходима установленная JAVA 1.6 и выше

Структура:
1. Main - точка входа
2. BusObj - описание сущностей(товаров) c ru.investment.com
3. HttpUtils - все для запросов к серверу
4. DbUtils - все для работы с бд
5. XmlConfig - чтение настроек из xml файла

Инструкция по установке:
1. Соберите jar файл
2. Выполните создание таблицы create_table.sql
3. Отредактируйте configXML.xml и положите его в папку с jar файлом
    <entry key="proxyHost">178.128.217.141</entry> - Здесь указываем хост своего прокси сервера(В качестве примера вставлен первый попавшийся из интернета)
    <entry key="proxyPort">3128</entry> - Здесь указываем порт прокси
    <entry key="proxyUser">User</entry> - Юзер прокси
    <entry key="proxyPassword">Password</entry> - Пароль
    <entry key="jdbcHost">jdbc:oracle:thin:@localhost:1521:ORCL</entry> - jdbc строка подключения к бд(стандартный oracle на локальной машине)
    <entry key="jdbcUser">SCOTT</entry> - пользователь, под которым выполняли create_table.sql
    <entry key="jdbcPassword">TIGER</entry> - пароль
4. Выполните первоначальный запуск, например из коммандной строки:
    java -jar HttpParser.jar 1
5. Для установки в качестве служьы Windows используйте bat файл с содержимым
    java -jar HttpParser.jar
    без каких либо параметров
