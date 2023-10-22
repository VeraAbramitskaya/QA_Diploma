# *Отчет по итогам тестирования*

## ***Краткое описание***
В ходе работы было тестирование формы оплаты "Путешествие дня - Марракэш".
Приложение предлагает оплатить тур двумя способами:
- оплата по дебетовой карте
- выдача кредита с указанием банковской карты

## ***Были написаны:***
- Позитивные и негативные UI тесты
- Тесты для проверки записей в БД

## ***Количество тест-кейсов***
Всего: [38 тестов](https://prnt.sc/KFyjcbdWyi0q)
Успешных:  30 (78.94%) 
Неуспешных: 6 (___%)
Дефективных: [2 (___%)](https://prnt.sc/SuXtZrxW_UmB) 

## ***Критические ошибки***
- [Одобрена заявка с заблокированной карты](https://github.com/VeraAbramitskaya/QA_Diploma/issues/3)
- [Поле "Владелец" принимает не валидные значения](https://github.com/VeraAbramitskaya/QA_Diploma/issues/2)
- [При покупке в кредит "месяц" может принимать не валидное значение](https://github.com/VeraAbramitskaya/QA_Diploma/issues/1)
- [При вводе не валидных данных в поле "CVV" активной карты производится операция покупки](https://github.com/VeraAbramitskaya/QA_Diploma/issues/4)

## ***Общие рекомендации***
- Устранить найденные баги
- Провести повторное тестирование
- Составить техзадание на продукт с указанием требований к полям
- Добавить в код тестовые метки для ускорения поиска элементов страницы при автоматизации тестирования.