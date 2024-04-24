pipeline {
    agent any
    tools {
        maven 'maven'
    }

    stages {
        stage('Git Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/vineethasumesh/bookmanagement.git']])
                echo 'Git Checkout Completed'
            }
        }
        stage(' Maven Build') {
            steps {
                bat 'mvn clean package -DskipTests'
                echo 'Maven build Completed'
            }
        }
        stage('JUnit Test') {
            steps {
                // Run unit tests
                script {
                    try {
                        bat 'mvn clean test surefire-report:report' 
                    } catch (err) {
                        currentBuild.result = 'FAILURE'
                        echo 'Unit tests failed!'
                        error 'Unit tests failed!'
                    }
                }
                echo 'JUnit test Completed'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat '''mvn clean verify sonar:sonar -Dsonar.projectKey=cicd-full -Dsonar.projectName='cicd-full' -Dsonar.host.url=http://localhost:9000''' //port 9000 is default for sonar
                    echo 'SonarQube Analysis Completed'
                }
            }
        }
    }
}
