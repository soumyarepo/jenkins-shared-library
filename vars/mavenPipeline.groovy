def call() {
    pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }

            stage('Verify Project') {
                steps {
                    sh 'pwd'
                    sh 'ls -ltr'
                    sh 'find . -name pom.xml'
                }
            }

            stage('Build') {
                steps {
                    sh 'mvn clean compile'
                }
            }

            stage('Test') {
                steps {
                    sh 'mvn test'
                }
            }

            stage('Package') {
                steps {
                    sh 'mvn package'
                }
            }
        }
    }
}