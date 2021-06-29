C:\work\practice\java\ws\001-TDD>git init .
C:\work\practice\java\ws\001-TDD>git add .
C:\work\practice\java\ws\001-TDD>git config --global user.email "amsalways@gmail.com"
C:\work\practice\java\ws\001-TDD>git config --global user.name "Ameya Joshi"
C:\work\practice\java\ws\001-TDD>git commit -m "commiting the code"
create a remote repo by logging to github repo-name : 001-TDD
C:\work\practice\java\ws\001-TDD>git remote add origin https://github.com/amsalways/001-TDD.git
C:\work\practice\java\ws\001-TDD>git branch -M master
C:\work\practice\java\ws\001-TDD>git push -u origin master

+++++++++++++++ Without Configuring Maven installing sonarqube on local machine ++++++++++++++++++++++++++
Download sonarqube for java 11 community version
unzip it 
run C:\work\apps\sonarqube-8.9.1.44547\bin\windows-x86-64>StartSonar.bat

in browser go to localhost:9000

default credentials in initially : admin/admin
update the password

Ckick on Add Project select manually give some Project Key (001-TDD)
click on setup
Give a token (Ameyaj) click on generate
Click on Continue and then click Maven
Copy the command and run it in your project in console
eg. C:\work\practice\java\ws\001-TDD>mvn sonar:sonar -Dsonar.projectKey=001-TDD -Dsonar.host.url=http://localhost:9000 -Dsonar.login=d31a3f23e2f6fab02657f99960ace48eef9f8543
Observe the Browser for the changes.and the analysis
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



Login to sonarcloud.io using github credentials

click on + and create organization
Click on choose an organization from github
provide credentials and select the repo u want to make available
Provide key (ameyajoshi)
click on continue
Choose free plan 
Click create organization
Click Add Project
select ur repo
Click analyze project
select With GitHub Actions
Click on continue Click on Maven copy the properties to ur pom.xml
<sonar.projectKey>001-TDD</sonar.projectKey>
  <sonar.organization>ameyajoshi</sonar.organization>
  <sonar.host.url>https://sonarcloud.io</sonar.host.url>
  Additionally  copy the entries from 1. create Github secret
  <SONAR_TOKEN>52cccd9632d9e707552fc91a4a4a6349460520b4</SONAR_TOKEN>
  Also add below entry for jacoco
   <sonar.coverage.jacoco.xmlReportPaths>../001-TDD/target/site/jacoco-aggregate/jacoco.xml
   
   run the below cmd
C:\work\practice\java\ws\001-TDD>mvn clean verify sonar:sonar -Dsonar.login=52cccd9632d9e707552fc91a4a4a6349460520b4

Site and Sonar Has to be Updated on every commit

Install SonarLint plugin from eclipse marketplace
This will enable for test analysis on dev machine It is before code not after code
Like PMD for Eclipse
Rt-Click on project select SonarLint --> Analyze

++++++++++++++++++ Pull the data web scraping from airports.com using HttpRequest ++++++++++++++++
Create a new Java Class AirportDataDownloader

within main Do as in code

++++++++++++++ Create a application.properties in resources +++++++++++++
++++ Update POM.xml add slf4j dependencies ++++
++++ Create PropertyHelper.java in com.ameya.PropertyHelper +++++++++++ Mention this will be used later
++++ Modify AirportDataDownloader below sysout

+++ Explain Lambda expressions then come back to this code ++++

+++ Code in the code for populating the lists.

+++ code in the predicate method
and show the below code
System.out.println(airports
				.stream()
				//.filter(airport->airport.contains("Shivaji"))
				.filter(airport->filterByNamePredicate(airport))
				.findAny()
				.orElse(null));
++++ code int the class StreamsDemo

