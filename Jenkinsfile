pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Build') {
            steps {
                echo 'The build is done successfully'
                bat 'mvn clean'
            }
        }
        stage('Test') {
            steps {
                echo 'Tests breweries are running'
                bat 'mvn test -DsuiteXmlFile=suites/suite.xml'
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