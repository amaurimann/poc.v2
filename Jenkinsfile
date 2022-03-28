properties([
  [$class: 'JiraProjectProperty'],
  buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '5', numToKeepStr: '5')),
  disableConcurrentBuilds(),
  parameters([
    string(defaultValue: 'jenkins-Quality-poc-testng-front-$BUILD_NUMBER', description: 'Set the build name of tests', name: 'BUILD', trim: true),
    string(defaultValue: 'tst', description: 'Set the environment', name: 'ENV', trim: true)
  ]),
])

pipeline
{
    agent any
    tools
    {
        git 'Default'
        maven 'Maven'
        jdk 'JDK 11.0.1'
    }
    stages
    {
        stage('Slack notification')
        {
            steps
            {
                slackSend color: '#008000', channel: '#framework-jenkins-notification',
                    message: "Job: ${env.JOB_NAME} with build number ${env.BUILD_NUMBER} was started"
            }
        }
        stage('downloading dependencies')
        {
            steps
            {
                sh 'mvn clean install -DskipTests'
            }
        }
//         stage('Sonar analysis')
//         {
//             steps
//             {
//                 withSonarQubeEnv('SonarQube')
//                 {
//                     sh 'mvn sonar:sonar -Dsonar.projectKey=POC-QA-FRONT -Dsonar.host.url=https://sonar.zenvia.com -Dsonar.login=dd123d85073f2b5bd412cbe122a27e773a6f7a46'
//                 }
//             }
//         }
//         stage('Sonar Quality Gates')
//         {
//             steps
//             {
//                 timeout(time: 1, unit: 'HOURS')
//                 {
//                     waitForQualityGate abortPipeline: false
//                 }
//             }
//         }
        stage('set browserstack connection')
        {
            steps
            {
                browserstack(credentialsId: '2b5b7bfa-f4fe-44ac-a251-cfbfa8949b99', localConfig: [localOptions: '', localPath: ''])
                {
                }
            }
        }
        stage('running tests')
        {
            steps
            {
                sh "mvn test -DBUILD_NAME=$BUILD -Denv=$ENV"
            }
        }
        stage('browserstack report')
        {
            steps
            {
                browserStackReportPublisher 'automate'
            }
        }
        stage('publishing report')
        {
            steps
            {
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: false, reportDir: 'TestReport', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])
            }
        }
    }
        post
        {
            failure
            {
            slackSend color: 'danger', channel: '#framework-jenkins-notification',
                                     message: "Job: ${env.JOB_NAME} with build number ${env.BUILD_NUMBER} was failed"
            }
            aborted
            {
            slackSend color: '#808080', channel: '#framework-jenkins-notification',
                                     message: "Job: ${env.JOB_NAME} with build number ${env.BUILD_NUMBER} was aborted"
            }
            success
            {
            slackSend color: 'good', channel:'#framework-jenkins-notification',
                                     message: "Job: ${env.JOB_NAME} with build number ${env.BUILD_NUMBER} was successfully"
            }
            unstable
            {
            slackSend color: 'warning', channel:'#framework-jenkins-notification',
                                     message: "Job: ${env.JOB_NAME} with build number ${env.BUILD_NUMBER} was unstable"
            }
            always
            {
            junit testDataPublishers: [[$class: 'AutomateTestDataPublisher']], testResults: 'target/surefire-reports/TEST-*.xml'
            }
//              always
//                          {
//                             cleanWs()
//                          }
        }
}
