pipeline {
    agent {label 'AWS'}
    tools {
        jdk 'jdk'
        maven 'Maven-3.9.16'
    }
    stages {
        stage('Build') {
            steps {
                echo 'The build is done successfully'
                sh 'mvn clean compile'
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