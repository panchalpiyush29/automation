# Automation
How to run tests
1) Select Cucumber Runner (under Edit configuration)
2) Set VM options = -Dspring.profiles.active=local -Dselenide.browser=chrome

e.g. `-Dspring.profiles.active=local -Dselenide.browser=firefox`
3) Set `-Dsaucelabs.enabled=true` in order to activate saucelabs.
4) Swagger API Documentation: http://localhost:8089/swagger-ui.html
5) Run cucumber test on mvn

`mvn -Dit.test=CucumberRunner -Dcucumber.options="--tags @google" -Dspring.profiles.active=local -Dselenide.browser=chrome verify`

or with saucelab

`mvn -Dit.test=CucumberRunner -Dcucumber.options="--tags @google" -Dsaucelabs.enabled=true verify`

Mobile
1) mobile (for android) and mobileIOS (for iOS) are two different modules for mobile automation
2) android .apk file is embedded in the mobile project (under resources), To run the test create a android phone simulator 
   via Android Studio copy down the name of the simulator and replace the same in AppiumConfigurator (field = deviceName)
3) To run the test on iOS is a little different so under the resource (app)folder there is a zip file copy and paste on your system (and unzip)
   On AppiumConfigurator file modify udid, deviceName, app (specifying the path of the downloaded file) 
  