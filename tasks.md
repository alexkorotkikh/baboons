# Задача 1
 
Дан текст, состоящий из нескольких строк произвольной длины. Нужно разбить его на абзацы и юстифицировать, то есть оформить в виде текста шириной в N (20 - 120) символов, выровняв по правой и по левой границе. Ширину строки следует увеличивать за счет добавления пробелов — по одному, начиная с правого края. Окончанием абзаца считается строка, которая заканчивается на соответствующие знаки пунктуации. Новые абзацы должны начинаться с красной строки в четыре пробела. Абзац из одной строки длиной менее половины N — это заголовок, его юстифицировать не нужно.
 
Плюсом будет, если ваша программа будет способна обрабатывать не только ASCII тексты, но и тексты в кодировке UTF-8.
 
## Пример
 
Входной текст:
 
Lorem ipsum
 
Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco 
laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse 
cillum dolore eu fugiat nulla pariatur. 
Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
 
 
Выходной текст:
 

    Lorem ipsum
    
    Lorem ipsum dolor sit amet, consectetur adipisicing  elit,  sed  do  eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut  enim  ad  minim  veniam,
quis nostrud  exercitation  ullamco  laboris  nisi  ut  aliquip  ex  ea  commodo
consequat. Duis aute irure  dolor  in  reprehenderit  in  voluptate  velit  esse
cillum dolore eu fugiat nulla pariatur.
    Excepteur sint occaecat cupidatat non proident, sunt in  culpa  qui  officia
deserunt mollit anim id est laborum.

