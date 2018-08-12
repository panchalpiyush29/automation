Run test on firefox browser from command line :

mvn clean verify -Dwebdriver.gecko.driver=/Users/piyushpanchal/geckodriver

Note: For executing test on different browser's just change the path pointing to the correct browser file

Run multiple threads

mvn clean verify -Dthreads=2 -Dwebdriver.gecko.driver=/Users/piyushpanchal/chromedriver4