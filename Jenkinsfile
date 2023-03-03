def sendSlackNotification()
{
 if ( currentBuild.currentResult == "SUCCESS" ) {
  buildSummary = "Job: ${env.JOB_NAME}\n Status: *SUCCESS* \nBuild Report: http://localhost:63342/qa-automation/JOGORegressionSuite/src/test/Reports/cucumber-html-reports/feature-overview.html"
  def slackResponse = slackSend(color : "good", message: "${buildSummary}")
  slackUploadFile(channel: slackResponse.threadId,filePath: "src/test/Reports/ExtentReport/AutomationReport.html", initialComment:  "Reports")
 }
 else {
  buildSummary = "Job: ${env.JOB_NAME}\n Status: *FAILURE*\n Error description: *${CI_ERROR}* \nBuild Report: http://localhost:63342/qa-automation/JOGORegressionSuite/src/test/Reports/cucumber-html-reports/feature-overview.html"
  slackSend color : "danger", message: "${buildSummary}"
  slackUploadFile(channel: slackResponse.threadId,filePath: "src/test/Reports/ExtentReport/AutomationReport.html", initialComment:  "Reports")
 }
}
pipeline {
    agent any
    tools {
        maven 'MAVEN_HOME'
        jdk 'JAVA_HOME'
    }
    stages {
        stage('Code Pull') {
            steps {
                git branch: 'main', credentialsId: '992ea1c2-7fff-4c14-9465-265f97e875c0', url: 'https://github.com/JOGO-FOOTBALL/qa-automation.git'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn -f pom.xml clean test -DrunMode=${RunMode} -DplatformType=${PlatformType} -DmobilePlatformType=${MobilePlatformType} -DenvironmentType=${EnvironmentType} -DremoteModeType=${RemotePlatformType} -DdeviceName=${DeviceName} -Dcucumber.filter.tags="${FilterTAGS}" -Dmaven.test.failure.ignore=true'
            }
            post{
            always{
                 cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', fileIncludePattern: 'src/test/Reports/*.json', sortingMethod: 'ALPHABETICAL', failedScenariosPercentage : 50
                sendSlackNotification()
            }
            }
        }
    }
}