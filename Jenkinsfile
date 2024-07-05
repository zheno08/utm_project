pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                bat 'echo Building...'
            //   bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'echo Testing...'
           //  bat 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                bat 'echo Deploying...'
                // Add your deploy steps here, e.g., `sh 'kubectl apply -f deployment.yaml'`
            }
        }
    }

    post {
        always {
            echo 'Cleaning up...'
            // Add any cleanup steps here
        }
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
