# Лабораторная работа 3, вариант 48122

Объект тестирования: XING.com, `https://www.xing.com/`.

Состав:

- [Отчет_ЛР3_48122_XING.md](./Отчет_ЛР3_48122_XING.md) — основной отчет по ТЗ.
- [docs/use_case_diagram.dot](./docs/use_case_diagram.dot) — исходник UseCase-диаграммы.
- [docs/checklist.md](./docs/checklist.md) — чек-лист тестового покрытия.
- [docs/test_scenarios.md](./docs/test_scenarios.md) — набор тестовых сценариев.
- [selenium-ide/xing_variant_48122.side](./selenium-ide/xing_variant_48122.side) — шаблон Selenium IDE.
- [src/test/java/ru/tpo/lr3/XingPublicTest.java](./src/test/java/ru/tpo/lr3/XingPublicTest.java) — 40 автоматизированных Selenium-тестов на Java.

## Запуск Java/Selenium-тестов

```bash
./gradlew test -Pbrowser=chrome
```

Для Firefox:

```bash
./gradlew test -Pbrowser=firefox
```

По умолчанию тесты запускаются headless. Для видимого окна добавьте:

```bash
./gradlew test -Pbrowser=chrome -Pheaded=true
```

Старое требование про Selenium RC в современных версиях Selenium фактически заменено WebDriver/Selenium Server. Поэтому сценарии оформлены как Selenium IDE `.side` и продублированы в WebDriver-тестах, которые запускаются в Chrome/Firefox.
