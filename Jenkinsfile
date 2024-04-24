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

        

    }
}
