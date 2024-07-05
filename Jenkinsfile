pipeline {
    agent any

    environment {
       MAVEN_HOME = tool name: 'Maven', type: 'hudson.tasks.Maven$MavenInstallation'
        JAVA_HOME = tool name: 'JDK 17', type: 'hudson.model.JDK'
        PATH = "${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${env.PATH}"
     

    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from the version control system
                checkout scm
            }
        }
        stage('Build') {
            steps {
                // Build your project (if needed)
                bat 'mvn clean install'
            }
        }
        stage('Performance Test') {
            steps {
                // Run JMeter tests
                bat "C:/jmeter/bin/jmeter -n -t test-plan.jmx -l results.jtl -j jmeter.log"
            }
            post {
                always {
                    // Publish JMeter results
                    publishPerformanceReport parsers: [[$class: 'JMeterParser', glob: 'results.jtl']]
                }
            }
        }
    }

    post {
        always {
            // Clean up actions, e.g., deleting temporary files
            cleanWs()
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
