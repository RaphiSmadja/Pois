pipeline {
    agent any
    tools {
        maven 'maven3.6.3'
    }
    stages {
        stage ('Initialize') {
            steps {
                bat 'mvn clean'
            }
        }
        stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('My SonarQube Server') {
                bat 'mvn clean package sonar:sonar'
              }
            }
          }
          stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
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