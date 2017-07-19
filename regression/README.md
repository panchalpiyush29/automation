# automation
How to run tests
1) Open Cucumber Runner
2) Set VM options = -Dselenide.browser=chrome -Dwebdriver.chrome.driver=/<path to chrome driver>/chromedriver
e.g. 
`-Dselenide.browser=chrome -Dwebdriver.chrome.driver=/Users/nicktran/chromedriver`
3) Set `-Dsaucelabs.enabled=true` in order to activate saucelabs.
4) Swagger API Documentation: http://localhost:8089/swagger-ui.html