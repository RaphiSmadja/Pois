pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage ('Initialize') {
            steps {
                bat 'mvn clean'
            }
        }
        stage ('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
        stage ('Build') {
            steps {
                bat 'mvn install'
            }
        }
        stage ('Deploy') {
            steps {
                bat 'mvn package'
            }
        }
    }
}