# automation
How to run tests
1) Open Cucumber Runner
2) Set VM options = -Dselenide.browser=chrome -Dwebdriver.chrome.driver=/<path to chrome driver>/chromedriver

e.g. `-Dselenide.browser=chrome -Dwebdriver.chrome.driver=/Users/nicktran/chromedriver`
3) Set `-Dsaucelabs.enabled=true` in order to activate saucelabs.
4) Swagger API Documentation: http://localhost:8089/swagger-ui.html
5) Run cucumber test on mvn

`mvn -Dit.test=CucumberRunner -Dcucumber.options="--tags @google" -Dselenide.browser=chrome -Dwebdriver.chrome.driver=/Users/nicktran/chromedriver verify`

or with saucelab 

`mvn -Dit.test=CucumberRunner -Dcucumber.options="--tags @google" -Dsaucelabs.enabled=true verify`