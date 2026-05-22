# CheckList тестового покрытия

| ID | Раздел | Проверка | Приоритет | Автоматизация |
|---|---|---|---|---|
| CL-01 | Главная | Отображается основной hero-заголовок AI-поиска работы | High | `homePageShowsAiJobSearchHero` |
| CL-02 | Главная | В навигации доступен раздел Find jobs | High | `homeNavigationContainsFindJobs` |
| CL-03 | Главная | В навигации доступен раздел Companies | High | `homeNavigationContainsCompanies` |
| CL-04 | Главная | В навигации доступен раздел Network | Medium | `homeNavigationContainsNetwork` |
| CL-05 | Главная | В навигации доступен раздел Insights | Medium | `homeNavigationContainsInsights` |
| CL-06 | Главная | В навигации доступен раздел Search | High | `homeNavigationContainsSearch` |
| CL-07 | Главная | В навигации доступно действие Log in | High | `homeNavigationContainsLogin` |
| CL-08 | Главная | Доступны controls предпочтений: career level, workplace, salary, save | High | `homeShowsPreferenceControls` |
| CL-09 | Главная | AI search entry ведет на поиск вакансий | High | `homeAiSearchEntryLinksToJobsSearch` |
| CL-10 | Главная | Отображается блок популярных работодателей | Medium | `homeShowsPopularEmployersBlock` |
| CL-11 | Поиск вакансий | Открывается заголовок All available jobs | High | `jobsSearchPageShowsAllAvailableJobsHeading` |
| CL-12 | Поиск вакансий | Доступно поле Location | High | `jobsSearchPageHasLocationInput` |
| CL-13 | Поиск вакансий | Отображается фильтр Workplace | High | `jobsSearchPageShowsWorkplaceFilter` |
| CL-14 | Поиск вакансий | Отображается фильтр Employment type | High | `jobsSearchPageShowsEmploymentTypeFilter` |
| CL-15 | Поиск вакансий | Отображается фильтр Career level | High | `jobsSearchPageShowsCareerLevelFilter` |
| CL-16 | Поиск вакансий | Отображается фильтр Salary | High | `jobsSearchPageShowsSalaryFilter` |
| CL-17 | Поиск вакансий | В выдаче есть не менее 5 карточек вакансий | High | `jobsSearchPageListsMultipleJobCards` |
| CL-18 | Поиск вакансий | В выдаче есть не менее 5 действий Save job | High | `jobsSearchPageShowsSaveJobActions` |
| CL-19 | Компании | Отображается раздел Top companies hiring now | High | `companiesPageShowsTopCompaniesSection` |
| CL-20 | Компании | Отображается раздел Companies by industry | Medium | `companiesPageShowsCompaniesByIndustrySection` |
| CL-21 | Компании | В каталоге есть не менее 8 заголовков компаний | Medium | `companiesPageListsCompanyHeadings` |
| CL-22 | Компании | В каталоге есть не менее 5 ссылок View ... jobs | Medium | `companiesPageListsCompanyJobLinks` |
| CL-23 | Компании | Первая ссылка View ... jobs ведет в раздел вакансий компании | Medium | `firstCompanyJobLinkPointsToCompanyJobs` |
| CL-24 | Network | Гость видит приглашение Join XING now | High | `networkPageShowsJoinPrompt` |
| CL-25 | Network | Register now ведет на `login.xing.com` | High | `networkRegisterLinkPointsToLoginXing` |
| CL-26 | Network | На странице доступна ссылка Log in | Medium | `networkPageShowsLoginLink` |
| CL-27 | Регистрация | Отображается заголовок формы регистрации | High | `signupPageShowsHeading` |
| CL-28 | Регистрация | Доступны варианты Continue with Google и Continue with Apple | Medium | `signupShowsGoogleAndAppleOptions` |
| CL-29 | Регистрация | Есть поля First name и Last name | High | `signupHasFirstAndLastNameFields` |
| CL-30 | Регистрация | Есть поля E-mail и Password | High | `signupHasEmailAndPasswordFields` |
| CL-31 | Регистрация | Пустое поле First name не проходит HTML5-валидацию | High | `signupEmptyFormMarksFirstNameInvalid` |
| CL-32 | Регистрация | Пустое поле E-mail не проходит HTML5-валидацию | High | `signupEmptyFormMarksEmailInvalid` |
| CL-33 | Регистрация | Доступны ссылки GTC и Privacy Policy | Medium | `signupTermsAndPrivacyLinksPresent` |
| CL-34 | Insights | Отображается категория Recommended | Medium | `insightsShowsRecommendedCategory` |
| CL-35 | Insights | Отображается категория Salary | Medium | `insightsShowsSalaryCategory` |
| CL-36 | Insights | Отображается категория Job search | Medium | `insightsShowsJobSearchCategory` |
| CL-37 | Insights | Есть не менее 5 ссылок на материалы | Medium | `insightsListsArticleLinks` |
| CL-38 | Работодатель | Страница создания объявления показывает XING Job Ads и Quick & easy | High | `jobAdCreationPageShowsHeading` |
| CL-39 | Работодатель | В форме создания объявления есть поля Job Title и Company | High | `jobAdCreationPageHasJobTitleAndCompanyInputs` |
| CL-40 | Работодатель | В форме создания объявления доступна кнопка Preview your ad | High | `jobAdCreationPageHasPreviewButton` |

Покрытие построено по публичным use-case, которые не требуют реального аккаунта и не изменяют данные на сайте. Все проверки используют XPath-локаторы.
