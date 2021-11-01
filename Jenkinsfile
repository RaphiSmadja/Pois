pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'JDK8'
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