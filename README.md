# Basic Web Automation

Web Automation using Geb, Groovy, Cucumber, Gradle and Allure reports.

| Job        | Status                                                                                                                                                                                                                  | Report                                                                                                                                                                               |
|------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Smoke      | [![Smoke Tests](https://github.com/fifernandez/basic-web-automation/actions/workflows/smoke-tests.yml/badge.svg)](https://github.com/fifernandez/basic-web-automation/actions/workflows/smoke-tests.yml)                | [<img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" width="15" alt="Allure Report"/> Allure Report](https://fifernandez.github.io/basic-web-automation/smoke)      |
| Regression | [![Regression Tests](https://github.com/fifernandez/basic-web-automation/actions/workflows/regression-tests.yml/badge.svg)](https://github.com/fifernandez/basic-web-automation/actions/workflows/regression-tests.yml) | [<img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" width="15" alt="Allure Report"/> Allure Report](https://fifernandez.github.io/basic-web-automation/regression) |

To run the tests:
-
Option 1:

- Execute:  ./gradlew test
- Low console output, just the names of the scenarios and the result.

Option 2:

- Execute: ./gradlew cucumber
- Will display all the scenarios in the console output while running along the errors.

Option 3:

- Execute: ./gradlew runTests
- Will display all the scenarios in the console output while running along the errors.

Parameters:

- Browser:
    - You can choose the browser you want to use.
    - Add to command line: -Dbrowser=desired
    - Available: chrome, firefox, safari
    - Default: firefox

- Browser Option:
    - You can choose to run the browser in headless mode.
    - Add to command line: -Dbrowser.option=headless
    - If not added, browser will run normally.


- Tags:
    - You can choose which scenarios you want to run.
        - Add to command: -tags="desired"
        - Remember each scenario starts with @
        - You can use "and", "or", "not" operators and also "(" or ")".
        - Example: -Dtags="@2 and not @3"
        - A tag for the environment will be automatically added, so only scenarios that have the selected environment
          tag will run.
        - You can disable tests adding the tag @disable.