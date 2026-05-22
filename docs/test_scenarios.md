# Описание набора тестовых сценариев

| ID | UseCase | Предусловия | Шаги | Ожидаемый результат | Автотест |
|---|---|---|---|---|---|
| TC-01 | Просмотр главной | Гость | Открыть `/`; проверить hero | Отображается AI job search hero | `homePageShowsAiJobSearchHero` |
| TC-02 | Навигация | Гость | Открыть `/`; проверить Find jobs | Пункт Find jobs доступен | `homeNavigationContainsFindJobs` |
| TC-03 | Навигация | Гость | Открыть `/`; проверить Companies | Пункт Companies доступен | `homeNavigationContainsCompanies` |
| TC-04 | Навигация | Гость | Открыть `/`; проверить Network | Пункт Network доступен | `homeNavigationContainsNetwork` |
| TC-05 | Навигация | Гость | Открыть `/`; проверить Insights | Пункт Insights доступен | `homeNavigationContainsInsights` |
| TC-06 | Навигация | Гость | Открыть `/`; проверить Search | Пункт Search доступен | `homeNavigationContainsSearch` |
| TC-07 | Навигация | Гость | Открыть `/`; проверить Log in | Действие Log in доступно | `homeNavigationContainsLogin` |
| TC-08 | Предпочтения вакансий | Гость | Открыть `/`; проверить controls предпочтений | Controls career/workplace/salary/save отображаются | `homeShowsPreferenceControls` |
| TC-09 | Поиск вакансий | Гость | Открыть `/`; проверить href AI search | Ссылка ведет на `/jobs/search/ki` | `homeAiSearchEntryLinksToJobsSearch` |
| TC-10 | Работодатели | Гость | Открыть `/`; проверить блок работодателей | Блок популярных работодателей виден | `homeShowsPopularEmployersBlock` |
| TC-11 | Поиск вакансий | Гость | Открыть `/jobs/search/ki`; проверить заголовок | Заголовок All available jobs виден | `jobsSearchPageShowsAllAvailableJobsHeading` |
| TC-12 | Поиск вакансий | Гость | Открыть `/jobs/search/ki`; проверить Location | Поле Location видно | `jobsSearchPageHasLocationInput` |
| TC-13 | Фильтрация | Гость | Открыть `/jobs/search/ki`; проверить Workplace | Фильтр Workplace есть на странице | `jobsSearchPageShowsWorkplaceFilter` |
| TC-14 | Фильтрация | Гость | Открыть `/jobs/search/ki`; проверить Employment type | Фильтр Employment type есть на странице | `jobsSearchPageShowsEmploymentTypeFilter` |
| TC-15 | Фильтрация | Гость | Открыть `/jobs/search/ki`; проверить Career level | Фильтр Career level есть на странице | `jobsSearchPageShowsCareerLevelFilter` |
| TC-16 | Фильтрация | Гость | Открыть `/jobs/search/ki`; проверить Salary | Фильтр Salary есть на странице | `jobsSearchPageShowsSalaryFilter` |
| TC-17 | Поиск вакансий | Гость | Открыть `/jobs/search/ki`; посчитать карточки | Найдено не менее 5 карточек вакансий | `jobsSearchPageListsMultipleJobCards` |
| TC-18 | Сохранение вакансий | Гость | Открыть `/jobs/search/ki`; посчитать Save job | Найдено не менее 5 действий Save job | `jobsSearchPageShowsSaveJobActions` |
| TC-19 | Каталог компаний | Гость | Открыть `/companies`; проверить Top companies | Раздел Top companies hiring now виден | `companiesPageShowsTopCompaniesSection` |
| TC-20 | Каталог компаний | Гость | Открыть `/companies`; проверить industries | Раздел Companies by industry виден | `companiesPageShowsCompaniesByIndustrySection` |
| TC-21 | Каталог компаний | Гость | Открыть `/companies`; посчитать заголовки компаний | Найдено не менее 8 заголовков компаний | `companiesPageListsCompanyHeadings` |
| TC-22 | Каталог компаний | Гость | Открыть `/companies`; посчитать View ... jobs | Найдено не менее 5 ссылок вакансий | `companiesPageListsCompanyJobLinks` |
| TC-23 | Каталог компаний | Гость | Открыть `/companies`; проверить href первой View ... jobs | Ссылка ведет в `/jobs` | `firstCompanyJobLinkPointsToCompanyJobs` |
| TC-24 | Network | Гость | Открыть `/network`; проверить приглашение | Текст Join XING now виден | `networkPageShowsJoinPrompt` |
| TC-25 | Network | Гость | Открыть `/network`; проверить Register now | Ссылка ведет на `login.xing.com` | `networkRegisterLinkPointsToLoginXing` |
| TC-26 | Network | Гость | Открыть `/network`; проверить Log in | Ссылка Log in видна | `networkPageShowsLoginLink` |
| TC-27 | Регистрация | Гость | Открыть `/start/signup`; проверить заголовок | Заголовок регистрации виден | `signupPageShowsHeading` |
| TC-28 | Регистрация | Гость | Открыть `/start/signup`; проверить OAuth buttons | Google и Apple варианты видны | `signupShowsGoogleAndAppleOptions` |
| TC-29 | Регистрация | Гость | Открыть `/start/signup`; проверить name fields | First name и Last name видны | `signupHasFirstAndLastNameFields` |
| TC-30 | Регистрация | Гость | Открыть `/start/signup`; проверить email/password | E-mail и Password видны | `signupHasEmailAndPasswordFields` |
| TC-31 | Регистрация | Гость | Открыть `/start/signup`; нажать Next без данных | First name невалиден | `signupEmptyFormMarksFirstNameInvalid` |
| TC-32 | Регистрация | Гость | Открыть `/start/signup`; нажать Next без данных | E-mail невалиден | `signupEmptyFormMarksEmailInvalid` |
| TC-33 | Регистрация | Гость | Открыть `/start/signup`; проверить правовые ссылки | GTC и Privacy Policy видны | `signupTermsAndPrivacyLinksPresent` |
| TC-34 | Insights | Гость | Открыть `/insights`; проверить Recommended | Категория Recommended видна | `insightsShowsRecommendedCategory` |
| TC-35 | Insights | Гость | Открыть `/insights`; проверить Salary | Категория Salary видна | `insightsShowsSalaryCategory` |
| TC-36 | Insights | Гость | Открыть `/insights`; проверить Job search | Категория Job search видна | `insightsShowsJobSearchCategory` |
| TC-37 | Insights | Гость | Открыть `/insights`; посчитать ссылки статей | Есть не менее 5 материалов | `insightsListsArticleLinks` |
| TC-38 | Создание объявления | Работодатель | Открыть `/recruiting/jobs/create`; проверить заголовки | XING Job Ads и Quick & easy видны | `jobAdCreationPageShowsHeading` |
| TC-39 | Создание объявления | Работодатель | Открыть `/recruiting/jobs/create`; проверить поля | Job Title и Company видны | `jobAdCreationPageHasJobTitleAndCompanyInputs` |
| TC-40 | Создание объявления | Работодатель | Открыть `/recruiting/jobs/create`; проверить кнопку | Preview your ad доступна | `jobAdCreationPageHasPreviewButton` |

Все локаторы в автоматизации заданы через XPath. Привязка к `id` элементов не используется.
