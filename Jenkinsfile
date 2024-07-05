pipeline {
    agent any

    environment {
        JAVA_HOME = tool name: 'JDK 11', type: 'hudson.model.JDK'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
        JMETER_HOME = 'C:\Program Files\Git\usr\bin' // Adjust this to the actual path of your JMeter installation
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
                sh 'mvn clean install'
            }
        }
        stage('Performance Test') {
            steps {
                // Run JMeter tests
                sh "${JMETER_HOME}/bin/jmeter -n -t test-plan.jmx -l results.jtl -j jmeter.log"
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
