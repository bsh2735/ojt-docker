pipeline {
    agent any

    stages {
        stage('Build Docker Images') {
            steps {
                bat 'docker compose build'
            }
        }

        stage('Clean Existing Containers') {
            steps {
                bat '''
                docker rm -f postgres backend frontend 2>NUL || exit 0
                '''
            }
        }

        stage('Run Containers') {
            steps {
                bat 'docker compose up -d'
            }
        }
    }

    post {
        success {
            echo 'CI/CD Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Please check logs.'
        }
    }
}
