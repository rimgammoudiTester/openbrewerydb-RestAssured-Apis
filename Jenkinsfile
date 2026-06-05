pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Build') {
            steps {
                echo 'The build is done successfully'
                sh 'mvn clean'
            }
        }
        stage('Test') {
            steps {
                echo 'Tests breweries are running'
                sh 'mvn test -DsuiteXmlFile=suites/suite.xml'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Running in the server AWS'
            }
        }
    }
    post {
        always {
            echo 'end of pipeline!'
        }
        failure {
            echo 'failure something went wrong!'
        }
    }
}