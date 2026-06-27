def call() {
    pipeline {
        agent any
        stages {
            stage('checkout') {
                steps {
                    checkout scm
                }
            }
            stage('build') {
                steps {
                    dir('student-maven-app') {
                        sh 'mvn clean complie'
                    }
                }
            }
            stage('test') {
                steps {
                    dir('student-maven-app') {
                        sh 'mvn test'
                    }
                }
            }
            stage('package') {
                steps {
                    dir('student-maven-app') {
                        sh 'mvn package'
                    }
                }
            }
        }
    }
}