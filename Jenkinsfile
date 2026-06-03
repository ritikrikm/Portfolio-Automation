pipeline {
    agent any

    parameters {
        choice(name: 'ENV', choices: ['dev', 'qa', 'uat', 'prod'], description: 'Select environment')
        choice(name: 'TEST_SUITE', choices: ['smoke', 'sanity', 'regression'], description: 'Select test suite')
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Checking out code from GitHub...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building Maven project...'
                sh '/usr/local/bin/mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Running ${params.TEST_SUITE} tests on ${params.ENV}..."
                sh "/usr/local/bin/mvn test -Dgroups=${params.TEST_SUITE}"
            }
        }

        stage('Deploy to DEV') {
            steps {
                echo 'Deploying to DEV environment...'
            }
        }

        stage('Deploy to QA') {
            when {
                anyOf {
                    expression { params.ENV == 'qa' }
                    expression { params.ENV == 'uat' }
                    expression { params.ENV == 'prod' }
                }
            }
            steps {
                echo 'Deploying to QA environment...'
            }
        }

        stage('Deploy to UAT') {
            when {
                anyOf {
                    expression { params.ENV == 'uat' }
                    expression { params.ENV == 'prod' }
                }
            }
            steps {
                echo 'Deploying to UAT environment...'
            }
        }

        stage('Prod Approval') {
            when {
                expression { params.ENV == 'prod' }
            }
            steps {
                input message: 'Approve production deployment?'
            }
        }

        stage('Deploy to PROD') {
            when {
                expression { params.ENV == 'prod' }
            }
            steps {
                echo 'Deploying to PROD environment...'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed.'
        }

        success {
            echo 'Pipeline passed.'
        }

        failure {
            echo 'Pipeline failed.'
        }
    }
}